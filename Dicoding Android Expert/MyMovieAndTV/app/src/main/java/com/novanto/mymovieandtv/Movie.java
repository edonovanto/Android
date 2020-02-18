package com.novanto.mymovieandtv;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {

    private String name, desc, genre, runtime, revenue, rating, trailer;
    private int photo;

    Movie(){
        //default constractor :)
    }

    protected Movie(Parcel in) {
        name = in.readString();
        desc = in.readString();
        genre = in.readString();
        runtime = in.readString();
        revenue = in.readString();
        rating = in.readString();
        trailer = in.readString();
        photo = in.readInt();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getRevenue() {
        return revenue;
    }

    public void setRevenue(String revenue) {
        this.revenue = revenue;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(desc);
        parcel.writeString(genre);
        parcel.writeString(runtime);
        parcel.writeString(revenue);
        parcel.writeString(rating);
        parcel.writeString(trailer);
        parcel.writeInt(photo);
    }
}
