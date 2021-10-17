package welcomescreen;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
//import controller.Controller;

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

        // Adding labels
        Label welcomeLabel = new Label("Game Over");
        welcomeLabel.setFont(new Font("Arial", 30));
        welcomeLabel.setTranslateY(30);
        welcomeLabel.setTextFill(Color.web("##D5634A"));

//        Button welcomeButton = new Button("Start New Game");
//        welcomeButton.setOnAction(e -> {
//            stage.hide();
//            controller.startGameUI();
//        });
//        root.setTop(welcomeLabel);
//        root.setCenter(welcomeButton);
//
//        welcomeButton.setPadding(new Insets(15, 15, 15, 15)); // Increase button size
//        BorderPane.setMargin(welcomeButton, new Insets(10, 10, 440, 10)); // Move button upwards
//        BorderPane.setAlignment(welcomeButton, Pos.CENTER);
//        BorderPane.setAlignment(welcomeLabel, Pos.CENTER);

        // Create a scene and place it in the stage
        Scene scene = new Scene(root, 300, 100);
        scene.getStylesheets().add("style/main.css");
        stage.setTitle("Game Over"); // Set the stage title
        stage.setScene(scene); // Place the scene in the stage
        stage.show(); // Display the stage
    }
}

