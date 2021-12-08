package dal.interfaces;

import be.Playlist;
import be.Song;

import java.util.List;

public interface ISongsInPlaylistManager {

    void addSongToPlaylist(Playlist playlist, Song song);

    List<Song> getSongsFromPlaylist(Playlist playlist);

    void updateSongsInPlaylist(int idOfPlaylist,String[] idOfSongs);
}
