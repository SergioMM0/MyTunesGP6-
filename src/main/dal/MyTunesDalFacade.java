package dal;

import be.Playlist;
import be.Song;

import java.util.List;

public interface MyTunesDalFacade {

    Song addSong(int id, String name, String artist, String category, int duration);

    List<Song> getAllSongs();

    void deleteSong(Song song);

    void updateSong(Song song);

    Song getSong(int id);

    //******

    Playlist createPlaylist();//TODO implement parameters

    List<Playlist> getAllPlaylist();

    void deletePlaylist(Playlist playlist);

    void updatePlaylist(Playlist playlist);

    Playlist getPlaylist(int id);

}
