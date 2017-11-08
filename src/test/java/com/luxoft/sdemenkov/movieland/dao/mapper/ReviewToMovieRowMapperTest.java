package com.luxoft.sdemenkov.movieland.dao.mapper;

import com.luxoft.sdemenkov.movieland.model.Review;
import javafx.util.Pair;
import org.junit.Test;

import java.sql.ResultSet;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by sergeydemenkov on 04.11.17.
 */
public class ReviewToMovieRowMapperTest {
    @Test
    public void mapRow() throws Exception {
        ResultSet resultSet = mock(ResultSet.class);
        when(resultSet.getInt("movie_id")).thenReturn(1);
        when(resultSet.getInt("user_id")).thenReturn(2);
        when(resultSet.getInt("review_id")).thenReturn(3);
        when(resultSet.getString("text")).thenReturn("Text");
        when(resultSet.getString("user_name")).thenReturn("User Name");

        ReviewToMovieRowMapper reviewToMovieRowMapper = new ReviewToMovieRowMapper();
        Pair<Integer, Review> expected = reviewToMovieRowMapper.mapRow(resultSet,0);
        assertEquals(1, expected.getKey(),0);
        assertEquals(3, expected.getValue().getId());
        assertEquals("Text", expected.getValue().getText());
        assertEquals(2, expected.getValue().getUser().getId());
        assertEquals("User Name", expected.getValue().getUser().getNickname());

    }

}