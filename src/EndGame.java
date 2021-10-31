import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Game Over Code
 * @author Spencer Kim
 * @version 1.0
 */
public class EndGame extends Application {
    private Stage stage;
    private Controller controller;

    /**
     * Construction for the main controller of the end game.
     *
     * @param controller for controller object
     */
    public EndGame(Controller controller) {
        this.controller = controller;
    }

    /**
     * Welcome screen construction to launch.
     */
    public EndGame() {
    } // no-arg constructor to launch.

    public void start(Stage stage) {
        this.stage = stage;
        stage.setMinWidth(950);
        stage.setMinHeight(650);
        BorderPane root = new BorderPane();

        Image image = new Image("https://image.freepik.com/free-vector/game-with-glitch-effect_225004-661.jpg");

        //Background image
        BackgroundSize backgroundSize = new BackgroundSize(200, 200, true, true, true, true);
        BackgroundImage backgroundImage = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                backgroundSize);

        // Create background
        Background background = new Background(backgroundImage);
        root.setBackground(background);


        Button welcomeButton = new Button("Start New Game");
        welcomeButton.setOnAction(e -> {
            stage.hide();
            try {
                controller.startWelcome();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        Button closeGame = new Button("Close Game");
        closeGame.setOnAction(e -> stage.hide());
        root.setCenter(welcomeButton);
        root.setBottom(closeGame);

        welcomeButton.setPadding(new Insets(15, 15, 15, 15)); // Increase button size
        BorderPane.setMargin(welcomeButton, new Insets(10, 10, 440, 10)); // Move button upwards
        BorderPane.setAlignment(welcomeButton, Pos.CENTER);

        closeGame.setPadding(new Insets(15, 15, 15, 15)); // Increase button size
        BorderPane.setMargin(closeGame, new Insets(10, 10, 440, 10)); // Move button upwards
        BorderPane.setAlignment(closeGame, Pos.CENTER);



        // Create a scene and place it in the stage
        Scene scene = new Scene(root, 300, 100);
        stage.setTitle("Game Over"); // Set the stage title
        stage.setScene(scene); // Place the scene in the stage
        stage.show(); // Display the stage
    }
}

