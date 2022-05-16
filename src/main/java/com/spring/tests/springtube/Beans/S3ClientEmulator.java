package com.spring.tests.springtube.Beans;


import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

import java.net.URI;
import java.net.URISyntaxException;

@Getter
@Component
@Scope("singleton")
public class S3ClientEmulator {
    @Value("${localstack.path:http://localhost:4566}")
    private String localstackPath;
    AwsBasicCredentials awsCreds = AwsBasicCredentials.create("123","xyz");

    final StaticCredentialsProvider credentialsProvider = StaticCredentialsProvider.create(awsCreds);
    //final S3Client s3 = S3Client.builder().endpointOverride(new URI(localstackPath)).credentialsProvider(credentialsProvider).region(Region.EU_NORTH_1).build();
    public S3Client initS3() throws URISyntaxException {
       final S3Client s3 = S3Client.builder().endpointOverride(new URI(localstackPath)).credentialsProvider(credentialsProvider).region(Region.EU_NORTH_1).build();
        return  s3;
    }

}
