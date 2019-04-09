package com.example.campaignmanager;

import android.os.Parcel;
import android.os.Parcelable;

public class DataItem implements Parcelable {
    private String name;
    private String description;

    public DataItem(String name, String description){
        setName(name);
        setDescription(description);
    }

    private DataItem(Parcel in) {
        setName(in.readString());
        setDescription(in.readString());
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        name = name;
    }

    public void setDescription(String description) {
        description = description;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeString(name);
        out.writeString(description);
    }

    public static final Parcelable.Creator<DataItem> CREATOR  = new Parcelable.Creator<DataItem>() {
        public DataItem createFromParcel(Parcel in) {
            return new DataItem(in);
        }

        public DataItem[] newArray(int size) {
            return new DataItem[size];
        }
    };
}
