import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

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

        Text consoleText = new Text(
                "You suck! Your enemies defeated you. " + '\n' +
                        "Get better loser, better luck next time hehe.");
        consoleText.setFill(Color.WHITE);
        Button welcomeButton = new Button("Start New Game");
        welcomeButton.setOnAction(e -> {
            stage.hide();
            try {
                controller.startWelcomeScreen();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        root.setCenter(welcomeButton);
        Button endGame = new Button("End Game");
        endGame.setOnAction(e -> stage.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(consoleText, welcomeButton, endGame);
        root.setTop(layout);
        consoleText.setFont(Font.font(30));
        welcomeButton.setPadding(new Insets(15, 15, 15, 15)); // Increase button size
        endGame.setPadding(new Insets(15, 15, 15, 15)); // Increase button size
        BorderPane.setMargin(endGame, new Insets(10, 10, 440, 10)); // Move buttons upwards
        layout.setAlignment(Pos.CENTER);
        layout.setSpacing(15);



        // Create a scene and place it in the stage
        Scene scene = new Scene(root, 300, 100);
        stage.setTitle("Game Over"); // Set the stage title
        stage.setScene(scene); // Place the scene in the stage
        stage.show(); // Display the stage
    }
}

