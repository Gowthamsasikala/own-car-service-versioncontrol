package com.ocs.owncarservice.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
public class S3Config {

	@Value("${amazonProperties.accessKey}")
	private String awsID;
	
	@Value("${amazonProperties.secretKey}")
	private String awsKey;
	
	@Value("${amazonProperties.region}")
	private String region;
	
	
	@Bean
	public AmazonS3 S3Client() {
		
		BasicAWSCredentials bcred = new BasicAWSCredentials(awsID, awsKey);
		
		AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withRegion(Regions.fromName(region))
				            .withCredentials(new AWSStaticCredentialsProvider(bcred)).build();
		
		
		return s3Client;
	}
	
	
}
