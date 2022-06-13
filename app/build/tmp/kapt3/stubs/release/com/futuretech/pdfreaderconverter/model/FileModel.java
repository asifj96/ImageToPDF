package com.futuretech.pdfreaderconverter.model;

import android.os.Parcelable;
import androidx.annotation.Keep;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import kotlinx.android.parcel.Parcelize;

@androidx.room.Entity(tableName = "FileModel")
@kotlinx.android.parcel.Parcelize()
@androidx.annotation.Keep()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0002\u0010\rJ\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0006H\u00c6\u0003J\u001d\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\nH\u00c6\u0003J\t\u0010 \u001a\u00020\fH\u00c6\u0003JO\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u001c\b\u0002\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u00c6\u0001J\t\u0010\"\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010#\u001a\u00020\f2\b\u0010$\u001a\u0004\u0018\u00010%H\u00d6\u0003J\t\u0010&\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\'\u001a\u00020\u0003H\u00d6\u0001J\u0019\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0006H\u00d6\u0001R\u001e\u0010\u000e\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R*\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\n8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0015R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0018\"\u0004\b\u001a\u0010\u001b\u00a8\u0006-"}, d2 = {"Lcom/futuretech/pdfreaderconverter/model/FileModel;", "Landroid/os/Parcelable;", "title", "", "timestamp", "noOfImages", "", "imageQueueArrayList", "Ljava/util/ArrayList;", "Lcom/futuretech/pdfreaderconverter/model/ImageQueue;", "Lkotlin/collections/ArrayList;", "isPdf", "", "(Ljava/lang/String;Ljava/lang/String;ILjava/util/ArrayList;Z)V", "id", "getId", "()I", "setId", "(I)V", "getImageQueueArrayList", "()Ljava/util/ArrayList;", "()Z", "getNoOfImages", "getTimestamp", "()Ljava/lang/String;", "getTitle", "setTitle", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"})
public final class FileModel implements android.os.Parcelable {
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "title")
    private java.lang.String title;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "timestamp")
    private final java.lang.String timestamp = null;
    @androidx.room.ColumnInfo(name = "noOfImages")
    private final int noOfImages = 0;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "queueImage")
    private final java.util.ArrayList<com.futuretech.pdfreaderconverter.model.ImageQueue> imageQueueArrayList = null;
    @androidx.room.ColumnInfo(name = "isPdf")
    private final boolean isPdf = false;
    @androidx.room.PrimaryKey(autoGenerate = true)
    private int id = 0;
    public static final android.os.Parcelable.Creator<com.futuretech.pdfreaderconverter.model.FileModel> CREATOR = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.futuretech.pdfreaderconverter.model.FileModel copy(@org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String timestamp, int noOfImages, @org.jetbrains.annotations.Nullable()
    java.util.ArrayList<com.futuretech.pdfreaderconverter.model.ImageQueue> imageQueueArrayList, boolean isPdf) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public FileModel(@org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String timestamp, int noOfImages, @org.jetbrains.annotations.Nullable()
    java.util.ArrayList<com.futuretech.pdfreaderconverter.model.ImageQueue> imageQueueArrayList, boolean isPdf) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTitle() {
        return null;
    }
    
    public final void setTitle(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTimestamp() {
        return null;
    }
    
    public final int component3() {
        return 0;
    }
    
    public final int getNoOfImages() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.ArrayList<com.futuretech.pdfreaderconverter.model.ImageQueue> component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.ArrayList<com.futuretech.pdfreaderconverter.model.ImageQueue> getImageQueueArrayList() {
        return null;
    }
    
    public final boolean component5() {
        return false;
    }
    
    public final boolean isPdf() {
        return false;
    }
    
    public final int getId() {
        return 0;
    }
    
    public final void setId(int p0) {
    }
    
    @java.lang.Override()
    public int describeContents() {
        return 0;
    }
    
    @java.lang.Override()
    public void writeToParcel(@org.jetbrains.annotations.NotNull()
    android.os.Parcel parcel, int flags) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 3)
    public static final class Creator implements android.os.Parcelable.Creator<com.futuretech.pdfreaderconverter.model.FileModel> {
        
        public Creator() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.futuretech.pdfreaderconverter.model.FileModel createFromParcel(@org.jetbrains.annotations.NotNull()
        android.os.Parcel in) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.futuretech.pdfreaderconverter.model.FileModel[] newArray(int size) {
            return null;
        }
    }
}