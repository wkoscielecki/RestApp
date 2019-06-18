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
        user1.setName("qwe");
        user1.setLastName("qwe");
        user1.setEmail("naimie@onet.pl");
        user1.setPassword("aa");
        user1.setEnabled(1);
        userRepository.save(user1);

        User user2=new User();
        user2.setName("qwe");
        user2.setLastName("wewewe");
        user2.setEmail("nwee@onet.pl");
        user2.setPassword("awewe");
        user2.setEnabled(1);
        userRepository.save(user2);

        User user3=new User();
        user3.setName("weqwe");
        user3.setLastName("wewq");
        user3.setEmail("weqe@onet.pl");
        user3.setPassword("w");
        user3.setEnabled(1);
        userRepository.save(user3);

        return users;
    }
}
