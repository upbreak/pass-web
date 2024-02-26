package com.jinwoo.pass.passweb.controller;

import com.jinwoo.pass.passweb.dto.Pass;
import com.jinwoo.pass.passweb.dto.User;
import com.jinwoo.pass.passweb.service.PassService;
import com.jinwoo.pass.passweb.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/pass")
public class PassViewController {

    private final UserService userService;
    private final PassService passService;

    @GetMapping
    public String getPass(
            @RequestParam("userId") String userId
            , ModelMap map
    ){
        List<Pass> passes = passService.getPasses(userId);
        User user = userService.getUser(userId);

        map.addAttribute("passes", passes);
        map.addAttribute("user", user);

        return "pass/index";
    }
}
