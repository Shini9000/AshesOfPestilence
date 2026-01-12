package me.shini9000;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import me.shini9000.utils.GradientGlowLabel;
import me.shini9000.utils.GradientLabel;
import me.shini9000.utils.MyColors;

public class MainMenu {
	private JFrame frame;
	public float gameVersion = 1.1f;
	
	public static void main(String[] args) { 
		Scanner myScanner = new Scanner(System.in);
		JFrame mainMenu = new JFrame("Game window");
		MyColors mc = new MyColors();
        
        // -------------------------
	    // PHOTO PANEL (TOP)
	    // -------------------------
        
	    JPanel photoPanel = new JPanel();
	    photoPanel.setBackground(Color.BLACK);

	    // Example placeholder label
	    JLabel photoLabel = new JLabel();
	    ImageIcon iconLogo = new ImageIcon(Game.class.getResource("/AOP_ref.PNG"));
	    Image image = iconLogo.getImage().getScaledInstance(400, 550, Image.SCALE_SMOOTH);
	    photoLabel.setIcon(new ImageIcon(image));

	    //photoLabel.setForeground(Color.WHITE);
	    photoPanel.add(photoLabel);
	    photoPanel.setPreferredSize(new Dimension(250, 550));
	    System.out.println(new File("resources/AOP_ref.PNG").getAbsolutePath());
	    System.out.println("Loaded: " + iconLogo.getIconWidth() + "x" + iconLogo.getIconHeight());

	    // Add photo panel to top
	    mainMenu.add(photoPanel, BorderLayout.CENTER);
	    mainMenu.setResizable(false);
        
        
        // Create a label
        JLabel mainmenu_welcome = new JLabel("Welcome to");
        
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));

        JPanel gameMenu = new JPanel();
        gameMenu.setLayout(new BoxLayout(gameMenu, BoxLayout.Y_AXIS));
        JButton newGame_btn = new JButton("New Game");
        JButton loadGame_btn = new JButton("Load Game");
        JButton quitGame_btn = new JButton("Quit"); // Set the size of the frame
        mainMenu.setSize(photoPanel.getPreferredSize());
        mainmenu_welcome.setHorizontalAlignment(SwingConstants.CENTER);
        mainmenu_welcome.setVerticalAlignment(SwingConstants.TOP);
        mainmenu_welcome.setFont(new Font("MONOSPACED", Font.BOLD, 40));
        newGame_btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        loadGame_btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        newGame_btn.setPreferredSize(new Dimension(100, 100));
        loadGame_btn.setPreferredSize(new Dimension(100, 100));
        newGame_btn.setMaximumSize(new Dimension(125, 40));
        loadGame_btn.setMaximumSize(new Dimension(150, 40));
        quitGame_btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        quitGame_btn.setPreferredSize(new Dimension(100, 100));
        quitGame_btn.setMaximumSize(new Dimension(100, 40));
        gameMenu.setBorder(BorderFactory.createEmptyBorder(0, 0, 270, 0));
        
        GradientLabel title01 = new GradientLabel("Ashes of", mc.getColor("#FB1717"), mc.getColor("#0CC204"));

        GradientGlowLabel title02 = new GradientGlowLabel( "Pestilence!", mc.getColor("#21911d"), mc.getColor("#0f4d0a"), mc.getColor("#00ff00"), 4);

        title01.setAlignmentX(Component.CENTER_ALIGNMENT);
        title02.setAlignmentX(Component.CENTER_ALIGNMENT);
        
	    // Run this AFTER 3 seconds (3000 ms)
	    Timer t = new Timer(3000, e -> {

	        mainMenu.setSize(800, 800);
	        // whatever you want to do after the delay
	        mainMenu.remove(photoPanel);
	        photoPanel.revalidate();
	        photoPanel.repaint();
	        

//	        // Create a menu bar
//	        JMenuBar menuBar = new JMenuBar();
//	        JMenu fileMenu = new JMenu("Menu");
//	        JMenuItem openItem = new JMenuItem("Open");
//	        JMenuItem creditsItem = new JMenuItem("Credits");
//	        JMenuItem guideItem = new JMenuItem("Guide");
//	        JMenuItem exitItem = new JMenuItem("Exit");
//	        fileMenu.add(openItem);
//	        //fileMenu.addSeparator();
//	        fileMenu.add(guideItem);
//	        //fileMenu.addSeparator();
//	        fileMenu.add(creditsItem);
//	        fileMenu.addSeparator();
//	        fileMenu.add(exitItem);
//	        menuBar.add(fileMenu);

	        // Set frame properties

	        mainMenu.add(mainmenu_welcome, BorderLayout.NORTH);
	        
	        // Close operation
	        mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        System.out.println("*DEBUG* Menu title changed");
	        mainMenu.add(gameMenu, BorderLayout.SOUTH);
	        gameMenu.add(Box.createRigidArea(new Dimension(0,2)));
	        gameMenu.add(newGame_btn);
	        gameMenu.add(loadGame_btn);
	        gameMenu.add(quitGame_btn);
	        //mainMenu.setJMenuBar(createMenuBar(mainMenu));
	        System.out.println("*DEBUG* Gamebar creation complete");


	        titlePanel.add(title01);
	        titlePanel.add(Box.createVerticalStrut(0));
	        titlePanel.add(title02);
			
	        mainMenu.add(titlePanel, BorderLayout.CENTER);
			mainMenu.revalidate();
			mainMenu.repaint();

	        System.out.println("*DEBUG* Game welcome complete... clearing on button press...");
			
	    });
	    t.setRepeats(false);
	    t.start();
        
        // Add action to the button QUIT
        quitGame_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            		quitProgram();
            }
        }); 
        
        // Add action to the button NEWGAME
        newGame_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            		System.out.print("\033[H\033[2J");
            		System.out.flush();
            		//JOptionPane.showMessageDialog(mainMenu, "Button Clicked!");
            		mainMenu.dispose();	// close menu window
            	    System.out.println("newgame window loaded");
            		//new newGame();
            	    new GameWindow("newgame");

            }
        });
        
        // Add action to the button LOADGAME
        loadGame_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            		System.out.print("\033[H\033[2J");
            		System.out.flush();
            		//JOptionPane.showMessageDialog(mainMenu, "Button Clicked!");
            		mainMenu.dispose();	// close menu window
            	    System.out.println("load game window loaded");
            		//new loadGame();
            	    new GameWindow("loadame");

            }
        });
        

        mainMenu.setVisible(true);
	}
	
	public static void quitProgram() {
		System.exit(0);
	}
}