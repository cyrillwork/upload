package com.cyrillwork.upload.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.IOException;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@Table(name = "upload_files")
@Slf4j
public class UploadFiles {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Long fileSize;

    @OneToOne(targetEntity = FileData.class)
    private FileData file;

    public void setMultipartFile(MultipartFile multipartFile) {
        //this.multipartFile = multipartFile;
        try {
            this.file.setFile(multipartFile.getBytes());
            this.name = multipartFile.getOriginalFilename();
            this.fileSize = multipartFile.getSize();
        } catch (IOException e) {
            log.error(String.valueOf(e.getStackTrace()));
        }
    }

}

