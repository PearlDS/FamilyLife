public class Lungs implements Runnable{

    private boolean lungsFull;


    @Override
    public void run() {

        for (;;){

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
            if (lungsFull){
                System.out.println(Thread.currentThread().getName()+ " breathes out");
                lungsFull= false;
            }else {
                System.out.println(Thread.currentThread().getName()+" breathes in");
                lungsFull= true;
            }
        }

    }
}
