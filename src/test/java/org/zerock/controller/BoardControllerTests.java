package org.zerock.controller;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({
        "file:src/main/webapp/*/*/*.xml",
        "file:src/main/webapp/*/*/*/*.xml"
})

@Log4j
public class BoardControllerTests {

    @Setter(onMethod_ = @Autowired)
    private  WebAppConfiguration ctx;

    private MockMvc mockMvc;

    @Before
    public void setup(){
        log.debug("setup() invoked.");


    } //setup

} //end class
