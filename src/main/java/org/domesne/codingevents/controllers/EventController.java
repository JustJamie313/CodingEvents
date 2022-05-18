package org.domesne.codingevents.controllers;

import org.domesne.codingevents.data.EventData;
import org.domesne.codingevents.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String renderCreateEventForm(Model model){
        model.addAttribute("title","Create Event");
        return "events/create";
    }

    @PostMapping("create")
    public String createEvent(@ModelAttribute Event newEvent){
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
        return "events";
    }

    @GetMapping("edit/{eventId}")
    public String displayEditForm(Model model, @PathVariable int eventId){
        Event editEvent = EventData.getEventById(eventId);
        model.addAttribute("title","Edit Event "+editEvent.getName()+" (id="+editEvent.getId()+")");
        model.addAttribute("event",editEvent);
        return "events/edit";
    }

    @PostMapping("edit")
    public String editEvent(int eventId,String name,String description){
            Event editEvent = EventData.getEventById(eventId);
            editEvent.setName(name);
            editEvent.setDescription(description);
        return "redirect:";
    }
}
