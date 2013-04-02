package States;

import Audio.MusicList;
import BaseClasses.TextCenter;
import Classes.BaseClass;
import Classes.Classes;
import GUI.CharacterCreation;
import Main.Entity;
import Main.Main;
import Maps.Map;
import Maps.Maps;
import Player.Player;
import Render.PlayerRender;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Game extends BasicGameState {
    Entity EntityPlayer = null, EntityName = null;
    static Player player1 = null, player2 = null, player3 = null, player4 = null;
    private boolean createCharacterOpen = false, isMenuOpen = false, /*isRunning,*/ isInventoryOpen;
    private static boolean changingMap = true, creatingCharacter = false;
    private static Map currMap;
    private static int players = 0;
    private static Vector2f tileSize;

    private static void changeMap(String s) {
        changingMap = true;
    }

    private static void changeMap(Map map) {
        currMap = map;
        changingMap = true;
    }

    public static void createCharacter(String name, BaseClass Class) {
        creatingCharacter = true;
        if(creatingCharacter) {
            creatingCharacter = false;
            switch(players) {
                default: System.out.println("The amount of players is either too high or too low! " + players);
                case 4: System.out.println("There are too many players! " + players);
                case 3: player4 = new Player(name, Class); players = 4;
                case 2: player3 = new Player(name, Class); players = 3;
                case 1: player2 = new Player(name, Class); players = 2;
                case 0: player1 = new Player(name, Class); players = 1;
            }
        }
    }

    public int getID() {
        return States.Playing.ordinal();
    }
//
//    public boolean isInventoryOpen() {
//        return isInventoryOpen;
//    }
//
//    public boolean isMenuOpen() {
//        return isMenuOpen;
//    }
//
//    public void stop() {
//        isRunning = false;
//    }
//
//    public boolean isGameRunning() {
//        return isRunning;
//    }


    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        changeMap(Maps.Map1);
        tileSize = new Vector2f(64*(gc.getWidth()/1280), 64*(gc.getHeight()/720));
//        createCharacter("Zurrox", Classes.Archer);

        player1 = new Player("Zurrox", Classes.Archer);
        System.out.println("MaxHealth: " + player1.getMaxHealth());
        EntityPlayer = new Entity("Player");
        EntityName = new Entity("PlayerName");
//        ImageRenderComponent PlayerImage = new ImageRenderComponent("PlayerImage", classImage, 42 * (gc.getWidth() / 1280), 58 * (gc.getHeight() / 720));
//        EntityPlayer.addComponent(PlayerImage);
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        EntityPlayer.setScale(42 * (gc.getWidth() / 1280), 58 * (gc.getHeight() / 720));
        float playerPosX = -EntityPlayer.getPosition().x / 64 * (gc.getWidth() / 1280) + 2;
        float playerPosY = -EntityPlayer.getPosition().y / 64 * (gc.getHeight() / 720);
        Maps.renderMap(currMap, playerPosX, playerPosY, gc);
        PlayerRender.renderPlayer(gc, player1);

        if(changingMap) {
            changingMap = false;
        }

        Input input = gc.getInput();

        boolean gameHidden = false;
        if(!gameHidden) {
            EntityPlayer.render(gc, null, g);
            EntityName.render(gc, null, g);
            EntityName.setPosition(new Vector2f(TextCenter.getCenterTextX(player1.getName(), gc.getWidth() / 2), gc.getHeight() / 2));
        }

        try {
            Thread.sleep(2);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

        if(isMenuOpen) {
            if(createCharacterOpen) {
                CharacterCreation.createWindow(gc, g);
            }
            if(isInventoryOpen) {
                Inventory(gc, g);
            }
        } else closeAllWindows();

        //DEBUG
        if(Main.debugMode()) {
            if(input.isKeyDown(Input.KEY_1)) {
                changeMap(Maps.Map1);
            }
            if(input.isKeyPressed(Input.KEY_2)) {
                MusicList.cave1.play();
            }
            if(input.isKeyPressed(Input.KEY_3)) {
                MusicList.cave1.stop();
            }
            if(input.isKeyDown(Input.KEY_E)) {
                Main.exitGame();
            }

            int tempPosX = (int) Math.ceil(playerPosX), tempPosY = (int) Math.ceil(playerPosY);
            if(currMap.getTile(tempPosX, tempPosY) != null) {
                g.drawString("Tile: " + currMap.getTile(tempPosX, tempPosY).getName(), 0, gc.getHeight() / 4 - 40);
                g.drawString("Solid: " + currMap.getTile(tempPosX, tempPosY).isSolid(), 0, gc.getHeight() / 4 - 60);
            } else {
                g.drawString("Tile: Null", 0, gc.getHeight() / 4 - 40);
                g.drawString("Solid: Null", 0, gc.getHeight() / 4 - 60);
            }

            g.setColor(Color.white);
            g.drawString("MouseX: " + (int) Math.ceil(input.getMouseX()) + ", MouseY: " + (int) Math.ceil(input.getMouseY()), 0, gc.getHeight() / 4);
            g.drawString("PlayerX: " + (int) Math.ceil(playerPosX) + " PlayerPosY: " + (int) Math.ceil(playerPosY), 0, gc.getHeight() / 4 + 20);
            g.drawString("Dead: " + player1.isDead(), 0, gc.getHeight() / 4 - 20);
        }
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) {
        Input input = gc.getInput();

        tileSize = new Vector2f(64*(gc.getWidth()/1280), 64*(gc.getHeight()/720));

        if(Main.debugMode()) {
            gc.setShowFPS(true);

            /*if (input.isKeyDown(Input.KEY_X)) {
                player1.addPower(1);
            }
            if (input.isKeyDown(Input.KEY_Z)) {
                player1.takePower(1);
            }
            if (input.isKeyDown(Input.KEY_D)) {
                player1.addXP(1);
            }
            if (input.isKeyPressed(Input.KEY_W) && !input.isKeyDown(Input.KEY_LSHIFT)) {
                player1.setDead(false);
            }
            if (input.isKeyPressed(Input.KEY_W) && input.isKeyDown(Input.KEY_LSHIFT)) {
                player1.setDead(true);
            }
            if (input.isKeyDown(Input.KEY_Q)) {
                player1.takeHealth(1);
            }
            if (input.isKeyDown(Input.KEY_E)) {
                player1.addHealth(1);
            }*/
        } else {
            gc.setShowFPS(false);
        }

        if(input.isKeyPressed(Input.KEY_LCONTROL) || gc.getInput().isKeyPressed(Input.KEY_RCONTROL)) {
            Main.toggleDebug();
        }


        boolean gamePaused = false;
        if(!gamePaused) {
            EntityPlayer.update(gc, null, delta);
            EntityName.update(gc, null, delta);
        }


        if(gc.getInput().isKeyPressed(Input.KEY_ESCAPE)) {
            sbg.enterState(States.PauseMenu.ordinal());
        }

        if(gc.getInput().isKeyPressed(Input.KEY_B)) {
            isMenuOpen = !isMenuOpen;
            isInventoryOpen = !isInventoryOpen;
        }

        if(gc.getInput().isKeyPressed(Input.KEY_C)) {
            isMenuOpen = !isMenuOpen;
            createCharacterOpen = !createCharacterOpen;
        }

        try {
            Thread.sleep(2);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void Inventory(GameContainer gc, Graphics g) throws SlickException {

        g.drawImage(new Image("res/logo.png"), gc.getWidth() - (gc.getWidth() / 4), gc.getHeight() / 2);
    }

    public void closeAllWindows() {
        isMenuOpen = false;

        createCharacterOpen = false;
        isInventoryOpen = false;
    }

    public static Vector2f getTileSize() {
        return tileSize;
    }

    public static Map getCurrentMap() {
        return currMap;
    }
}