import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
public class WinScreen extends Application {
    private Stage stage;
    private Controller controller;

    /**
     * Construction for the main controller of the end game.
     *
     * @param controller for controller object
     */
    public WinScreen(Controller controller) {
        this.controller = controller;
    }

    /**
     * Welcome screen construction to launch.
     */
    public WinScreen() {
    } // no-arg constructor to launch.

    public void start(Stage stage) {
        this.stage = stage;
        stage.setMinWidth(950);
        stage.setMinHeight(650);
        BorderPane root = new BorderPane();

        Image image = new Image("https://media.istockphoto.com/videos/you-win-game-screen-video-id1185664467?s=640x640");

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

        Text consoleText = new Text("YOU WON THE GAME");
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

        Label damageTaken = new Label("Damage Taken: " + controller.getStats().getDamageTaken());
        Label timePlayed = new Label("Time Played: " + ((int) controller.getStats().getTimePlayed()));
        Label enemiesKilled = new Label("Enemies Killed: " + controller.getStats().getEnemiesKilled());

        damageTaken.setTextFill(Color.WHITE);
        timePlayed.setTextFill(Color.WHITE);
        enemiesKilled.setTextFill(Color.WHITE);

        VBox layout = new VBox(10);
        layout.getChildren().addAll(consoleText, welcomeButton, endGame, damageTaken, timePlayed, enemiesKilled);
        root.setTop(layout);
        consoleText.setFont(Font.font(30));
        welcomeButton.setPadding(new Insets(15, 15, 15, 15)); // Increase button size
        endGame.setPadding(new Insets(15, 15, 15, 15)); // Increase button size
        BorderPane.setMargin(endGame, new Insets(10, 10, 440, 10)); // Move buttons upwards
        layout.setAlignment(Pos.CENTER);
        layout.setSpacing(15);

        // Create a scene and place it in the stage
        Scene scene = new Scene(root, 300, 100);
        stage.setTitle("Win Game"); // Set the stage title
        stage.setScene(scene); // Place the scene in the stage
        stage.show(); // Display the stage
    }
}
