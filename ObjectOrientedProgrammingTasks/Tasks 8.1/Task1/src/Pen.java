public class Pen {
    public enum Color {
        RED("red"), GREEN("green"), BLUE("blue");
        private final String color;
        Color(String color) { this.color = color; }
        @Override public String toString() { return color; }
    }

    private Color color;      // Current ink color
    private boolean capped;   // Whether the pen is capped

    // Default constructor → RED pen, capped
    public Pen() {
        this.color = Color.RED;
        this.capped = true;
    }

    // Constructor with selected color → capped
    public Pen(Color color) {
        this.color = color;
        this.capped = true;
    }

    // Remove the cap
    public void capOff() {
        capped = false;
    }

    // Put the cap back on
    public void capOn() {
        capped = true;
    }

    // Draw if uncapped
    public String draw() {
        if (capped) return "";
        return "Drawing " + color.toString();
    }

    // Change color only when capped
    public void changeColor(Color newColor) {
        if (capped) {
            this.color = newColor;
        }
    }
}