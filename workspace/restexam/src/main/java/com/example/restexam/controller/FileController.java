package com.example.restexam.controller;

import com.example.restexam.entity.UploadInfo;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Slf4j
@RestController
public class FileController {
    //파일 다운로드 -- 서버가 가지고 있는 "이미지의 경로" 다운로드
    @GetMapping("/download")
    public void download(HttpServletResponse response) {
        Path path=Paths.get("c:/LikeLion/cat.jpg"); //서버 경로에 저장해서 그 경로로 이미지를 띄우면 새로고침해야 보인다. 다른 경로에 저장하기
        response.setContentType("image/jpeg");
        try (InputStream inputStream=Files.newInputStream(path)){ //파일을 읽어 낼 수 있는 통로를 만든다
            StreamUtils.copy(inputStream, response.getOutputStream());
            response.flushBuffer();
        }catch (IOException e){
            log.error("파일 다운로드 중 오류 발생"+e.getMessage());
        }
    }


    //파일 업로드
    @PostMapping("/upload")
    public ResponseEntity<String> upload(@RequestParam(name = "file") MultipartFile file
//                                         @RequestParam(name = "info",required = false)UploadInfo uploadInfo
                                        ) {
        log.info(file.getContentType());
        log.info(file.getOriginalFilename());

        try(InputStream inputStream=file.getInputStream()){
            StreamUtils.copy(inputStream,
                    new FileOutputStream("c:/LikeLion/"+ UUID.randomUUID().toString()+file.getOriginalFilename()));
            return  ResponseEntity.ok().body("파일 저장 성공"+file.getOriginalFilename());
        }catch (IOException e){
            return ResponseEntity.badRequest().body("파일 업로드 실패"+file.getOriginalFilename());
        }
    }

}
