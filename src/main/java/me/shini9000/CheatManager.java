package me.shini9000;

public class CheatManager {
	
	public static boolean cheatCheckCode(String userCheatCode) {
		String ver_CheatCode = "AOP1.2";
		if (userCheatCode.equals(ver_CheatCode)) {
			System.out.println("Cheat code accepted!");
			return true;
		} else {
			System.out.println("Cheat code denied!");
			return false;
		}
		
	}
	
	

}
