import java.util.Random;

public class Person implements Runnable{

    private String name;
    private  int age;
    private Thread life;
    private Thread heart;
    private Thread breathing;

    public Person(String name, int age, int heartBeatMilliSeconds) {
        this.name = name;
        this.age = age;
        heart = new Thread(new HeartBeat(heartBeatMilliSeconds), name);
        breathing = new Thread(new Lungs(), name);
        life = new Thread(this, name);


    }

    public void startLife(){
        life.start();
        breathing.start();
        heart.start();
    }

    public void endLife(){
        heart.interrupt();
        breathing.interrupt();
        System.out.println(life.getName()+ " died.");
    }

    @Override
    public void run() {
        Random random = new Random();

            for (int i = age; i < 100; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(life.getName() + " is " + i + " years old.");
                if (random.nextInt(20) == 13) {
                    System.out.println("Bad luck!");
                   break;
                }

            }
            endLife();


    }
}
