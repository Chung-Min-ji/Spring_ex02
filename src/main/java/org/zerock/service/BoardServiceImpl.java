package org.zerock.service;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;

import java.util.List;


@Service

@Log4j
@AllArgsConstructor
public class BoardServiceImpl implements BoardService{

    // 스프링 4.3 이후부터는 @Autowired 어노테이션 안붙여도 자동주입 됨.
    @Setter(onMethod_ = @Autowired)
    private BoardMapper mapper;

    @Override
    public void register(BoardVO board){
        log.debug("register(board) invoked");

        mapper.insertSelectKey(board);
    } //register

    @Override
    public BoardVO get(Long bno) {
        log.debug("get(bno) invoked.");

        log.info("bno : " + bno);

        return mapper.read(bno);
    } //get

    @Override
    public boolean modify(BoardVO board) {
        log.debug("modify(board) invoked.");

        log.info("modify : " + board);

        return mapper.update(board) == 1;
    } //modify

    @Override
    public boolean remove(Long bno) {
        log.debug("remove(bno) invoked.");

        log.info("bno : " + bno);

        return mapper.delete(bno) == 1;
    } //remove

    @Override
    public List<BoardVO> getList() {
        log.debug("getList() invoked");

        return mapper.getList();
    } //getList

} //BoardServiceImpl

