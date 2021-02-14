package game1;

import java.util.Scanner;

public class AI {

	private Player player1, player2;
	private Board board;

	public static Scanner s = new Scanner(System.in);


	public void gameStart() {
		// players input
		player1 = takePlayerInput();
		if(player1.getSymbol() != 'x')
			player2 = new Player("AI", 'x');
		else
			player2 = new Player("AI", 'o');

		// create board
		board = new Board(player1.getSymbol(), player2.getSymbol());

		// conduct game.
		boolean player1turn = false;
		int status = board.INCOMPLETE;
		int t = 0;

		while(status == board.INCOMPLETE || status == board.INVALID) {

			if(player1turn) {
				//Human's turn
				System.out.println("player 1 : " + player1.getName() + "'s turn");

				System.out.println("enter x and y coordinates with space separated");
				
				int x = s.nextInt() - 1;
				//System.out.println("enter y coordinate");
				int y = s.nextInt() - 1;

				status = board.move(player1.getSymbol(), x, y);

				if(status != board.INVALID) {
					player1turn = false;
					board.print();
				}
				else {
					System.out.println("This is an invalid move. Please enter the coordinates again.");
				}
				System.out.println();
			}
			else {
				// AI's turn
				System.out.println("player 2 : " + player2.getName() + "'s turn");

				int[] bestMove = bestMove(player2);
				
				if(t == 0) {
					status = board.move(player2.getSymbol(), 1, 1);
				}
				else {
					status = board.move(player2.getSymbol(), bestMove[0], bestMove[1]);
				}
				

				if(status != board.INVALID) {
					player1turn = true;
					board.print();
				}
				else {
					System.out.println("This is an invalid move.");
				}
				System.out.println();
			}
			t++;
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
			System.out.println("Draw");
			System.out.println("-------------------------");
			System.out.println("Play again? (y/n)");

			return;
		}

	}

	private Player takePlayerInput() {
		System.out.println("enter player name");
		String name = s.next();

		System.out.println("enter player symbol");
		char symbol = s.next().charAt(0);

		Player p = new Player(name, symbol);
		return p;


	}


	public int[] bestMove(Player ai) {
		int bestScore = Integer.MIN_VALUE;
		int[] bestMove = {0, 0};

		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(board.get(i, j) == ' ') {

					board.set(ai.getSymbol(), i, j);
					int score = miniMax(false, ai.getSymbol(), player1.getSymbol());
					board.set(' ', i, j);

					if(score > bestScore) {
						bestScore = score;
						int[] a = {i, j};
						bestMove = a;
					}
				}
			}
		}
		return bestMove;
	}

	public int miniMax(boolean isMaximising, char AISymbol, char humanSymbol) {
		char winner = board.checkWinnerAI(AISymbol, humanSymbol);
		if(winner != 'F') {
			if(winner == AISymbol)	return 1;
			if(winner == humanSymbol)	return -1;
			return 0;
		}

		if(isMaximising) {
			int bestScore = Integer.MIN_VALUE;
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					if(board.get(i, j) == ' ') {

						board.set(AISymbol, i, j);
						int score = miniMax(false, AISymbol, humanSymbol);
						board.set(' ', i, j);

						if(score > bestScore) {
							bestScore = score;
						}
					}
				}
			}
			return bestScore;
		}
		else {
			int bestScore = Integer.MAX_VALUE;
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					if(board.get(i, j) == ' ') {

						board.set(humanSymbol, i, j);
						int score = miniMax(true, AISymbol, humanSymbol);
						board.set(' ', i, j);

						if(score < bestScore) {
							bestScore = score;
						}
					}
				}
			}
			return bestScore;
		}
	}
	
	
//	public int alphaBetaPruning(boolean isMaximising, char AISymbol, char humanSymbol) {
//		
//	}


}
