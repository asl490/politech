package com.store.politech.filestorage;

import org.springframework.core.io.Resource;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FileDownloadResource {
    private final Resource resource;
    private final String filename;
    private final String contentType;
    private final long contentLength;
}
