package org.domesne.codingevents.controllers;

import org.domesne.codingevents.data.EventData;
import org.domesne.codingevents.models.Event;
import org.domesne.codingevents.models.EventType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.text.CollationElementIterator;

import static java.util.Objects.isNull;

@Controller
@RequestMapping("events")
public class EventController {

    @GetMapping
    public String displayAllEvents(Model model) {
        model.addAttribute("title","All Events");
        model.addAttribute("events", EventData.getAllEvents());
        return "events/index";
    }

    @GetMapping("create")
    public String displayCreateEventForm(Model model){
        model.addAttribute("title","Create Event");
        model.addAttribute(new Event());
        model.addAttribute("types",EventType.values());
        return "events/create";
    }

    @PostMapping("create")
    public String processCreateEventForm(@ModelAttribute @Valid Event newEvent, Errors errors, Model model){
        if(errors.hasErrors()){
            model.addAttribute("title","Create Event");
            return "events/create";
        }
        EventData.addEvent(newEvent);
        return "redirect:";
    }

    @GetMapping("delete")
    public String displayDeleteEventForm(Model model){
        model.addAttribute("title","Delete Events");
        model.addAttribute("events",EventData.getAllEvents());
        return "events/delete";
    }

    @PostMapping("delete")
    public String deleteEvent(@RequestParam(required = false) int[] eventIds){
        if(!isNull(eventIds)){
            for(int id : eventIds){
                EventData.removeEvent(id);
            }
        }
        return "redirect:";
    }
}
