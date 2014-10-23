import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleGui3C {
  
  JFrame frame;
  JLabel label;
  JButton colorbutton;
  JButton labelbutton;
  public static void main(String[] args) {
    SimpleGui3C gui = new SimpleGui3C();
    gui.go();
  }

  public void go() {
    frame = new JFrame();
    label = new JLabel();
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
    label.setText(":-)");
    colorbutton = new JButton("Change color");
    labelbutton = new JButton("change text");
    colorbutton.addActionListener(new ColorListener());
    labelbutton.addActionListener(new LabelListener());
    
    MyDrawPanel drawPanel = new MyDrawPanel();
    
    frame.getContentPane().add(BorderLayout.SOUTH,colorbutton);
    frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
   
    frame.getContentPane().add(BorderLayout.WEST,labelbutton);
    frame.getContentPane().add(BorderLayout.EAST, label);

    frame.setSize(300,300);
    frame.setVisible(true);
  }
/*
  public void actionPerformed(ActionEvent event) {
    if(event.getSource() == colorbutton)
      frame.repaint();
    else {
       if(label.getText().equals(":-)")) {
          label.setText("That sweet!");
       }
       else label.setText(":-)");
    }
  } 
*/
  class LabelListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
         if(label.getText().equals(":-)")) {
            label.setText("That sweet!");
         }
         else label.setText(":-)");
    }
  }
  class ColorListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      frame.repaint();
    }
  }
}

class MyDrawPanel extends JPanel {
  public void paintComponent(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
    
    int red = (int) (Math.random()*255);
    int green =  (int) (Math.random()*255);
    int blue =  (int) (Math.random()*255);

    Color startColor = new Color(red,green,blue);

    red = (int) (Math.random()*255);
    green =  (int) (Math.random()*255);
    blue =  (int) (Math.random()*255);

    Color endColor = new Color(red,green,blue);

    GradientPaint gradient = new GradientPaint (70,70, startColor, 150, 150, endColor);
    g2d.setPaint(gradient);
    g2d.fillOval(70,70,100,100);

  }
}
