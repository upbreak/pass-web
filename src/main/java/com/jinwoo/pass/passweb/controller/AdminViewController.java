package com.jinwoo.pass.passweb.controller;

import com.jinwoo.pass.passweb.dto.request.BulkPassRequest;
import com.jinwoo.pass.passweb.service.BulkPassService;
import com.jinwoo.pass.passweb.service.PackageService;
import com.jinwoo.pass.passweb.service.StatisticsService;
import com.jinwoo.pass.passweb.service.UserGroupMappingService;
import com.jinwoo.pass.passweb.utils.LocalDateTimeUtils;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminViewController {

    private final BulkPassService bulkPassService;
    private final PackageService packageService;
    private final UserGroupMappingService userGroupMappingService;
    private final StatisticsService statisticsService;

    @GetMapping("/home")
    public String home(
            @RequestParam("to") String toString
            , ModelMap map
    ){
        LocalDateTime to = LocalDateTimeUtils.parseDate(toString);

        map.addAttribute("chartData", statisticsService.makeChartData(to));

        return "admin/index";
    }

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
