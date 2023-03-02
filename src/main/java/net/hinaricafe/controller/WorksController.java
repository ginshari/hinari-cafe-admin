package net.hinaricafe.controller;

import lombok.RequiredArgsConstructor;
import net.hinaricafe.model.Event;
import net.hinaricafe.model.Link;
import net.hinaricafe.model.Profile;
import net.hinaricafe.model.WorksPage;
import net.hinaricafe.service.WorksService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/works")
@RequiredArgsConstructor
public class WorksController {

    private final WorksService worksService;

    @GetMapping("")
    public String showWorks(Model model) {
        WorksPage worksPage = worksService.getWorksPage();
        model.addAttribute("links", worksPage.getLinks());
        model.addAttribute("profiles", worksPage.getProfiles());
        model.addAttribute("events", worksPage.getEvents());
        return "works/index";
    }

    @GetMapping("/links/{objectId}")
    public String showLinksEdit(@PathVariable("objectId") String objectId, Model model) {
        model.addAttribute("link", worksService.getLink(objectId));
        return "/works/links/edit";
    }

    @PostMapping("/links")
    public String upsertLink(@ModelAttribute Link link) {
        if (link.getId().isEmpty()) {
            worksService.insertLink(link);
        } else {
            worksService.updateLink(link);
        }

        return "redirect:/works";
    }

    @GetMapping("/profiles/{objectId}")
    public String showProfilesEdit(@PathVariable("objectId") String objectId, Model model) {
        model.addAttribute("profile", worksService.getProfile(objectId));
        return "/works/profiles/edit";
    }

    @PostMapping("/profiles")
    public String upsertProfile(@ModelAttribute Profile profile) {
        if (profile.getId().isEmpty()) {
            worksService.insertProfile(profile);
        } else {
            worksService.updateProfile(profile);
        }

        return "redirect:/works";
    }

    @GetMapping("/events/{objectId}")
    public String showEventsEdit(@PathVariable("objectId") String objectId, Model model) {
        model.addAttribute("event", worksService.getEvent(objectId));
        return "/works/events/edit";
    }

    @PostMapping("/events")
    public String upsertEvent(@ModelAttribute Event event) {
        if (event.getId().isEmpty()) {
            worksService.insertEvent(event);
        } else {
            worksService.updateEvent(event);
        }

        return "redirect:/works";
    }

}
