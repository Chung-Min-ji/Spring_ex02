package org.zerock.service;

import org.zerock.domain.BoardVO;

import java.util.List;

public interface BoardService {

    public void register(BoardVO board);    //게시물 등록
    public BoardVO get(Long bno);           //
    public boolean modify(BoardVO board);   //
    public boolean remove(Long bno);        //
    public List<BoardVO> getList();         //
} //end interface
