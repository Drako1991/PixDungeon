package GUI;

import Player.Player;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.RoundedRectangle;

public class PlayerHUD {

    public static void showHUD(GameContainer gc, Graphics g, Player ply) throws SlickException {
        Image xpBar = new Image("res/GUI/XPBar.png");
        Image healthPot = new Image("res/GUI/health.png");
        //TODO: Fix HP texturing when going to a bigger window.
        //TODO: Make health affect the health bar.

        //Background
        g.setColor(new Color(0, 0, 0, 150));
        g.fill(new Rectangle(0, gc.getHeight(), gc.getWidth(), -(gc.getHeight() / 5)));


        float posX = gc.getWidth() / 1.26F,
                posY = gc.getHeight() / 140,
                width = gc.getWidth() / 5,
                height = gc.getHeight() / 72;

        //Health Bar
        float perHP = (float) ply.getHealth() / (float) ply.getMaxHealth();

//        float HPX = posX + 0,
//              HPY = posY + 0,
//              HPW = width + 0,
//              HPH = height + 0;

        float HPX = gc.getWidth() / 35F,
                HPY = gc.getHeight() / 1.3F,
                HPW = gc.getWidth() / 35,
                HPH = gc.getHeight() / 6.25F;

//        if (perHP >= 0.75) {
//            g.setColor(Color.green);
//        } else if (perHP >= 0.25 && perHP < 75) {
//            g.setColor(Color.orange);
//        } else if (perHP < 0.25) {
//            g.setColor(Color.red);
//        }
//        g.fill(new RoundedRectangle(HPX, HPY, HPW * perHP, HPH, 3F));
//        g.draw(new RoundedRectangle(HPX - 5, HPY - 5, HPW + 10, HPH + 10, 3F));
                           /*R, G, B*/
//        g.setColor(new Color(50, 50, 255));
//        g.drawString("Health: " + ply.getHealth() + "/" + ply.getMaxHealth(), posX + 62, posY - 5);

//        g.setColor(Color.transparent);
        g.setColor(Color.red);
        g.texture(new Rectangle(HPX + 3, HPY + 30, HPW - 8, HPH - 50), new Image("res/GUI/Tex_Health.png"));
//        g.fill(new Rectangle(HPX, HPY, HPW, HPH));
        healthPot.draw(HPX, HPY);

        //XP Bar
        float perXP = (float) ply.getXP() / (float) ply.getMaxXP();

        float XPPosX = gc.getWidth() / 10;
        float XPPosY = gc.getHeight() / 1.235F;
        float XPWidth = gc.getWidth() - 300;
        float XPHeight = gc.getHeight() / 50;

        g.setColor(new Color(0, 0, 0, 100));
        g.fill(new RoundedRectangle(XPPosX, XPPosY, XPWidth, XPHeight, 3F));

//        g.setColor(new Color(0, 0, 0, 100));
//        g.draw(new RoundedRectangle(XPPosX - 5, XPPosY - 5, XPWidth + 10, XPHeight + 10, 3F));
        g.setColor(new Color(0, 255, 0, 110));
        g.fill(new RoundedRectangle(XPPosX + 18, XPPosY, (XPWidth - 34) * perXP, XPHeight, 3F));
        xpBar.draw(XPPosX, XPPosY, XPWidth - 5, XPHeight);

        g.setColor(new Color(255, 255, 255));
        g.drawString("Level: " + ply.getLevel(), (XPWidth / 2) - 15, XPPosY - (XPHeight / 2) - 30);
        g.drawString("XP: " + ply.getXP() + "/" + ply.getMaxXP(), (XPWidth / 2) - 15, XPPosY - (XPHeight / 2));

        //Power Bar
        float perPower = (float) ply.getPower() / (float) ply.getMaxPower();

        float powerPosX = posX + 0;
        float powerPosY = posY + 25;
        float powerWidth = width + 0;
        float powerHeight = height + 0;

        g.setColor(ply.getPowerColor());
        g.fill(new RoundedRectangle(powerPosX, powerPosY, powerWidth * perPower, powerHeight, 3F));
        g.draw(new RoundedRectangle(powerPosX - 5, powerPosY - 5, powerWidth + 10, powerHeight + 10, 3F));
        g.setColor(new Color(255, 255, 255));
        g.drawString(ply.getPowerTypeString() + ": " + ply.getPower() + "/" + ply.getMaxPower(), powerPosX + 62, powerPosY - 5);
    }
}