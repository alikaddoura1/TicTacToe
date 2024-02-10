// Author: Ali Kaddoura
package views_controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import model.OurObserver;
import model.TicTacToeGame;

public class DrawingView extends BorderPane implements OurObserver {

	private TicTacToeGame theGame;
	private Canvas canvas = new Canvas(254, 360);
	private Label textArea = new Label("       Make a move");

	private Image xImage = new Image("file:images/x.png");
	private Image oImage = new Image("file:images/o.png");

	public DrawingView(TicTacToeGame theModel) {
		theGame = theModel;
		initializePanel();
	}

	private void initializePanel() {

		GraphicsContext gc = canvas.getGraphicsContext2D();
		drawOn(gc);
		textArea.setStyle("-fx-font-family: 'arial'; -fx-font-size: 20px;");
	    textArea.setTextFill(Color.BLUE);
		this.setTop(textArea);
		this.setCenter(canvas);

		canvas.setOnMousePressed(new MousePressedHandler());
	}

	private void drawOn(GraphicsContext gc) {
		// x1,y1, x2, y2 down right
		// Perimeter
		// Top
		gc.strokeLine(25, 80, 230, 80);
		// left
		gc.strokeLine(25, 80, 25, 300);
		// right
		gc.strokeLine(230, 80, 230, 300);
		// bottom
		gc.strokeLine(25, 300, 230, 300);

		// upDown
		// left
		gc.strokeLine(92, 80, 92, 300);
		// right
		gc.strokeLine(162, 80, 162, 300);

		// leftRight
		// top
		gc.strokeLine(25, 155, 230, 155);
		// bottom
		gc.strokeLine(25, 230, 230, 230);
	}

	private class MousePressedHandler implements EventHandler<MouseEvent> {

		@Override
		public void handle(MouseEvent arg0) {
			double x = arg0.getSceneX();
			double y = arg0.getSceneY() - 40;


			// square one
			if ((x > 25 && x < 92) && (y > 80 && y < 155)) {
				if (theGame.available(0, 0)) {
					theGame.humanMove(0, 0, false);
					if (theGame.didWin('X')) {
						textArea.setText("     X wins");

					} else if (theGame.didWin('O')) {
						textArea.setText("     O wins");

					} else if (theGame.tied()) {
						textArea.setText("     Tied");

					} else {
						textArea.setText("       Make a move");
					}
				} else {
					textArea.setText("     Invalid Move");
				}
			}

			// square two
			if ((x > 92 && x < 162) && (y > 80 && y < 155)) {
				if (theGame.available(0, 1)) {
					theGame.humanMove(0, 1, false);
					if (theGame.didWin('X')) {
						textArea.setText("     X wins");

					} else if (theGame.didWin('O')) {
						textArea.setText("     O wins");

					} else if (theGame.tied()) {
						textArea.setText("     Tied");

					} else {
						textArea.setText("       Make a move");
					}
				} else {
					textArea.setText("     Invalid Move");
				}
			}

			// square three
			if ((x > 162 && x < 230) && (y > 80 && y < 155)) {
				if (theGame.available(0, 2)) {
					theGame.humanMove(0, 2, false);
					if (theGame.didWin('X')) {
						textArea.setText("     X wins");

					} else if (theGame.didWin('O')) {
						textArea.setText("     O wins");

					} else if (theGame.tied()) {
						textArea.setText("     Tied");

					} else {
						textArea.setText("       Make a move");
					}
				} else {
					textArea.setText("     Invalid Move");
				}

			}

			// square four
			if ((x > 25 && x < 92) && (y > 155 && y < 230)) {
				if (theGame.available(1, 0)) {
					theGame.humanMove(1, 0, false);
					if (theGame.didWin('X')) {
						textArea.setText("     X wins");

					} else if (theGame.didWin('O')) {
						textArea.setText("     O wins");

					} else if (theGame.tied()) {
						textArea.setText("     Tied");

					} else {
						textArea.setText("       Make a move");
					}
				} else {
					textArea.setText("     Invalid Move");
				}

			}
			// square five
			if ((x > 92 && x < 162) && (y > 155 && y < 230)) {
				if (theGame.available(1, 1)) {
					theGame.humanMove(1, 1, false);
					if (theGame.didWin('X')) {
						textArea.setText("     X wins");

					} else if (theGame.didWin('O')) {
						textArea.setText("     O wins");

					} else if (theGame.tied()) {
						textArea.setText("     Tied");

					} else {
						textArea.setText("       Make a move");
					}
				} else {
					textArea.setText("     Invalid Move");
				}

			}
			// square six
			if ((x > 162 && x < 230) && (y > 155) && y < 230) {
				if (theGame.available(1, 2)) {
					theGame.humanMove(1, 2, false);
					if (theGame.didWin('X')) {
						textArea.setText("     X wins");

					} else if (theGame.didWin('O')) {
						textArea.setText("     O wins");

					} else if (theGame.tied()) {
						textArea.setText("     Tied");

					} else {
						textArea.setText("       Make a move");
					}
				} else {
					textArea.setText("     Invalid Move");
				}

			}

			// square 7
			if ((x > 25 && x < 92) && y > 230 && y < 300) {
				if (theGame.available(2, 0)) {
					theGame.humanMove(2, 0, false);
					if (theGame.didWin('X')) {
						textArea.setText("     X wins");

					} else if (theGame.didWin('O')) {
						textArea.setText("     O wins");

					} else if (theGame.tied()) {
						textArea.setText("     Tied");

					} else {
						textArea.setText("       Make a move");
					}
				} else {
					textArea.setText("     Invalid Move");
				}

			}

			// square 8
			if ((x > 92 && x < 162) && (y > 230) && y < 300) {
				if (theGame.available(2, 1)) {
					theGame.humanMove(2, 1, false);
					if (theGame.didWin('X')) {
						textArea.setText("     X wins");

					} else if (theGame.didWin('O')) {
						textArea.setText("     O wins");

					} else if (theGame.tied()) {
						textArea.setText("     Tied");

					} else {
						textArea.setText("       Make a move");
					}
				} else {
					textArea.setText("     Invalid Move");
				}

			}
			// square 9
			if ((x > 162 && x < 230) && (y > 230) && y < 300) {
				if (theGame.available(2, 2)) {
					theGame.humanMove(2, 2, false);
					if (theGame.didWin('X')) {
						textArea.setText("     X wins");

					} else if (theGame.didWin('O')) {
						textArea.setText("     O wins");

					} else if (theGame.tied()) {
						textArea.setText("     Tied");

					} else {
						textArea.setText("       Make a move");
					}
				} else {
					textArea.setText("     Invalid Move");
				}

			}

		}

	}

