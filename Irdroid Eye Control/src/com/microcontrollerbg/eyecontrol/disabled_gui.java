package com.microcontrollerbg.eyecontrol;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Toolkit;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.util.prefs.*;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import org.harctoolbox.lircclient.LircClient;
import org.harctoolbox.lircclient.TcpLircClient;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JComboBox;
import javax.swing.JWindow;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JMenuItem;


public class disabled_gui  {

	private JFrame frmIrdroidAccessibility;
	LircClient lirc;
    String lirc_remote ;
	private List<String> remotes;
	/**
	 * Launch the application.
	 */
	 public List<String> get_remotes()
	  {
	    return remotes;
	  }

	public static void main(String[] args) {
		
				
				
					someTask();
		
					disabled_gui window = new disabled_gui();
				
					window.frmIrdroidAccessibility.setVisible(true);
				
			
		
	}
	
	 static void someTask() {  
		  System.out.println("Some time consuming task is executed");  
		  JWindow window = new JWindow();
		 
		  Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		 
		   int x = (int) ((dimension.getWidth() - 840) / 2);
		    int y = (int) ((dimension.getHeight() - 570) / 2);
		  window.getContentPane().add(
		      new JLabel("Loading...", new ImageIcon(MySplashScreenDemo.class.getResource("IR_branging.png")), SwingConstants.CENTER));
		  window.setBounds(x, y, 840, 570);

		  window.setVisible(true);
		  try {
		      Thread.sleep(1000);
		  } catch (InterruptedException e) {
		      e.printStackTrace();
		  }
		  window.setVisible(false);
		 

		  }  
	 
	public void read_remote(){
		
		// Retrieve the user preference node for the package com.mycompany
		Preferences prefs = Preferences.userNodeForPackage(disabled_gui.class);

		// Preference key name
		final String PREF_NAME = "remote";

		// Set the value of the preference
	//	String newValue = "a string";
	//	prefs.put(PREF_NAME, newValue);

		// Get the value of the preference;
		// default value is returned if the preference does not exist
		String defaultValue = "Samsung_TV";
		String propertyValue = prefs.get(PREF_NAME, defaultValue); // "a string"
			lirc_remote=propertyValue;
			
	}
	
	public void store_remote(String remote){
		// Retrieve the user preference node for the package com.mycompany
				Preferences prefs1 = Preferences.userNodeForPackage(disabled_gui.class);

				// Preference key name
				final String PREF_NAME1 = "remote";

				// Set the value of the preference
			//	String newValue = "a string";
				prefs1.put(PREF_NAME1, remote);
	}

