package me.shini9000;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Executable;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.Delayed;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import me.shini9000.utils.MyColors;
import me.shini9000.utils.GradientGlowLabel;
import me.shini9000.utils.GradientLabel;


public class Game {
	static int saveSlot;
	 
	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		JFrame mainMenu = new JFrame("Game window");
        MyColors mc = new MyColors();
        
        // Create a label
        JLabel mainmenu_welcome = new JLabel("Welcome to");
        
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));

        JPanel gameMenu = new JPanel();
        gameMenu.setLayout(new BoxLayout(gameMenu, BoxLayout.Y_AXIS));
        JButton newGame_btn = new JButton("New Game");
        JButton loadGame_btn = new JButton("Load Game");
        JButton quitGame_btn = new JButton("Quit");

        // Create a menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("Menu");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem creditsItem = new JMenuItem("Credits");
        JMenuItem guideItem = new JMenuItem("Guide");
        JMenuItem exitItem = new JMenuItem("Exit");
        fileMenu.add(openItem);
        //fileMenu.addSeparator();
        fileMenu.add(guideItem);
        //fileMenu.addSeparator();
        fileMenu.add(creditsItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);

        // Set frame properties
        mainMenu.setSize(800, 800); // Set the size of the frame
        mainMenu.setLayout(new BorderLayout());
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
        gameMenu.setBorder(BorderFactory.createEmptyBorder(20, 0, 300, 0));
        mainMenu.add(mainmenu_welcome);
        
        // Close operation
        mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Make the frame visible
        mainMenu.setVisible(true);
        
        System.out.println("*DEBUG* Menu title changing going to sleep...");
        try {
        	  Thread.sleep(1500);
        	} catch (InterruptedException e) {
        	  Thread.currentThread().interrupt();
        	}

        System.out.println("*DEBUG* Menu title changed");
        mainMenu.add(gameMenu, BorderLayout.SOUTH);
        gameMenu.add(Box.createRigidArea(new Dimension(0,2)));
        gameMenu.add(newGame_btn);
        gameMenu.add(loadGame_btn);
        gameMenu.add(quitGame_btn);
        mainMenu.remove(mainmenu_welcome);
        mainMenu.setJMenuBar(menuBar);
        System.out.println("*DEBUG* Gamebar creation complete");
        GradientLabel title01 = new GradientLabel("Ashes of", mc.getColor("#FB1717"), mc.getColor("#0CC204"));

        GradientGlowLabel title02 = new GradientGlowLabel( "Pestilence!", mc.getColor("#21911d"), mc.getColor("#0f4d0a"), mc.getColor("#00ff00"), 4);

        title01.setAlignmentX(Component.CENTER_ALIGNMENT);
        title02.setAlignmentX(Component.CENTER_ALIGNMENT);

        titlePanel.add(title01);
        titlePanel.add(Box.createVerticalStrut(0));
        titlePanel.add(title02);
		
        mainMenu.add(titlePanel, BorderLayout.NORTH);
		mainMenu.revalidate();
		mainMenu.repaint();

        System.out.println("*DEBUG* Game welcome complete... clearing on button press...");
		
        // Add action to the button CREDITS
		creditsItem.addActionListener(new ActionListener() {
    	    @Override
    	    public void actionPerformed(ActionEvent e) {
    	    		JLabel link = new JLabel("<html><a href=''>Click here!</a></html>");

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
	
	    	    	JOptionPane.showMessageDialog(mainMenu, link);
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
	    		                new java.net.URI("https://github.com/Shini9000/TextAdventureGame")
	    		            );
	    		        } catch (Exception ex) {
	    		            ex.printStackTrace();
	    		        }
	    		    }
	    		});
		
	    	    	JOptionPane.showMessageDialog(mainMenu, link);
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
        
        // Add action to the button QUIT
        quitGame_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            		//JOptionPane.showMessageDialog(mainMenu, "Button Clicked!");
            		System.exit(0);
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
            	    newGame();	// start your game logic

            }
        });
        
        
	}
	
	
	private static JFrame window;
	public static void gameWindow(String[] args) {
        SwingUtilities.invokeLater(Game::start);
    }

    private static void start() {
        window = new JFrame("Game");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(900, 900);
        window.setLayout(new BorderLayout());

        showNewGameScreen();
        window.setVisible(true);
    }

    private static void showNewGameScreen() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 5)); // 3 rows, 5 columns

        for (int i = 1; i <= 15; i++) {
            panel.add(new JButton("B" + i));
        }

        window.setContentPane(panel);
        window.revalidate();
        window.repaint();
    }


	

	// Loads the game
	private static void loadGame() {
		System.out.println("game loading");
		System.out.println("Current saveslot: " + saveSlot);
		System.out.println("THERE IS NO SAVE SYSTEM YET... SO... YEAH");
	}
		

	
	// Starts the new game
	private static void newGame() {

	    
		Scanner input = new Scanner(System.in);
		
		try {
			saveSlot = 1;
			System.out.println("Current saveslot: " + saveSlot);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Welcome to some Java text adventure game called... /press enter/");
		input.nextLine();
		System.out.println("Ashes of Pestilence!!!!");
		input.nextLine();
		System.out.println("Creative I know... \nDon't judge it too much it's truly special in a way :) ");
		
		createPlayer();
	}
	
	// CHANGING TO ITS OWN "NEW GAME JAVA"
	public static void createPlayer() {
		Scanner input = new Scanner(System.in);

		PlayerProfile pp = new PlayerProfile();
		String userName;
		
		//String gender;
		String[] userRace = {"Orc", "Human", "Elf", "Dwarf"};
		String[] userClass = {"Hunter", "Mage", "Warrior", "Assassin"};
		
		
		// USERNAME
		while (true) {
		    System.out.println("Please enter a username: ");
		    userName = input.nextLine().trim();   // get userName
		    System.out.println("You entered: " + userName);
		    
		    System.out.println("Is this correct? Type YES or NO.");
		    String confirm = input.nextLine().trim().toUpperCase();

		    if (confirm.equals("YES")) {
		        break; // exit loop if confirmed
		    } else {
		        System.out.println("Let's try again...");
		        // loop repeats until they type YES
		    }

			
		}
		
		// RACE
		while (true) {
		    System.out.println("Please enter a race: \n" + Arrays.toString(userRace));
		    String choice = input.nextLine();

		    boolean found = false;
		    for (String race : userRace) {
		        if (race.equalsIgnoreCase(choice)) {
		            found = true;
		            break; // stop checking once we find a match
		        }
		    }

		    if (found) {
		        System.out.println("Race accepted: " + choice);
		        pp.user_race = choice;
		        break; // exit the while loop
		    } else {
		        System.out.println("Invalid race, try again.");
		    }
		}
		
		switch(pp.user_race) {
			case "orc":
				System.out.println("Your race is " + pp.user_race);
				pp.health = pp.health + 10;
				break;
			case "chicken":
				System.out.println("Your race is " + pp.user_race);
				pp.health--;
				break;
			case "elf":
				System.out.println("Your race is " + pp.user_race);
				break;
			case "dwarf":
				System.out.println("Your race is " + pp.user_race);
				break;
			default:
				System.out.println("Your race is " + pp.user_race);
		}
		
		System.out.println(pp.strength);
	
		pp.inventory.addItem(WeaponLibrary.weapons.get("Fists"));
		System.out.println(pp.strength);
		
		pp.inventory.showInventory();
		
		pp.strength++;
		System.out.println(pp.strength);
		pp.inventory.showInventory();
		
		Weapon weapon = pp.inventory.getItem(0);
		weapon.use(pp);
		
		pp.strength++;
		pp.strength++;
		pp.strength++;
		pp.strength++;
		pp.strength++;
		weapon.use(pp);
		
		
		pp.inventory.addItem(WeaponLibrary.weapons.get("Iron Sword"));
		pp.inventory.showInventory();
		weapon.use(pp);
		
		
		
		weapon = pp.inventory.getItem(1);
		weapon.use(pp);
		
		System.out.println("Health: " + pp.health);
	
	}
		

}
