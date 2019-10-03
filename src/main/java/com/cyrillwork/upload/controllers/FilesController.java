package com.cyrillwork.upload.controllers;

import com.cyrillwork.upload.models.FileData;
import com.cyrillwork.upload.models.UploadFiles;
import com.cyrillwork.upload.repos.FileDataRepository;
import com.cyrillwork.upload.repos.UploadFilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController(value = "/files")
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

    @GetMapping
    public Iterable<UploadFiles> showFiles() {
        return filesRepository.findAll();
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
