import java.util.*;
import java.util.Random;
import java.util.concurrent.*;

public class SubAnimator implements Runnable{
    private Random rg;
    public SubAnimator(SubComponent subPanel, BlockingQueue<String> queue){
        this.subPanel = subPanel;
        this.queue = queue;
    }

    public void run(){
        while(true){
            rg = new Random();
            try{
                String command = queue.take();
                if(command.equals("Move")){
                    Thread.sleep(DELAY);
                    subPanel.setValues();
                    if(!"Freeze".equals(queue.peek())){
                        queue.add("Move");
                    }
                }
            } catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }
        } 
    }

    private SubComponent subPanel;
    private BlockingQueue<String> queue;
    private static final int DELAY = 100;
}