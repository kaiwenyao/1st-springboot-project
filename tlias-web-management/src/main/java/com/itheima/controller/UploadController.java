package com.itheima.controller;

import com.itheima.pojo.Result;
import com.itheima.utils.AliyunOSSOperator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {
    // 本地
//    @PostMapping("/upload")
//    public Result upload(String name, Integer age, MultipartFile file) throws IOException {
//        log.info("接收到的参数：{}, {}, {}", name, age, file);
//        String originalFileName = file.getOriginalFilename();
//        String extension =  originalFileName.substring(originalFileName.lastIndexOf("."));
//        String newFileName = UUID.randomUUID().toString() + extension;
//        file.transferTo(new File("/Users/ykw/Pictures/" + newFileName));
//        return Result.success();
//    }
    @Autowired
    private AliyunOSSOperator aliyunOSSOperator;
    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws Exception {
        log.info("文件上传：{}", file.getOriginalFilename());
        String url = aliyunOSSOperator.upload(file);
        log.info("文件上传到OSS, url: {}", url);
        return Result.success(url);
    }
}
