package homework.epam.mod4.task04SerialFileIO;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DAOFilmsAndActors implements Serializable {
    private static final long serialVersionUID = 4296296680076948587L;

    static volatile Map<String, List<String>> filmsActors = new HashMap<>();

    public DAOFilmsAndActors(Map<String, List<String>> filmsActors) {
        this.filmsActors = filmsActors;
    }

    public static synchronized Map<String, List<String>> getFilmsActors() {
        return filmsActors;
    }

    public static synchronized boolean setFilmsActors(Map<String, List<String>> filmsActors) {
        boolean result = false;

        if (filmsActors != null) {
            DAOFilmsAndActors.filmsActors = filmsActors;
            result = true;
        }
        return result;
    }

    public static synchronized boolean setActorsToFilm(String film, List<String> actors) {
        boolean result = false;

        if (film != null && actors != null) {
            result = true;
            filmsActors.get(film).addAll(actors);
        }
        return result;
    }

    public static synchronized boolean appendActorToKeyFilm(String filmName, String actorName) {
        boolean result = false;
        if (filmName != null) {
            if (filmsActors.containsKey(filmName)) {
                filmsActors.get(filmName).add(actorName);
                result = true;
            }
        }
        return result;
    }

    public static synchronized boolean removeActorFromKeyFilm(String filmName, String actorName) {
        boolean result = false;
        if (filmName != null) {
            if (filmsActors.containsKey(filmName)) {
                filmsActors.get(filmName).remove(actorName);
                result = true;
            }
        }
        return result;
    }

    public static synchronized boolean addFilmAndActors(String newFilm, List<String> actorsInNewFilm) {
        boolean result = false;
        if (newFilm != null) {
            if (!filmsActors.containsKey(newFilm)) {
                result = true;
                filmsActors.put(newFilm, actorsInNewFilm);
            }
        }
        return result;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + filmsActors.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        boolean equlity = false;
        if (obj != null) {
            if ((obj instanceof DAOFilmsAndActors) && ((this.hashCode()) == (obj.hashCode()))) {
                equlity = true;
            }
        }
        return equlity;
    }
}
