package com.store.politech.filestorage;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
@Profile("dev")
public class LocalStorageImpl implements FileStorageService {

    private final Path rootLocation;
    private static final String TEST_FOLDER = "test-uploads";

    public LocalStorageImpl(@Value("${app.storage.local.location:upload-dir}") String location) {
        this.rootLocation = Paths.get(location);
        try {
            Files.createDirectories(rootLocation);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize storage", e);
        }
    }

    @Override
    public String uploadTestFile(MultipartFile file) {
        // return fileStoragePort.save(file, TEST_FOLDER);
        try {
            if (file.isEmpty()) {
                throw new RuntimeException("Failed to store empty file.");
            }

            Path destinationFolder = rootLocation.resolve(TEST_FOLDER);
            Files.createDirectories(destinationFolder);

            String extension = getFileExtension(file.getOriginalFilename());
            String newFileName = UUID.randomUUID().toString() + "." + extension;

            Path destinationFile = destinationFolder.resolve(Paths.get(newFileName)).normalize().toAbsolutePath();

            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
            }

            return Paths.get(TEST_FOLDER).resolve(newFileName).toString().replace('\'', '/');

        } catch (IOException e) {
            throw new RuntimeException("Failed to store file.", e);
        }
    }

    public void delete(String filePath) {
        try {
            Path fileToDelete = rootLocation.resolve(filePath).normalize();
            Files.deleteIfExists(fileToDelete);
        } catch (IOException e) {
            System.err.println("Failed to delete file: " + filePath);
        }
    }

    @Override
    public Optional<FileDownloadResource> getTestFile(String fileName) {
        String filePath = TEST_FOLDER + "/" + fileName;
        // return fileStoragePort.getResource(filePath);

        try {
            Path file = rootLocation.resolve(filePath).normalize();
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                String contentType = Files.probeContentType(file);
                if (contentType == null) {
                    contentType = "application/octet-stream";
                }
                return Optional.of(new FileDownloadResource(
                        resource,
                        resource.getFilename(),
                        contentType,
                        resource.contentLength()));
            }
        } catch (IOException e) {
            // Log error
        }
        return Optional.empty();
    }

    @Override
    public Optional<String> getTestFilePresignedUrl(String fileName) {
        // String filePath = TEST_FOLDER + "/" + fileName;
        // Not applicable for local storage
        return Optional.empty();
    }

    private String getFileExtension(String fileName) {
        if (fileName == null || fileName.lastIndexOf('.') == -1) {
            return "";
        }
        return fileName.substring(fileName.lastIndexOf('.') + 1);
    }
}
