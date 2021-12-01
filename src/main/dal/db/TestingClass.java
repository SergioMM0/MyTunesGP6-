package dal.db;

import be.Song;
import dal.db.dao.DbDAOSong;

import java.sql.SQLException;

public class TestingClass {
    public static void main(String[] args) throws SQLException {
        DbDAOSong daosong = new DbDAOSong();

        System.out.println(daosong.addSong(1,"Nombre","Melendi", "rock", 345,"/data.miscojones"));

    }
}
