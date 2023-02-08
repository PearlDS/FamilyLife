public class HeartBeat implements Runnable{

    private int secondsBetweenBeats;

    public HeartBeat(int secondsBetweenBeats) {
        this.secondsBetweenBeats = secondsBetweenBeats;
    }

    @Override
    public void run() {


        for (;;){

            try {
                Thread.sleep(secondsBetweenBeats);
            } catch (InterruptedException e) {
              break;
            }
            System.out.println(Thread.currentThread().getName()+ " heart's: <3 <3");
        }

    }
}
