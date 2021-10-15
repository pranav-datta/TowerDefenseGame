package welcomescreen;

import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.testfx.api.FxAssert.verifyThat;

public class UnitTests extends ApplicationTest {

    @Override
    public void start(Stage stage) throws Exception {
        WelcomeScreen welcome = new WelcomeScreen();
        welcome.start(stage);
    }

    @Test
    public void testInitialScreen() {
        clickOn("Click to Start");
        verifyThat("Configuration Screen", NodeMatchers.isNotNull());
    }

    @Test
    public void testPlayerTwoArgConstructor() {
        Player player1 = new Player("Eric", Level.HARD);
        assertNotNull(player1);
        assertEquals(player1.getName(), "Eric");
        assertEquals(player1.getLevel(), Level.HARD);
        assertEquals(player1.getMoney(), 150, 0);
    }

    @Test
    public void testPlayerOneArgConstructor() {
        Player player2 = new Player("Spencer");
        assertNotNull(player2);
        assertEquals(player2.getName(), "Spencer");
        assertEquals(player2.getMoney(), 500, 0);
        assertEquals(player2.getLevel(), Level.EASY);
    }

    @Test
    public void testPlayerAndController() {
        Player play = new Player("Laolu Dada", Level.EASY);
        assertNotNull(play);
        assertEquals("Laolu Dada", play.getName());
        assertEquals(500, play.getMoney(), 0);
        assertEquals(Level.EASY, play.getLevel());

        Controller c = new Controller();
        c.createPlayer("Laolu Dada", Level.INTERMEDIATE);
        assertNotNull(c.getPlayer());
        assertEquals("Laolu Dada", c.getPlayer().getName());
        assertEquals(250, c.getPlayer().getMoney(), 0);
        assertEquals(Level.INTERMEDIATE, c.getPlayer().getLevel());
    }

    @Test
    public void testTowerMenuButton() {
        clickOn("Click to Start");
        clickOn("Input player name");
        write("Pranav");
        clickOn("Easy");
        clickOn("CONFIRM");
        clickOn("OK");
        clickOn("Access Tower Store");
        verifyThat("Purchase a tower here!", NodeMatchers.isNotNull());
    }

    @Test
    public void testLightTowerButton() {
        clickOn("Click to Start");
        clickOn("Input player name");
        write("Pranav");
        clickOn("Easy");
        clickOn("CONFIRM");
        clickOn("OK");
        clickOn("Access Tower Store");
        clickOn("BUY LIGHT TOWER: $25.0");
        clickOn("CONFIRM");
        verifyThat("Tower Defense!", NodeMatchers.isNotNull());
    }
}
