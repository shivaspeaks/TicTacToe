package game1;

public class Board {
	private char[][] board;
	private int boardSize = 3;
	private char p1Symbol, p2Ssymbol;
	private int count;

	public final static int PLAYER_1_WINS = 1;
	public final static int PLAYER_2_WINS = 2;
	public final static int DRAW = 3;
	public final static int INCOMPLETE = 4;
	public final static int INVALID = 5;


	public Board(char p1Symbol, char p2Symbol) {

		board = new char[boardSize][boardSize];

		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board.length; j++) {
				board[i][j] = ' ';
			}
		}

		this.p1Symbol = p1Symbol;
		this .p2Ssymbol = p2Symbol;

	}

	public int move(char symbol, int x, int y) {
		if(x>=boardSize || y>=boardSize || x<0 || y<0 || board[x][y]!=' ')		return INVALID;

		board[x][y] = symbol;
		count++;
		
		return checkWinner(symbol, x, y);
	}
	
	public int checkWinner(char symbol, int x, int y) {
		if(board[x][0] == board[x][1] && board[x][0] == board[x][2]) {
			return symbol == p1Symbol ? PLAYER_1_WINS : PLAYER_2_WINS;
		}
		
		else if(board[0][y] == board[1][y] && board[0][y] == board[2][y]) {
			return symbol == p1Symbol ? PLAYER_1_WINS : PLAYER_2_WINS;
		}
		
		else if(board[0][0] != ' ' && board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
			return symbol == p1Symbol ? PLAYER_1_WINS : PLAYER_2_WINS;
		}
		
		else if(board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
			return symbol == p1Symbol ? PLAYER_1_WINS : PLAYER_2_WINS;
		}
		
		else if(count==9) {
			return DRAW;
		}
		
		else {
			return INCOMPLETE;
		}
	}
	
	public char checkWinnerAI(char AI, char human) {
		for(int i=0; i<3; i++) {
			if(board[0][i] == board[1][i] && board[2][i] == board[1][i] && board[1][i] != ' ') {
				return board[0][i];
			}
		}
		for(int i=0; i<3; i++) {
			if(board[i][0] == board[i][1] && board[i][2] == board[i][1] && board[i][1] != ' ') {
				return board[i][0];
			}
		}
		if(board[0][0] == board[1][1] && board[2][2] == board[1][1] && board[1][1] != ' ') {
			return board[0][0];
		}
		if(board[2][0] == board[1][1] && board[0][2] == board[1][1] && board[1][1] != ' ') {
			return board[1][1];
		}
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(board[i][j] == ' ')	return 'F';
			}
		}
		
		return 'D';
	}
	
	public char get(int i, int j) {
		return this.board[i][j];
	}
	
	public void set(char ch, int i, int j) {
		this.board[i][j] = ch;
	}

	public void print() {
		
		System.out.println("---------");
		
		for(int i=0; i<board.length; i++) {
			System.out.print(" ");
			for(int j=0; j<board.length; j++) {
				System.out.print("|" + board[i][j]);
			}
			
			System.out.println("|");
		}
		
		System.out.println("---------");
		
	}
	
}