	/**
	 * Create the application.
	 */
	public disabled_gui() {
		initialize();
		read_remote();
	}
	private void elements(){
		List <String> remos= disabled_gui.this.get_remotes();
        JPanel panel = new JPanel();
        panel.add(new JLabel("Please select device:"));
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
     int selected=0;  
    for (int i=0;i<remotes.size();i++){
    	if(lirc_remote.equals(remotes.get(i).toString())){
    		selected=i;
    		System.out.println(selected);
    	}
    	  model.addElement(remotes.get(i));
    }
    
    
      
        JComboBox<String> comboBox = new JComboBox<String>(model);
      
        comboBox.setSelectedIndex(selected);
        panel.add(comboBox);

        int result = JOptionPane.showConfirmDialog(null, panel, "Flavor", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        switch (result) {
            case JOptionPane.OK_OPTION:
                System.out.println("You selected " + comboBox.getSelectedItem());
               lirc_remote=comboBox.getSelectedItem().toString();
                store_remote(comboBox.getSelectedItem().toString());
                break;
        }
	}
	
	 

	/**
	 * Initialize the contents of the frame.
	 */
	
	 public static void infoBox(String infoMessage, String titleBar)
	    {
	        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
	    }
	private void initialize() {
	
		
	lirc = null;
		try {
			lirc = new TcpLircClient("localhost", 8765, true, 5000);
		} catch (UnknownHostException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
			infoBox("No connection with Lirc exiting!", "Connectivity error");
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			infoBox("No connection with Lirc exiting!", "Connectivity error");
			e2.printStackTrace();
		}
        String version = null;
		try {
			version = lirc.getVersion();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		remotes = null;
		try {
			remotes = lirc.getRemotes();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
         for (int i = 0; i < remotes.size(); i++)
             System.out.println(i + ":\t" + remotes.get(i));
        System.out.println(version);
		
		frmIrdroidAccessibility = new JFrame();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		  int x = (int) ((dim.getWidth() - 628) / 2);
		    int y = (int) ((dim.getHeight() - 534) / 2);
		 
		//frmIrdroidAccessibility.setLocation(dim.width/2-frmIrdroidAccessibility.getSize().width/2, dim.height/2-frmIrdroidAccessibility.getSize().height/2);
		frmIrdroidAccessibility.setTitle("Irdroid accessibility v1.0");
		frmIrdroidAccessibility.setResizable(false);
		frmIrdroidAccessibility.setBounds(x, y, 628, 534);
		frmIrdroidAccessibility.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmIrdroidAccessibility.getContentPane().setLayout(null);
		try {
			frmIrdroidAccessibility.setIconImage(ImageIO.read(new File("res/icon.png")));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JButton btnNewButton = new JButton("Канал-");
		String pathToImage = "tv_minus.png";
		ImageIcon myIcon = new ImageIcon(getClass().getClassLoader().getResource(pathToImage));
		btnNewButton.setIcon(myIcon);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				new Thread(new Runnable() {
				    public void run() {
				        //Do whatever
				    	try {
				    		lirc.sendIrCommand(lirc_remote, "P-", 0);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							infoBox("No connection with Lirc!", "Connectivity error");
							e.printStackTrace();
						}
				    }
				}).start();
				
			}
		});
		btnNewButton.setBounds(57, 63, 131, 117);
		frmIrdroidAccessibility.getContentPane().add(btnNewButton);
		String pathToImage1 = "tv_plus.png";
		ImageIcon myIcon1 = new ImageIcon(getClass().getClassLoader().getResource(pathToImage1));
		JButton button = new JButton("Канал+");
		button.setIcon(myIcon1);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Thread(new Runnable() {
				    public void run() {
				        //Do whatever
				    	try {
				    		
				    		lirc.sendIrCommand(lirc_remote, "P+", 0);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							infoBox("No connection with Lirc!", "Connectivity error");
							e.printStackTrace();
						}
				    }
				}).start();
			}
		});
		button.setBounds(245, 63, 131, 117);
		frmIrdroidAccessibility.getContentPane().add(button);
		String pathToImage2 = "stop.png";
		ImageIcon myIcon2 = new ImageIcon(getClass().getClassLoader().getResource(pathToImage2));
		JButton button_1 = new JButton("Вкл/Изк");
		button_1.setIcon(myIcon2);
		button_1.setBounds(433, 63, 138, 117);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Thread(new Runnable() {
				    public void run() {
				        //Do whatever
				    	try {
				    		
				    		lirc.sendIrCommand(lirc_remote, "POWER", 0);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							infoBox("No connection with Lirc!", "Connectivity error");
							e.printStackTrace();
						}
				    }
				}).start();
			}
		});
		frmIrdroidAccessibility.getContentPane().add(button_1);
		String pathToImage3 = "speaker_minus.png";
		ImageIcon myIcon4 = new ImageIcon(getClass().getClassLoader().getResource(pathToImage3));
		JButton button_2 = new JButton("Звук-");
		button_2.setIcon(myIcon4);
		button_2.setBounds(57, 266, 131, 117);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Thread(new Runnable() {
				    public void run() {
				        //Do whatever
				    	try {
				    		lirc.sendIrCommand(lirc_remote, "VOL-", 0);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							infoBox("No connection with Lirc!", "Connectivity error");
							e.printStackTrace();
						}
				    }
				}).start();
			}
		});
		frmIrdroidAccessibility.getContentPane().add(button_2);
		String pathToImage4 = "speaker_plus.png";
		ImageIcon myIcon5 = new ImageIcon(getClass().getClassLoader().getResource(pathToImage4));
		JButton button_3 = new JButton("Звук+");
		button_3.setIcon(myIcon5);
		button_3.setBounds(245, 266, 131, 117);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Thread(new Runnable() {
				    public void run() {
				        //Do whatever
				    	try {
				    		lirc.sendIrCommand(lirc_remote, "VOL+", 0);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							infoBox("No connection with Lirc!", "Connectivity error");
							e.printStackTrace();
						}
				    }
				}).start();
			}
		});
		frmIrdroidAccessibility.getContentPane().add(button_3);
		String pathToImage6 = "speaker_off.png";
		ImageIcon myIcon6 = new ImageIcon(getClass().getClassLoader().getResource(pathToImage6));
		JButton btnMute = new JButton("MUTE");
		btnMute.setIcon(myIcon6);
		btnMute.setBounds(433, 266, 138, 117);
		btnMute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Thread(new Runnable() {
				    public void run() {
				        //Do whatever
				    	try {
				    		lirc.sendIrCommand(lirc_remote, "MUTE", 0);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							infoBox("No connection with Lirc!", "Connectivity error");
							e.printStackTrace();
						}
				    }
				}).start();
			}
		});
		frmIrdroidAccessibility.getContentPane().add(btnMute);
		
		JLabel lblAllRightsReserved = new JLabel("All Rights Reserved. Irdroid is a Registered Trademark of Hardware Group Ltd.");
		lblAllRightsReserved.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblAllRightsReserved.setBounds(137, 459, 359, 14);
		frmIrdroidAccessibility.getContentPane().add(lblAllRightsReserved);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(126, 459, 370, 14);
		frmIrdroidAccessibility.getContentPane().add(separator);
		for (int i =0;i<remotes.size();i++){
		//	comboBox.addItem(arg0)(remotes.get(i));
		}
		
		JMenuBar menuBar = new JMenuBar();
		frmIrdroidAccessibility.setJMenuBar(menuBar);
		
		JMenu mnInfo = new JMenu("Settings");
		menuBar.add(mnInfo);
		
		JMenuItem menuItem = new JMenuItem("Device");
		mnInfo.add(menuItem);
		menuItem.addActionListener(
	            new ActionListener(){
	                public void actionPerformed(ActionEvent e)
	                {
	                elements();	
	                 
	                }
	            }
	        );
		
		
	}
}
