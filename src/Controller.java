import javafx.application.Application;
import javafx.stage.Stage;

/**
 * A Controller class that handles flow between
 * different screens in the Application.
 *
 * @author Olaolu Dada, Pranav Datta
 * @version 1.0
 */


public class Controller extends Application {
    private Stage primaryStage;
    private Player player;
    private InitialConfigurationScreen config;
    private boolean saved;
    private WelcomeScreen welcome;
    private InitialGameScreen game;
    //private EndGameUI endGameUI;

    /**
     * Constructor for the Controller.Controller class.
     *
     * @param primaryStage the main stage
     * @throws Exception if stage can't launch correctly
     */
    public Controller(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        welcome = new WelcomeScreen(this);
        config = new InitialConfigurationScreen();
        game = new InitialGameScreen(this);
        welcome.start(primaryStage);
    }

    /**
     * No-arg constructor for the Controller.Controller class
     */
    public Controller() {

    }

    /**
     * Creates a player object based on user input
     *
     * @param name  player's chosen name
     * @param level player's chosen difficulty
     */
    public void createPlayer(String name, Level level) {
        player = new Player(name, level);
    }

    /**
     * Getter for the player object.
     *
     * @return the player object.
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Transitions from Welcome Screen to Config screen
     */
    public void startConfigUI() {
        config.initializeGame(primaryStage);
        saved = false;
    }

    /**
     * Starts the game screen
     */
    public void startGameUI() {
        game.playGame(primaryStage);
    }

    /**
     * Shows the game over screen
     */
//    public void end() {
//        primaryStage.hide();
//        EndGame.start(primaryStage);
//    }

    ///**
    // * Saves the game
    // *
    // * @throws Exception if stage can't launch correctly
    // */
    //public void save() {
    //    saved = true;
    //    primaryStage.hide();
    //    welcome = new WelcomeScreen(this);
    //    welcome.start(primaryStage);
    //}

    ///**
    // * Getter for saved
    // *
    // * @return true if game is saved.
    // */

    @Override
    public void start(Stage stage) throws Exception {
        this.primaryStage = stage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
