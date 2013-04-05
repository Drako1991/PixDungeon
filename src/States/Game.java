package States;

import Audio.MusicList;
import Classes.BaseClass;
import Classes.Classes;
import GUI.CharacterCreation;
import GUI.Inventory;
import GUI.Types;
import Main.Main;
import Maps.Map;
import Maps.Maps;
import Objects.Item;
import Objects.ItemEquipable;
import Player.Player;
import Render.PlayerRender;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Game extends BasicGameState {
    public static Player player = null;
    private static boolean createCharacterOpen = false, isMenuOpen = false, /*isRunning,*/ isInventoryOpen, isInitialising;
    private static boolean changingMap = true, creatingCharacter = false;
    private static Map curMap;
    private static Vector2f tileSize;
    private static GameContainer gc;
    private static Item selectedItem;
    private static Graphics g;

    public static GameContainer getGameContainer() {
        return gc;
    }

    public static Graphics getGraphics() {
        return g;
    }

    private static void changeMap(Map map) {
        curMap = map;
        /*changingMap = true;*/
    }

    public static void createCharacter(String name, BaseClass Class) {
        creatingCharacter = true;
        if(creatingCharacter) {
            creatingCharacter = false;
            player = new Player(name, Class);
        }
    }

    public static void setSelectedItem(Item item) {
        selectedItem = item;
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
        isInitialising = true;
        Inventory.initInventory(gc);
        changeMap(Maps.Map1);
        this.gc = gc;
        tileSize = new Vector2f(64*(gc.getWidth()/1280), 64*(gc.getHeight()/720));
//        createCharacter("Zurrox", Classes.Archer);
        Item logoTest = new Item("logoTest", Types.SlotTypes.Inventory, Inventory.getSlot(5), "res/Logo.png");
        Item logoTest1 = new Item("logoTest1", Types.SlotTypes.Inventory, Inventory.getSlot(4), "res/Logo.png");
        ItemEquipable logoTest2 = new ItemEquipable("equipTest1", Types.SlotTypes.Inventory, Inventory.getSlot(3), 10, 5, 5, 5, "res/Logo.png");
//        Inventory.getSlot(2).setItemInSlot(logoTest);

        player = new Player("Zurrox", Classes.Archer);
        if(isInitialising) {
            isInitialising = false;
        }
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        boolean initRender = true;

        if(initRender) {
            initRender = false;

            this.g = g;
        }
//        System.out.println(Inventory.getSlot(5).getItemInSlot().getName());
        Maps.renderMap(curMap, -player.getPos().x-4, player.getPos().y+2, gc);
        PlayerRender plyRender = new PlayerRender(player, gc);
        plyRender.renderPlayer();

        changingMap = true;
        if(changingMap) {
            changingMap = false;
        }

        /*if(changingMap) {
            changingMap = false;
        }*/

        Input input = gc.getInput();

        boolean gameHidden = false;
        if(!gameHidden) {
        }

        /*try {
            Thread.sleep(2);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }*/

        if(isMenuOpen) {
            if(createCharacterOpen) {
                CharacterCreation.createWindow(gc, g);
            }
            if(isInventoryOpen) {
                GUI.Inventory.Inventory(gc, g);
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

            if(curMap.getTile((int) player.getPos().x, (int) player.getPos().y) != null) {
                g.drawString("Tile: " + curMap.getTile((int) player.getPos().x, (int) player.getPos().y).getName(), 0, gc.getHeight() / 4 - 40);
                g.drawString("Solid: " + curMap.getTile((int) player.getPos().x, (int) player.getPos().y).isSolid(), 0, gc.getHeight() / 4 - 60);
            } else {
                g.drawString("Tile: Null", 0, gc.getHeight() / 4 - 40);
                g.drawString("Solid: Null", 0, gc.getHeight() / 4 - 60);
            }

            g.setColor(Color.white);
            g.drawString("MouseX: " + (int) Math.ceil(input.getMouseX()) + ", MouseY: " + (int) Math.ceil(input.getMouseY()), 0, gc.getHeight() / 4);
            g.drawString("PlayerX: " + (int) player.getPos().x + " PlayerPosY: " + (int) player.getPos().y, 0, gc.getHeight() / 4 + 20);
            g.drawString("Dead: " + player.isDead(), 0, gc.getHeight() / 4 - 20);
        }
        if(selectedItem != null) {
//            g.texture(new RoundedRectangle(gc.getInput().getMouseX(), gc.getInput().getMouseY(), 48, 48, 3F), selectedItem.getImage());
            selectedItem.getImage().draw(gc.getInput().getMouseX(), gc.getInput().getMouseY(), 48, 48);
        }
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) {
        Input input = gc.getInput();

        tileSize = new Vector2f(64*(gc.getWidth()/1280), 64*(gc.getHeight()/720));

        if(Main.debugMode()) {
            gc.setShowFPS(true);
        } else {
            gc.setShowFPS(false);
        }

        if(input.isKeyPressed(Input.KEY_LCONTROL) || gc.getInput().isKeyPressed(Input.KEY_RCONTROL)) {
            Main.toggleDebug();
        }


        boolean gamePaused = false;
        if(!gamePaused) {
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

        /*try {
            Thread.sleep(2);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }*/
    }

    public void closeAllWindows() {
        isMenuOpen = false;

        createCharacterOpen = false;
        isInventoryOpen = false;
    }

    public static Item getSelectedItem() {
        return selectedItem;
    }

    public static boolean isInventoryOpen() {
        return isInventoryOpen;
    }

    public static Vector2f getTileSize() {
        return tileSize;
    }

    public static Map getCurrentMap() {
        return curMap;
    }

    public static boolean isChangingMap() {
        return changingMap;
    }

    public static boolean isKeyDown(int key) {
        return gc.getInput().isKeyDown(key);
    }

    public static boolean isKeyPressed(int key) {
        return gc.getInput().isKeyPressed(key);
    }

    public static boolean isInitialising() {
        return isInitialising;
    }
}