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
        List<Song> allSongsDurationConverted = new ArrayList<>();
        for (Song song : dalFacade.getAllSongs()) {
            convertSongDuration(song);
            allSongsDurationConverted.add(song);
        }
        return allSongsDurationConverted;
    }

    private Song convertSongDuration(Song song) {
        String oldDuration = song.getDuration();
        if (!oldDuration.contains(":")) {
            int intDuration = Integer.parseInt(oldDuration);
            String nMinutes = String.valueOf(intDuration / 60);
            String nSeconds = String.valueOf(intDuration % 60);
            String newDuration = nMinutes + ":" + nSeconds;
            song.setDuration(newDuration);
        }
        return song;
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
    public List<Playlist> getAllPlaylist() {
        return dalFacade.getAllPlaylist();
    }

    @Override
    public Playlist addPlaylist(String name) {
        return dalFacade.addPlaylist(name);
        //remember to add duration of songs to variable
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
    public Playlist getSongsFromPlaylist(Playlist playlist) {
        return dalFacade.getSongsFromPlaylist(playlist);
    }

    @Override
    public Playlist addSongToPlaylist(Playlist playlist, Song song) {
        return dalFacade.addSongToPlaylist(playlist, song);
    }

    @Override
    public Playlist updatePlaylist(Playlist playlist) {
        return dalFacade.updatePlaylist(playlist);
    }

}
