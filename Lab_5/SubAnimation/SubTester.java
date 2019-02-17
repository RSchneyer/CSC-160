import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.concurrent.*;

public class SubTester{
    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 500;
    private static final int VALUES_LENGTH = 80;
    public static void main(String [] args){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SubComponent panel = new SubComponent();
        frame.add(panel, BorderLayout.CENTER);

        final JButton moveButton = new JButton("Move");
        JButton freezeButton = new JButton("Freeze");
        JPanel buttons = new JPanel();
        buttons.add(moveButton);
        buttons.add(freezeButton);
        frame.add(buttons, BorderLayout.NORTH);

        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setVisible(true);

        final BlockingQueue<String> queue = new LinkedBlockingQueue<String>();
        queue.add("Freeze");

        final SubAnimator animator = new SubAnimator(panel, queue);

        freezeButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                queue.add("Freeze");
                moveButton.setEnabled(true);
            }
        }); 
        moveButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                moveButton.setEnabled(false);
                queue.add("Move");
            }
        });

        Thread aniThread = new Thread(animator);
        aniThread.start(); 

    }
}