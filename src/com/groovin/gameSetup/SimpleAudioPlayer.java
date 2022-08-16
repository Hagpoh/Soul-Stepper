package com.groovin.gameSetup;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpCookie;
import java.util.Scanner;

import javax.sound.sampled.*;

public class SimpleAudioPlayer {
    public float currentVolume = 0;
    public float previousVolume = 0;
    public FloatControl fc;
    Long currentFrame;
    Clip clip;

    // current status of clip
    String status = "play";
    String musicFile = "/musicfiles/The Truth - Anno Domini Beats.wav";

    AudioInputStream audioInputStream;

    // constructor to initialize streams and clip
    public SimpleAudioPlayer(String musicFile) {
        // create AudioInputStream object
        this.musicFile = musicFile;
        try {
            InputStream audioSrc = getClass().getResourceAsStream(musicFile);
            InputStream bufferedIn = new BufferedInputStream(audioSrc);
            audioInputStream = AudioSystem.getAudioInputStream(bufferedIn);

            // create clip reference
            clip = AudioSystem.getClip();

            // open audioInputStream to the clip
            clip.open(audioInputStream);

            clip.loop(Clip.LOOP_CONTINUOUSLY);
            fc = (FloatControl) clip.getControl((FloatControl.Type.MASTER_GAIN));
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    // Method to play the audio
    public void play() {
        //start the clip
        clip.start();

        status = "play";
    }

    // Method to pause the audio
    public void pause() {
        if (status.equals("paused")) {
            return;
        }
        this.currentFrame =
                this.clip.getMicrosecondPosition();
        clip.stop();
        status = "paused";
    }

    // Method to resume the audio
    public void resumeAudio() {
        if (status.equals("play")) {
            return;
        }
        clip.close();
        resetAudioStream();
        clip.setMicrosecondPosition(currentFrame);
        this.play();
    }

    // Method to restart the audio
    public void restart() {
        clip.stop();
        clip.close();
        resetAudioStream();
        currentFrame = 0L;
        clip.setMicrosecondPosition(0);
        this.play();
    }

    // Method to stop the audio
    public void stop() {
        currentFrame = 0L;
        clip.stop();
        clip.close();
    }

    // Method to jump over a specific part


    // Method to reset audio stream
    public void resetAudioStream() {
        try {
            InputStream audioSrc = getClass().getResourceAsStream(musicFile);
            InputStream bufferedIn = new BufferedInputStream(audioSrc);
            audioInputStream = AudioSystem.getAudioInputStream(bufferedIn);
            clip.open(audioInputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}