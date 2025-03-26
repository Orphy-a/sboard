package kr.co.sboard.service;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.sboard.dto.ArticleDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;

@Slf4j
@RequiredArgsConstructor
@Service
public class FileService {

    // 업로드 경로 변수
    @Value("${spring.servlet.multipart.location}")
    private String upladDir;


    public void uploadFile(ArticleDTO articledto){

        // 파일 업로드 객체 생성
        File fileUploadDir = new File(upladDir);

        if(!fileUploadDir.exists()){
            // 디렉터리가 존재하지 않으면 생성
            fileUploadDir.mkdirs();
        }

        // 파일 업로드 디렉터리 시스템 경로 구하기
        String fileUploadPath = fileUploadDir.getAbsolutePath();



    }

    public void downloadFile(){

    }

}
