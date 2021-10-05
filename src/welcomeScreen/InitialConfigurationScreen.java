package welcomescreen;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author Eric Shavkin, Olaolu Dada, Pranav Datta
 * @version 1.0
 * This class is the initial configuration screen
 * accessed by starting the game from the welcome screen
 */
public class InitialConfigurationScreen {
    private Controller controller;
    private Level level;
    private Stage mainStage;
    private Label label;

    /**
     * Constructor for the initial configuration screen
     * @param controller Controller object that controls the movement between screens
     */
    public InitialConfigurationScreen(Controller controller) {
        this.controller = controller;
        this.label = new Label("Configuration Screen");
    }

    /**
     * Getter method for level
     * @return the desired level
     */
    public Level getLevel() {
        return level;
    }

    /**
     * Setter method for level
     * @param level desired level to set to
     */
    public void setLevel(Level level) {
        this.level = level;
    }

    /**
     * Method that initializes the game where user sets the player name and level
     * @param stage stage that is used to create the screen
     */
    public void initializeGame(Stage stage) {
        mainStage = stage;

        Dialog dialogBox = new Dialog();
        dialogBox.setTitle("Initialize Game");
        dialogBox.getDialogPane().getButtonTypes().add(ButtonType.OK);

        Label nameLabel = new Label("Name: ");
        TextField name = new TextField();
        name.setPromptText("Input player name");

        Label levelLabel = new Label("Game Level: ");
        Button easy = new Button("Easy");
        easy.setOnAction(event -> {
            Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
            level = Level.EASY;
        });

        Button intermediate = new Button("Intermediate");
        intermediate.setOnAction(event -> {
            Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
            level = Level.INTERMEDIATE;
        });

        Button hard = new Button("Hard");
        hard.setOnAction(event -> {
            Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
            level = Level.HARD;
        });

        HBox nameBox = new HBox();
        nameBox.setAlignment(Pos.CENTER);
        nameBox.setSpacing(10);
        nameBox.getChildren().addAll(nameLabel, name);

        HBox levelBox = new HBox();
        levelBox.setAlignment(Pos.CENTER);
        levelBox.setSpacing(10);
        levelBox.getChildren().addAll(easy, intermediate, hard);

        VBox root = new VBox(label);
        root.getChildren().addAll(nameBox, levelBox);

        Scene scene = new Scene(root, 700, 380);
        mainStage.setScene(scene);
        mainStage.show();
        AtomicBoolean entryIsValid = new AtomicBoolean(false);
        while (!entryIsValid.get()) {
            dialogBox.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    if (name.getText() != null && name.getText().length() > 0
                            && !name.getText().trim().isEmpty() && level != null) {
                        entryIsValid.set(true);
                        controller.createPlayer(name.getText(), level);
                        //controller.startInitialGameScreen();
                    } else {
                        Alert configAlert = new Alert(Alert.AlertType.ERROR);
                        configAlert.getDialogPane().setPrefSize(450, 150);
                        configAlert.setTitle("Error");
                        configAlert.setHeaderText("Invalid Input!");
                        configAlert.setContentText("Please input a valid name and select a level.");
                        configAlert.showAndWait();
                    }
                }
            });
        }
    }
}