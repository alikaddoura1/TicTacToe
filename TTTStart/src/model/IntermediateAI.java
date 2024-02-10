/**
 * Rick suggests, the IntermediateAI first check to stop a win of the opponent, 
 * then look for its own win. If neither is found, select any other open
 * spot randomly. You may use any other strategy as long as it beats RandomAI.
 * 
 * @authors Rick Mercer and Ali Kaddoura
 */
package model;

import java.util.Random;

public class IntermediateAI implements TicTacToeStrategy {

	private Random random;

	public IntermediateAI() {
		random = new Random();

	}

	@Override
	public OurPoint desiredMove(TicTacToeGame theGame) {
		boolean set = false;
		while (!set) {
			if (theGame.maxMovesRemaining() == 0) {
				throw new IGotNowhereToGoException(" -- Hey there programmer, the board is filled");
			}
			char[][] board = theGame.getTicTacToeBoard();

			// Checking if bot has winnable move
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (theGame.available(i, j)) {
						board[i][j] = 'O';
						if (theGame.didWin('O')) {
							board[i][j] = '_';
							set = true;
							return new OurPoint(i, j);
						}
						board[i][j] = '_';
					}
				}
			}

			// checking if human has winnable move and so block it
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (theGame.available(i, j)) {
						board[i][j] = 'X';
						if (theGame.didWin('X')) {
							board[i][j] = '_';
							set = true;
							return new OurPoint(i, j);
						}
						board[i][j] = '_';
					}
				}
			}
			// Pick a random spot that is available
			// Id you cant win the game or block a winning move
			while (true) {
				int row = random.nextInt(3);
				int col = random.nextInt(3);
				if (theGame.available(row, col)) {
					return new OurPoint(row, col);
				}
			}
		}
		return null;
	}
}
