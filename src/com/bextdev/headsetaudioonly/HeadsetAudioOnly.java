package com.bextdev.headsetaudioonly;

import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.common.PropertyTypeConstants;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.runtime.errors.YailRuntimeError;
import android.media.AudioManager;
import android.media.MediaPlayer;

public class HeadsetAudioOnly extends AndroidNonvisibleComponent {

  private AudioManager audioManager;
  private MediaPlayer player;
  private String source;

  public HeadsetAudioOnly(ComponentContainer container) {
    super(container.$form());
    audioManager = (AudioManager) container.$context().getSystemService(android.content.Context.AUDIO_SERVICE);
    player = new MediaPlayer();
  }

  @SimpleFunction
  public void Play(){
    if(audioManager.isWiredHeadsetOn()){
      audioManager.setMode(AudioManager.MODE_NORMAL);
      audioManager.setSpeakerphoneOn(false);
      try {
        player.setDataSource(source);
        player.prepare();
        player.start();
      } catch (Exception e) {
        throw new YailRuntimeError("Error playing audio: " + e.getMessage(), "HeadsetAudioOnly");
      }
    } else {
      throw new YailRuntimeError("Only played using Headsets", "HeadsetAudioOnly");
    }
  }
  
  @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_ASSET, defaultValue = "")
  @SimpleProperty
  public void Source(String audioPath){
    source = audioPath;
  }

  @SimpleFunction
  public void Stop(){
    if (player.isPlaying()) {
      player.stop();
    }
  }

  @SimpleFunction
  public void Pause(){
    if (player.isPlaying()) {
      player.pause();
    }
  }
}