package net.hinaricafe.controller;

import lombok.RequiredArgsConstructor;
import net.hinaricafe.model.Coffee;
import net.hinaricafe.model.CoffeesPage;
import net.hinaricafe.service.CoffeesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/coffees")
@RequiredArgsConstructor
public class CoffeesController {

    private final CoffeesService coffeesService;

    @GetMapping("")
    public String showCoffees(Model model) {
        CoffeesPage coffeesPage = coffeesService.getCoffeesPage();
        model.addAttribute("coffees", coffeesPage.getCoffees());
        return "coffees/index";
    }

    @GetMapping("/coffees/{objectId}")
    public String showCoffeesEdit(@PathVariable("objectId") String objectId, Model model) {
        model.addAttribute("coffee", coffeesService.getCoffee(objectId));
        return "/coffees/coffees/edit";
    }

    @PostMapping("/coffees")
    public String upsertCoffee(@ModelAttribute Coffee coffee) {
        if (coffee.getId().isEmpty()) {
            coffeesService.insertCoffee(coffee);
        } else {
            coffeesService.updateCoffee(coffee);
        }

        return "redirect:/coffees";
    }

}
