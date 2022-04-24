public class Indicator {
    private boolean status = false;
    private int count = 0;

    public void alarm(boolean status) {
        if(count == 0 && status) {
            this.status = status;
            count++;
        }
    }

    public boolean getStatus() {
        return status;
    }

    public int getCounter() {
        return count;
    }
}
