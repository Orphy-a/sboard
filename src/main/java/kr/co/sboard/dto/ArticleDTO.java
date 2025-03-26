package kr.co.sboard.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleDTO {

    private int no;
    private String cate;
    private String title;
    private String content;
    private int comment;
    private int file;
    private int hit;
    private String writer;
    private String regip;
    private String wdate;

    private MultipartFile file1;
    private MultipartFile file2;




}
