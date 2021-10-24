package org.zerock.mapper;


import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

import java.util.List;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")

@Log4j
public class BoardMapperTests {

    @Setter(onMethod_ = @Autowired)
    private BoardMapper mapper;

    @Test
    public void testGetList(){
        log.debug("testGetList() invoked");

        assertNotNull(mapper);

        mapper.getList().forEach(board->log.info(board));
    } //testGetList


    @Test
    public void testInsert(){
        log.debug("testInsert() invoekd");

        BoardVO board = new BoardVO();
        board.setTitle("new title");
        board.setContent("new content");
        board.setWriter("newbie");

        mapper.insert(board);

        log.info("board : " + board);
    } //testInsert

    @Test
    public void testInsertSelectKey(){
         log.debug("testInsertSelectKey() invoked.");

         BoardVO board = new BoardVO();
         board.setTitle("new title- select key");
         board.setContent("new content - select key");
         board.setWriter("newbie");

         mapper.insertSelectKey(board);

         log.info("board : " + board);
    } //testInsertSelectKey

    @Test
    public void testRead(){
        log.debug("testRead() invoked");

        // 존재하는 게시물 번호로 테스트
        BoardVO board = mapper.read(5L);

        log.info("board : " + board);
    } //testRead

    @Test
    public void testDelete(){
        log.debug("testDelete() invoked");

        log.info("DELETE COUNT : " + mapper.delete(3L));
    } //testDelete

    @Test
    public void testUpdate(){
        log.debug("testUpdate() invoked.");

        BoardVO board = new BoardVO();

        // 실행 전 존재하는 번호인지 확인할 것
        board.setBno(5L);
        board.setTitle("수정된 제목");
        board.setContent("수정된 내용");
        board.setWriter("user00");

        int count = mapper.update(board);
        log.info("UPDATE COUNT : " + count);
    } //testUpdate

    @Test
    public void testPaging(){
        log.debug("test Paging() invoked.");

        Criteria cri = new Criteria();

        // 10개씩 3페이지
        cri.setPageNum(3);
        cri.setAmount(10);
        
        List<BoardVO> list = mapper.getListWithPaging(cri);

        list.forEach(board -> log.info(board));
    } //testPaging
} // end class
