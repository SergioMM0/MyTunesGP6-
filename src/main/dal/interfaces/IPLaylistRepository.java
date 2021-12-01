package dal.interfaces;

import be.Playlist;
import be.Song;

public interface IPLaylistRepository {

    Playlist addPlaylist(int id, String name);

    void deletePlaylist(Playlist playlist);

    void renamePlaylist(Playlist playlist);

    Playlist getPlaylist(int id);

    Playlist addSongToPlaylist(Song song);
}
