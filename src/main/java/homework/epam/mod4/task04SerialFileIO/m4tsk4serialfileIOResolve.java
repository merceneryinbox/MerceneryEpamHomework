package homework.epam.mod4.task04SerialFileIO;

import java.io.*;
import java.util.List;

public class m4tsk4serialfileIOResolve {
    static String fileName = "./src/main/java/homework/epam/mod4/task04SerialFileIO/serializedDAO.serial";
    static File file;
    static DAOFilmsAndActors daoFilmsAndActors;

    static {
        try {
            file = new File(fileName);
        } catch (Exception fnfe) {
            fnfe.printStackTrace();
        }
    }

    {
        try (
                FileInputStream fileInputStream = new FileInputStream(file);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                ObjectInputStream objectiInputStream = new ObjectInputStream(fileInputStream);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            daoFilmsAndActors = (DAOFilmsAndActors) objectiInputStream.readObject();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public synchronized boolean attachActorIntoFilmToDao(String film, String actor) {
        boolean result = false;
        if (film != null && actor != null) {
            daoFilmsAndActors.appendActorToKeyFilm(film, actor);
            result = true;
        }
        return result;
    }

    public synchronized boolean attachActorsListIntoFilmToDao(String film, List<String> actors) {
        boolean result = false;
        if (film != null && actors != null) {
            daoFilmsAndActors.setActorsToFilm(film, actors);
            result = true;
        }
        return result;
    }

    public synchronized boolean deleteActorFromFilm(String film, String actor) {
        boolean result = false;
        if (film != null && actor != null) {
            result = true;
            daoFilmsAndActors.removeActorFromKeyFilm(film, actor);
        }
        return result;
    }


    public static void main(String[] args) {

    }
}
