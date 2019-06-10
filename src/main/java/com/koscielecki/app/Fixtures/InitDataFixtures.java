package com.koscielecki.app.Fixtures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class InitDataFixtures {

    @Autowired
    RoleFixtures roleFixtures;
    @Autowired
    UserFixtures userFixtures;

    @PostConstruct
    public void initData(){
        roleFixtures.crateAndInsertIntoDb();
        userFixtures.createIntoDb();
    }
}
