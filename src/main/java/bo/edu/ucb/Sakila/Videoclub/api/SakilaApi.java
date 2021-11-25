package bo.edu.ucb.Sakila.Videoclub.api;

import bo.edu.ucb.Sakila.Videoclub.bl.MostFilmBl;
import bo.edu.ucb.Sakila.Videoclub.bl.FilmSearchBl;
import bo.edu.ucb.Sakila.Videoclub.bl.ActorSearchBl;
import bo.edu.ucb.Sakila.Videoclub.dto.Film;
import bo.edu.ucb.Sakila.Videoclub.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Bajo la perspectiva de High Cohesion. El API rest debería validar que lo que el cliente envía, entenediendo por
 * cliente a las aplicaciones Web y Móvil, son datos correctos..
 *
 * Por ejemplo para la busqueda por titulo el API rest no debería pasarle un titulo nulo.
 */
@RestController()
public class SakilaApi {

    FilmSearchBl filmSearchBl;
    ActorSearchBl actorSearchBl;
    MostFilmBl mostFilmBl;

    @Autowired
    public SakilaApi(FilmSearchBl filmSearchBl, ActorSearchBl actorSearchBl, MostFilmBl mostFilmBl) {

        this.filmSearchBl = filmSearchBl;
        this.actorSearchBl= actorSearchBl;
        this.mostFilmBl= mostFilmBl;
    }

    @GetMapping(value = "/film/{title}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Film> findBytTitle(@PathVariable(name = "title") String title) {
        System.out.println("Invocando al metodo GET!!!!!!!!!!!");
        return filmSearchBl.findByTitle(title);
    }
    @GetMapping(value = "/actor/{name}/{surname}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Film> findByActor(@PathVariable(name = "name") String name,@PathVariable(name="surname") String surname){
        return actorSearchBl.findByName(name,surname);
    }

    @GetMapping(value = "/main/{country}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Film> findTheMost(@PathVariable(name = "country") int country) {
        System.out.println("Invocando al metodo GET!!!!!!!!!!!");
        return mostFilmBl.findTheMost(country);
    }

    @GetMapping(value = "/main1/{country}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Film> findPremier(@PathVariable(name = "country") int country) {
        System.out.println("Invocando al metodo GET!!!!!!!!!!!");
        return mostFilmBl.findPremier(country);
    }

    @PostMapping(value = "/customer",consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public String Prueba1(@RequestBody Customer customer){
        return customer.getFirstName();
    }

}