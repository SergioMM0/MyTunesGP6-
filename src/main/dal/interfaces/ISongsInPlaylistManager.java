package dal.interfaces;

import be.Playlist;
import be.Song;

import java.util.List;

public interface ISongsInPlaylistManager {

    void addSongToPlaylist(Playlist playlist, Song song);

    List<Song> getAllSongsFromPlaylist(Playlist playlist);

    void updateSongPosition(Playlist playlist,Song selected, Song pushed);

    void deleteSongOnPlaylist(Song song);

    void deleteRemainingSongs(Playlist playlist);
}
