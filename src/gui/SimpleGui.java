package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleGui implements ActionListener {
    private JButton button;
    private JFrame window;
    private DrawPanel panel;

    public static void main(String[] args) {
        new SimpleGui().run();

    }

    protected void run() {
        JFrame window = new JFrame();
        JButton button = new JButton("Change color");
        panel = new DrawPanel();
        button.addActionListener(this);

        window.getContentPane().add(BorderLayout.SOUTH, button);
        window.getContentPane().add(BorderLayout.CENTER, panel);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(200, 200);
        window.setVisible(true);
    }

    public void changeText() {
        button.setText("You clicked me");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        changeText();
        changeColor ();
        moveCircle();
    }

    private void moveCircle() {
        for (int x = 0; x <= 300; x++) {
            panel.setXY (x, x);
            window.repaint();
            try {
                Thread.sleep(10);

            }catch (InterruptedException e)
                e.printStackTrace();
        }
    }

    private void changeColor() {
        window.repaint();

    }
}
