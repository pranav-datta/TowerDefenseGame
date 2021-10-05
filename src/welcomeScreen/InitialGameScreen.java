package welcomeScreen;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class InitialGameScreen {
    private Controller controller;
    private Stage mainStage;

    /**
     * No-arg constructor for initial game screen
     */
    public InitialGameScreen() {
    }

    /**
     * Constructor for initial game screen
     * @param controller controller
     */
    public InitialGameScreen(Controller controller) {
        this.controller = controller;
    }

    /**
     * Method where game UI is displayed and user interacts with game application
     * @param stage stage on which GUI is displayed
     */
    public void playGame(Stage stage) {
        mainStage = stage;
        mainStage.setTitle("*insert game name here*");

        Text moneyText = new Text("Total money: " + controller.getPlayer().getMoney());
        Text pathText = new Text("The path that enemies will travel along will run from the "
                + "left side of the screen to the right side of the screen, and will have many bends"
                + " and corners along the way.");
        Text monumentText = new Text("The monument that the user will have to protect is a fortified "
                + "tower with a king at the top. It is made of stone, but has many flags and is very ornate.");
        Text monumentHealthText = new Text("Monument health: " + controller.getPlayer().getMonument());

        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(7.5);
        root.getChildren().addAll(moneyText, pathText, monumentText, monumentHealthText);

        Scene scene = new Scene(root, 700, 380);
        mainStage.setScene(scene);
        mainStage.show();
    }
}
