package kr.co.sboard.entity;

import jakarta.persistence.*;
import kr.co.sboard.dto.UserDTO;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "User")
public class User {

    @Id
    private String uid;
    private String pass;
    private String name;
    private String nick;
    private String email;
    private String hp;

    @Column(nullable = false)
    private String role;

    private String zip;
    private String addr1;
    private String addr2;
    private String regip;


    @CreationTimestamp // NOW()
    private LocalDateTime regDate;

    private String leaveDate;


    @PrePersist
    public void prePersist(){

        if(this.role == null){
            this.role = "USER";
        }

    }



}
