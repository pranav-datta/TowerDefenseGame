package welcomescreen;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class TowerMenu {

    public static void display(Level level, double money) {
        Stage window = new Stage();
        /*
        This makes it so you cannot interact with other windows until you are
        done with this window when it pops up.
        This is important because we want to ensure that the user knows what
        they selected.
         */
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Tower Shop");
        window.setMinWidth(250);

        LightTower lightTower = new LightTower(level);
        Button buyLightTower = new Button("BUY LIGHT TOWER: $" + lightTower.getCost());
        Label lightTowerLabel = new Label(lightTower.getDescription());
        buyLightTower.setOnAction(event -> {
            if (money < lightTower.getCost()) {
                AlertBox.display("Not Enough Funds!", "You need more money!");
            } else {

            }
        });

        MediumTower mediumTower = new MediumTower(level);
        Button buyMediumTower = new Button("BUY MEDIUM TOWER: $" + mediumTower.getCost());
        Label mediumTowerLabel = new Label(mediumTower.getDescription());
        buyMediumTower.setOnAction(event -> {
            if (money < mediumTower.getCost()) {
                AlertBox.display("Not Enough Funds!", "You need more money!");
            } else {

            }
        });

        HeavyTower heavyTower = new HeavyTower(level);
        Button buyHeavyTower = new Button("BUY HEAVY TOWER: $" + heavyTower.getCost());
        Label heavyTowerLabel = new Label(heavyTower.getDescription());
        buyMediumTower.setOnAction(event -> {
            if (money < heavyTower.getCost()) {
                AlertBox.display("Not Enough Funds!", "You need more money!");
            } else {

            }
        });

        Button closeButton = new Button("CANCEL");
        closeButton.setOnAction(event -> window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(buyLightTower, lightTowerLabel, buyMediumTower, mediumTowerLabel,
                buyHeavyTower, heavyTowerLabel, closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        /*
        This makes it so the screen that pops up stays until you confirm.
        (Blocks any user interaction until alert box is closed)
        */
        window.showAndWait();

    }
}
