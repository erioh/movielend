package com.luxoft.sdemenkov.movieland.dao.api;

import com.luxoft.sdemenkov.movieland.model.User;

public interface UserDao {

    public User getUser(String username, String password);
}
