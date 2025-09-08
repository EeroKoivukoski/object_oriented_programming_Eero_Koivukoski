public class Clock {
    // Private static member to hold the unique instance
    private static Clock instance;

    // Private constructor to prevent instantiation from outside
    private Clock() {
        // Initialization code
    }

    // Public static method to access the unique instance
    public static Clock getInstance() {
        if (instance == null) {
            instance = new Clock();
        }
        return instance;
    }

    // Other methods and properties of the Singleton class
}