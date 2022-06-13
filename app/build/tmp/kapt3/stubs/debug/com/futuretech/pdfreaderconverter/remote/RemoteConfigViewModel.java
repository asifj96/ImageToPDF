package com.futuretech.pdfreaderconverter.remote;

import android.app.Activity;
import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.gson.Gson;
import com.futuretech.pdfreaderconverter.R;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u0010R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/futuretech/pdfreaderconverter/remote/RemoteConfigViewModel;", "Landroidx/lifecycle/ViewModel;", "remoteData", "Lcom/google/firebase/remoteconfig/FirebaseRemoteConfig;", "(Lcom/google/firebase/remoteconfig/FirebaseRemoteConfig;)V", "remoteConfig", "Landroidx/lifecycle/MutableLiveData;", "Lcom/futuretech/pdfreaderconverter/remote/RemoteAdSettings;", "getRemoteConfig", "()Landroidx/lifecycle/MutableLiveData;", "setRemoteConfig", "(Landroidx/lifecycle/MutableLiveData;)V", "context", "Landroid/content/Context;", "getRemoteConfigInit", "", "Landroid/app/Activity;", "app_debug"})
public final class RemoteConfigViewModel extends androidx.lifecycle.ViewModel {
    private final com.google.firebase.remoteconfig.FirebaseRemoteConfig remoteData = null;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<com.futuretech.pdfreaderconverter.remote.RemoteAdSettings> remoteConfig;
    
    public RemoteConfigViewModel(@org.jetbrains.annotations.NotNull()
    com.google.firebase.remoteconfig.FirebaseRemoteConfig remoteData) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.futuretech.pdfreaderconverter.remote.RemoteAdSettings> getRemoteConfig() {
        return null;
    }
    
    public final void setRemoteConfig(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<com.futuretech.pdfreaderconverter.remote.RemoteAdSettings> p0) {
    }
    
    public final void getRemoteConfigInit(@org.jetbrains.annotations.NotNull()
    android.app.Activity context) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.futuretech.pdfreaderconverter.remote.RemoteAdSettings getRemoteConfig(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
}