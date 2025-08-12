package com.store.politech.filestorage;

import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {
    String uploadTestFile(MultipartFile file);

    Optional<FileDownloadResource> getTestFile(String fileName);

    Optional<String> getTestFilePresignedUrl(String fileName);
}
