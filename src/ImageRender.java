import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class ImageRender {
    public ImageRender() {

    }

    /**
     * Renders the plots for the map.
     *
     * @param tower tower to add to the map
     * @return StackPane representing the plot.
     */
    public Pane renderPlot(Tower tower) {
        if (tower == null || tower.isDestroyed()) {
            return createBlankPlot();
        }

        Color fill = getFill(tower);

        if (tower.isDestroyed()) {
            return renderDestroyed(Color.BLACK);
        }

        StackPane pane = new StackPane();
        Shape background = new Circle(0, 0, 60, fill);
        pane.getChildren().addAll(createBlankPlot(), background);
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
     * Renders destroyed tower
     *
     * @param fill fill
     * @return pane
     */
    public Pane renderDestroyed(Color fill) {
        StackPane pane = new StackPane();
        Shape background = new Circle(0, 0, 60, fill);
        pane.getChildren().addAll(createBlankPlot(), background);
        return pane;
    }


}
