package dal.interfaces;

import be.Song;

import java.util.List;

public interface ISongRepository {

    Song addSong(int id, String name, String artist, String category, int duration);

    void deleteSong(int id);

    void updateSong(int id);

    Song getSong(int id);

    List<Song> getAllSongs();

}
