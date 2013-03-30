package Audio;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

public class GameFX {
    private String soundLocation;
    private float volume, pitch;
    private Sound fx;

    public void play() {
        try{
            fx = new Sound(soundLocation);
        }catch(SlickException e) {
            e.printStackTrace();
        }
        fx.play(volume, pitch);
    }

    public void stop() {
        fx.stop();
    }

    public GameFX(String soundLocation) {
        this.soundLocation = soundLocation;
        this.volume = 1.0f;
        this.pitch = 0.5f;
    }

    public GameFX(String soundLocation, float volume) {
        this.soundLocation = soundLocation;
        this.volume = volume;
        this.pitch = 0.5f;
    }

    public GameFX(String soundLocation, float volume, float pitch) {
        this.soundLocation = soundLocation;
        this.volume = volume;
        this.pitch = pitch;
    }

    public GameFX setSoundLocation(String soundLocation) {
        this.soundLocation = soundLocation;
        return this;
    }

    public GameFX setVolume(float volume) {
        this.volume = volume;
        return this;
    }

    public GameFX setPitch(float pitch) {
        this.pitch = pitch;
        return this;
    }

    public String getSoundLocation() {
        return soundLocation;
    }

    public float getVolume() {
        return volume;
    }

    public float getPitch() {
        return pitch;
    }

    public boolean isPlaying() {
        return fx.playing();
    }
}