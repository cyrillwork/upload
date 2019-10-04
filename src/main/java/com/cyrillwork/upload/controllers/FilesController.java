package com.cyrillwork.upload.controllers;

import com.cyrillwork.upload.exceptions.NotFoundFileException;
import com.cyrillwork.upload.models.FileData;
import com.cyrillwork.upload.models.UploadFiles;
import com.cyrillwork.upload.repos.FileDataRepository;
import com.cyrillwork.upload.repos.UploadFilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@RestController
public class FilesController {
    @Autowired
    private UploadFilesRepository filesRepository;

    @Autowired
    private FileDataRepository fileDataRepository;

    @DeleteMapping
    public String deleteFile(@RequestParam(value = "name") String name){
        String result = "Error delete ";

        UploadFiles file = filesRepository.findByName(name);
        if(file != null)
        {
            filesRepository.deleteByName(name);
            fileDataRepository.deleteById(file.getFile().getId());
            result = "OK delete ";
        }
        result += name;

        return result;
    }

    @GetMapping(value = "/file/{name}")
    public UploadFiles getFile(@PathVariable String name) throws NotFoundFileException {
        UploadFiles file = filesRepository.findByName(name);
        if(file == null)
        {
            throw new NotFoundFileException();
        }
        return file;
    }


    @GetMapping(value = "/files")
    public Iterable<UploadFiles> showFiles() {
        List<MultipartFile> listFiles = new ArrayList<>();
        List<UploadFiles> all = filesRepository.findAll();
        for (UploadFiles iii: all) {
            listFiles.add(new UploadMultipartFile(iii));
        }
        return all;
    }

    @PostMapping
    public String addFile( @RequestParam("file") MultipartFile multipartFile
    ){

        FileData fileData = new FileData();
        UploadFiles uploadFiles = new UploadFiles();

        uploadFiles.setFile(fileData);
        uploadFiles.setMultipartFile(multipartFile);

        fileDataRepository.save(fileData);
        filesRepository.save(uploadFiles);

        return "add file ";
    }
}
