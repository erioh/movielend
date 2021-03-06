package com.luxoft.sdemenkov.movieland.dao.cache;

import com.luxoft.sdemenkov.movieland.dao.api.GenreDao;
import com.luxoft.sdemenkov.movieland.model.business.Genre;
import com.luxoft.sdemenkov.movieland.model.business.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
@Primary
@ManagedResource(objectName = "MovieLandCache:name=GenreCacheInvalidator")
public class CachedGenreDao implements GenreDao {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private GenreDao genreDao;

    private volatile List<Genre> cachedGenreList = new ArrayList<>();

    @PostConstruct
    @ManagedOperation
    @Scheduled(fixedRateString = "${cron.cache.genre.schedule}", initialDelayString = "${cron.cache.genre.schedule}")
    public void invalidate() {
        cachedGenreList = genreDao.getAll();
        logger.debug("Cache for Genre is updated");
        logger.trace("Cache for Genre is updated. Cache value is {}", cachedGenreList);
    }

    @Override
    public List<Genre> getGenreListByMovie(Movie movie) {
        return genreDao.getGenreListByMovie(movie);
    }

    @Override
    public List<Genre> getAll() {
        return Collections.unmodifiableList(cachedGenreList);

    }

    @Override
    public void enrichMoviesWithGenres(List<Movie> movieList) {
        genreDao.enrichMoviesWithGenres(movieList);
    }

    @Override
    public int[] mapMoviesGenre(Movie movie) {
        return genreDao.mapMoviesGenre(movie);
    }

    @Override
    public int removeMappedGenres(Movie movie) {
        return genreDao.removeMappedGenres(movie);
    }
}
