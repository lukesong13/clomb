package com.clomb.tracker.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AwsSecretsDto {
    String username;
    String password;
    String host;
    String engine;
    String port;
    String dbInstanceIdentifier;
}
