package com.koscielecki.app.Service;

import com.koscielecki.app.Model.User;
import com.koscielecki.app.Repository.UserRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/app")
public class DbServiceResource {


    UserService userService;
    UserRepository userRepository;

    public DbServiceResource(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository=userRepository;
    }
        @PostMapping("/users")
        public User createUser(@Valid @RequestBody User user ) {
            return userService.save(user);
        }
        @GetMapping("/users")
    public List<User>getAllUsers(){
        return userService.findAll();
        }
        @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable(value = "id") Long id){
        User user=userRepository.getOne(id);
        if (user==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(user);
        }
        @PutMapping("/users/{id}")
        public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long id, @Valid @RequestBody User userDetail) {
            User user = userRepository.getOne(id);
            if (user == null) {
                return ResponseEntity.notFound().build();
            }
            user.setName(userDetail.getName());
            user.setLastName(userDetail.getLastName());
            user.setEmail(userDetail.getEmail());
            User updateUser=userService.save(user);
            return ResponseEntity.ok().body(updateUser);
        }
        @DeleteMapping("users/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable(value = "id") Long id){
        User user=userRepository.getOne(id);
            if (user == null) {
                return ResponseEntity.notFound().build();
            }
            userService.deleteUser(user);
            return ResponseEntity.ok().body(user);
        }








}
