package com.app.controllers;

import com.app.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class FileUploadController {
    @Autowired
    private FileService fileService;

    @GetMapping("/fileUpload")
    public String getFileUploadPage(Model model) {
        model.addAttribute("location", fileService.getLocation());
        model.addAttribute("files", fileService.getAllFiles());
        return "fileUpload";
    }

    @PostMapping("/fileUpload")
    public String storeFile(@RequestParam("file")MultipartFile file) throws IOException {
        fileService.store(file);
        return "redirect:/";
    }
}
