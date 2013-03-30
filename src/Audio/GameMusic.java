package Audio;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;

public class GameMusic {
    private Music music;
    private String musicLocation;
    private boolean looping;
    private float volume, pitch;

    public void play(boolean looping) {
        this.looping = looping;
        play();
    }

    public void pause() {
        music.pause();
    }

    public void stop() {
        music.stop();
    }

    public void play() {
        try {
            music = new Music(musicLocation);
        } catch(SlickException e) {
            e.printStackTrace();
        }

        if(!music.paused()) {
            if(this.looping) {
                music.loop();
            } else {
                music.play(pitch, volume);
            }
        } else {
            music.release();
        }
    }

    public void playAt(float startPos) {
        try {
            music = new Music(musicLocation);
        } catch(SlickException e) {
            e.printStackTrace();
        }

        music.setPosition(startPos);

        if(this.looping) {
            music.loop();
        } else {
            music.play();
        }
    }

    public float getPosition() {
        return music.getPosition();
    }

    public boolean isPlaying() {
        return music.playing();
    }

    public boolean isPaused() {
        return music.paused();
    }

    public GameMusic(String musicLocation) {
        this.musicLocation = musicLocation;
        this.volume = 1.0F;
        this.pitch = 0.5F;
    }

    public GameMusic(String musicLocation, float volume) {
        this.musicLocation = musicLocation;
        this.volume = volume;
        this.pitch = 0.5F;
    }

    public GameMusic(String musicLocation, float volume, float pitch) {
        this.musicLocation = musicLocation;
        this.volume = volume;
        this.pitch = pitch;
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