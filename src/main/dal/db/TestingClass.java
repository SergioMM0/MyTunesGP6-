package dal.db;

import be.Playlist;
import be.Song;
import dal.db.dao.DbDAOPlaylist;
import dal.db.dao.DbDAOSong;
import dal.db.dao.DbDAOSongsInPlaylistManager;

import java.sql.SQLException;
import java.util.List;

public class TestingClass {
    public static void main(String[] args) throws SQLException {
        for(Song s : getSongsInPlaylist()){
            System.out.println(s);
        }
    }

    public static List<Song> getSongsInPlaylist(){
        DbDAOSongsInPlaylistManager db = new DbDAOSongsInPlaylistManager();
        Playlist p = new Playlist(1,"WorkingUpdate",123456,"7890");
        return db.getSongsFromPlaylist(p);
    }

    public static void addSongToPlaylist(){
        DbDAOSongsInPlaylistManager db = new DbDAOSongsInPlaylistManager();
        Playlist p = new Playlist(12,"WorkingUpdate",123456,"7890");
        Song s = new Song(111,"itWorks","Worked","Dubstep","555", "data/notanormaldata.mp3");
        db.addSongToPlaylist(p,s);
    }

    public static Playlist updatePlaylist(){
        DbDAOPlaylist db = new DbDAOPlaylist();
        Playlist p = new Playlist(12,"WorkingUpdate",123456,"7890");
        return db.updatePlaylist(p);
    }

    public static Song getSong() throws SQLException {
        DbDAOSong db = new DbDAOSong();
        return db.getSong(20);

    }

    public static Song updateSong() throws SQLException {
        DbDAOSong db = new DbDAOSong();
        Song s = new Song(22,"itWorks","Worked","Dubstep","555", "data/notanormaldata.mp3");
        db.updateSong(s);
        return s;
    }

    public static void deleteSong(){
        DbDAOSong db = new DbDAOSong();
        Song s = new Song(24,"Hopefully","Maroon 5","Electronic","340", "data/data.mp3");
        db.deleteSong(s);
    }

    public static List<Song> getAllSong(){
        DbDAOSong db = new DbDAOSong();
        return db.getAllSongs();
    }

    public static Song addSong() throws SQLException {
        DbDAOSong db = new DbDAOSong();
        Song s = new Song(1,"Spotless?","idk","classic","111", "data/song4.mp3");
        return db.addSong(s);
    }

    public static List<Playlist> getAllPlaylist(){
        DbDAOPlaylist db = new DbDAOPlaylist();
        return db.getAllPlaylist();
    }

    public static Playlist addPLaylist(){
        DbDAOPlaylist db = new DbDAOPlaylist();
        return db.addPlaylist("Your Playlist");
    }

    public static void deletePlaylist(){
        DbDAOPlaylist db = new DbDAOPlaylist();
        Playlist p = new Playlist(4,"My Music",0,"0");
        db.deletePlaylist(p);
    }

    public static void renamePlaylist(){
        DbDAOPlaylist db = new DbDAOPlaylist();
        Playlist p = new Playlist(3,"Study Music",0,"0");
        db.renamePlaylist(p);
    }

    public static Playlist getPlaylist(){
        DbDAOPlaylist db = new DbDAOPlaylist();
        return db.getPlaylist(12);
    }
}
