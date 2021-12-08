package dal.interfaces;

import be.Playlist;
import be.Song;

import java.util.List;

public interface ISongsInPlaylistManager {

    void addSongToPlaylist(Playlist playlist, Song song);

    void deleteSongOnPlaylist(Song song);

    List<Song> getAllSongsFromPlaylist(Playlist playlist);
}
