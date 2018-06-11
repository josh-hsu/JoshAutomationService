package com.mumu.joshautomationservice;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/**
 * CommandProxy (for client) <Not used here>
 * Implementation of ICommandService
 * This is code for client
 */

public class CommandProxy implements ICommandService {
    private IBinder mBinder;


    public CommandProxy(IBinder binder) {
        mBinder = binder;
    }

    @Override
    public void runCommand(String cmd) {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        try {
            mBinder.transact(CODE_RUN_COMMAND,data,reply,0);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destroyAll() {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        try {
            mBinder.transact(CODE_DESTROY_ALL,data,reply,0);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
