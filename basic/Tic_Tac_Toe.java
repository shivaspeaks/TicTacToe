package OOPs;

public class Tic_Tac_Toe {

	private int[][] matrix;

	public Tic_Tac_Toe() {
		matrix = new int[3][3];
		for(int i=0;i<3;i++) {
			for(int j=0; j<3; j++) {
				matrix[i][j] = 5;
			}
		}
	}

	
	public String abc_turn(int x, int y) {
		matrix[x][y] = 0;	
		return check_abc_wins(x, y);
	}

	private String check_abc_wins(int x, int y) {

		if(matrix[x][0] + matrix[x][1] + matrix[x][2] == 0)			return "abc_wins";
		else if(matrix[0][y] + matrix[1][y] + matrix[2][y]==0)		return "abc_wins";

		else if((x==0&&y==0) || (x==1&&y==1) || (x==2&&y==2) || (x==0&&y==2) || (x==2&&y==0)) {

			if((x==0&&y==0) || (x==2&&y==2)) {
				if(matrix[0][0] + matrix[1][1] + matrix[2][2] == 0)		return "abc_wins";
			}
			else if((x==0&&y==2) || (x==2&&y==0)) {
				if(matrix[0][2] + matrix[1][1] + matrix[2][0] == 0)		return "abc_wins";
			}
			else if(x==1&&y==1) {
				if(matrix[0][2] + matrix[1][1] + matrix[2][0] == 0)		return "abc_wins";
				if(matrix[0][0] + matrix[1][1] + matrix[2][2] == 0)		return "abc_wins";
			}	
		}
		return null;
	}
	
	
	
	public String ghi_turn(int x, int y) {
		matrix[x][y] = 1;	
		return check_ghi_wins(x, y);
	}

	private String check_ghi_wins(int x, int y) {

		if(matrix[x][0] + matrix[x][1] + matrix[x][2] == 3)			return "ghi_wins";
		else if(matrix[0][y] + matrix[1][y] + matrix[2][y]==3)		return "ghi_wins";

		else if((x==0&&y==0) || (x==1&&y==1) || (x==2&&y==2) || (x==0&&y==2) || (x==2&&y==0)) {

			if((x==0&&y==0) || (x==2&&y==2)) {
				if(matrix[0][0] + matrix[1][1] + matrix[2][2] == 3)		return "ghi_wins";
			}
			else if((x==0&&y==2) || (x==2&&y==0)) {
				if(matrix[0][2] + matrix[1][1] + matrix[2][0] == 3)		return "ghi_wins";
			}
			else if(x==1&&y==1) {
				if(matrix[0][2] + matrix[1][1] + matrix[2][0] == 3)		return "ghi_wins";
				if(matrix[0][0] + matrix[1][1] + matrix[2][2] == 3)		return "ghi_wins";
			}	
		}
		return null;
	}

}
