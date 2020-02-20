package com.novanto.mymovieandtv;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {

    private String name, desc, genre, runtime, revenue, rating, trailer;
    private int photo;

    Movie(){
        //default constractor :)
    }

    private Movie(Parcel in) {
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

    String getDesc() {
        return desc;
    }

    void setDesc(String desc) {
        this.desc = desc;
    }

    String getGenre() {
        return genre;
    }

    void setGenre(String genre) {
        this.genre = genre;
    }

    String getRuntime() {
        return runtime;
    }

    void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    String getRevenue() {
        return revenue;
    }

    void setRevenue(String revenue) {
        this.revenue = revenue;
    }

    String getRating() {
        return rating;
    }

    void setRating(String rating) {
        this.rating = rating;
    }

    String getTrailer() {
        return trailer;
    }

    void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    int getPhoto() {
        return photo;
    }

    void setPhoto(int photo) {
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
