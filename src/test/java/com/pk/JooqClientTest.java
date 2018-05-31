package com.pk;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Created by pangkunkun on 2018/5/31.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JooqStudyApplication.class)
public class JooqClientTest {

    @Autowired
    private JooqClient jooqClient;

    @Test
    public void testUpdate(){
        jooqClient.updateUsers();
    }

}
