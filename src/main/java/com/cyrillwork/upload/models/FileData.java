package com.cyrillwork.upload.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="file_data")
public class FileData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Lob
    private byte[] file;
}
