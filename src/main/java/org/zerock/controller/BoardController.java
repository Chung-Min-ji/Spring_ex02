package org.zerock.controller;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.service.BoardService;

@RequestMapping("/board/*")

@Controller
@Log4j
public class BoardController {

    @Setter(onMethod_ = @Autowired)
    private BoardService service;

    @GetMapping("/list")
    public void list(Model model){
        log.debug("list(model) invoked");

        model.addAttribute("list", service.getList());
    } //list


} //BoardController
