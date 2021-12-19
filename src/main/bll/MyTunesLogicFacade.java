package bll;

import be.Playlist;
import be.Song;

import java.sql.SQLException;
import java.util.List;

public interface MyTunesLogicFacade {

    //************* Song operations

    /**
     * Retrieves all songs from persistent storage.
     * @return List of Songs
     */

    List<Song> getAllSongs();

    /**
     * Adds a song to the persistent storage.
     * @param song to be added
     * @return Song
     * @throws SQLException if needed
     */

    Song addSong(Song song) throws SQLException;

    /**
     * Deletes a song from persistent storage.
     * @param song to be deleted.
     */

    void deleteSong(Song song);

    /**
     * Updates a song from persistent storage.
     * @param song to be updated.
     * @throws SQLException if needed.
     */

    void updateSong(Song song) throws SQLException;

    /**
     * Returns all categories that already exists on persistent storage.
     * @return List of String
     */

    List<String> getCategories();

    //************* Playlist operations

    /**
     * Returns all playlists in the persistent storage.
     * @return List of playlist.
     */

    List<Playlist> getAllPlaylist();

    /**
     * Adds a playlist to the persistent storage given a name.
     * @param name of the playlist.
     */

    void addPlaylist(String name);

    /**
     * Deletes a playlist from the persistent storage.
     * @param playlist to be erased.
     */

    void deletePlaylist(Playlist playlist);

    /**
     * Renames a playlist.
     * @param playlist to be renamed
     */

    void renamePlaylist(Playlist playlist);

    /**
     * Returns a playlist given an ID of the playlist.
     * @param id of the playlist.
     * @return Playlist.
     */

    Playlist getPlaylist(int id);

    //**********

    /**
     * Returns all the songs linked to a Playlist given a Playlist.
     * @param playlist which contains the songs.
     * @return List of Songs.
     */

    List<Song> getAllSongsInPlaylist(Playlist playlist);

    /**
     * Deletes all remaining songs from persistent storage when a Playlist is deleted.
     * @param playlist that holds the songs to be deleted.
     */

    void deleteRemainingSongs(Playlist playlist);

    /**
     * Allows the user to interact with the positions of the songs in a playlist.
     * @param playlist which is updated.
     * @param selected song to be moved.
     * @param pushed song which gets pushed to other position.
     */

    void updateSongPosition(Playlist playlist, Song selected, Song pushed);

    /**
     * Deletes a song from a Playlist.
     * @param playlist to be deleted from.
     * @param song to be deleted.
     */

    void deleteSongOnPlaylist(Playlist playlist, Song song);

    /**
     * Adds a song to a Playlist.
     * @param playlist to be added to.
     * @param song to be added.
     */

    void addSongToPlaylist(Playlist playlist, Song song);
}
