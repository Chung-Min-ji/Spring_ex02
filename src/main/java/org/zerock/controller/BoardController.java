package org.zerock.controller;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;

@RequestMapping("/board/")

@Controller
@Log4j
public class BoardController {

    @Setter(onMethod_ = @Autowired)
    private BoardService service;

    // 전체 리스트 가져오기
    @GetMapping("/list")
    public void list(Model model){
        log.debug("list(model) invoked");

        model.addAttribute("list", service.getList());
    } //list


    // 게시물 등록 화면
    @GetMapping("/register")
    public void register(){
        log.debug("register() invoked.");

    } //register


    // 새 게시물 등록하기
    @PostMapping("/register")
    public String register(BoardVO board, RedirectAttributes rttrs){
        log.debug("register(board, rttrs) invoked.");

        log.info("register : " + board);

        service.register(board);

        // 등록작업 끝난 후, 다시 목록 화면으로 이동할 때
        // 새롭게 등록된 게시물의 bno 함께 전달하기 위해 rttrs 사용
        rttrs.addFlashAttribute("result", board.getBno());

        // redirect: 접두어 -> 스프링mvc가 내부적으로 response.sendRedirect()처리
        return "redirect:/board/list";
    } //register


    // 특정 게시물 조회하기
    @GetMapping("/get")
    public void get(@RequestParam("bno") Long bno, Model model){
        log.debug("get(bno, model) invoked.");

        model.addAttribute("board", service.get(bno));
    } //get


    // 게시물 수정
    @PostMapping("/modify")
    public String modify(BoardVO board, RedirectAttributes rttrs){
        log.debug("modify(board, rttrs) invoked.");

        if (service.modify(board)){
            rttrs.addFlashAttribute("result", "success");

        } //if : 성공적으로 modify가 이루어졌으면...

        return "redirect:/board/list";
    } //modify


    // 게시물 삭제
    @PostMapping("/remove")
    public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttrs){
        log.debug("remove(bno, rttrs) invoked.");

        if (service.remove(bno)){
            rttrs.addFlashAttribute("result", "success");
        } //if : 성공적으로 remove가 이루어졌으면..

        return "redirect:/board/list";
    } //remove




} //BoardController
