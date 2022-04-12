package com.example.image.controller;

import com.example.image.service.S3Uploader;
import com.example.image.testdto.testdto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RequiredArgsConstructor
@RestController
public class HelloController {

    private final S3Uploader s3Uploader;

    @PostMapping("/images")
    public List<String> upload(@RequestParam("images") MultipartFile[] multipartFile, testdto t1) throws IOException {
        int leng= multipartFile.length;
        List<String> urls=new ArrayList<>();
        for(int i=0;i<leng;i++)
            urls.add(s3Uploader.upload(multipartFile[i], "static"));
        System.out.println(t1.getTitle());
        System.out.println(t1.getStar());
        System.out.println(t1.getContent());
//        System.out.println(urls);
        return urls;
    }
}