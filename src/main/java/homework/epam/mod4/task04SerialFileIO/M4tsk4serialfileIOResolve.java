package homework.epam.mod4.task04SerialFileIO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class M4tsk4serialfileIOResolve {
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
                ObjectInputStream objectiInputStream = new ObjectInputStream(fileInputStream)) {
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

    public synchronized boolean addNewFilmAndActors(String newFilm, List<String> actors) {
        boolean result = false;
        daoFilmsAndActors.addFilmAndActors(newFilm, actors);
        return result;
    }

    public synchronized boolean saveDaoOnExit() {
        boolean result = false;
        try (FileOutputStream fileOutputStream = new FileOutputStream(file);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(daoFilmsAndActors);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }


    public static void main(String[] args) {
        M4tsk4serialfileIOResolve m4tsk4serialfileIOResolve = new M4tsk4serialfileIOResolve();
        String FigthClubFilm = "Figth Club";
        List<String> fc = new ArrayList<String>();
        fc.add("Brad Pitt");
        fc.add("Edwart Northon");


        m4tsk4serialfileIOResolve.addNewFilmAndActors(FigthClubFilm, fc);
        m4tsk4serialfileIOResolve.attachActorIntoFilmToDao(FigthClubFilm, "Mitt Loaf");
        m4tsk4serialfileIOResolve.attachActorIntoFilmToDao(FigthClubFilm, "Bezrukov");
        m4tsk4serialfileIOResolve.deleteActorFromFilm(FigthClubFilm, "Bezrukov");
        m4tsk4serialfileIOResolve.saveDaoOnExit();
    }
}
