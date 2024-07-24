package com.clomb.tracker.config;

import com.google.gson.Gson;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueRequest;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueResponse;

import javax.sql.DataSource;

@Configuration
public class AwsConfig {

    // Use this code snippet in your app.
// If your need more information about configurations or implementing the sample
// code, visit the AWS docs:
// https://docs.aws.amazon.com/sdk-for-java/latest/developer-guide/home.html

// Make sure to import the following packages in your code
// import software.amazon.awssdk.regions.Region;
// import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
// import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueRequest;
// import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueResponse;

    private Gson gson = new Gson();

    @Bean
    public DataSource dataSource() {
        AwsSecretsDto secrets = getSecret();

        return DataSourceBuilder
                .create()
                .url("jdbc:"+secrets.getEngine()+"://"+secrets.getHost()+":"+secrets.getPort()+"/clombDB")
                .username(secrets.getUsername())
                .password(secrets.getPassword())
                .build();

    }

    private AwsSecretsDto getSecret() {

        String secretName = "prodclombDB";
        Region region = Region.of("us-west-2");

        // Credentials for accessing Secrets Manager
        AwsBasicCredentials awsCreds = AwsBasicCredentials.create("AKIA4MTWL4QMFLIZ4L64", "2");

        // Create a Secrets Manager client
        SecretsManagerClient client = SecretsManagerClient.builder()
                .region(region)
                .credentialsProvider(StaticCredentialsProvider.create(awsCreds))
                .build();

        GetSecretValueRequest getSecretValueRequest = GetSecretValueRequest.builder()
                .secretId(secretName)
                .build();

        GetSecretValueResponse getSecretValueResponse;

        try {
            getSecretValueResponse = client.getSecretValue(getSecretValueRequest);
        } catch (Exception e) {
            // For a list of exceptions thrown, see
            // https://docs.aws.amazon.com/secretsmanager/latest/apireference/API_GetSecretValue.html
            throw e;
        }

        String secret = getSecretValueResponse.secretString();

        // Your code goes here.
        return gson.fromJson(secret, AwsSecretsDto.class);



    }

}
