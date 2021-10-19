package org.zerock.controller;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({
        "file:src/main/webapp/*/*/*.xml",
        "file:src/main/webapp/*/*/*/*.xml"
})

@Log4j
public class BoardControllerTests {

    @Setter(onMethod_ = @Autowired)
    private WebApplicationContext ctx;

    // 가짜 mvc. 가짜 url과 파라미터등을 브라우저에서 사용하는 것처럼 만들어 Controller실행해볼 수 있다.
    private MockMvc mockMvc;

    @Before
    // 해당 어노테이션 붙으면 모든 테스트 전에 매번 실행
    public void setup(){
        log.debug("setup() invoked.");

        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    } //setup

    @Test
    public void testList() throws Exception{
        log.debug("testList() invoked.");

        log.info(
                //MockMvcRequestBuilders를 이용해 GET방식 호출.
                mockMvc.perform(MockMvcRequestBuilders.get("/board/list"))
                        .andReturn()
                        .getModelAndView()
                        .getModelMap());
    } //testList

    @Test
    public void testRegister() throws Exception{
        log.debug("testRegister() invoked.");

        String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
                .param("title", "테스트 새 글 제목")
                .param("content", "테스트 새 글 내용")
                .param("writer", "user00")
        ).andReturn()
                .getModelAndView()
                .getViewName();

        log.info("resultPage : " + resultPage);
    } //testRegister

    @Test
    public void testGet() throws Exception{
        log.debug("testGet() invoked.");

        log.info(mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/board/get")
                        .param("bno", "2")) //perform
                        .andReturn()
                        .getModelAndView()
                        .getModelMap()
                ); //info
    } //testGet

    @Test
    public void testModify() throws Exception {
        log.debug("testModify() invoked.");

        String resultPage = mockMvc
                .perform(MockMvcRequestBuilders.post("/board/modify")
                        .param("bno", "1")
                        .param("title", "수정된 테스트 새글 제목")
                        .param("content", "수정된 테스트 새글 내용")
                        .param("writer", "user00")) //perform
                .andReturn()
                .getModelAndView()
                .getViewName();
    } //testModify

    @Test
    public void testRemove() throws Exception{
        log.debug("testRemove() invoked.");

        // 삭제 전 DB에 게시물 번호 존재하는지 확인할 것
        String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/remove")
                .param("bno", "25")
                ).andReturn().getModelAndView().getViewName();

        log.info(resultPage);
    } //testRemove

} //end class
