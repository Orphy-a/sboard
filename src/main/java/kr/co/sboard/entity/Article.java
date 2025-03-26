package kr.co.sboard.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;
    private String cate;
    private String title;
    private String content;
    private int comment;
    private int file;
    private int hit;
    private String writer;
    private String regip;

    @CreationTimestamp
    private LocalDateTime wdate;

    @PrePersist
    public void prePersist(){
        if(this.cate == null){
            this.cate = "free";
        }
    }

}
