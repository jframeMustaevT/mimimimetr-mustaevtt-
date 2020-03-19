package ru.mustaevtt.mimimetr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.mustaevtt.mimimetr.dto.CatDto;
import ru.mustaevtt.mimimetr.service.CatService;
import ru.mustaevtt.mimimetr.service.VoteService;

import java.util.List;

@Controller
public class CatController {
    private CatService catService;
    private VoteService voteService;

    @Autowired
    public CatController(CatService catService, VoteService voteService) {
        this.catService = catService;
        this.voteService = voteService;
    }

    @GetMapping("/vote")
    public String vote(Model model) {
        List<CatDto> cats = catService.getPairCats();
        if (cats.isEmpty()) {
            return "thank";
        }
        model.addAttribute("list", cats);
        return "vote";
    }

    @GetMapping("/result")
    public String result(Model model) {
        List<CatDto> catDtoList = catService.getTop10Cats();
        model.addAttribute("list", catDtoList);
        return "result";
    }


    @PostMapping("/vote")
    public void vote(@RequestBody String id) {
        System.out.println(id);
        voteService.save(Long.parseLong(id));
    }
}
