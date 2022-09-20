package com.app.services;

import com.app.dao.FileDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class FileService {
    @Autowired
    private FileDao fileDao;

    private final Path location = Paths.get("/static/files");

    public void store(MultipartFile file) throws IOException {
        Files.copy(file.getInputStream(), location.resolve(file.getOriginalFilename()));   //сохраняет файл в буфер
        fileDao.storeFileData(file.getOriginalFilename());
    }

    public String getLocation() {
        return location.toString();
    }

    public List<String> getAllFiles() {
        return fileDao.getAllFiles();
    }
}
