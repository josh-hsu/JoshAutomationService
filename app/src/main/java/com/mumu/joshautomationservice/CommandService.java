package com.mumu.joshautomationservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.io.IOException;

/**
 * CommandService
 * Implementation of ICommandService
 */

public class CommandService extends Service {
    private static final String TAG = "CommandService";
    private final ICommandStub mStub;

    public CommandService() {
        mStub = new ICommandStub() {
            @Override
            public void runCommand(String cmd) {
                Log.d(TAG, "Run cmd: " + cmd);
                try {
                    Runtime.getRuntime().exec(cmd);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void destroyAll() {
                Log.d(TAG, "Destroy called");
            }
        };
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mStub;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate");
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy");
    }

    @Override
    public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2) {
        Log.d(TAG, "onStartCommand: para1 = " + paramInt1 + ", para2 = " + paramInt2);
        return Service.START_STICKY;
    }
}
