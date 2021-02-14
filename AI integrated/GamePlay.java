package game1;

import java.util.Scanner;

public class GamePlay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		AI game = new AI();
		while(true) {
			game.gameStart();
			System.out.println("Press 1 to play again.");
			System.out.println("Press any key to exit");
			String n = s.nextLine();
			if(n != "1") {
				break;
			}
		}
		
	}

}
