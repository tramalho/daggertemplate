package com.example.tramalho.templates;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by tramalho on 04/08/17.
 */

public class Model implements Parcelable {

    String title, subtitle, column1, value1, labelValueL1, labelValueV1, labelValueL2,
            labelValueV2, labelValueL3, labelValueV3, message;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.subtitle);
        dest.writeString(this.column1);
        dest.writeString(this.value1);
        dest.writeString(this.labelValueL1);
        dest.writeString(this.labelValueV1);
        dest.writeString(this.labelValueL2);
        dest.writeString(this.labelValueV2);
        dest.writeString(this.message);
    }

    public Model() {
    }

    protected Model(Parcel in) {
        this.title = in.readString();
        this.subtitle = in.readString();
        this.column1 = in.readString();
        this.value1 = in.readString();
        this.labelValueL1 = in.readString();
        this.labelValueV1 = in.readString();
        this.labelValueL2 = in.readString();
        this.labelValueV2 = in.readString();
        this.message = in.readString();
    }

    public static final Parcelable.Creator<Model> CREATOR = new Parcelable.Creator<Model>() {
        @Override
        public Model createFromParcel(Parcel source) {
            return new Model(source);
        }

        @Override
        public Model[] newArray(int size) {
            return new Model[size];
        }
    };
}
