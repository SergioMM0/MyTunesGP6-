package dal.db;

import be.Playlist;
import be.Song;
import dal.db.dao.DbDAOPlaylist;
import dal.db.dao.DbDAOSong;

import java.sql.SQLException;
import java.util.List;

public class TestingClass {
    public static void main(String[] args) throws SQLException {
        System.out.println(updatePlaylist());
    }

    public static Playlist updatePlaylist(){
        DbDAOPlaylist db = new DbDAOPlaylist();
        Playlist p = new Playlist(12,"WorkingUpdate","numbers,numbers and more numbers",123456,7890);
        return db.updatePlaylist(p);
    }

    public static Playlist addSongToPlaylist(){
        DbDAOPlaylist db = new DbDAOPlaylist();
        Playlist p = new Playlist(12,"test","Miscojones",2332,899876);
        Song s = new Song(900909,"AddedSong","eee","eee",122,"data.data.lel");
        return db.addSongToPlaylist(p,s);
    }

    public static Playlist getIdOfSongsInPLaylist (){
        DbDAOPlaylist db = new DbDAOPlaylist();
        Playlist p = new Playlist(12,"test", "1,2,3,54,18899",2332,899876);
        return db.getSongsFromPlaylist(p);
    }

    public static Song getSong() throws SQLException {
        DbDAOSong db = new DbDAOSong();
        return db.getSong(20);

    }

    public static Song updateSong() throws SQLException {
        DbDAOSong db = new DbDAOSong();
        Song s = new Song(22,"itWorks","Worked","Dubstep",555, "data/notanormaldata.mp3");
        db.updateSong(s);
        return s;
    }

    public static void deleteSong(){
        DbDAOSong db = new DbDAOSong();
        Song s = new Song(24,"Hopefully","Maroon 5","Electronic",340, "data/data.mp3");
        db.deleteSong(s);
    }

    public static List<Song> getAllSong(){
        DbDAOSong db = new DbDAOSong();
        return db.getAllSongs();
    }

    public static Song addSong() throws SQLException {
        DbDAOSong db = new DbDAOSong();
        Song s = new Song(1,"Hopefully","Maroon 5","Electronic",340, "data/data.mp3");
        return db.addSong(s);
    }

    public static List<Playlist> getAllPlaylist(){
        DbDAOPlaylist db = new DbDAOPlaylist();
        return db.getAllPlaylist();
    }

    public static Playlist addPLaylist(){
        DbDAOPlaylist db = new DbDAOPlaylist();
        return db.addPlaylist("My Music");
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
        return db.getPlaylist(12);
    }

    public static Playlist getgetSongsFromPlaylist() throws SQLException {
        DbDAOPlaylist db = new DbDAOPlaylist();
        Playlist p = new Playlist(22,"Study Music","0",0,0);
        return db.getSongsFromPlaylist(p);
    }

    public static Playlist getAndAddSongsFromPlaylist(){
        DbDAOPlaylist db = new DbDAOPlaylist();
        Song s = new Song(123,"ee","eee","eee",31,"eee.data");
        Playlist p = new Playlist(3,"Study Music","0",0,0);
        return db.addSongToPlaylist(p,s);
    }
}
