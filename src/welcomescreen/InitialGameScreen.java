package welcomescreen;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

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

    private VBox mainPage(BorderPane root) {
        Text moneyText = new Text("Total money: $" + controller.getPlayer().getMoney());
        Text pathText = new Text("The path that enemies will travel along will run from the "
                + "left side of the screen to the right side of the screen, "
                + "and will have many bends"
                + " and corners along the way.");
        Text monumentText = new Text(
                "The monument that the user will have to protect is a fortified "
                        + "tower with a king at the top. It is made of stone, "
                        + "but has many flags and is very ornate.");
        Text monumentHealthText = new Text("Monument health: "
                + controller.getPlayer().getMonument().getHealth());

        Button towerMenu = new Button("Access Tower Store");
        towerMenu.setOnAction(event -> TowerMenu.display(controller));

        VBox main = new VBox();
        main.setAlignment(Pos.CENTER);
        main.setSpacing(7.5);
        main.getChildren().addAll(moneyText, pathText, monumentText, monumentHealthText, towerMenu);
        return main;
    }

    /**
     * Creates the inventory panel.
     *
     * @return vbox representing inventory panel.
     */
    public VBox getInventory() {
        HBox inventoryHeader = new HBox();
        Label inventoryLabel = new Label("Inventory");
        inventoryHeader.getChildren().add(inventoryLabel);
        inventoryHeader.setPadding(new Insets(10, 50, 5, 100));
        inventoryHeader.setBorder(new Border(new BorderStroke(Color.BROWN,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(0, 0, 5, 0))));

        VBox inventoryContents = new VBox();

        ArrayList<LightTower> lTowers = controller.getPlayer().getLTowers();
        int numLTowers = lTowers.size();
        ArrayList<MediumTower> mTowers = controller.getPlayer().getMTowers();
        int numMTowers = mTowers.size();
        ArrayList<HeavyTower> hTowers = controller.getPlayer().getHTowers();
        int numHTowers = hTowers.size();
        int totalTowers = lTowers.size() + mTowers.size() + hTowers.size();

        Label lTowerCount = new Label("Light Towers Count: " + numLTowers);
        Label mTowerCount = new Label("Medium Towers Count: " + numMTowers);
        Label hTowerCount = new Label("Heavy Towers Count: " + numHTowers);
        Label tTowerCount = new Label("Total Towers Count: " + totalTowers);

        inventoryContents.getChildren().addAll(lTowerCount, mTowerCount, hTowerCount, tTowerCount);

        VBox inventoryPanel = new VBox(10);
        inventoryPanel.getChildren().addAll(inventoryHeader, inventoryContents);
        inventoryPanel.setBorder(new Border(new BorderStroke(Color.BROWN,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(5))));

        inventoryPanel.setMaxHeight(240);
        inventoryPanel.setMinWidth(200);
        inventoryPanel.setAlignment(Pos.CENTER);

        return inventoryPanel;
    }

    /**
     * Method where game UI is displayed and user interacts with game application
     * @param stage stage on which GUI is displayed
     */
    public void playGame(Stage stage) {
        this.mainStage = stage;
        BorderPane root = new BorderPane();

        root.setCenter(mainPage(root));
        root.setRight(getInventory());

        Scene scene = new Scene(root, 1000, 380);

        mainStage.setScene(scene);
        mainStage.setTitle("Tower Defense!");
        mainStage.show();
    }
}
