package welcomescreen;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class TowerMenu {

    public static void display(Controller controller) {
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

        Label towerShop = new Label("Purchase a tower here!");

        LightTower lightTower = new LightTower(controller.getPlayer().getLevel());
        Button buyLightTower = new Button("BUY LIGHT TOWER: $" + lightTower.getBuyCost());
        Label lightTowerLabel = new Label(lightTower.getDescription());

        double currentFunds = controller.getPlayer().getMoney();


        buyLightTower.setOnAction(event -> {
            if (currentFunds < lightTower.getBuyCost()) {
                AlertBox.display("Not Enough Funds!", "You need more money!");
            } else {
                controller.getPlayer().setMoney(currentFunds - lightTower.getBuyCost());
                AlertBox.display("New Balance", "You now have $"
                        + controller.getPlayer().getMoney());
                window.close();
//                placeTower(lightTower);
            }
        });

        Button upgradeLightTower = new Button("UPGRADE LIGHT TOWER: $"
                + controller.getPlayer().getLTowers().get(0).getUpgradeCost());
        upgradeLightTower.setOnAction(event -> {
            if (currentFunds < controller.getPlayer().getLTowers().get(0).getUpgradeCost()) {
                AlertBox.display("Not Enough Funds!", "You need more money!");
            } else {
                controller.getPlayer().upgradeLTower(controller.getPlayer().getLTowers().get(0).getUpgradeCost());
            }
        });

        MediumTower mediumTower = new MediumTower(controller.getPlayer().getLevel());
        Button buyMediumTower = new Button("BUY MEDIUM TOWER: $" + mediumTower.getBuyCost());
        Label mediumTowerLabel = new Label(mediumTower.getDescription());
        buyMediumTower.setOnAction(event -> {
            if (currentFunds < mediumTower.getBuyCost()) {
                AlertBox.display("Not Enough Funds!", "You need more money!");
            } else {
                controller.getPlayer().setMoney(currentFunds - mediumTower.getBuyCost());
                AlertBox.display("New Balance", "You now have $"
                        + controller.getPlayer().getMoney());
                window.close();
//                placeTower(mediumTower);
            }
        });

        Button upgradeMediumTower = new Button("UPGRADE MEDIUM TOWER: $"
                + controller.getPlayer().getMTowers().get(0).getUpgradeCost());
        upgradeLightTower.setOnAction(event -> {
            if (currentFunds < controller.getPlayer().getMTowers().get(0).getUpgradeCost()) {
                AlertBox.display("Not Enough Funds!", "You need more money!");
            } else {
                controller.getPlayer().upgradeMTower(controller.getPlayer().getMTowers().get(0).getUpgradeCost());
            }
        });

        HeavyTower heavyTower = new HeavyTower(controller.getPlayer().getLevel());
        Button buyHeavyTower = new Button("BUY HEAVY TOWER: $" + heavyTower.getBuyCost());
        Label heavyTowerLabel = new Label(heavyTower.getDescription());
        buyHeavyTower.setOnAction(event -> {
            if (currentFunds < heavyTower.getBuyCost()) {
                AlertBox.display("Not Enough Funds!", "You need more money!");
            } else {
                controller.getPlayer().setMoney(currentFunds - heavyTower.getBuyCost());
                AlertBox.display("New Balance", "You now have $"
                        + controller.getPlayer().getMoney());
                window.close();
//                placeTower(heavyTower);
            }
        });

        Button closeButton = new Button("CANCEL");
        closeButton.setOnAction(event -> window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(towerShop, buyLightTower, lightTowerLabel, upgradeLightTower, buyMediumTower,
                mediumTowerLabel, upgradeMediumTower, buyHeavyTower, heavyTowerLabel, closeButton);
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