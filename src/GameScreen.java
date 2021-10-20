import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class GameScreen {
    private Controller controller;
    private Stage mainStage;
    private ImageRender imageRender;

    /**
     * No-arg constructor for initial game screen
     */
    public GameScreen() {
    }

    /**
     * Constructor for initial game screen
     * @param controller controller
     */
    public GameScreen(Controller controller) {
        this.controller = controller;
        imageRender = new ImageRender();
    }

    private VBox header(BorderPane root) {
        Label gameName = new Label("Tower Defense!");
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
        towerMenu.setOnAction(e -> {
            TowerMenu.display(controller);
            reload(root);
        });




        VBox main = new VBox();
        main.setAlignment(Pos.CENTER);
        main.setSpacing(7.5);
        main.getChildren().addAll(gameName, moneyText, pathText, monumentText, monumentHealthText, towerMenu);
        return main;
    }

    /**
     * Reloads the title, inventory, and map.
     *
     * @param root borderpane to reload.
     */
    public void reload(BorderPane root) {
        root.setTop(header(root));
        root.setRight(getInventory());
        root.setCenter(mainPage(root));
    }
    /**
     * Creates a scrollpane containing the plot for the map.
     *
     * @param root borderpane to reload
     * @return scrollpane representing the plots.
     */
    private ScrollPane mainPage(BorderPane root) {
        GridPane plots = new GridPane();
        ArrayList<Tower> towerPlots = controller.getPlayer().getTowerPlots();
        int rows = controller.getPlayer().getRows();

        Rectangle plot = new Rectangle(50, 50);
        plot.setFill(Color.BLUE);
        StackPane monument = new StackPane(plot);
        plots.add(monument, 0, 0);

        int i = 0;
        for (int column = 0; column < 12; column++) {
            for (int row = 0; row < rows; row++) {
                Tower tower = (i < towerPlots.size()) ? towerPlots.get(i) : null;
                Pane pane = imageRender.renderPlot(tower);
                plots.add(pane, column, row + 1);
                i++;
            }
            for (int row = rows; row < 7; row++) {
                Pane pane = imageRender.renderPlot();
                plots.add(pane, column, row + 1);
            }
        }
        plots.setHgap(10);
        plots.setVgap(10);
        plots.setAlignment(Pos.CENTER);
        VBox vbox = new VBox(2);

        HBox hbox = new HBox();
        Button clear = new Button("Clear destroyed towers");
        clear.setOnAction(e -> {
            controller.getPlayer().clear();
            reload(root);

        });

        //Test for end game screen
        Button tempEndGame = new Button("End the Game");
        tempEndGame.setOnAction(event -> controller.end());

        hbox.getChildren().addAll(clear, tempEndGame);
        hbox.setAlignment(Pos.BOTTOM_RIGHT);

        vbox.getChildren().addAll(plots, hbox);
        vbox.setPadding(new Insets(10, 10, 10, 10));
        ScrollPane pane = new ScrollPane(vbox);
        pane.setPadding(new Insets(20, 20, 20, 20));
        return pane;
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
        root.setTop(header(root));

        Scene scene = new Scene(root, 1000, 400);

        mainStage.setScene(scene);
        mainStage.setTitle("Tower Defense!");
        mainStage.show();
    }
}
