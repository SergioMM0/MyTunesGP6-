package dal.db;

import be.Song;
import dal.db.dao.DbDAOSong;

import java.sql.SQLException;
import java.util.List;

public class TestingClass {
    public static void main(String[] args) throws SQLException {
        //updateSong();
        //getSong();
        List<Song> allSongs = getAllSongs();
        for (Song song : allSongs){
            System.out.println(song);
        }

    }

    public static List<Song> getAllSongs(){
        DbDAOSong dbDAOSong = new DbDAOSong();
        return dbDAOSong.getAllSongs();
    }

    public static void getSong() throws SQLException {
        DbDAOSong dbDAOSong = new DbDAOSong();
        Song testSong = dbDAOSong.getSong(2);
        System.out.println("testSong: "+testSong.getName());
    }
    public static void updateSong() throws SQLException {
        DbDAOSong daosong = new DbDAOSong();

        //System.out.println(daosong.addSong(1,"Nombre","Melendi", "rock", 345,"/data.miscojones"));
        //System.out.println(daosong.addSong(2,"Nombre2","Melendi2", "rock2", 346,"/data.miscojones2"));
        //System.out.println(daosong.addSong(3,"Nombre3","Melendi3", "rock3", 347,"/data.miscojones3"));
        System.out.println(daosong.addSong(4,"Nombre4","Melendi4", "rock4", 348,"/data.miscojones4"));
        Song song = new Song(3,"Este tio","Paquillo", "Guitarras", 200,"/data.miscojones33");
        daosong.deleteSong(song);
        daosong.updateSong(song);
    }
}
