package com.luxoft.sdemenkov.movieland.web.responce;

import com.luxoft.sdemenkov.movieland.model.Movie;

public class ResponseGetMovieByGenre {
    private int id;
    private String nameRussian;
    private String nameNative;
    private int yearOfRelease;
    private double rating;
    private double price;
    private String picturePath;

    public ResponseGetMovieByGenre() {
    }

    public ResponseGetMovieByGenre(Movie movie) {
        id = movie.getId();
        nameRussian = movie.getNameRussian();
        nameNative = movie.getNameNative();
        yearOfRelease = movie.getYearOfRelease();
        rating = movie.getRating();
        price = movie.getPrice();
        picturePath = movie.getPicturePath();
    }

    public int getId() {
        return id;
    }

    public String getNameRussian() {
        return nameRussian;
    }

    public String getNameNative() {
        return nameNative;
    }


    public int getYearOfRelease() {
        return yearOfRelease;
    }


    public double getRating() {
        return rating;
    }

    public double getPrice() {
        return price;
    }


    public String getPicturePath() {
        return picturePath;
    }


    @Override
    public String toString() {
        return "ResponseGetMovieByGenre{" +
                "id=" + id +
                ", nameRussian='" + nameRussian + '\'' +
                ", nameNative='" + nameNative + '\'' +
                ", yearOfRelease=" + yearOfRelease +
                ", rating=" + rating +
                ", price=" + price +
                ", picturePath='" + picturePath + '\'' +
                '}';
    }
}
