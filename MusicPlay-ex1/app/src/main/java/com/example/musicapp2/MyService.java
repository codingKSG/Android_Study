package com.example.musicapp2;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;

public class MyService extends Service {

    private static final String TAG = "MyService2";
    private MediaPlayer mp;
    private final IBinder mBinder = new LocalBinder();

    class LocalBinder extends Binder {
        MediaPlayer getMp() {
            return mp;
        }
    }

    public MyService() {

    }

    @Override
    public void onCreate() {
        super.onCreate();
        mp = MediaPlayer.create(this, R.raw.sample2);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return mBinder;
    }
}