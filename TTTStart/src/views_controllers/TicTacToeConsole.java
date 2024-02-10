// Author: Ali Kaddoura
package views_controllers;

import java.util.Scanner;

import model.TicTacToeGame;

public class TicTacToeConsole {
	
	

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		
		TicTacToeGame game = new TicTacToeGame();
		
		
		
		while (game.stillRunning()) {
			Scanner scanner = new Scanner (System.in);
			System.out.print("Enter row and column: ");
			
			
			String row = scanner.next();
			String col = scanner.next();
			
			if ((isInt(row) && isInt(col)) && (validInt(row) && validInt(col))) {
				int rowInt = Integer.parseInt(row);
				int colInt = Integer.parseInt(col);
				if (!game.available(rowInt,colInt)) {
					System.out.println("Square taken, please try again.");
					System.out.println();
				} else {
					game.humanMove(rowInt, colInt, false);
					System.out.println(game.toString());
					System.out.println();
				}
			
			} else {
				System.out.println("Invalid input, please try again.");
				System.out.println();
			}
		}
	
		
		if (game.didWin('X')) {
			System.out.println("X wins");
		} else if (game.didWin('O')){
				System.out.println("O wins");
		} else {
			System.out.println("Tie");
		}
		

		
	}
	
	public static boolean isInt(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static boolean validInt(String str) {
		int strToInt = Integer.parseInt(str);

		if (strToInt > 2 || strToInt < 0) {
			return false;
		}
		return true;
	}

}
