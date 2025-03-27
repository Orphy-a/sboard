package kr.co.sboard.controller;

import kr.co.sboard.dto.FileDTO;
import kr.co.sboard.service.FileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Slf4j
@RequiredArgsConstructor
@Controller
public class FileController {


    private final FileService fileService;

    @GetMapping("/file/download")
    public ResponseEntity download(int fno) {

        try {
            // 파일 조회
            FileDTO fileDTO = fileService.findById(fno);

            // 파일 다운로드 카운트 1증가
            fileService.updateDownloadCount(fileDTO);

            // 파일 리소스 스트림
            fileService.downloadFile(fileDTO);

            log.info("fileDTO : {}", fileDTO);

            // 파일 다운로드 헤더 정보 설정
            HttpHeaders headers = new HttpHeaders();
            headers.setContentDisposition(
                    ContentDisposition.builder("attachment")
                            .filename(fileDTO.getOName(), StandardCharsets.UTF_8)
                            .build());

            headers.add(HttpHeaders.CONTENT_TYPE, fileDTO.getContentType());

            return ResponseEntity.ok()
                    .headers(headers)
                    .body(fileDTO.getResource());

        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return ResponseEntity
                .notFound()
                .build();

    }


}
