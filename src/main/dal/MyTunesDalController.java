package dal;

import be.Playlist;
import be.Song;

import java.util.List;

public class MyTunesDalController implements MyTunesDalFacade {

    @Override
    public Song createSong(int id, String name, String artist, String category, int duration) {
        return null;
    }

    @Override
    public List<Song> getAllSongs() {
        return null;
    }

    @Override
    public void deleteSong(Song song) {

    }

    @Override
    public void updateSong(Song song) {

    }

    @Override
    public Song getSong(int id) {
        return null;
    }

    @Override
    public Playlist createPlaylist() {
        return null;
    }

    @Override
    public List<Playlist> getAllPlaylist() {
        return null;
    }

    @Override
    public void deletePlaylist(Playlist playlist) {

    }

    @Override
    public void updatePlaylist(Playlist playlist) {

    }

    @Override
    public Playlist getPlaylist(int id) {
        return null;
    }
}
