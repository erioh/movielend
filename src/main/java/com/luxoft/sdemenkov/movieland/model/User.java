package com.luxoft.sdemenkov.movieland.model;

/**
 * Created by sergeydemenkov on 04.11.17.
 */
public class User {
    private int id;
    private String nickname;

    public User() {
    }

    public User(int id, String nickname) {
        this.id = id;
        this.nickname = nickname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}