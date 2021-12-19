package dal.interfaces;

import be.Song;

import java.sql.SQLException;
import java.util.List;

public interface ISongRepository {

    /**
     * Adds a song to the persistent storage.
     * @param song to be added.
     * @return Song added.
     * @throws SQLException if there's a problem with SQL.
     */

    Song addSong(Song song) throws SQLException;

    /**
     * Deletes a song from the persistent storage.
     * @param song to be deleted.
     */

    void deleteSong(Song song);

    /**
     * Updates a song in the persistent storage.
     * @param song to be updated.
     * @throws SQLException if there's a problem with SQL.
     */

    void updateSong(Song song) throws SQLException;

    /**
     * Returns a song by giving an ID of the song requested.
     * @param id of the song requested.
     * @return song requested.
     * @throws SQLException if there's a problem with SQL.
     */

    Song getSong(int id) throws SQLException;

    /**
     * Returns all the songs in the persistent storage.
     * @return list of songs.
     */

    List<Song> getAllSongs();

    /**
     * Returns all categories already stored in persistent storage from songs already stored.
     * @return list of existing categories.
     */

    List<String> getCategories();

}
