package com.store.politech.filestorage;

import java.util.Map;
import java.util.Optional;

import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/test")
@RequiredArgsConstructor
public class TestController {

    private final FileStorageService fileStorageService;

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Map<String, String>> uploadFile(
            @RequestParam("file") MultipartFile file) {

        String filePath = fileStorageService.uploadTestFile(file);
        String fileName = filePath.substring(filePath.lastIndexOf('/') + 1);
        return ResponseEntity.ok(Map.of("fileName", fileName, "fullPath", filePath));
    }

    @Operation(summary = "Download a test file", description = "Downloads a file directly from the server. This endpoint returns the file as a binary stream.", responses = {
            @ApiResponse(responseCode = "200", description = "File downloaded successfully", content = @Content(mediaType = "application/octet-stream", schema = @Schema(type = "string", format = "binary"))),
            @ApiResponse(responseCode = "404", description = "File not found", content = @Content)
    })
    @GetMapping(value = "/download/{fileName:.+}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName) {
        Optional<FileDownloadResource> resourceOptional = fileStorageService.getTestFile(fileName);

        if (resourceOptional.isPresent()) {
            FileDownloadResource fileDownloadResource = resourceOptional.get();

            ContentDisposition contentDisposition = ContentDisposition.builder("attachment")
                    .filename(fileDownloadResource.getFilename())
                    .build();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentDisposition(contentDisposition);
            headers.setContentLength(fileDownloadResource.getContentLength());

            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(fileDownloadResource.getContentType()))
                    .headers(headers)
                    .body(fileDownloadResource.getResource());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/download-url/{fileName:.+}")
    public ResponseEntity<Map<String, String>> getDownloadUrl(@PathVariable String fileName) {
        Optional<String> urlOptional = fileStorageService.getTestFilePresignedUrl(fileName);

        if (urlOptional.isPresent()) {
            return ResponseEntity.ok(Map.of("url", urlOptional.get()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}