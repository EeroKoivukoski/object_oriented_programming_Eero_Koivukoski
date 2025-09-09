package Main;

import ClockCode.Clock;

public class TestMain{
    public static void main(String[] args) {
        Clock clock = Clock.getInstance();
        while(clock.getTime() <= 20) {
            System.out.println(clock.getTime());
            clock.advanceTime();
        }
    }
}
