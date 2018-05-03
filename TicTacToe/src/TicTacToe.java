import java.util.Scanner;


public class TicTacToe {
	public static void main(String[] args) {
		String[][] board = createBoard(3, 3);
		
		System.out.println("Game start");
		Scanner scanner = new Scanner (System.in);
		int turn = 1;
		turnCycle(scanner, turn, board);
		
		scanner.close();
	}
	
	static void turnCycle(Scanner scanner, int turnNum, String[][] board){
		if(turnNum%2==0){
			targetMark(scanner, "Y", board);
		} else {
			targetMark(scanner, "X", board);
		}
		showBoard(board);
		turnNum++;
		if(!checkGameOver(board)){
			turnCycle(scanner, turnNum, board);
		}
		
	}
	static void showBoard(String[][] board){
		for(String[] r : board){
			for(String c: r){
				System.out.print(c+" ");
			}
			System.out.println();
		}
	}
	static boolean checkGameOver(String[][] board){
		int openSlots=9;
		boolean gameOver=false;
		for(String[] r: board){
			for(String c:r){
				if( !c.equals(" ") ){
					openSlots--;
//					System.out.println("!c==blank");
				} else{
//					System.out.println("c is blank");
				}
			}
		}
		if(openSlots==0){
			gameOver=true;
			System.out.println("The board is full and the game is over.");
		}
		return gameOver;
	}
	static void writeMark(int row, int col, String[][] board, String mark){
		board[row][col] = mark;
		checkGameOver(board);
	}
	static void checkEmptySlot(int row, int col, String[][] board, String mark, Scanner scanner){
		if(board[row][col].equals(" ")){
			writeMark(row,col,board,mark); //this may not need to be its own function? but leaving it for now.
		} else {
			System.out.println("Please choose an empty slot.");
			targetMark(scanner, mark, board); //potential for loop if player is stubborn, but its their time's being wasted, not mine.
		}
	}
	static void targetMark(Scanner scanner, String mark, String[][] board){
		if(checkGameOver(board)){
			System.out.println("The game's over.");
		} else {
			System.out.println("Row&Column can range from 1-3.");
			System.out.println("Enter the row for your mark: ");  
			int userRow = scanner.nextInt()-1; 
			System.out.println("Enter the column for your mark: ");
			int	userCol = scanner.nextInt()-1;
			checkEmptySlot(userRow,userCol,board, mark, scanner);
		}
		
		
	}
	static String[][] createBoard(int row, int col){
		//filling the array with spaces to start
		String[][] a = new String[row][];	
		System.out.println();
		for(int i=0; i<a.length;i++){
			a[i] = new String[col];
			int j=0;
			while(j<a[i].length){
//				System.out.println(a[i][j]+" was a[i][j]");
				switch(i){
					case 0:
						a[i][j] = " ";
//						a[i][j] = "a"; 
//						coordSet(a, i, j);
//						System.out.println(i+" i, "+j+" j");
						break;
					case 1:
						a[i][j] = " ";
//						a[i][j] = "b";
//						coordSet(a, i, j);
//						System.out.println(i+" i, "+j+" j");
						break;
					case 2:
						a[i][j] = " ";
//						a[i][j] = "c";
//						coordSet(a, i, j);
//						System.out.println(i+" i, "+j+" j");
						break;
					default:
							break;
					// returns
//							aaa // i==0
//							bbb // i==1
//							ccc // i==2
				}
//				a[i][j] = "a";
				j++;
			}
		}
		
		return a;
	}
	static void coordSet(String[][] a, int i, int j){
		switch (j){
			case 0: //first column
				a[i][j]= "1"; 
				break;
			case 1: //second column
				a[i][j]= "2";
				break;
			case 2: //third column
				a[i][j]= "3";
				break;
			default:
				System.out.println("default reached");
		}
	}
}
