package com.example.onlybounty.controllers;
import com.example.onlybounty.model.Kid;
import com.example.onlybounty.service.KidsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@Controller
@RequestMapping("/kids")
public class KidsController {
    private KidsService kidsService;

    public KidsController(KidsService kidsService) {
        this.kidsService = kidsService;
    }


    @RequestMapping
    public String showAllKids (Model model){
        List<Kid> allKids = kidsService.getAllKids();
        model.addAttribute("allKids", allKids);

        return "allKids";
    }

    @RequestMapping("/addNewKid")
    public String addNewKid (Model model){
        Kid kid = new Kid();
        model.addAttribute("kid", kid);
        return "new";
    }

    @RequestMapping("/saveKid")
    public String saveKid (@ModelAttribute("kid") Kid kid){
        kidsService.saveKid(kid);
        return "redirect:/kids/";
    }

    @RequestMapping("/updateInfo")
    public String updateKid(@RequestParam("kidId") int id, Model model) {
        Kid kid = kidsService.getKid(id);
        model.addAttribute("kid", kid);

        return "edit";
    }

    @RequestMapping("/deleteKid")
    public String deleteKid (@RequestParam("kidId") int id){
        kidsService.deleteKid(id);
        return "redirect:/kids/";
    }

    @RequestMapping("/viewKid")
    public String viewKid(@RequestParam("kidId") int id, Model model) {
        Kid kid = kidsService.getKid(id);
        model.addAttribute("kid", kid);

        return "kid";
    }
}