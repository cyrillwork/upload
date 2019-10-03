package com.cyrillwork.upload.repos;

import com.cyrillwork.upload.models.FileData;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FileDataRepository extends JpaRepository<FileData, Long> {
}
