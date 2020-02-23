package com.ocs.owncarservice.Service;

import org.springframework.web.multipart.MultipartFile;

public interface S3ServiceInterface {
	public void uploadFile(String keyName, MultipartFile file);
}
