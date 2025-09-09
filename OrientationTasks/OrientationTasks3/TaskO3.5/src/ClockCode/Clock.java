package ClockCode;

public class Clock {
    private static Clock instance;
    private int time;

    private Clock() {
        this.time=0;
    }

    public static Clock getInstance() {
        if (instance == null) {
            instance = new Clock();
        }
        return instance;
    }
    public int getTime() {
        return time;
    }
    public void setTime(int time) {
        this.time = time;
    }
    public void advanceTime() {
        this.time++;
    }
}