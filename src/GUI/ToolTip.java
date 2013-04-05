package GUI;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.RoundedRectangle;
import org.newdawn.slick.geom.Vector2f;

public class ToolTip {
    private Vector2f pos;
    private String[] text = new String[10];
    private Types.ttTypes types;
    private String name;

    public ToolTip(Types.ttTypes type, Vector2f pos, String name, String[] text) {
        this.pos = pos;
        types = type;
        this.name = name;

//        if(types == Types.ttTypes.Weapon) {
//            this.text = new String[6];
//        }
//        if(types == Types.ttTypes.Armor) {
//            this.text = new String[5];
//        }
//        if(types == Types.ttTypes.Ability) {
//            this.text = new String[];
//        }
        this.text = text;
    }

    public ToolTip showToolTip(Graphics g) {
        g.setColor(new Color(100, 100, 100));
        g.fill(new RoundedRectangle(pos.x, pos.y, 125, (text.length+1) * 20, 2F));
        g.setColor(new Color(150, 150, 150));
        g.draw(new RoundedRectangle(pos.x, pos.y, 125, (text.length+1) * 20, 2F));

        g.drawString(name, pos.x, pos.y);
        for(int i = 0; i < text.length; i++) {
            g.drawString(text[i], pos.x+2, pos.y + (i+1.25f)*17.5f);
        }
        return this;
    }
}
