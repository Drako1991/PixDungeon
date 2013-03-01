package Classes;

import Player.PowerTypes;

public class ClassKnight extends BaseClass {
    private DefaultValues v = new DefaultValues();

    public ClassKnight() {

        setVitality(v.KNIGHT_VITALITY);
        setStrength(v.KNIGHT_STRENGTH);
        setIntellect(v.KNIGHT_INTELLECT);
        setDexterity(v.KNIGHT_DEXTERITY);
        setAgility(v.KNIGHT_AGILITY);
        setName(v.KNIGHT_NAME);
        setPowerType(PowerTypes.Fury);
    }
}