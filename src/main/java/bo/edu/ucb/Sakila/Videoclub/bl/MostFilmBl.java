package bo.edu.ucb.Sakila.Videoclub.bl;
import bo.edu.ucb.Sakila.Videoclub.dao.MostFilmDao;
import bo.edu.ucb.Sakila.Videoclub.dto.Film;
import bo.edu.ucb.Sakila.Videoclub.exception.SakilaException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MostFilmBl {

    private final MostFilmDao mostFilmDao;

    @Autowired
    public MostFilmBl(MostFilmDao mostFilmDao) {
        this.mostFilmDao = mostFilmDao;
    }
    public List<Film> findTheMost(int country) {
        if (country<=0) {
            throw new SakilaException(403, "Bad request: The country can't be 0 or null");
        }
        return mostFilmDao.findTheMost(country);
    }
    public List<Film> findPremier(int country) {
        if (country<=0) {
            throw new SakilaException(403, "Bad request: The country can't be 0 or null");
        }
        return mostFilmDao.findPremier(country);
    }
    public List<Film> findMostWeek(int country) {
        if (country<=0) {
            throw new SakilaException(403, "Bad request: The country can't be 0 or null");
        }
        return mostFilmDao.findMostWeek(country);
    }
}
