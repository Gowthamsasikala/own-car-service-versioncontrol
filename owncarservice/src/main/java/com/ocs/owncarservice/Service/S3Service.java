package com.ocs.owncarservice.Service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;

@Service
public class S3Service implements S3ServiceInterface {

	
	
	@Autowired
	private AmazonS3 s3Client;
	
	@Value("${amazonProperties.bucketName}")
	private String bucketName;
	
	@Override
	public void uploadFile(String keyName, MultipartFile file) {
		try {
			System.out.println(keyName+"---"+file.getOriginalFilename());
		      ObjectMetadata metadata = new ObjectMetadata();
		      metadata.setContentLength(file.getSize());
		      metadata.setContentType(file.getContentType());
		      System.out.println(file.getSize());
		      System.out.println(file.getContentType());
		      s3Client.putObject(bucketName, keyName, file.getInputStream(), metadata);
		    } catch(IOException ioe) {
		      System.out.println("IOException: " + ioe.getMessage());
		    } catch (AmazonServiceException ase) {
		    	System.out.println("AWSException: " + ase.getMessage());
		    }
		
	}

}
