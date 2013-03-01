package Classes;

public class ClassAssassin extends BaseClass {
    private DefaultValues v = new DefaultValues();

    public ClassAssassin() {

        setVitality(v.ASSASSIN_VITALITY);
        setStrength(v.ASSASSIN_STRENGTH);
        setIntellect(v.ASSASSIN_INTELLECT);
        setDexterity(v.ASSASSIN_DEXTERITY);
        setAgility(v.ASSASSIN_AGILITY);
        setName(v.ASSASSIN_NAME);
    }
}