package Main;

import ClockCode.Clock;
import CustomerCode.Customer;
import CustomerCode.ServicePoint;
import DistributionLib.*;
import EventCode.ArrivalProcess;
import EventCode.Event;
import EventCode.EventList;
import EventCode.EventType;

public class TestMain {
    public static void main(String[] args) {
        Clock clock = new Clock();
        EventList eventList = new EventList();
        ServicePoint servicePoint = new ServicePoint();

        ContinuousGenerator gen = new Uniform(1.0, 5.0);
        ArrivalProcess arrivalProcess = new ArrivalProcess(EventType.ARRIVAL, gen);

        Event lastEvent = null;
        for (int i = 0; i < 10; i++) {
            Event e = arrivalProcess.generateNext();
            eventList.addEvent(e);
            lastEvent = e;
        }

        if (lastEvent != null) {
            clock.setTime(lastEvent.getTime());
        }
        System.out.println("ClockCode.Clock after arrivals: " + clock.getTime());

        while (!eventList.isEmpty()) {
            Event e = eventList.getNextEvent();
            Customer c = new Customer(e.getTime());
            servicePoint.addCustomer(c);
        }

        clock.advance(5.0);
        System.out.println("ClockCode.Clock after advancing: " + clock.getTime());

        while (servicePoint.hasCustomers()) {
            Customer c = servicePoint.serveNext();
            double timeInSystem = clock.getTime() - c.getArrivalTime();
            System.out.printf("CustomerCode.Customer arrived at %.2f, departed at %.2f, time in system = %.2f%n",
                              c.getArrivalTime(), clock.getTime(), timeInSystem);
        }
    }
}
