import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class ImageRender {
    public ImageRender() {

    }

    /**
     * Renders the plots for the map.
     *
     * @param enemy tower to add to the map
     * @return StackPane representing the plot.
     */
    public Pane renderPlot(Enemy enemy) {
        if (enemy == null) {
            return renderDestroyed();
        }

        Color fill = getFill(enemy);
        Rectangle plot = new Rectangle(50, 50);
        plot.setFill(fill);
        StackPane pane = new StackPane(plot);

        return pane;
    }
    /**
     * Renders the plots for the map.
     *
     * @param tower tower to add to the map
     * @return StackPane representing the plot.
     */
    public Pane renderPlot(Tower tower) {
        if (tower == null) {
            return createBlankPlot();
        }
        Color fill = getFill(tower);
        Circle plot = new Circle(0, 0, 20, fill);
        StackPane pane = new StackPane(plot);

        return pane;
    }

    /**
     * Renders the plots for the map.
     *
     * @return StackPane representing the plot.
     */
    public Pane renderPlot() {
        Rectangle plot = new Rectangle(50, 50);
        plot.setFill(Color.WHITE);
        StackPane pane = new StackPane(plot);
        return pane;
    }

    /**
     * Creates a blank plot.
     *
     * @return StackPane containing a blank plot.
     */
    public StackPane createBlankPlot() {
        Rectangle plot = new Rectangle(50, 50);
        plot.setFill(Color.GREY);
        StackPane pane = new StackPane(plot);
        return pane;
    }

    /**
     * Our custom ColorPicker.
     *
     * @param tower the tower whose color we want.
     * @return returns the color associated with a particular tower.
     */
    public Color getFill(Tower tower) {
        Color fill = null;
        if (tower.getName().equals("Light Tower")) {
            fill = Color.GREEN;
        } else if (tower.getName().equals("Medium Tower")) {
            fill = Color.YELLOW;
        } else if (tower.getName().equals("Heavy Tower")) {
            fill = Color.RED;
        }
        return fill;
    }

    /**
     * Our custom ColorPicker.
     *
     * @param enemy the enemy whose color we want.
     * @return returns the color associated with a particular enemy.
     */
    public Color getFill(Enemy enemy) {
        Color fill = null;
        if (enemy.getName().equals("Light enemy")) {
            fill = Color.rgb((150 - enemy.getHealth()), 255, (150 - enemy.getHealth()));
        } else if (enemy.getName().equals("Medium enemy")) {
            fill = Color.rgb(255, 255, (250 - enemy.getHealth()));
        } else if (enemy.getName().equals("Heavy enemy")) {
            fill = Color.rgb(255, (250 - (enemy.getHealth() / 2)), (250 - (enemy.getHealth() / 2)));
        }
        return fill;
    }

    /**
     * Renders destroyed tower
     *
     * @return pane
     */
    public Pane renderDestroyed() {
        Rectangle plot = new Rectangle(50, 50);
        plot.setFill(Color.WHITE);
        StackPane pane = new StackPane(plot);
        return pane;
    }


}
