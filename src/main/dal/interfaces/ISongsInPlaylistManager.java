package dal.interfaces;

import be.Playlist;
import be.Song;

import java.util.List;

public interface ISongsInPlaylistManager {

    /**
     * Adds a song to a playlist and store it in the persistent Storage.
     * @param playlist to add the song to.
     * @param song to be added.
     */

    void addSongToPlaylist(Playlist playlist, Song song);

    /**
     * Returns all songs contained in a playlist.
     * @param playlist to get the songs from.
     * @return a list of songs.
     */

    List<Song> getAllSongsFromPlaylist(Playlist playlist);

    /**
     * Updates the position of a song when an user wants to change the position inside of a
     * playlist and reflects it in the persistent storage.
     * @param playlist that holds the song.
     * @param selected song that is moved.
     * @param pushed song that is pushed due to movement of the selected song.
     */

    void updateSongPosition(Playlist playlist,Song selected, Song pushed);

    /**
     * Deletes a song from a Playlist and reflects it in persistent storage.
     * @param playlist that holds the song.
     * @param song to be deleted.
     */

    void deleteSongOnPlaylist(Playlist playlist,Song song);

    /**
     * Deletes all remaining songs when deletes a playlist in persistent storage.
     * @param playlist to be cleaned.
     */

    void deleteRemainingSongs(Playlist playlist);
}
