package Main;

import EventCode.Event;
import EventCode.EventList;

public class SimulationTest {
    public static void main(String[] args) {
        EventList eventList = new EventList();

        // a) Lisää tapahtumia nimillä
        eventList.addEvent(new Event(5.0, "Arrival"));
        eventList.addEvent(new Event(2.0, "StartService"));
        eventList.addEvent(new Event(8.0, "EndService"));
        eventList.addEvent(new Event(1.5, "Arrival"));

        System.out.println("All events in order:");
        eventList.printOrderedEvents();

        // b) Poista ensimmäinen tapahtuma
        Event next = eventList.getNextEvent();
        System.out.printf("%nProcessing next event: %s at time %.2f%n",
                next.getName(), next.getTime());

        // c) Tulosta EventCode.EventList uudelleen aikajärjestyksessä
        System.out.println("\nRemaining events in order:");
        eventList.printOrderedEvents();
    }
}
