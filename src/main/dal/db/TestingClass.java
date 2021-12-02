package dal.db;

import be.Playlist;
import be.Song;
import dal.db.dao.DbDAOPlaylist;
import dal.db.dao.DbDAOSong;

import java.sql.SQLException;
import java.util.List;

public class TestingClass {
    public static void main(String[] args) throws SQLException {
        for (Playlist s : getAllPlaylist()){
            System.out.println(s);
        }
    }


    public static List<Playlist> getAllPlaylist(){
        DbDAOPlaylist db = new DbDAOPlaylist();
        return db.getAllPlaylist();
    }

}
