package dal.interfaces;

import be.Playlist;
import be.Song;

import java.util.List;

public interface ISongsInPlaylistManager {

    void addSongToPlaylist(Playlist playlist, Song song, int position);

    void deleteSongOnPlaylist(int position);

    List<Song> getAllSongsFromPlaylist(Playlist playlist);
}
