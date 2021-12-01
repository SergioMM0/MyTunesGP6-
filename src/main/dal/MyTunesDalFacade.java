package dal;

import be.Playlist;
import be.Song;

import java.util.List;

public interface MyTunesDalFacade {

    Song addSong(int id, String name, String artist, String category, int duration);

    void deleteSong(Song song);

    void updateSong(Song song);

    Song getSong(int id);

    List<Song> getAllSongs();

    //******

    Playlist addPlaylist(int id, String name);

    void deletePlaylist(Playlist playlist);

    void renamePlaylist(Playlist playlist);

    Playlist getPlaylist(int id);

    Playlist addSongToPlaylist(Song song);

}
