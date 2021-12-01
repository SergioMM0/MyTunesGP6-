package dal.db.dao;

import be.Song;
import dal.interfaces.ISongRepository;

import java.util.List;

public class DbDAOSong implements ISongRepository {



    @Override
    public Song addSong(int id, String name, String artist, String category, int duration) {
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
    public List<Song> getAllSongs() {
        return null;
    }
}
