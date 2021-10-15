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

/**
 * Initial welcome screen.
 * @author Olaolu Dada, Eric Shavkin
 * @version 1.0
 */
public class WelcomeScreen extends Application {
    private Controller controller;
    private Stage stage;

    /**
     * Constructor taking the main controller object.
     *
     * @param controller the controller object
     */
    public WelcomeScreen(Controller controller) {
        this.controller = controller;
    }

    /**
     * Welcome screen constructor for the launch to work.
     */
    public WelcomeScreen() {
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        stage.setMinWidth(950);
        stage.setMinHeight(650);
        BorderPane root = new BorderPane();
        Image image = new Image("https://lcl.okstate.edu/gogreek/site-files/images/sigma-phi-epsilon_crest-01.png");

        // Create background image
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, true);
        BackgroundImage backgroundImage = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                backgroundSize);

        // Create background
        Background background = new Background(backgroundImage);
        root.setBackground(background);

        // Adding labels
        Label welcomeLabel = new Label("Welcome to Tower Defense!");
        welcomeLabel.setFont(new Font("Arial", 30));
        welcomeLabel.setTranslateY(30);
        welcomeLabel.setTextFill(Color.web("#904D39"));

        Button welcomeButton = new Button("Click to Start");
        welcomeButton.setOnAction(e -> {
            InitialConfigurationScreen config = new InitialConfigurationScreen();
            stage.hide();
            config.initializeGame(stage);
        });

        root.setTop(welcomeLabel);
        root.setCenter(welcomeButton);

        welcomeButton.setPadding(new Insets(15, 15, 15, 15)); // Increase button size
        BorderPane.setMargin(welcomeButton, new Insets(10, 10, 440, 10)); // Move button upwards
        BorderPane.setAlignment(welcomeButton, Pos.CENTER);
        BorderPane.setAlignment(welcomeLabel, Pos.CENTER);


        // Create a scene and place it in the stage
        Scene scene = new Scene(root, 300, 100);
        stage.setTitle("Welcome Page"); // Set the stage title
        stage.setScene(scene); // Place the scene in the stage
        stage.show(); // Display the stage
    }

    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     * @param args arg from command line.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
