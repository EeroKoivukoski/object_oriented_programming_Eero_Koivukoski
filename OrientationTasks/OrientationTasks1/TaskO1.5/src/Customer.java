public class Customer {
    private static int nextId = 1;
    private final int id;
    private final long queueStartTime;
    private long serviceStartTime;
    private long serviceEndTime;

    public Customer() {
        this.id = nextId++ ;
        this.queueStartTime = System.currentTimeMillis();
    }


    //Methods to get values out of object
    public long getQueueStartTime(){ return queueStartTime; }
    public long getServiceStartTime(){ return serviceStartTime; }
    public long getServiceEndTime(){ return serviceEndTime; }
    public int getId(){ return id; }

    //calculations
    public long getTimeSpentInQueue(){return serviceStartTime - queueStartTime; }
    public long getTimeSpentInService(){return serviceEndTime - serviceStartTime; }
    public long getTimeToRespond(){return serviceEndTime - queueStartTime; }

    //Methods to set values of object
    public void setServiceStartTime(){ this.serviceStartTime = System.currentTimeMillis(); }
    public void setServiceEndTime(){ this.serviceEndTime = System.currentTimeMillis(); }

}
