package kr.co.sboard.service;

import kr.co.sboard.dto.UserDTO;
import kr.co.sboard.entity.User;
import kr.co.sboard.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordencoder;

    public void register(UserDTO userDTO){

        // 비밀번호 인코딩
        String encodedPass = passwordencoder.encode(userDTO.getPass());
        userDTO.setPass(encodedPass);

        // 엔티티 변환
        User user = modelMapper.map(userDTO, User.class);


        userRepository.save(user);

    }

    public long checkUser(String type, String value){

        long count = 0;

        if(type.equals("uid")){
            count = userRepository.countByUid(value);
        }else if(type.equals("nick")){
            count = userRepository.countByNick(value);
        }else if(type.equals("email")){
            count = userRepository.countByEmail(value);
        }else if(type.equals("ph")){
            count = userRepository.countByHp(value);
        }


        return count;

    }

}
