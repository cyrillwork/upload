package com.cyrillwork.upload.controllers;

import com.cyrillwork.upload.models.UploadFiles;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class UploadMultipartFile implements MultipartFile {
    private UploadFiles file;

    public UploadMultipartFile(UploadFiles file){
        this.file = file;
    }

    @Override
    public String getName() {
        return file.getName();
    }

    @Override
    public String getOriginalFilename() {
        return file.getName();
    }

    @Override
    public String getContentType() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public long getSize() {
        return file.getFileSize();
    }

    @Override
    public byte[] getBytes() throws IOException {
        return file.getFile().getFile();
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return null;
    }

    @Override
    public void transferTo(File file) throws IOException, IllegalStateException {

    }
}
