package dal;

import be.Playlist;
import be.Song;

import java.sql.SQLException;
import java.util.List;

public interface MyTunesDalFacade {

    /**
     * MAKE SURE BEFORE IMPLEMENTING BLL ALL METHOD INTERFACES ARE IMPLEMENTED
    */
    Song addSong(Song song) throws SQLException;

    void deleteSong(Song song);

    void updateSong(Song song) throws SQLException;

    Song getSong(int id) throws SQLException;

    List<Song> getAllSongs();

    List<String> getCategories();

    //******

    List<Playlist> getAllPlaylist();

    void addPlaylist(String name);

    void deletePlaylist(Playlist playlist);

    void renamePlaylist(Playlist playlist);

    Playlist getPlaylist(int id);

    Playlist updatePlaylist(Playlist playlist);

    //*******

    List<Song> getAllSongsInPlaylist(Playlist playlist);

    void deleteRemainingSongs(Playlist playlist);

    void updateSongPosition(Playlist playlist, Song selected, Song pushed);

    void deleteSongOnPlaylist(Playlist playlist,Song song);

    void addSongToPlaylist(Playlist playlist, Song song);
}
