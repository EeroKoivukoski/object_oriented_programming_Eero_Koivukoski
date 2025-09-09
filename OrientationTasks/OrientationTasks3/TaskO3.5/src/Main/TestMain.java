package Main;

import ClockCode.MyClock;

public class TestMain{
    public static void main(String[] args) {
        MyClock clock = MyClock.getInstance();
        while(clock.getTime() <= 20) {
            System.out.println(clock.getTime());
            clock.advanceTime();
        }
    }
}
