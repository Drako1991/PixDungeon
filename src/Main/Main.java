package Main;

import Player.Player;
import States.*;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Main extends StateBasedGame {
    //TODO: Install and use Gradle to build the project
    private static boolean debugMode = false;

    public static void saveGame() {
        Player.writePlayerToFile();
    }

    public static void loadGame() {
        Player.readPlayerFromFile();
    }

    public static void exitGame() {
        System.exit(0);
    }

    public static void setDebugMode(boolean debugMode1) {
        debugMode = debugMode1;
    }

    public static void toggleDebug() {
        debugMode = !debugMode;
    }

    public static boolean debugMode() {
        return debugMode;
    }

    public static void main(String[] args) throws SlickException {
        AppGameContainer gc = new AppGameContainer(new Main());
        gc.setVSync(Options.isVSync);
        if(Options.isFrameLimit) {
            gc.setTargetFrameRate(60);
        }
        gc.setDisplayMode(1280, 720, false);
        gc.setResizable(false);
        gc.setIcon("res/logo.png");

        gc.start();
    }

    public Main() {
        super("Pix. Dungeon (WIP)");
    }

    public void initStatesList(GameContainer gc) throws SlickException {
        addState(new MainMenu());
        addState(new Game());
        addState(new Options());
        addState(new PauseMenu());
        addState(new CharacterCreation());
    }
}