package dal.interfaces;

import be.Playlist;

import java.util.List;

public interface IPLaylistRepository {

    /**
     * Returns all playlist stored in persistent storage.
     * @return list of playlist.
     */

    List<Playlist> getAllPlaylist();

    /**
     * Adds a playlist to the persistent storage.
     * @param name of the playlist to be added.
     */

    void addPlaylist(String name);

    /**
     * Deletes a playlist from the persistent storage.
     * @param playlist to be deleted.
     */

    void deletePlaylist(Playlist playlist);

    /**
     * Renames a playlist in the persistent storage.
     * @param playlist to be renamed.
     */

    void renamePlaylist(Playlist playlist);

    /**
     * Returns a playlist given an ID of the playlist.
     * @param id of the playlist to be returned.
     * @return a Playlist.
     */

    Playlist getPlaylist(int id);

    /**
     * Updates a playlist in the persistent storage.
     * @param playlist to be updated.
     * @return updated playlist.
     */

    Playlist updatePlaylist (Playlist playlist);
}
