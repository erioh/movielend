package com.luxoft.sdemenkov.movielend.dao.jdbc.impl;

import com.luxoft.sdemenkov.movielend.dao.jdbc.GenreDao;
import com.luxoft.sdemenkov.movielend.model.Genre;
import com.luxoft.sdemenkov.movielend.model.Movie;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring-test-config.xml")
public class GenreDaoImplTest {
    @Autowired
    GenreDao genreDao;

    @Test
    public void getGenreListByMove() throws Exception {

        Movie movie = new Movie();
        movie.setId(1);
        List<Genre> actualGenreList = genreDao.getGenreListByMove(movie);
        assertEquals(2, actualGenreList.size());
        assertEquals(1, actualGenreList.get(0).getId());
        assertEquals(2, actualGenreList.get(1).getId());
        assertEquals("drama", actualGenreList.get(0).getName());
        assertEquals("crime", actualGenreList.get(1).getName());
    }

    @Test
    public void getAllGenres() throws Exception {
        List<Genre> genreList = genreDao.getAllGenres();
        assertEquals(15, genreList.size());
    }

    @Test
    public void enrichMoviesByGenres() throws Exception {
        Movie movie = getMovieForTest();
        List<Movie> movies = new ArrayList<>();
        movies.add(movie);
        movies = genreDao.enrichMoviesByGenres(movies);
        assertEquals(2, movies.get(0).getGenreList().size());
    }

    private Movie getMovieForTest() throws Exception {
        Movie expectedMovie = new Movie();
        expectedMovie.setId(15);
        expectedMovie.setNameRussian("Gladiator");
        expectedMovie.setNameNative("Gladiator");
        expectedMovie.setYearOfRelease(2000);
        expectedMovie.setRating(8.6);
        expectedMovie.setPrice(175.0);
        expectedMovie.setPicturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BMDliMmNhNDEtODUyOS00MjNlLTgxODEtN2U3NzIxMGVkZTA1L2ltYWdlXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1._SY209_CR0,0,140,209_.jpg");
        return expectedMovie;
    }

}