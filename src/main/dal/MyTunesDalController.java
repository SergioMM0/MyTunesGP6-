package dal;

import be.Playlist;
import be.Song;

import java.sql.SQLException;
import java.util.List;

public class MyTunesDalController implements MyTunesDalFacade {


    @Override
    public Song addSong(int id, String name, String artist, String category, int duration, String filePath) throws SQLException {
        return null;
    }

    @Override
    public void deleteSong(Song song) {

    }

    @Override
    public void updateSong(Song song) throws SQLException {

    }

    @Override
    public Song getSong(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Song> getAllSongs() {
        return null;
    }

    @Override
    public List<Playlist> getAllPlaylist() {
        return null;
    }

    @Override
    public Playlist addPlaylist(int id, String name) {
        return null;
    }

    @Override
    public void deletePlaylist(Playlist playlist) {

    }

    @Override
    public void renamePlaylist(Playlist playlist) {

    }

    @Override
    public Playlist getPlaylist(int id) {
        return null;
    }

    @Override
    public Playlist getSongsFromPlaylist(Playlist playlist) {
        return null;
    }

    @Override
    public Playlist addSongToPlaylist(Playlist playlist, Song song) {
        return null;
    }
}
