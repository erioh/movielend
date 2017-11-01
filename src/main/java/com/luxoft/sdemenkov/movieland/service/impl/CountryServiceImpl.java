package com.luxoft.sdemenkov.movieland.service.impl;

import com.luxoft.sdemenkov.movieland.dao.api.CountryDao;
import com.luxoft.sdemenkov.movieland.model.Movie;
import com.luxoft.sdemenkov.movieland.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dp-ptcstd-43 on 10/31/2017.
 */

@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryDao countryDao;

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public List<Movie> ecrichMoviesByCountries(List<Movie> movieList) {
        List<Movie> enrichedMovieList = countryDao.enrichMoviesByCountries(movieList);
        log.debug("ecrichMoviesByCountries is executed");
        return enrichedMovieList;
    }
}