package views_controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
/**
 * This is the beginning of one view of a Tic Tac Toe game using
 * two TextField objects and one TextArea. The other two views
 * of ButtonView and DrawingView follow the same structure as this.
 * 
 * @author Rick Mercer and Ali Kaddoura 
 */
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import model.OurObserver;
import model.TicTacToeGame;

public class TextAreaView extends BorderPane implements OurObserver {

	private TicTacToeGame theGame;
	
	private char [][] board;

	private TextField row = new TextField();
	private TextField col = new TextField();
	private Button enter = new Button("Make Move");
	private Label rowLabel = new Label("row");
	private Label colLabel = new Label("column");
	private TextArea message = new TextArea();

	public TextAreaView(TicTacToeGame theModel) {
		theGame = theModel;
		board = theGame.getTicTacToeBoard();
		initializePanel();
	}

	public void initializePanel() {

		message.setEditable(false);
		GridPane topGridPane = new GridPane();
		topGridPane.setHgap(10);
		topGridPane.setVgap(15);
		row.setMaxSize(70, 20);
		col.setMaxSize(70, 20);
		topGridPane.add(enter, 6, 3);
		topGridPane.add(new Label(""), 5, 4);
		topGridPane.add(rowLabel, 7, 1);
		topGridPane.add(colLabel, 7, 2);

		topGridPane.add(row, 6, 1);
		topGridPane.add(col, 6, 2);
		BorderPane mainPane = new BorderPane();
		mainPane.setTop(topGridPane);
		mainPane.setBottom(message);
		enter.setPrefWidth(95);
		enter.setPrefHeight(25);
		
		row.setEditable(true);
		col.setEditable(true);
		enter.setMouseTransparent(false);

		enter.setOnAction(new EnterHandler());

		message.setStyle("-fx-font-family: 'monospace'; -fx-font-size: 35px;");
		message.setText(theGame.toString());
		this.setCenter(mainPane);

		// this.setBottom(new Button("Bottom"));
	}

	private class EnterHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent arg0) {
			String rowString = row.getText().trim();
			String colString = col.getText().trim();

			if ((isInt(rowString) && isInt(colString)) && (validInt(rowString) && validInt(colString))) {
				int rowToInt = Integer.parseInt(rowString);
				int colToInt = Integer.parseInt(colString);
				if (theGame.available(rowToInt, colToInt)) {
					row.clear();
					col.clear();
					enter.setText("Make Move");
					theGame.humanMove(rowToInt, colToInt, false);
					message.setText(theGame.toString());
					if (theGame.didWin('X')) {
						enter.setText("X wins");
						row.setEditable(false);
						col.setEditable(false);
						enter.setMouseTransparent(true);
					} else if (theGame.didWin('O')) {
						enter.setText("O wins");
						row.setEditable(false);
						col.setEditable(false);
						enter.setMouseTransparent(true);
					} else if (theGame.tied()) {
						enter.setText("Tie");
						row.setEditable(false);
						col.setEditable(false);
						enter.setMouseTransparent(true);
					}
				} else {
					enter.setText("Invalid Choice");
				}

			} else {
				enter.setText("Invalid Choice");
			}

		}

		public boolean isInt(String str) {
			try {
				Integer.parseInt(str);
				return true;
			} catch (NumberFormatException e) {
				return false;
			}
		}

		public boolean validInt(String str) {
			int strToInt = Integer.parseInt(str);

			if (strToInt > 2 || strToInt < 0) {
				return false;
			}
			return true;
		}

	}

	// This method is called by Observable's notifyObservers()
	@Override
	public void update(Object observable) {
		
		row.setEditable(true);
		col.setEditable(true);
		enter.setMouseTransparent(false);
		
		message.setText(theGame.toString());
		
	    if(theGame.didWin('X')) {
			enter.setText("X wins");
			row.setEditable(false);
			col.setEditable(false);
			enter.setMouseTransparent(true);

			
		} else if (theGame.didWin('O')){
			enter.setText("O wins");
			row.setEditable(false);
			col.setEditable(false);
			enter.setMouseTransparent(true);

		} else if (theGame.tied()) {
			enter.setText("Tied");
			row.setEditable(false);
			col.setEditable(false);
			enter.setMouseTransparent(true);

		} else {
			enter.setText("Make a move");

		
		}
	}
}