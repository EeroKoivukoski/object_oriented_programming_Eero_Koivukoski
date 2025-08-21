class Television {
    //variables to mimic the features of a television
    boolean power=false;
    int channel;

    //simple methods to check status of the television
    public boolean isOn() { return power; }
    public int getChannel() { return channel; }

    //method to switch the power variable of the television
    public void pressOnOff() { power = !power; }

    //method to switch the channel variable
    public void setChannel(int setchannel) {
        channel = setchannel;
        while (channel >10){
            channel = channel - 10;
        }
    }
}

class TelevisionViewer {
    public static void main(String[] args) {
        Television myTV = new Television();
        myTV.setChannel(1);

        for (int day = 1; day <= 10; day++) {
            System.out.println("Woke up, day " + day);

            boolean tired = false;

            if (!myTV.isOn())
                myTV.pressOnOff();

            while (!tired) {
                System.out.println("Watching channel " + myTV.getChannel());
                myTV.setChannel(myTV.getChannel() + 1);
                if (myTV.getChannel() % 4 == 0)
                    tired = true;
            }

            myTV.pressOnOff();

            System.out.println("Falling asleep");
        }
    }
}