package dal.interfaces;

import be.Playlist;
import be.Song;

import java.util.List;

public interface IPLaylistRepository {

    List<Playlist> getAllPlaylist();

    Playlist addPlaylist(int id, String name);

    void deletePlaylist(Playlist playlist);

    void renamePlaylist(Playlist playlist);

    Playlist getPlaylist(int id);

    Playlist getSongsFromPlaylist(Playlist playlist);

    /** addSong OVERWRITE the field IdOfSongsInPlaylist in DB, so getSongs
    need to be executed first */

    Playlist addSongToPlaylist(Playlist playlist,Song song);
}
