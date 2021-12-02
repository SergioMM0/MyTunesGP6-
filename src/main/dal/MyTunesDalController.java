package dal;

import be.Playlist;
import be.Song;
import dal.db.dao.DbDAOPlaylist;
import dal.db.dao.DbDAOSong;
import dal.interfaces.IPLaylistRepository;
import dal.interfaces.ISongRepository;

import java.sql.SQLException;
import java.util.List;

public class MyTunesDalController implements MyTunesDalFacade {

    private final IPLaylistRepository playlistRepository;
    private final ISongRepository songRepository;

    public MyTunesDalController(){
    playlistRepository = new DbDAOPlaylist();
    songRepository = new DbDAOSong();
    }

    @Override
    public Song addSong(int id, String name, String artist, String category, int duration, String filePath) throws SQLException {
        return songRepository.addSong(id,name,artist,category,duration,filePath);
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
    public Playlist addPlaylist(int id, String name) {
        return playlistRepository.addPlaylist(id,name);
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
    public Playlist getSongsFromPlaylist(Playlist playlist) {
        return playlistRepository.getSongsFromPlaylist(playlist);
    }

    @Override
    public Playlist addSongToPlaylist(Playlist playlist, Song song) {
        return playlistRepository.addSongToPlaylist(playlist,song);
    }
}
