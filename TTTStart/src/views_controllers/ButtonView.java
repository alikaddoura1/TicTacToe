// Author: Ali Kaddoura
package views_controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import model.OurObserver;
import model.TicTacToeGame;

public class ButtonView extends BorderPane implements OurObserver {
	
	private TicTacToeGame theGame;
	char[][] board;
	
	private GridPane gridPane = new GridPane();
	private Label gameText = new Label("Click to make a move");
	private Button[][] buttons = new Button[3][3];
	private VBox vBox = new VBox();
	private BorderPane borderPane = new BorderPane();

	private int size = 3;
	public ButtonView(TicTacToeGame theModel) {
		theGame = theModel;
		board = theGame.getTicTacToeBoard();
		initializePanel();
		
	}
	

	private void initializePanel() {
		
		int row = 2;
		int col = 3;
		gridPane.setHgap(10);
		gridPane.setVgap(10);
	    for (int r = 0; r < size; r++) {
	    	row++;
	    	col = 3;
	        for (int c = 0; c < size; c++) {
	            buttons[r][c] = new Button(String.valueOf(board[r][c]));
	            buttons[r][c].setStyle("-fx-font-size: 30px; -fx-font-family: 'monospace';");
	            buttons[r][c].setPrefSize(60,60);
	            buttons[r][c].setTextFill(Color.BLUE);
	            gridPane.add(buttons[r][c], col, row);
	            col++;
	        }
	    }
		

	    
	    gameText.setTextFill(Color.BLUE);
	    gameText.setStyle("-fx-font-size: 20; -fx-font-family: 'arial';");
	    
	    borderPane.setCenter(gameText);
	    vBox.getChildren().addAll(gridPane, borderPane);
	    
	    
		this.setCenter(vBox);

		
		for (int i = 0; i <size;i++) {
			for (int j =0;j<size;j++) {
				buttons[i][j].setOnAction(new ButtonHandler());
			}
		}
		
	}
	
	private class ButtonHandler implements EventHandler<ActionEvent>{
		
		
		public void handle(ActionEvent arg0) {
			Button buttonClicked = (Button) arg0.getSource();
			
			for(int i = 0;i<size;i++) {
				for(int j=0;j<size;j++) {
					if(buttons[i][j] == buttonClicked) {
						if(theGame.available(i,j)) {
							theGame.humanMove(i, j, false);
							if(theGame.didWin('X')) {
								gameText.setText("X wins");
								for(int r = 0; r< size;r++) {
									for(int c = 0;c<size;c++) {
							            buttons[r][c].setMouseTransparent(true);
									}
								}
								
							} else if (theGame.didWin('O')){
								gameText.setText("O wins");
								for(int r = 0; r< size;r++) {
									for(int c = 0;c<size;c++) {
							            buttons[r][c].setMouseTransparent(true);
									}
								}
							} else if (theGame.tied()) {
								gameText.setText("Tied");
								for(int r = 0; r< size;r++) {
									for(int c = 0;c<size;c++) {
							            buttons[r][c].setMouseTransparent(true);
									}
								}
							}
						} else {
							gameText.setText("Invalid Move");
						}
					}
				}
			}
		}
	}
	


	@Override
	public void update(Object theObserved) {
		
		for(int r = 0; r< size;r++) {
			for(int c = 0;c<size;c++) {
	            buttons[r][c].setMouseTransparent(false);
			}
		}
		
		
	    char[][] board = theGame.getTicTacToeBoard();
	    for (int i = 0; i < 3; i++) {
	        for (int j = 0; j < 3; j++) {
	            buttons[i][j].setText(String.valueOf(board[i][j]));
	        }
	    }
	    
	    if(theGame.didWin('X')) {
			gameText.setText("X wins");
			for(int r = 0; r< size;r++) {
				for(int c = 0;c<size;c++) {
		            buttons[r][c].setMouseTransparent(true);
				}
			}
			
		} else if (theGame.didWin('O')){
			gameText.setText("O wins");
			for(int r = 0; r< size;r++) {
				for(int c = 0;c<size;c++) {
		            buttons[r][c].setMouseTransparent(true);
				}
			}

		} else if (theGame.tied()) {
			gameText.setText("Tied");
			for(int r = 0; r< size;r++) {
				for(int c = 0;c<size;c++) {
		            buttons[r][c].setMouseTransparent(true);
				}
			}

		} else {
			gameText.setText("Click to make a move");
		
		}
	    
  
	    
		
	}

}
