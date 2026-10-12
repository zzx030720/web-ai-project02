package com.zzx.controller;


import com.zzx.pojo.Result;
import com.zzx.utils.AliyunOSSOperator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

//等于 @Controller + @ResponseBody：声明本类是控制器并交给Spring管理，
//所有方法的返回值都自动转成JSON写回浏览器
@RestController
//Lombok注解：编译时自动生成一个log日志对象，类里可以直接用 log.info(...) 记录日志
@Slf4j
public class UploadController {
    //Spring依赖注入：容器自动把AliyunOSSOperator对象（阿里云OSS工具类）塞给这个变量，不用手动new
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
    //处理POST /upload请求：接收前端上传的文件（file参数由Spring自动封装成MultipartFile对象）
    @PostMapping("/upload")
    public Result upload(MultipartFile  file) throws Exception {
        log.info("上传文件：{}", file.getOriginalFilename());
        //将文件交给OSS管理
        String url = aliyunOSSOperator.upload(file.getBytes(), file.getOriginalFilename());
        log.info("文件上传成功，返回的url为：{}", url);
        return Result.success(url);
    }
}
