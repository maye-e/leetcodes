import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LiftOff implements Runnable {
    protected int counDown = 5;
    private static int taskCount = 0;
    private final int id = taskCount ++;

    public LiftOff() {
    }

    public LiftOff(int counDown) {
        this.counDown = counDown;
    }

    public String status(){
        return "#" + id + "(" + (counDown > 0 ? counDown : "LiftOff!") + "),";
    }

    @Override
    public void run() {
        while (counDown -- > 0){
            System.out.println(status());
            Thread.yield();
        }
    }

    public static void main(String[] args) {
//        ExecutorService exec = Executors.newCachedThreadPool();
//        ExecutorService exec = Executors.newFixedThreadPool(5);
        ExecutorService exec = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i ++){
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}
