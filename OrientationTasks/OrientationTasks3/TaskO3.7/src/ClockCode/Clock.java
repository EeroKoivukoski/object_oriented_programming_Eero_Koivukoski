package ClockCode;

public class Clock {
    private double time;

    public Clock() {
        this.time = 0.0;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public void advance(double delta) {
        this.time += delta;
    }
}
