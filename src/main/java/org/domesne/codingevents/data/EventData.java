package org.domesne.codingevents.data;

import org.domesne.codingevents.models.Event;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class EventData {

    private static final Map<Integer,Event> events = new HashMap<>();

    public static void removeEvent(int aId){events.remove(aId);}

    public static void addEvent(Event aEvent){
        events.put(aEvent.getId(),aEvent);
    }

    public static Event getEventById(int aId){return events.get(aId);}

    public static Collection<Event> getAllEvents(){return events.values();}

}
