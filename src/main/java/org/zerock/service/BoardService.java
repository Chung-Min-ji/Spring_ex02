package org.zerock.service;

import org.zerock.domain.BoardVO;

import java.util.List;

public interface BoardService {

    public void register(BoardVO board);    // 게시물 등록
    public BoardVO get(Long bno);           // 특정 게시물 조회
    public boolean modify(BoardVO board);   // 게시물 수정
    public boolean remove(Long bno);        // 게시물 삭제
    public List<BoardVO> getList();         // 전체 게시물 목록 조회
} //end interface
