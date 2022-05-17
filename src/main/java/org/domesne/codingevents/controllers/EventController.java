package org.domesne.codingevents.controllers;

import org.domesne.codingevents.data.EventData;
import org.domesne.codingevents.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("events")
public class EventController {

    @GetMapping
    public String displayAllEvents(Model model) {
        model.addAttribute("events", EventData.getAllEvents());
        return "events/index";
    }

    @GetMapping("create")
    public String renderCreateEventForm(){
        return "events/create";
    }

    @PostMapping("create")
    public String createEvent(@RequestParam String eventName, @RequestParam String eventDescription){
        EventData.addEvent(new Event(eventName, eventDescription));
        return "redirect:";
    }
}
