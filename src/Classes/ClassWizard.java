package Classes;

import Player.PowerTypes;

public class ClassWizard extends BaseClass {
    private DefaultValues v = new DefaultValues();

    public ClassWizard() {

        setVitality(v.WIZARD_VITALITY);
        setStrength(v.WIZARD_STRENGTH);
        setIntellect(v.WIZARD_INTELLECT);
        setDexterity(v.WIZARD_DEXTERITY);
        setAgility(v.WIZARD_AGILITY);
        setName(v.WIZARD_NAME);
        setPowerType(PowerTypes.Mana);
    }
}