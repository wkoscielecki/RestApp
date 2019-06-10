package com.koscielecki.app.Service;

import com.koscielecki.app.Model.Role;
import com.koscielecki.app.Model.User;
import com.koscielecki.app.Repository.RoleRepository;
import com.koscielecki.app.Repository.UserRepository;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class UserService {


    private UserRepository userRepository;
//    private final BCryptPasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository,  RoleRepository roleRepository) {
        this.userRepository = userRepository;

        this.roleRepository = roleRepository;
    }

    List<User> findAll(){
        return userRepository.findAll();
    }
    public User save(User user){
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(1);
        Role userRole = roleRepository.findByName("ROLE_ADMIN");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);

        return user;
    }
    public void deleteUser(User user){
        userRepository.delete(user);
    }


}
