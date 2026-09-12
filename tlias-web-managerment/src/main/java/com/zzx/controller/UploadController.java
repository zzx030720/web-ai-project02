package com.zzx.controller;


import com.zzx.pojo.Result;
import com.zzx.utils.AliyunOSSOperator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Slf4j
public class UploadController {
    @Autowired
    private AliyunOSSOperator aliyunOSSOperator;
    /*
    * 文件上传（本地磁盘）
     */
//    @PostMapping("/upload")
//    public Result upload(String name, Integer age, MultipartFile file) throws IOException {
//        log.info("上传文件{},{},{}", name, age, file);
//        //获取原始文件名
//        String originalFilename = file.getOriginalFilename();
//
//        String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
//        //新文件名
//        String newFileName = UUID.randomUUID().toString() + extension;
//        //保存文件
//        file.transferTo(new File("D:/images/"+newFileName));
//        return Result.success();
//    }
    @PostMapping("/upload")
    public Result upload(MultipartFile  file) throws Exception {
        log.info("上传文件：{}", file.getOriginalFilename());
        //将文件交给OSS管理
        String url = aliyunOSSOperator.upload(file.getBytes(), file.getOriginalFilename());
        log.info("文件上传成功，返回的url为：{}", url);
        return Result.success(url);
    }
}
