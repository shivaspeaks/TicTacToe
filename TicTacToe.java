package game1;

import java.util.Scanner;

public class TicTacToe {

	private Player player1, player2;
	private Board board;

	public static Scanner s = new Scanner(System.in);

	public void gameStart() {
		// players input
		player1 = takePlayerInput(1);
		player2 = takePlayerInput(2);
		while(player1.getSymbol() == player2.getSymbol()) {
			System.out.println("symbol already taken!! take another symbol.");
			player2.setSymbol(s.next().charAt(0));
		}


		// create board
		board = new Board(player1.getSymbol(), player2.getSymbol());



		// conduct game.
		boolean playe1turn = true;
		int status = board.INCOMPLETE;

		while(status == board.INCOMPLETE || status == board.INVALID) {

			if(playe1turn) {
				System.out.println("player 1 : " + player1.getName() + "'s turn");

				System.out.println("enter x and y coordinates with space in between");
				
				int x = s.nextInt() - 1;
				//System.out.println("enter y coordinate");
				int y = s.nextInt() - 1;

				status = board.move(player1.getSymbol(), x, y);

				if(status != board.INVALID) {
					playe1turn = false;
					board.print();
				}
				else {
					System.out.println("This is an invalid move. Please enter the coordinates again.");
				}
			}
			else {
				System.out.println("player 2 : " + player2.getName() + "'s turn");

				System.out.println("enter x and y coordinates with space in between");
				
				int x = s.nextInt() - 1;
				//System.out.println("enter y coordinate");
				int y = s.nextInt() - 1;

				status = board.move(player2.getSymbol(), x, y);

				if(status != board.INVALID) {
					playe1turn = true;
					board.print();
				}
				else {
					System.out.println("This is an invalid move. Please enter the coordinates again.");
				}
			}
		}
		 if(status == board.PLAYER_1_WINS) {
			System.out.println("GAME OVER!");
			System.out.println("player 1 : " + player1.getName() + " wins");
			return;
		}
		else if(status == board.PLAYER_2_WINS) {
			System.out.println("GAME OVER!");
			System.out.println("player 2 : " + player2.getName() + " wins");
			return;
		}
		else{
			System.out.println("draw");
			return;
		}

	}

	private Player takePlayerInput(int num) {
		System.out.println("enter player " + num + " name");
		String name = s.next();

		System.out.println("enter player " + num + " symbol");
		char symbol = s.next().charAt(0);

		Player p = new Player(name, symbol);
		return p;


	}

}
