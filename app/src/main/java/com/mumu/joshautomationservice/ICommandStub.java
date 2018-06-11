package com.mumu.joshautomationservice;

import android.os.Binder;
import android.os.Parcel;
import android.os.RemoteException;

/**
 * ICommandStub (for Server)
 */

public abstract class ICommandStub extends Binder implements ICommandService {

    protected boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        switch (code) {
            case CODE_RUN_COMMAND:
                runCommand(data.readString());
                break;
            case CODE_DESTROY_ALL:
                destroyAll();
                break;
            default:
                super.onTransact(code, data, reply, flags);
        }

        return true;
    }


    public abstract void runCommand(String cmd);
    public abstract void destroyAll();
}
