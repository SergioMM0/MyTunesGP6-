package dal.db;

import be.Playlist;
import be.Song;
import dal.db.dao.DbDAOPlaylist;
import dal.db.dao.DbDAOSong;

import java.sql.SQLException;
import java.util.List;

public class TestingClass {
    public static void main(String[] args) throws SQLException {
        System.out.println(getAndAddSongsFromPlaylist());
    }

    public static List<Playlist> getAllPlaylist(){
        DbDAOPlaylist db = new DbDAOPlaylist();
        return db.getAllPlaylist();
    }

    public static Playlist addPLaylist(){
        DbDAOPlaylist db = new DbDAOPlaylist();
        return db.addPlaylist(4,"My Music");
    }

    public static void deletePlaylist(){
        DbDAOPlaylist db = new DbDAOPlaylist();
        Playlist p = new Playlist(4,"My Music","0",0,0);
        db.deletePlaylist(p);
    }

    public static void renamePlaylist(){
        DbDAOPlaylist db = new DbDAOPlaylist();
        Playlist p = new Playlist(3,"Study Music","0",0,0);
        db.renamePlaylist(p);
    }

    public static Playlist getPlaylist(){
        DbDAOPlaylist db = new DbDAOPlaylist();
        return db.getPlaylist(2);
    }

    public static Playlist getAndAddSongsFromPlaylist(){
        DbDAOPlaylist db = new DbDAOPlaylist();
        Song s = new Song(1,"ee","eee","eee",31,"eee.data");
        Playlist p = new Playlist(3,"Study Music","0",0,0);
        return db.addSongToPlaylist(p,s);
    }
}
