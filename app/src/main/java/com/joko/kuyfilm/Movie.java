package com.joko.kuyfilm;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {
    private int poster, bgPoster;
    private String name, date, desc, sutradara, genre, production, producer, writter, distributor;

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    public int getBgPoster() {
        return bgPoster;
    }

    public void setBgPoster(int bgPoster) {
        this.bgPoster = bgPoster;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getSutradara() {
        return sutradara;
    }

    public void setSutradara(String sutradara) {
        this.sutradara = sutradara;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getWritter() {
        return writter;
    }

    public void setWritter(String writter) {
        this.writter = writter;
    }

    public String getDistributor() {
        return distributor;
    }

    public void setDistributor(String distributor) {
        this.distributor = distributor;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.poster);
        dest.writeInt(this.bgPoster);
        dest.writeString(this.name);
        dest.writeString(this.date);
        dest.writeString(this.desc);
        dest.writeString(this.sutradara);
        dest.writeString(this.genre);
        dest.writeString(this.production);
        dest.writeString(this.producer);
        dest.writeString(this.writter);
        dest.writeString(this.distributor);
    }

    public Movie() {
    }

    protected Movie(Parcel in) {
        this.poster = in.readInt();
        this.bgPoster = in.readInt();
        this.name = in.readString();
        this.date = in.readString();
        this.desc = in.readString();
        this.sutradara = in.readString();
        this.genre = in.readString();
        this.production = in.readString();
        this.producer = in.readString();
        this.writter = in.readString();
        this.distributor = in.readString();
    }

    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}
