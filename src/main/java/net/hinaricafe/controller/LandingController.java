package net.hinaricafe.controller;

import lombok.RequiredArgsConstructor;
import net.hinaricafe.model.LandingPage;
import net.hinaricafe.model.LpItem;
import net.hinaricafe.service.LandingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/landing")
@RequiredArgsConstructor
public class LandingController {

    private final LandingService landingService;

    @GetMapping("")
    public String showLanding(Model model) {
        LandingPage landingPage = landingService.getLandingPage();
        model.addAttribute("id", landingPage.getId());
        model.addAttribute("greeting", landingPage.getGreeting());
        model.addAttribute("annotation", landingPage.getAnnotation());
        model.addAttribute("works", landingPage.getWorks());
        model.addAttribute("recommends", landingPage.getRecommends());
        model.addAttribute("coffees", landingPage.getCoffees());
        return "landing/index";
    }

    @GetMapping("/{objectId}")
    public String showLandingEdit(@PathVariable("objectId") String objectId, Model model) {
        model.addAttribute("landing", landingService.getLandingPage());
        return "/landing/edit";
    }

    @PostMapping("")
    public String updateLanding(@ModelAttribute LandingPage landingPage) {
        landingService.updateLandingPage(landingPage);
        return "redirect:/landing";
    }

    @GetMapping("/lpitems/{objectId}")
    public String showLpItemsEdit(@PathVariable("objectId") String objectId, Model model) {
        model.addAttribute("lpitem", landingService.getLpItem(objectId));
        return "/landing/lpitems/edit";
    }

    @PostMapping("/lpitems")
    public String upsertLpItem(@ModelAttribute LpItem lpItem) {
        if (lpItem.getId().isEmpty()) {
            landingService.insertLpItem(lpItem);
        } else {
            landingService.updateLpItem(lpItem);
        }

        return "redirect:/landing";
    }

}
