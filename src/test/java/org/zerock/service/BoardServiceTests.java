package org.zerock.service;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/*/*/*.xml")

@Log4j
public class BoardServiceTests {

    @Setter(onMethod_ = @Autowired)
    private BoardService service;

    @Test
    public void testExist(){
        log.debug("testExist() invoked.");

        log.info("service : " + service);
        assertNotNull(service);
    } //testExist

    @Test
    public void testRegister(){
        log.debug("testRegister() invoked.");

        BoardVO board = new BoardVO();
        board.setTitle("새로 작성하는 글");
        board.setContent("새로 작성하는 내용");
        board.setWriter("newbie");

        service.register(board);

        log.info("생성된 게시물 번호 : " + board.getBno());
    } //testRegister

    @Test
    public void testGetList(){
        log.debug("testGetList() invoked.");

//        service.getList().forEach( board -> log.info(board) );
        service.getList(new Criteria(2,10))
                .forEach(board -> log.info(board));
    } //testGetList

    @Test
    public void testGet(){
        log.debug("testGet() invoked.");

        log.info(service.get(1L));
    } //testGet

    @Test
    public void testUpdate(){
        log.debug("testUpdate() invoked");

        BoardVO board = service.get(1L);

        if(board == null) {
            return ;
        } //if

        board.setTitle("제목 수정");

        log.info("MODIFY RESULT : " + service.modify(board));
    }  //testUpdate
} //end class
