import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;


import static org.testfx.api.FxAssert.verifyThat;

public class M5UnitTests extends ApplicationTest {

    @Override
    public void start(Stage stage) throws Exception {
        WelcomeScreen welcome = new WelcomeScreen();
        welcome.start(stage);
    }

    @Test
    public void testMoneyGain() throws InterruptedException {
        clickOn("Click to Start");
        clickOn("Input player name");
        write("Eric");
        clickOn("Easy");
        clickOn("CONFIRM");
        clickOn("OK");
        clickOn("Access Tower Store");
        clickOn("BUY HEAVY TOWER");
        clickOn("CONFIRM");
        clickOn("Start Combat");
        Thread.sleep(5000);
        verifyThat("Total money: $675.0", NodeMatchers.isNotNull());
    }

    @Test
    public void testTowerAttack() throws InterruptedException {
        clickOn("Click to Start");
        clickOn("Input player name");
        write("Eric");
        clickOn("Easy");
        clickOn("CONFIRM");
        clickOn("OK");
        clickOn("Access Tower Store");
        clickOn("BUY HEAVY TOWER");
        clickOn("CONFIRM");
        clickOn("Start Combat");
        Thread.sleep(5000);
        verifyThat("Tower Defense!", NodeMatchers.isNotNull());
    }
}
