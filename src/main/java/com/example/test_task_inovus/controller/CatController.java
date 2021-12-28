package com.example.test_task_inovus.controller;

import com.example.test_task_inovus.dto.CatDTO;
import com.example.test_task_inovus.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class CatController {

        private CatService catService;

        @Autowired
        public CatController(CatService catService) {
            this.catService = catService;

        }

        @GetMapping("/candidates")
        public String vote(Model model) {
            List<CatDTO> cats = catService.getTwoCats();
            if (cats.isEmpty()) {
                return "/final";
            }
            model.addAttribute("list", cats);
            return "candidates";
        }

        @GetMapping("/result")
        public String result(Model model) {
            List<CatDTO> catDtoList = catService.getTop10();
            model.addAttribute("list", catDtoList);
            return "result";
        }


        @PostMapping("/candidates")
        public void vote(@RequestBody String id) {
            catService.increment(Long.parseLong(id));
        }
    }

