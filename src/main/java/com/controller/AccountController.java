package com.controller;

import com.domain.Account;
import com.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    /**
     * find all accounts info and show.
     * @param model contains search result.
     * @return forward to list.jsp
     */
    @RequestMapping("/findAll")
    public String findAll(Model model) {
        System.out.println("Representation layer: find all accounts.");
        List<Account> list = accountService.findAll();
        model.addAttribute("list", list);
        return "list";
    }

    /**
     * Save a player info.
     * @param player player object to save.
     */
    @RequestMapping("/savePlayer")
    public void savePlayer(Account player, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("representation layer: save a player.");
        accountService.saveAccount(player);
        response.sendRedirect(request.getContextPath()+"/account/findAll");
    }

}
