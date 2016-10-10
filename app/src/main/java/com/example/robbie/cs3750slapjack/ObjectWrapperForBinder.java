package com.example.robbie.cs3750slapjack;

import android.os.Binder;

/**
 * Created by sethalumps on 10/10/2016.
 */

public class ObjectWrapperForBinder extends Binder {

    private final Object mData;

    public ObjectWrapperForBinder(Object data) {
        mData = data;
    }

    public Object getData() {
        return mData;
    }
}
