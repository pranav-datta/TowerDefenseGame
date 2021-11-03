import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class GameScreen {
    private Controller controller;
    private Stage mainStage;
    private ImageRender imageRender;
    private ArrayList<Enemy> enemyPlots = new ArrayList<>(51);
    private int count = 0;
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
        Text moneyText = new Text("Total money: $" + controller.getPlayer().getMoney());
        Text monumentHealthText = new Text("Monument health: "
                + controller.getPlayer().getMonument().getHealth());

        Button towerMenu = new Button("Access Tower Store");
        towerMenu.setOnAction(e -> {
            TowerMenu.display(controller);
            reload(root, enemyPlots, controller.getPlayer().getLevel());
        });

        VBox main = new VBox();
        main.setAlignment(Pos.CENTER);
        main.setSpacing(7.5);
        main.getChildren().addAll(moneyText, monumentHealthText, towerMenu);
        return main;
    }

    /**
     * Reloads the title, inventory, and map.
     *
     * @param root borderpane to reload.
     */
    public void reload(BorderPane root, ArrayList<Enemy> enemyPlots, Level level) {
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
        Timeline move = new Timeline(new KeyFrame(Duration.seconds(1), ev -> {
            enemyPlots.add(null);
            reload(root, enemyPlots, controller.getPlayer().getLevel());
        }));
        move.setCycleCount(Animation.INDEFINITE);
        move.setDelay(Duration.seconds(7));
        if (controller.getPlayer().getMonument().checkIfDestroyed()) {
            move.stop();
            if (count == 0) {
               // AlertBox.display("Game Over", "Your monument has reached 0 health and the game is over.");
                controller.end();
                count++;
            }
        }
        int i = 0;
        int j = enemyPlots.size() - 1;
        for (int row = 0; row < 7; row++) {
            if (row != 2 && row != 6) {
                for (int column = 0; column < 12; column++) {
                    if (row == 5 || row == 1) {
                        if (column < 11) {
                            Tower tower = (i < towerPlots.size()) ? towerPlots.get(i) : null;
                            Pane pane = imageRender.renderPlot(tower);
                            plots.add(pane, column, row);
                            i++;
                        } else {
                            Enemy enemy = (j >= 0) ? enemyPlots.get(j) : null;
                            Pane pane = imageRender.renderPlot(enemy);
                            plots.add(pane, column, row);
                            j--;
                        }
                    } else if (row == 3) {
                        if (column > 0) {
                            Tower tower = (i < towerPlots.size()) ? towerPlots.get(i) : null;
                            Pane pane = imageRender.renderPlot(tower);
                            plots.add(pane, column, row);
                            i++;
                        } else {
                            Enemy enemy = (j >= 0) ? enemyPlots.get(j) : null;
                            Pane pane = imageRender.renderPlot(enemy);
                            plots.add(pane, column, row);
                            j--;
                        }
                    } else {
                        Enemy enemy = (j >= 0) ? enemyPlots.get(j) : null;
                        Pane pane = imageRender.renderPlot(enemy);
                        plots.add(pane, column, row);
                        j--;
                    }
                }
            } else {
                for (int column = 11; column >= 0; column--) {
                    Enemy enemy = (j >= 0) ? enemyPlots.get(j) : null;
                    Pane pane = imageRender.renderPlot(enemy);
                    plots.add(pane, column, row);
                    j--;
                }
            }
        }
        Rectangle plot = new Rectangle(50, 50);
        plot.setFill(Color.BLUE);
        StackPane monument = new StackPane(plot);
        plots.add(monument, 0, 8);
        plots.setHgap(10);
        plots.setVgap(10);
        plots.setAlignment(Pos.CENTER);
        VBox vbox = new VBox(2);

        Rectangle lastPane = (((Rectangle) (((Pane) plots.getChildren().get(83)).getChildren().get(0))));
        if (lastPane.getFill().equals(Color.GREEN)) {
            controller.getPlayer().getMonument().setHealth(controller.getPlayer().getMonument().getHealth() -
                    new LightEnemy().getDamage());
        } else if (lastPane.getFill() == Color.YELLOW) {
            controller.getPlayer().getMonument().setHealth(controller.getPlayer().getMonument().getHealth() -
                    new MediumEnemy().getDamage());
        } else if (lastPane.getFill() == Color.RED) {
            controller.getPlayer().getMonument().setHealth(controller.getPlayer().getMonument().getHealth() -
                    new HeavyEnemy().getDamage());
        }

        Button tempEndGame = new Button("End the Game");
        tempEndGame.setOnAction(event -> controller.end());
        HBox hbox = new HBox();
        Button clear = new Button("Clear destroyed towers");
        clear.setOnAction(e -> {
            controller.getPlayer().clear();
            reload(root, enemyPlots, controller.getPlayer().getLevel());
        });

        Button start = new Button("Start combat");
        start.setOnAction(e -> {
            this.startCombat(enemyPlots, controller.getPlayer().getLevel(), root);
            move.play();
        });

        //Test for end game screen


        hbox.getChildren().addAll(start, clear, tempEndGame);
        hbox.setAlignment(Pos.BOTTOM_RIGHT);

        vbox.getChildren().addAll(plots, hbox);
        vbox.setPadding(new Insets(10, 10, 10, 10));
        ScrollPane pane = new ScrollPane(vbox);
        pane.setPadding(new Insets(20, 20, 20, 20));
        return pane;
    }


    public void startCombat(ArrayList<Enemy> enemyPlots, Level level, BorderPane root) {
        Timeline begin = new Timeline(new KeyFrame(Duration.seconds(.5), ev -> {
            addEnemy(enemyPlots, level, root);
            reload(root, enemyPlots, level);
        }));
        begin.setCycleCount(5);
        begin.play();
    }


    public void addEnemy(ArrayList<Enemy> enemyPlots, Level level, BorderPane root) {
        if (level == Level.EASY || level == null) {
            enemyPlots.add(new LightEnemy());
        } else if (level == Level.INTERMEDIATE) {
            enemyPlots.add(new MediumEnemy());
        } else {
            enemyPlots.add(new HeavyEnemy());
        }
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
