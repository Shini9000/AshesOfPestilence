package me.shini9000;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import me.shini9000.utils.MyColors;

public class Game {
	
	public static void startTutorial(JFrame window, JPanel main, JPanel middle, JPanel bottom) {
	    MyColors mc = new MyColors();

	    JPanel top = new JPanel(new GridLayout(3, 1)); // 3 rows, 1 column

	    // Create labels ONCE
	    JLabel msg  = new JLabel(mc.coloredText("CHARACTER CREATION", "#FF78F5"));
	    JLabel msg2 = new JLabel(mc.coloredText("Enter your username", "#000000"));

	    // Style them
	    msg.setHorizontalAlignment(SwingConstants.CENTER);
	    msg2.setHorizontalAlignment(SwingConstants.CENTER);

	    // Add first label immediately
	    top.add(msg);

	    // Input field
	    JTextField input = new JTextField();
	    input.setHorizontalAlignment(SwingConstants.CENTER);
	    top.add(input);
	    
	    // When user presses Enter
	    input.addActionListener(e -> {
	        String username = input.getText().trim();
	        System.out.println("USERNAME ENTERED: " + username);
	        if (username.isEmpty()) 
	        	return;

	        top.remove(input);   // remove input box
	        
//		    Timer t2 = new Timer(3000, te -> {
	    	username.toString();
	    	msg.setText(mc.coloredText("CHARACTER CREATION | " + mc.coloredText(username, "#07AB00"), "#FF78F5"));
	        msg2.setText(mc.coloredText("Select a race", "#000000"));
	        top.add(msg2);       // add second label
	        middle.setVisible(true);

	        top.revalidate();
	        top.repaint();
//		    });
//		    t2.setRepeats(false);
//		    t2.start();
	    });
	    
	    
	    for (int i = 0; i < 4; i++) {

	        JButton btn; // shared reference
	        switch (i) {
	        case 0:
	            btn = new JButton("DWARF");
	            break;
	        case 1:
	            btn = new JButton("ELF");
	            break;
	        case 2:
	            btn = new JButton("HUMAN");
	            break;
	        case 3:
	            btn = new JButton("ORC");
	            break;
	        default:
	            continue;
	    }


	        // Add your event here
	        btn.addActionListener(e -> {
	            String race = btn.getText();
	            System.out.println("Selected race: " + race);
	            msg2.setText(mc.coloredText("Select a class", "#000000"));
	            middle.setVisible(false);

	            // Next step in your character creation flow
	            // e.g. showClassSelection(race);
	        });

	        middle.add(btn);
	    }

	    main.add(top, BorderLayout.NORTH);
	}
}
