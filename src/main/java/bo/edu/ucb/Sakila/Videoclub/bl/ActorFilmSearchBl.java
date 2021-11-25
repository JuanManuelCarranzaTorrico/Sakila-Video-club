package bo.edu.ucb.Sakila.Videoclub.bl;
import java.util.ArrayList;
import java.util.List;
import bo.edu.ucb.Sakila.Videoclub.dto.Film;
import bo.edu.ucb.Sakila.Videoclub.dao.ActorDao;
import bo.edu.ucb.Sakila.Videoclub.dao.FilmDao;
import bo.edu.ucb.Sakila.Videoclub.bl.ActorSearchBl;
import bo.edu.ucb.Sakila.Videoclub.bl.FilmSearchBl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class ActorFilmSearchBl {


    private static ActorSearchBl actorSearchBl;
    private static FilmSearchBl filmSearchBl;
    @Autowired
    public ActorFilmSearchBl(ActorSearchBl actorSearchBl,FilmSearchBl filmSearchBl) {
        this.actorSearchBl=actorSearchBl;
        this.filmSearchBl=filmSearchBl;
    }
    public static List<Film> actorFilm(String title,String name, String surname) {
        List<Film> result = new ArrayList<>();
        List<String> ac = new ArrayList<>();
        List<String> fi = new ArrayList<>();
        //saco los resultados
        List<Film> filmList =  actorSearchBl.findByName(name,surname);
        List<Film> filmList1 =  filmSearchBl.findByTitle(title);
        //codigo paja
        if (!filmList.isEmpty()) {
            for (Film film : filmList) {
                ac.add(film.toString());
            }
        }
        if (!filmList1.isEmpty()) {
            for (Film film : filmList1) {
                fi.add(film.toString());
            }
        }
        //comparar titulos
        for(Film actor: filmList){
            boolean igual=false;
            for(Film peli: filmList1){
                if(actor.getTitle().equals(peli.getTitle())){
                    igual=true;
                }
            }
            if(igual){
                result.add(actor);
            }

        }
        return result;
    }

}
