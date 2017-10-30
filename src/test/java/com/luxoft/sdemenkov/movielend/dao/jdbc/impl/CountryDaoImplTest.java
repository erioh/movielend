package com.luxoft.sdemenkov.movielend.dao.jdbc.impl;

import com.luxoft.sdemenkov.movielend.model.Country;
import com.luxoft.sdemenkov.movielend.model.Movie;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

public class CountryDaoImplTest {
    private ApplicationContext context;


    @Before
    public void setUp() throws Exception {
        context = new FileSystemXmlApplicationContext("./src/test/resources/spring-test-config.xml");
    }

    @Test
    public void getCountryListByMovie() throws Exception {
        CountryDaoImpl countryDaoImpl = (CountryDaoImpl) context.getBean("countryDaoImpl");
        Movie movie = new Movie();
        movie.setId(6);
        List<Country> actualCountryList = countryDaoImpl.getCountryListByMovie(movie);
        assertEquals(2, actualCountryList.size());
        assertEquals(1, actualCountryList.get(0).getId());
        assertEquals(3, actualCountryList.get(1).getId());
        assertEquals("USA", actualCountryList.get(0).getName());
        assertEquals("Great Britain", actualCountryList.get(1).getName());

    }

}