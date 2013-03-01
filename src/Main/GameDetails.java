package Main;

public class GameDetails {
    private boolean isServer;
    private int Difficulty;

    public int getDifficulty() {

        return this.Difficulty;
    }

    public boolean isServer() {

        return this.isServer;
    }

    public void setDifficulty(int Difficulty) {

        this.Difficulty = Difficulty;
    }

    public void setServer(boolean Server) {

        this.isServer = Server;
    }
}