package com.controller;

import com.domain.Game;
import com.service.ManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ManagementController {

    @Autowired
    private ManagementService managementService;

    /**
     * find all game info and show.
     * @param model contains search result.
     * @return forward to gameList.jsp
     */
    @RequestMapping("/management")
    public String findAll(Model model) {
        System.out.println("Representation layer: find all games.");
        List<Game> list = managementService.findAll();
        model.addAttribute("list", list);
        return "gameList";
    }
}
