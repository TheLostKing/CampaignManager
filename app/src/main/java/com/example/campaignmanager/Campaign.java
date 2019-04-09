package com.example.campaignmanager;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Campaign implements Parcelable {
    private String CampaignName;
    ArrayList<DataItem> items = new ArrayList<>();

    public Campaign(String name){
        setCampaignName(name);
    }

    private Campaign(Parcel in){
        setCampaignName(in.readString());
        in.readTypedList(items, DataItem.CREATOR);
    }

    public String getCampaignName() {
        return CampaignName;
    }

    public void setCampaignName(String campaignName) {
        CampaignName = campaignName;
    }

    public void addDataItem(String name, String description){
        DataItem d = new DataItem(name, description);
        items.add(d);
    }

    public ArrayList<DataItem> getDataList(){
        return items;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(CampaignName);
        dest.writeTypedList(items);
    }

    public static final Parcelable.Creator<Campaign> CREATOR  = new Parcelable.Creator<Campaign>() {
        public Campaign createFromParcel(Parcel in) {
            return new Campaign(in);
        }

        public Campaign[] newArray(int size) {
            return new Campaign[size];
        }
    };
}
