package dal.interfaces;

import be.Playlist;
import be.Song;

import java.util.List;

public interface ISongsInPlaylistManager {

    Song addSongToPlaylist(Playlist playlist, Song song);

    List<Song> getSongsFromPlaylist(int idOfPlaylist);

    void updateSongsInPlaylist(int idOfPlaylist,String[] idOfSongs);
}
