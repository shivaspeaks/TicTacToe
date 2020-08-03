package OOPs;

import java.util.Scanner;

public class Tic_Tac_Toe_Play {
	static Scanner s = new Scanner(System.in);
	
	public static String game(Tic_Tac_Toe matrix) {
		for(int i=0; i<9 ; i++) {
			if(i%2 == 0) {
				System.out.println("abc's turn");
				int x = s.nextInt();
				int y = s.nextInt();
				String retVal = matrix.abc_turn(x, y);
				if(retVal != null)		return "abc_wins";
			}
			else {
				System.out.println("ghi's turn");
				int x = s.nextInt();
				int y = s.nextInt();
				String retVal = matrix.ghi_turn(x, y);
				if(retVal != null)		return "ghi_wins";
			}
		}
		return "draw";
	}
	
	public static void main(String[] args) {
		
		Tic_Tac_Toe matrix = new Tic_Tac_Toe();
		System.out.println(game(matrix));

	}

}
