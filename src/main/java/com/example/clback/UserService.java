package com.example.clback;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;

    public void save(UserDto.CreateUser req){
        User user = User.builder()
                .name(req.getName())
                .part(req.getPart())
                .age(req.getAge())
                .build();
        userRepo.save(user);
    }

    public List<User> readUser(String part){
        if(Objects.equals(part, "all")){
            return userRepo.findAll();
        }
        else {
            return userRepo.findByPart(part);
        }
    }

    public void update(Long id, UserDto.CreateUser req){
        User user = userRepo.findById(id).orElseThrow(RuntimeException::new);
        user.update(req.getName(),req.getPart(),req.getAge());
        userRepo.save(user);
    }

    public void deleteUser(Long id){
        userRepo.deleteById(id);
    }
}
