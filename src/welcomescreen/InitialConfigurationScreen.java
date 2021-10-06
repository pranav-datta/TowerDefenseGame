package welcomescreen;

import javafx.geometry.Pos;
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
    //private Controller controller;
    private Level level;
    private Stage mainStage;

    ///**
    // * Constructor for the initial configuration screen
    // * @param controller Controller object that controls the movement between screens
    // */
    //public InitialConfigurationScreen(Controller controller) {
    //    this.controller = controller;
    //    this.label = new Label("Configuration Screen");
    //}

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
     * @param mainStage stage that is used to create the screen
     */
    public void initializeGame(Stage mainStage) {
        this.mainStage = mainStage;

        Dialog dialogBox = new Dialog();
        dialogBox.setTitle("Initialize Game");
        dialogBox.getDialogPane().getButtonTypes().add(ButtonType.OK);

        Label nameLabel = new Label("Name: ");
        TextField name = new TextField();
        name.setPromptText("Input player name");

        Label levelLabel = new Label("Game Level: ");
        Button easy = new Button("Easy");
        easy.setOnAction(event -> {
            AlertBox.display("Selection", "You have selected Easy difficulty!");
            level = Level.EASY;
        });

        Button intermediate = new Button("Intermediate");
        intermediate.setOnAction(event -> {
            AlertBox.display("Selection", "You have selected Intermediate difficulty!");
            level = Level.INTERMEDIATE;
        });

        Button hard = new Button("Hard");
        hard.setOnAction(event -> {
            AlertBox.display("Selection", "You have selected Hard difficulty!");
            level = Level.HARD;
        });
        Label label = new Label("Configuration Screen");

        HBox nameBox = new HBox();
        nameBox.setAlignment(Pos.CENTER);
        nameBox.setSpacing(10);
        nameBox.getChildren().addAll(nameLabel, name);

        HBox levelBox = new HBox();
        levelBox.setAlignment(Pos.CENTER);
        levelBox.setSpacing(10);
        levelBox.getChildren().addAll(levelLabel, easy, intermediate, hard);

        VBox root = new VBox(label);
        root.getChildren().addAll(nameBox, levelBox);
        dialogBox.getDialogPane().setContent(root);

        AtomicBoolean entryIsValid = new AtomicBoolean(false);
        while (!entryIsValid.get()) {
            dialogBox.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    if (name.getText().length() > 0 && name.getText() != null
                            && !name.getText().trim().isEmpty()) {
                        entryIsValid.set(true);
                        Controller control = null;
                        try {
                            control = new Controller(mainStage);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        control.createPlayer(name.getText(), level);
                        control.startGameUI();
                    } else {
                        Alert configAlert = new Alert(Alert.AlertType.ERROR);
                        configAlert.getDialogPane().setPrefSize(450, 150);
                        configAlert.setTitle("Error");
                        configAlert.setHeaderText("Invalid Input!");
                        configAlert.setContentText("Please input a valid name. "
                                + "If you don't select a level, "
                                + "it will default to easy.");
                        level = null;
                        configAlert.showAndWait();
                    }
                }
            });
        }
    }
}
