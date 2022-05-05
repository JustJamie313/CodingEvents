package org.domesne.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
@RequestMapping("events")
public class EventController {
    private static HashMap<String, ArrayList<String>> events = new HashMap<>();
    @GetMapping
    public String displayAllEvents(Model model) {
        ArrayList<String> sampleData = new ArrayList<>();
        sampleData.add("Together we will explore the world of coding and programming. We will code robots, make a virtual game, tell virtual stories and much more! This camp is full of digital and hands-on activities that will be sure to bring the concept of coding to real life. Note: 6-8th graders will learn how to create a website & an app");
        sampleData.add("Bishop Miege High School\n" +
                "5041 Reinhardt Dr\n" +
                "Roeland Park, KS 66205");
        sampleData.add("activeKids.png");
        events.put("Coding/Programming: Session 1", sampleData);
        sampleData = new ArrayList<>();
        sampleData.add("This instructor-led, live training in Kansas (online or onsite) is aimed at software engineers who wish to develop parallel applications using OpenMP.  By the end of this training, participants will be able to:\n" +
                "                - Understand and use parallel programming with Fortran in OpenMP.\n" +
                "                - Calculate fractals in parallel to render multiple pixels and characters.\n" +
                "                - Implement vector programming with SIMD extensions for HPC systems.\n" +
                "                - Add parallel blocks for specifying shared memory parallelism.");
        sampleData.add("Lighton Tower\n" +
                "7500 College Blvd, 5th Floor\n" +
                "Overland Park, KS 66210");
        sampleData.add("nobleProg.png");
        events.put("Parallel Programming with OpenMP", sampleData);
        sampleData = new ArrayList<>();
        sampleData.add("This instructor-led, live training in Kansas City (online or onsite) is aimed at networking engineers and developers who wish to configure, execute and manage programmable networking resources using P4.  By the end of this training, participants will be able to:\n" +
                "                - Learn the fundamentals of the P4 language.\n" +
                "                - Program network devices.\n" +
                "                - Set up a server for traffic management.\n" +
                "                - Compile and execute a P4 program to control plane applications.\n" +
                "                - Manage network congestion using monitoring and debugging methods.");
        sampleData.add("Crown Center - Two Pershing Square\n" +
                "2300 Main Street\n" +
                "Kansas City, MO 64108");
        sampleData.add("nobleProg.png");
        events.put("P4 Programming", sampleData);
        sampleData = new ArrayList<>();

        model.addAttribute("events",events);
        return "events/index";
    }

    @GetMapping("create")
    public String renderCreateEventForm(){
        return "events/create";
    }

    @PostMapping("create")
    public String createEvent(@RequestParam String eventName, @RequestParam String eventDescription, @RequestParam String eventLocation, @RequestParam String pathToEventImage){
        ArrayList<String> eventDetail = new ArrayList<>();
        eventDetail.add(eventDescription);
        eventDetail.add(eventLocation);
        eventDetail.add(pathToEventImage);
        events.put(eventName, eventDetail);
        return "redirect:";
    }
}
