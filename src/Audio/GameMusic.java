package Audio;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;

public class GameMusic {
    private Music music;
    private String musicLocation;
    private boolean looping;
    private float volume, pitch;

    public void play(boolean looping) {
        looping = true;
        play();
    }

    public void pause() {
        music.pause();
    }

    public void stop() {
        music.stop();
    }

    public void play() {
        try{
            music = new Music(musicLocation);
        }catch(SlickException e) {
            e.printStackTrace();
        }

        if(this.looping) {
            music.loop();
        }else{
            music.play(volume, pitch);
        }
    }

    public boolean isPlaying() {
        return music.playing();
    }

    public boolean isPaused() {
        return music.paused();
    }

    public GameMusic(String musicLocation) {
        this.musicLocation = musicLocation;
    }

    public GameMusic setLooping(boolean looping) {
        this.looping = looping;
        return this;
    }

    public GameMusic setVolume(float volume) {
        this.volume = volume;
        return this;
    }

    public GameMusic setPitch(float pitch) {
        this.pitch = pitch;
        return this;
    }

    public String getMusicLocation() {
        return musicLocation;
    }

    public boolean isLooping() {
        return looping;
    }

    public float getVolume() {
        return volume;
    }

    public float getPitch() {
        return pitch;
    }
}
