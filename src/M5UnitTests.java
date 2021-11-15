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
    public void testMoneyGainEasy() throws InterruptedException {
        clickOn("Click to Start");
        clickOn("Input player name");
        write("Pranav");
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
        write("Pranav");
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

    @Test
    public void testMoneyGainHard() throws InterruptedException {
        clickOn("Click to Start");
        clickOn("Input player name");
        write("Eric");
        clickOn("Hard");
        clickOn("CONFIRM");
        clickOn("OK");
        clickOn("Access Tower Store");
        clickOn("BUY HEAVY TOWER");
        clickOn("CONFIRM");
        clickOn("Start Combat");
        Thread.sleep(15000);
        verifyThat("Total money: $250.0", NodeMatchers.isNotNull());
    }

    @Test
    public void testMonumentDamageEasy() throws InterruptedException {
        clickOn("Click to Start");
        clickOn("Input player name");
        write("Eric");
        clickOn("Easy");
        clickOn("CONFIRM");
        clickOn("OK");
        clickOn("Start Combat");
        Thread.sleep(30000);
        verifyThat("Monument health: 300", NodeMatchers.isNotNull());
    }

    @Test
    public void testMonumentDamageMedium() throws InterruptedException {
        clickOn("Click to Start");
        clickOn("Input player name");
        write("Laolu");
        clickOn("Intermediate");
        clickOn("CONFIRM");
        clickOn("OK");
        clickOn("Start Combat");
        Thread.sleep(30000);
        //verifyThat("Monument health: 0", NodeMatchers.isNotNull());
        verifyThat("Start New Game", NodeMatchers.isNotNull());
    }

    @Test
    public void testBuyTowerAfterRoundEnds() {
        clickOn("Click to Start");
        clickOn("Input player name");
        write("Laolu");
        clickOn("Easy");
        clickOn("CONFIRM");
        clickOn("OK");
        clickOn("End the Game");
        clickOn("Start New Game");
        clickOn("Click to Start");
        clickOn("Input player name");
        write("Dada");
        clickOn("Hard");
        clickOn("CONFIRM");
        clickOn("OK");
        clickOn("Start Combat");
        clickOn("Access Tower Store");
        clickOn("BUY HEAVY TOWER");
        clickOn("CONFIRM");
        verifyThat("Total money: $0.0", NodeMatchers.isNotNull());
    }

    @Test
    public void testMoneyGainMedium() throws InterruptedException {
        clickOn("Click to Start");
        clickOn("Input player name");
        write("Spencer");
        clickOn("Intermediate");
        clickOn("CONFIRM");
        clickOn("OK");
        clickOn("Access Tower Store");
        clickOn("BUY HEAVY TOWER");
        clickOn("CONFIRM");
        clickOn("Start Combat");
        Thread.sleep(15000);
        verifyThat("Total money: $400.0", NodeMatchers.isNotNull());
    }

    @Test
    public void testMonumentDamageHard() throws InterruptedException {
        clickOn("Click to Start");
        clickOn("Input player name");
        write("Spancer");
        clickOn("Hard");
        clickOn("CONFIRM");
        clickOn("OK");
        clickOn("Start Combat");
        Thread.sleep(30000);
        //verifyThat("Monument health: 0", NodeMatchers.isNotNull());
        verifyThat("Start New Game", NodeMatchers.isNotNull());
    }
}
