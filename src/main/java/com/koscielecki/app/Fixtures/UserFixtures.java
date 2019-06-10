package com.koscielecki.app.Fixtures;

import com.koscielecki.app.Model.User;
import com.koscielecki.app.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserFixtures {

    @Autowired
    UserRepository userRepository;

    public void createIntoDb(){
        List<User> users=createUsers();
    }
    public List<User> createUsers(){
        List<User>users=new ArrayList<>();
        User user1=new User();
        user1.setName("Chuj");
        user1.setLastName("Ci");
        user1.setEmail("naimie@onet.pl");
        user1.setPassword("aa");
        user1.setEnabled(1);
        userRepository.save(user1);

        User user2=new User();
        user2.setName("gowno");
        user2.setLastName("Ci");
        user2.setEmail("naimie@onet.pl");
        user2.setPassword("aa");
        user2.setEnabled(1);
        userRepository.save(user2);

        User user3=new User();
        user3.setName("Kurwa");
        user3.setLastName("Ci");
        user3.setEmail("naimie@onet.pl");
        user3.setPassword("aa");
        user3.setEnabled(1);
        userRepository.save(user3);

        return users;
    }
}
