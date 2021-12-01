package dal.db.dao;

import be.Playlist;
import be.Song;
import dal.interfaces.IPLaylistRepository;

public class DbDAOPlaylist implements IPLaylistRepository {
    @Override
    public Playlist addPlaylist(int id, String name) {
    return null;
    }

    @Override
    public void deletePlaylist(Playlist playlist) {

    }

    @Override
    public void renamePlaylist(Playlist playlist) {

    }

    @Override
    public Playlist getPlaylist(int id) {
        return null;
    }

    @Override
    public Playlist addSongToPlaylist(Song song) {
        return null;
    }
}
