package dal;

import be.Playlist;
import be.Song;
import dal.db.dao.DbDAOPlaylist;
import dal.db.dao.DbDAOSong;
import dal.db.dao.DbDAOSongsInPlaylistManager;
import dal.interfaces.IPLaylistRepository;
import dal.interfaces.ISongRepository;
import dal.interfaces.ISongsInPlaylistManager;

import java.sql.SQLException;
import java.util.List;

public class MyTunesDalController implements MyTunesDalFacade {

    private final IPLaylistRepository playlistRepository;
    private final ISongRepository songRepository;
    private final ISongsInPlaylistManager songsInPlaylistManager;

    public MyTunesDalController(){
    playlistRepository = new DbDAOPlaylist();
    songRepository = new DbDAOSong();
    songsInPlaylistManager = new DbDAOSongsInPlaylistManager();
    }

    @Override
    public Song addSong(Song song) throws SQLException {
        return songRepository.addSong(song);
    }

    @Override
    public void deleteSong(Song song) {
        songRepository.deleteSong(song);
    }

    @Override
    public void updateSong(Song song) throws SQLException {
        songRepository.updateSong(song);
    }

    @Override
    public Song getSong(int id) throws SQLException {
        return songRepository.getSong(id);
    }

    @Override
    public List<Song> getAllSongs() {
        return songRepository.getAllSongs();
    }

    @Override
    public List<Playlist> getAllPlaylist() {
        return playlistRepository.getAllPlaylist();
    }

    @Override
    public Playlist addPlaylist(String name) {
        return playlistRepository.addPlaylist(name);
    }

    @Override
    public void deletePlaylist(Playlist playlist) {
        playlistRepository.deletePlaylist(playlist);
    }

    @Override
    public void renamePlaylist(Playlist playlist) {
        playlistRepository.renamePlaylist(playlist);
    }

    @Override
    public Playlist getPlaylist(int id) {
        return playlistRepository.getPlaylist(id);
    }

    @Override
    public Playlist updatePlaylist(Playlist playlist) {
        return playlistRepository.updatePlaylist(playlist);
    }

    @Override
    public List<Song> getAllSongsInPlaylist(Playlist playlist) {
        return songsInPlaylistManager.getAllSongsFromPlaylist(playlist);
    }
}
