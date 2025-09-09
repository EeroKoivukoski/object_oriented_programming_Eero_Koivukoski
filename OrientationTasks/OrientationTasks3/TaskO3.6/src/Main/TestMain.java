package Main;

import EventCode.Event;
import EventCode.EventList;
import EventCode.EventType;
import EventCode.ArrivalProcess;
import DistributionLib.*;


public class TestMain{
    public static void main(String[] args) {
        EventList eventList = new EventList();
        ContinuousGenerator uniGen = new Uniform(0.0,1.0);
        ArrivalProcess arrival = new ArrivalProcess(EventType.ARRIVAL_X, uniGen);

        for (int i = 0; i < 10; i++) {
            arrival.generateNext(eventList);
        }


        System.out.println("All events in order:");
        eventList.printOrderedEvents();

        Event next = eventList.getNextEvent();
        System.out.printf("\nProcessing next event: %s at time %.2f%n",
                          next.getType(), next.getTime());

        System.out.println("\nRemaining events in order:");
        eventList.printOrderedEvents();
    }
}
