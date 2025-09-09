package ClockCode;

public class MyClock {
    private static MyClock instance;
    private int time;

    private MyClock() {
        this.time=0;
    }

    public static MyClock getInstance() {
        if (instance == null) {
            instance = new MyClock();
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