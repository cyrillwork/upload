package com.cyrillwork.upload.repos;

import com.cyrillwork.upload.models.UploadFiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

public interface UploadFilesRepository extends JpaRepository<UploadFiles, Long> {
    @Transactional
    UploadFiles findByName(String name);

    @Modifying
    @Transactional
    void deleteByName(String name);
}
