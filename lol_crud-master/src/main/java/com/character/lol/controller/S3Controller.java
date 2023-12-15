package com.character.lol.controller;

import com.character.lol.service.S3UploadService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class S3Controller {
    private final S3UploadService s3UploadService;
    @Autowired
    public S3Controller(S3UploadService s3UploadService) {
        this.s3UploadService = s3UploadService;
    }
    @PostMapping(value = "/image",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String image(@RequestParam(value = "image") MultipartFile image) throws IOException {
        String result = s3UploadService.saveFile(image);
        return result;
    }
}
