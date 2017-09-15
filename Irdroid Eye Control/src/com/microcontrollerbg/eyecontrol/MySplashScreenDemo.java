package com.microcontrollerbg.eyecontrol;
import java.awt.Dimension;
import java.awt.FlowLayout;  
import java.awt.Toolkit;
import java.awt.Window;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.*;  
 public class MySplashScreenDemo {  
  MySplashScreenDemo() {  
  // some time consuming task before UI initialization  
  someTask();  
  // UI will initialize now   
  initUI();  
  }  
  void someTask() {  
  System.out.println("Some time consuming task is executed");  
  JWindow window = new JWindow();
 
  Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
 
  int x = (int) (dimension.getWidth()  / 4);
  int y = (int) (dimension.getHeight()  / 6);
  window.getContentPane().add(
      new JLabel("Loading...", new ImageIcon(MySplashScreenDemo.class.getResource("IR_branging.png")), SwingConstants.CENTER));
  window.setBounds(x, y, 800, 600);

  window.setVisible(true);
  try {
      Thread.sleep(1000);
  } catch (InterruptedException e) {
      e.printStackTrace();
  }
  window.setVisible(false);
 

  }  
  void initUI() {  
  JFrame frame = new JFrame("Splash Screen Demo");  
  JPanel panel = new JPanel();  
  panel.setLayout(new FlowLayout());  
  JLabel label = new JLabel("www.isumitjha.com");  
  panel.add(label);  
  frame.add(panel);  
  frame.setSize(300, 300);  
  frame.setLocationRelativeTo(null);  
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
  frame.setVisible(true);  
  System.out.println("UI initialized");  
  }  
  public static void main(String s[]) {  
  MySplashScreenDemo ss = new MySplashScreenDemo();  
  }  
 }  