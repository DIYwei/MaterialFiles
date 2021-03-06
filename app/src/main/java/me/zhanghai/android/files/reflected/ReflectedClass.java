/*
 * Copyright (c) 2018 Hai Zhang <dreaming.in.code.zh@gmail.com>
 * All Rights Reserved.
 */

package me.zhanghai.android.files.reflected;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ReflectedClass {

    @NonNull
    private final String mClassName;

    @Nullable
    private Class<?> mClass;
    @NonNull
    private final Object mClassLock = new Object();

    public ReflectedClass(@NonNull String className) {
        mClassName = className;
    }

    @NonNull
    public Class get() throws ReflectedException {
        synchronized (mClassLock) {
            if (mClass == null) {
                mClass = ReflectedAccessor.getClass(mClassName);
            }
            return mClass;
        }
    }
}
