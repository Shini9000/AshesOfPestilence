package me.shini9000;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import me.shini9000.utils.MyColors;

public class GameWindow {
	private JFrame frame;
	
	
	public GameWindow(String state) {  
		JFrame gameWindow = new JFrame("Ashes of Pestilence");
		createMenuBar(gameWindow);
	    gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    gameWindow.setSize(800, 800);
	    gameWindow.setLayout(new BorderLayout());
	    gameWindow.setVisible(true);
	    gameWindow.setJMenuBar(createMenuBar(gameWindow));
	    //createPlayer();
	    
	    if (state.equals("newgame")) {
	    	System.out.println("NEW GAME SELECTED");
	    	createGameWindowTEST();
	    } else { 
	    	System.out.println("LOAD GAME SELECTED");
	    }

	    
	    
	}
	
	private void createGameWindowTEST() {
	    MyColors mc = new MyColors();
	    JFrame window = new JFrame("Merged Grid Example");
	    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    window.setSize(600, 600);

	    JPanel main = new JPanel(new BorderLayout());

	    // Section 2: 5x5 grid
	    JPanel middle = new JPanel(new GridBagLayout());
	    GridBagConstraints gbc = new GridBagConstraints();
	    middle.setPreferredSize(new Dimension(20, 20));
	    gbc.insets = new Insets(2, 2, 2, 2);

//	    middle.setMaximumSize(new Dimension(100, 100));
//	    middle.setMinimumSize(new Dimension(100, 100));
    	middle.setVisible(false);
//	    for (int i = 0; i < 4; i++) {
//	        middle.add(new JButton("M" + i));
//	    }

	    // Section 3: 5x3 grid
	    JPanel bottom = new JPanel(new GridLayout(1, 3));
    	bottom.setVisible(false);
//	    for (int i = 0; i < 3; i++) {
//	        bottom.add(new JButton("B" + i));
//	    }

	    Game.startTutorial(window, main, middle, bottom);
	    main.add(middle, BorderLayout.CENTER);
	    main.add(bottom, BorderLayout.SOUTH);

	    window.add(main);
	    window.setVisible(true);
	    
	    
	}


	private static JMenuBar createMenuBar(JFrame gameWindow) {
	    JMenuBar menuBar = new JMenuBar();
	    JMenu fileMenu = new JMenu("Menu");

	    JMenuItem openItem = new JMenuItem("Open");
	    JMenuItem guideItem = new JMenuItem("Guide");
	    JMenuItem creditsItem = new JMenuItem("Credits");
	    JMenuItem cheatsItem = new JMenuItem("Cheats");
	    JMenuItem exitItem = new JMenuItem("Exit");

	 // Add action to the button CREDITS
	 		creditsItem.addActionListener(new ActionListener() {
	     	    @Override
	     	    public void actionPerformed(ActionEvent e) {
	     	    	
     	    		JLabel link = new JLabel("<html><a href=''>Click here for AoP github site!</a></html>");

     	    		link.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

     	    		link.addMouseListener(new java.awt.event.MouseAdapter() {
     	    		    @Override
     	    		    public void mouseClicked(java.awt.event.MouseEvent e) {
     	    		        try {
     	    		            java.awt.Desktop.getDesktop().browse(
     	    		                new java.net.URI("https://github.com/shini9000")
     	    		            );
     	    		        } catch (Exception ex) {
     	    		            ex.printStackTrace();
     	    		        }
     	    		    }
     	    		});
 	
 	    	    	JOptionPane.showMessageDialog(gameWindow, link);
 	    	    	}
	     	    });

	 		// Add action to the button GUIDE
	 		guideItem.addActionListener(new ActionListener() {
	 	    	    @Override
	 	    	    public void actionPerformed(ActionEvent e) {
	 	    	    		JLabel link = new JLabel("<html><a href=''>Guide available here!</a></html>");
	 	
	 	    	    		link.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
	 	
	 	    	    		link.addMouseListener(new java.awt.event.MouseAdapter() {
	 	    		    @Override
	 	    		    public void mouseClicked(java.awt.event.MouseEvent e) {
	 	    		        try {
	 	    		            java.awt.Desktop.getDesktop().browse(
	 	    		                new java.net.URI("https://github.com/Shini9000/AshesOfPestilence")
	 	    		            );
	 	    		        } catch (Exception ex) {
	 	    		            ex.printStackTrace();
	 	    		        }
	 	    		    }
	 	    		});
	 		
	 	    	    	JOptionPane.showMessageDialog(gameWindow, link);
	 	    	    	}
	     	    });

	 		
	         // Add action to the button EXIT
	         cheatsItem.addActionListener(new ActionListener() {
	             @Override
	             public void actionPerformed(ActionEvent e) {
	            	 JOptionPane cheatCode = new JOptionPane();
	            	 String userCheatCode = cheatCode.showInputDialog(null, "Enter cheat code");
	            	 System.out.println(userCheatCode);
	            	 if (userCheatCode == null) {
	            		 System.out.println("DEBUG: User cancelled cheat dialog");
	            		 return; // stop here
	            		 }
	            	 
	            	 if (CheatManager.cheatCheckCode(userCheatCode)) {
	            		 System.out.println("DEBUG CHEAT ACCEPT");
	            		 JOptionPane.showMessageDialog(gameWindow, "Cheat code accepted!");
	            	 } else {
	            		 System.out.println("DEBUG CHEAT DENIED");
	            		 JOptionPane.showMessageDialog(gameWindow, "Cheat code denied!");
	            	 }
	            	 	
	             }
	         }); 
	         
	         // Add action to the button EXIT
	         exitItem.addActionListener(new ActionListener() {
	             @Override
	             public void actionPerformed(ActionEvent e) {
	             		//JOptionPane.showMessageDialog(mainMenu, "Button Clicked!");
	             		System.exit(0);
	             }
	         }); 
	    
	    fileMenu.add(openItem);
	    fileMenu.add(guideItem);
	    fileMenu.add(creditsItem);
	    fileMenu.add(cheatsItem);
	    fileMenu.addSeparator();
	    fileMenu.add(exitItem);

	    menuBar.add(fileMenu);
	    return menuBar;
	}
}