package Classes;

public class ClassArcher extends BaseClass {
    private DefaultValues v = new DefaultValues();

    public ClassArcher() {

        setVitality(v.ARCHER_VITALITY);
        setStrength(v.ARCHER_STRENGTH);
        setIntellect(v.ARCHER_INTELLECT);
        setDexterity(v.ARCHER_DEXTERITY);
        setAgility(v.ARCHER_AGILITY);
        setName(v.ARCHER_NAME);
        setImageLocation("/res/archer.png");
    }
}