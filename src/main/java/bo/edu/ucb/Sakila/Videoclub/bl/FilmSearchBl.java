package bo.edu.ucb.Sakila.Videoclub.bl;
import bo.edu.ucb.Sakila.Videoclub.exception.SakilaException;
import bo.edu.ucb.Sakila.Videoclub.dto.Film;
import bo.edu.ucb.Sakila.Videoclub.dao.FilmDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FilmSearchBl {

    private final FilmDao filmDao;

    @Autowired
    public FilmSearchBl(FilmDao filmDao) {
        this.filmDao = filmDao;
    }

    public List<Film> findByTitle(String title) {
        if (title == null || title.trim().equals("")) {
            throw new SakilaException(403, "Bad request: The title parameter is mandatory and can't be null or empty");
        }
        return filmDao.findByTitle(title);
    }
}