	@Override
	public void update(Object theObserved) {
		GraphicsContext gc = canvas.getGraphicsContext2D();

		EventHandler<MouseEvent> mousePressConsumer = event -> event.consume();
		this.removeEventFilter(MouseEvent.MOUSE_PRESSED, mousePressConsumer);

		gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		
		drawOn(gc);
		char[][] board = theGame.getTicTacToeBoard();
		for (int r = 0; r < 3; r++) {
			for (int c = 0; c < 3; c++) {
				if (board[r][c] == 'X') {
					// first row
					if (r == 0 && c == 0) {
						gc.drawImage(xImage, 45, 100);
					}
					if (r == 0 && c == 1) {
						gc.drawImage(xImage, 110, 100);
					}
					if (r == 0 && c == 2) {
						gc.drawImage(xImage, 180, 100);
					}

					// second row
					if (r == 1 && c == 0) {
						gc.drawImage(xImage, 45, 180);
					}
					if (r == 1 && c == 1) {
						gc.drawImage(xImage, 110, 180);
					}
					if (r == 1 && c == 2) {
						gc.drawImage(xImage, 180, 180);
					}

					// third row
					if (r == 2 && c == 0) {
						gc.drawImage(xImage, 45, 250);
					}
					if (r == 2 && c == 1) {
						gc.drawImage(xImage, 110, 250);
					}
					if (r == 2 && c == 2) {
						gc.drawImage(xImage, 180, 250);
					}

				}
				if (board[r][c] == 'O') {
					if (r == 0 && c == 0) {
						gc.drawImage(oImage, 45, 100);
					}
					if (r == 0 && c == 1) {
						gc.drawImage(oImage, 110, 100);
					}
					if (r == 0 && c == 2) {
						gc.drawImage(oImage, 180, 100);
					}

					// second row
					if (r == 1 && c == 0) {
						gc.drawImage(oImage, 45, 180);
					}
					if (r == 1 && c == 1) {
						gc.drawImage(oImage, 110, 180);
					}
					if (r == 1 && c == 2) {
						gc.drawImage(oImage, 180, 180);
					}

					// third row
					if (r == 2 && c == 0) {
						gc.drawImage(oImage, 45, 250);
					}
					if (r == 2 && c == 1) {
						gc.drawImage(oImage, 110, 250);
					}
					if (r == 2 && c == 2) {
						gc.drawImage(oImage, 180, 250);
					}
				}
			}
		}


		if (theGame.didWin('X')) {
			textArea.setText("     X wins");
			this.addEventFilter(MouseEvent.MOUSE_PRESSED, mousePressConsumer);

		} else if (theGame.didWin('O')) {
			textArea.setText("     O wins");
			this.addEventFilter(MouseEvent.MOUSE_PRESSED, mousePressConsumer);

		} else if (theGame.tied()) {
			textArea.setText("     Tied");
			this.addEventFilter(MouseEvent.MOUSE_PRESSED, mousePressConsumer);

		} else {
			textArea.setText("       Make a move");
		}
	}

}
