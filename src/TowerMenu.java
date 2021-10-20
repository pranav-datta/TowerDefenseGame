import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;

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

        double currentFunds = controller.getPlayer().getMoney();
        Label currentMoney = new Label("Current Funds: $" + controller.getPlayer().getMoney());
        Label towerShop = new Label("Purchase a tower here!");

        LightTower lightTower = new LightTower(controller.getPlayer().getLevel());
        ArrayList<LightTower> lTowers = controller.getPlayer().getLTowers();
        Button buyLightTower = new Button("BUY LIGHT TOWER");
        Label buyLightPrice = new Label("$ " + lightTower.getBuyCost());
        Label lightTowerLabel = new Label(lightTower.getDescription());

        ArrayList<Tower> tPlots = controller.getPlayer().getTowerPlots();

        buyLightTower.setOnAction(event -> {
            if (controller.getPlayer().isFull()) {
                AlertBox.display("Not Enough Space!", "Either clear your destroyed towers or upgrade them!");
            } else if (currentFunds < lightTower.getBuyCost()) {
                AlertBox.display("Not Enough Funds!", "You need more money!");
            } else if (tPlots.size() == 36) {
                AlertBox.display("Too many light towers", "You have reached capacity for light towers!");
            }  else {
                lTowers.add(lightTower);
                tPlots.add(lightTower);
                controller.getPlayer().setMoney(currentFunds - lightTower.getBuyCost());
                AlertBox.display("New Balance", "You now have $"
                        + controller.getPlayer().getMoney());
                window.close();
            }
        });

        Button upgradeLightTower = new Button("UPGRADE LIGHT TOWER");
        Label upgradeLightPrice = new Label("$ " + lightTower.getUpgradeCost());
        upgradeLightTower.setOnAction(event -> {
            ArrayList<MediumTower> mTowers = controller.getPlayer().getMTowers();
            if (controller.getPlayer().getLTowers().size() == 0) {
                AlertBox.display("No tower to upgrade!", "You need to have a light tower to upgrade.");
            } else if (currentFunds < lightTower.getUpgradeCost()) {
                AlertBox.display("Not Enough Funds!", "You need more money!");
            } else if (tPlots.size() == 36) {
                AlertBox.display("Too many medium towers", "You have reached capacity for medium towers!");
            } else {
                controller.getPlayer().upgradeLTower(lightTower.getUpgradeCost());
                controller.getPlayer().setMoney(currentFunds - lightTower.getBuyCost());
                AlertBox.display("New Balance", "You now have $"
                        + controller.getPlayer().getMoney());
                window.close();
            }
        });

        MediumTower mediumTower = new MediumTower(controller.getPlayer().getLevel());
        ArrayList<MediumTower> mTowers = controller.getPlayer().getMTowers();
        Button buyMediumTower = new Button("BUY MEDIUM TOWER");
        Label buyMediumPrice = new Label("$ " + mediumTower.getBuyCost());
        Label mediumTowerLabel = new Label(mediumTower.getDescription());
        buyMediumTower.setOnAction(event -> {
            if (controller.getPlayer().isFull()) {
                AlertBox.display("Not Enough Space!", "Either clear your destroyed towers or upgrade them!");
            } else if (currentFunds < mediumTower.getBuyCost()) {
                AlertBox.display("Not Enough Funds!", "You need more money!");
            } else if (tPlots.size() == 36) {
                AlertBox.display("Too many medium towers", "You have reached capacity for medium towers!");
            } else {
                mTowers.add(mediumTower);
                tPlots.add(mediumTower);
                controller.getPlayer().setMoney(currentFunds - mediumTower.getBuyCost());
                AlertBox.display("New Balance", "You now have $"
                        + controller.getPlayer().getMoney());
                window.close();
            }
        });

        Button upgradeMediumTower = new Button("UPGRADE MEDIUM TOWER");
        Label upgradeMediumPrice = new Label("$ " + mediumTower.getUpgradeCost());
        upgradeMediumTower.setOnAction(event -> {
            ArrayList<HeavyTower> hTowers = controller.getPlayer().getHTowers();
            if (controller.getPlayer().getMTowers().size() == 0) {
                AlertBox.display("No tower to upgrade!", "You need to have a medium tower to upgrade.");
            } else if (tPlots.size() == 36) {
                AlertBox.display("Too many towers", "You have reached capacity for towers!");
            } else if (currentFunds < mediumTower.getUpgradeCost()) {
                AlertBox.display("Not Enough Funds!", "You need more money!");
            } else {
                controller.getPlayer().upgradeMTower(mediumTower.getUpgradeCost());
                controller.getPlayer().setMoney(currentFunds - mediumTower.getBuyCost());
                AlertBox.display("New Balance", "You now have $"
                        + controller.getPlayer().getMoney());
                window.close();
            }
        });

        HeavyTower heavyTower = new HeavyTower(controller.getPlayer().getLevel());
        Button buyHeavyTower = new Button("BUY HEAVY TOWER");
        Label buyHeavyPrice = new Label("$ " + heavyTower.getBuyCost());
        Label heavyTowerLabel = new Label(heavyTower.getDescription());
        buyHeavyTower.setOnAction(event -> {
            ArrayList<HeavyTower> hTowers = controller.getPlayer().getHTowers();
            if (controller.getPlayer().isFull()) {
                AlertBox.display("Not Enough Space!", "Either clear your destroyed towers or upgrade them!");
            } else if (currentFunds < heavyTower.getBuyCost()) {
                AlertBox.display("Not Enough Funds!", "You need more money!");
            } else if (tPlots.size() == 36) {
                AlertBox.display("Too many towers", "You have reached capacity for towers!");
            } else {
                hTowers.add(heavyTower);
                tPlots.add(heavyTower);
                controller.getPlayer().setMoney(currentFunds - heavyTower.getBuyCost());
                AlertBox.display("New Balance", "You now have $"
                        + controller.getPlayer().getMoney());
                window.close();
            }
        });

        Button closeButton = new Button("CANCEL");
        closeButton.setOnAction(event -> window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(currentMoney, towerShop, buyLightTower, buyLightPrice, lightTowerLabel,
                upgradeLightTower, upgradeLightPrice,  buyMediumTower, buyMediumPrice, mediumTowerLabel,
                upgradeMediumTower, upgradeMediumPrice, buyHeavyTower, buyHeavyPrice, heavyTowerLabel, closeButton);
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