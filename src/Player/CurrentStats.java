package Player;

import Main.GameDetails;

public class CurrentStats {
    private int Strength, Vitality, Intellect, Dexterity, Agility;
    private GameDetails details;

    public void setPlayerStrength(int Strength) {

        if (!details.isServer()) {
            this.Strength = Strength;
        } else {
            System.out.println("====NEED TO SET PLAYER WHEN SETTING STRENGTH====");
        }
    }

    public void setPlayerStrength(Player player, int Strength) {

        player.setStrength(Strength);
    }

    public void setPlayerVitality(int Vitality) {

        if (!details.isServer()) {
            this.Vitality = Vitality;
        } else {
            System.out.println("====NEED TO SET PLAYER WHEN SETTING VITALITY====");
        }
    }

    public void setPlayerIntellect(int Intellect) {

        if (!details.isServer()) {
            this.Intellect = Intellect;
        } else {
            System.out.println("====NEED TO SET PLAYER WHEN SETTING INTELLECT====");
        }
    }

    public void setPlayerDexterity(int Dexterity) {

        if (!details.isServer()) {
            this.Dexterity = Dexterity;
        } else {
            System.out.println("====NEED TO SET PLAYER WHEN SETTING Dexterity====");
        }
    }

    public void setPlayerAgility(int Agility) {

        if (!details.isServer()) {
            this.Agility = Agility;
        } else {
            System.out.println("====NEED TO SET PLAYER WHEN SETTING AGILITY====");
        }
    }

    public int getStrength() {

        return this.Strength;
    }

    public int getVitality() {

        return this.Vitality;
    }

    public int getIntellect() {

        return this.Intellect;
    }

    public int getDexterity() {

        return this.Dexterity;
    }

    public int getAgility() {

        return this.Agility;
    }
}