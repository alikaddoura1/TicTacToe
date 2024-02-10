
package views_controllers;

/**
 * Play TicTacToe the computer that can have different AIs to beat you. 
 * Select the Options menus to begin a new game, switch strategies for 
 * the computer player (BOT or AI), and to switch between the two views.
 * 
 * This class represents an event-driven program with a graphical user 
 * interface as a controller between the view and the model. It has 
 * event handlers to mediate between the view and the model.
 * 
 * This controller employs the Observer design pattern that updates two 
 * views every time the state of the Tic Tac Toe game changes:
 * 
 *  1) whenever you make a move by clicking a button or an area of either view
 *  2) whenever the computer AI makes a move
 *  3) whenever there is a win or a tie
 *    
 * You can also select two different strategies to play against from the menus
 * 
 * @author Rick Mercer and Ali Kaddoura
 */
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.IntermediateAI;
import model.OurObserver;
import model.RandomAI;
import model.TicTacToeGame;

public class TicTacToeGUI extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	private TicTacToeGame theGame;

	private OurObserver currentView;
	private OurObserver textAreaView;
	private OurObserver buttonView;
	private OurObserver drawingView;
	// TBA:
	// private OurObserver buttonView;
	// private OurObserver drawingView;

	private BorderPane window;
	public static final int width = 254;
	public static final int height = 360;

	public void start(Stage stage) {
		stage.setTitle("Tic Tac Toe");
		window = new BorderPane();
		Scene scene = new Scene(window, width, height);
		initializeGameForTheFirstTime();

		// TBA: Set up the views in Sprint 2
		// buttonView = new ButtonView(theGame);
		// drawingView = new DrawingView(theGame);
		// theGame.addObserver(buttonView);
		// theGame.addObserver(drawingView);
		textAreaView = new TextAreaView(theGame);
		buttonView = new ButtonView(theGame);
		drawingView = new DrawingView(theGame);
		theGame.addObserver(textAreaView);
		theGame.addObserver(buttonView);
		theGame.addObserver(drawingView);
		setViewTo(textAreaView);
		
		
		
		MenuItem text = new MenuItem("TextArea"); 
		MenuItem button = new MenuItem("Button");
		MenuItem drawing = new MenuItem("Drawing");
		Menu views = new Menu("Views");
		views.getItems().addAll(text,button,drawing);
		
		MenuItem random = new MenuItem("RandomAI");
		MenuItem intermediate = new MenuItem("IntermediateAI");
		Menu strategies = new Menu ("Strategies");
		strategies.getItems().addAll(random,intermediate);
		
		MenuItem newGame = new MenuItem("New game");
		Menu options = new Menu("Options");
		
		options.getItems().addAll(newGame,strategies,views);
		MenuBar menuBar = new MenuBar();
		
		menuBar.getMenus().addAll(options);
		window.setTop(menuBar);
		
		EventHandler<ActionEvent> menuHandler = new MenuHandler();
		text.setOnAction(menuHandler);
		button.setOnAction(menuHandler);
		drawing.setOnAction(menuHandler);
		
		random.setOnAction(menuHandler);
		intermediate.setOnAction(menuHandler);
		
		newGame.setOnAction(menuHandler);
		
		
		
		stage.setScene(scene);
		stage.show();
	}
	
	private class MenuHandler implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent arg0) {
			MenuItem clicked = (MenuItem) arg0.getSource();
			String text = clicked.getText();

			
			if(text.equals("TextArea")) {
				setViewTo(textAreaView);
			}
			if(text.equals("Button")) {
				setViewTo(buttonView);
			}if (text.equals("IntermediateAI")) {
				theGame.setComputerPlayerStrategy(new IntermediateAI());
			}
			if (text.equals("Drawing")) {
				setViewTo(drawingView);
			}
			
			if(text.equals("RandomAI")) {
				theGame.setComputerPlayerStrategy(new RandomAI());
			}
			if (text.equals("New game")) {
				theGame.startNewGame();

				
			}
		}
		
	}

	/**
	 * Set the game to the default of an empty board and the random AI.
	 */
	public void initializeGameForTheFirstTime() {
		theGame = new TicTacToeGame();
		// This event driven program will always have
		// a computer player who takes the second turn
		theGame.setComputerPlayerStrategy(new RandomAI());
	}

	private void setViewTo(OurObserver newView) {
		window.setCenter(null);
		currentView = newView;
		window.setCenter((Node) currentView);
	}

}