package dal.db;

import be.Song;
import dal.db.dao.DbDAOSong;

import java.sql.SQLException;

public class TestingClass {
    public static void main(String[] args) throws SQLException {
        DbDAOSong daosong = new DbDAOSong();

        //System.out.println(daosong.addSong(1,"Nombre","Melendi", "rock", 345,"/data.miscojones"));
        //System.out.println(daosong.addSong(2,"Nombre2","Melendi2", "rock2", 346,"/data.miscojones2"));
        //System.out.println(daosong.addSong(3,"Nombre3","Melendi3", "rock3", 347,"/data.miscojones3"));
        //System.out.println(daosong.addSong(4,"Nombre4","Melendi4", "rock4", 348,"/data.miscojones4"));
        Song song = new Song(3,"Este tio","Paquillo", "Guitarras", 200,"/data.miscojones33");
        //daosong.deleteSong(song);
        daosong.updateSong(song);
    }
}
