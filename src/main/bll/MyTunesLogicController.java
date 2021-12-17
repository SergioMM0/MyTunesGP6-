package bll;

import be.Playlist;
import be.Song;
import dal.MyTunesDalController;
import dal.MyTunesDalFacade;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MyTunesLogicController implements MyTunesLogicFacade {

    private final MyTunesDalFacade dalFacade;

    public MyTunesLogicController() {
        dalFacade = new MyTunesDalController();
    }

    @Override
    public List<Song> getAllSongs() {
        return dalFacade.getAllSongs();
    }

    @Override
    public Song addSong(Song song) throws SQLException {
        return dalFacade.addSong(song);
    }

    @Override
    public void deleteSong(Song song) {
        dalFacade.deleteSong(song);
    }

    @Override
    public void updateSong(Song song) throws SQLException {
        dalFacade.updateSong(song);
    }

    @Override
    public Song getSong(int id) throws SQLException {
        return dalFacade.getSong(id);
    }

    @Override
    public List<String> getCategories() {
        return dalFacade.getCategories();
    }

    @Override
    public List<Playlist> getAllPlaylist() {
        return dalFacade.getAllPlaylist();
    }

    @Override
    public void addPlaylist(String name) {
        dalFacade.addPlaylist(name);
    }

    @Override
    public void deletePlaylist(Playlist playlist) {
        dalFacade.deletePlaylist(playlist);
    }

    @Override
    public void renamePlaylist(Playlist playlist) {
        dalFacade.renamePlaylist(playlist);
    }

    @Override
    public Playlist getPlaylist(int id) {
        return dalFacade.getPlaylist(id);
    }

    @Override
    public Playlist updatePlaylist(Playlist playlist) {
        return dalFacade.updatePlaylist(playlist);
    }

    @Override
    public List<Song> getAllSongsInPlaylist(Playlist playlist) {
        return dalFacade.getAllSongsInPlaylist(playlist);
    }

    public void updateSongPosition(Playlist playlist, Song selected, Song pushed){
        dalFacade.updateSongPosition(playlist,selected,pushed);
    }

    @Override
    public void deleteSongOnPlaylist(Playlist playlist, Song song) {
        dalFacade.deleteSongOnPlaylist(playlist,song);
        if (playlist.getHowManySongs()==0){
            playlist.setHowManySongs(0);
        }
        else playlist.setHowManySongs(playlist.getHowManySongs()-1);
        dalFacade.updatePlaylist(playlist);

    }

    @Override
    public void addSongToPlaylist(Playlist playlist, Song song) {
        dalFacade.addSongToPlaylist(playlist,song);
        playlist.setHowManySongs(playlist.getHowManySongs()+1);
        dalFacade.updatePlaylist(playlist);
    }

    public void deleteRemainingSongs(Playlist playlist){
        dalFacade.deleteRemainingSongs(playlist);
    }
}
