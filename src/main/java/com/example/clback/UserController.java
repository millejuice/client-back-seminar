package com.example.clback;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @GetMapping("")
    public List<User> findAllByPart(@RequestParam String part){
        return userService.readUser(part);
    }

    @PostMapping("")
    public void save(@RequestBody UserDto.CreateUser req){
        userService.save(req);
    }

    @PatchMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody UserDto.CreateUser req){
        userService.update(id,req);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        userService.deleteUser(id);
    }

}
