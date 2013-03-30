package Classes;

import Player.PowerTypes;

public class Classes {
    public static BaseClass
            Archer = new BaseClass(5, 5, 5, 15, 5, "Archer", PowerTypes.tempArcher, 100),
            Assassin = new BaseClass(5, 5, 5, 5, 15, "Assassin", PowerTypes.tempAssassin, 100),
            Knight = new BaseClass(5, 15, 5, 5, 5, "Knight", PowerTypes.Fury, 100),
            Wizard = new BaseClass(5, 5, 15, 5, 5, "Wizard", PowerTypes.Mana, 100);
}