package com.jinwoo.pass.passweb.controller;

import com.jinwoo.pass.passweb.dto.request.BulkPassRequest;
import com.jinwoo.pass.passweb.service.BulkPassService;
import com.jinwoo.pass.passweb.service.PackageService;
import com.jinwoo.pass.passweb.service.UserGroupMappingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminViewController {

    private final BulkPassService bulkPassService;
    private final PackageService packageService;
    private final UserGroupMappingService userGroupMappingService;

    @GetMapping("/bulk-pass")
    public String registerBulkPass(ModelMap map) {

        map.addAttribute("bulkPasses", bulkPassService.getAllBulkPasses());
        map.addAttribute("packages", packageService.getAllPackages());
        map.addAttribute("userGroupIds", userGroupMappingService.getAllUserGroupIds());
        map.addAttribute("request", new BulkPassRequest());

        return "admin/bulk-pass";
    }

    @PostMapping("/bulk-pass")
    public String addBulkPass(@ModelAttribute("request") BulkPassRequest request){
        bulkPassService.addBulkPass(request);

        return "redirect:/admin/bulk-pass";
    }
}
