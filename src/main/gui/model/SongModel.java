package gui.model;

import be.Song;
import bll.MyTunesLogicController;
import bll.MyTunesLogicFacade;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.List;

/**
 * Author: Sergio M.
 * @SergioMM0 on Github
 */

public class SongModel {

    private final MyTunesLogicFacade logicFacade;
    private final ObservableList<Song> songs;

    public SongModel(){
    songs = FXCollections.observableArrayList();
    logicFacade = new MyTunesLogicController();
    songs.addAll(logicFacade.getAllSongs());
    }

    public List<Song> getSongs() {
        return logicFacade.getAllSongs();
    }

    public void addSong(Song song) throws SQLException {
        logicFacade.addSong(song);
    }

    public List<String> getCategories(){
        return logicFacade.getCategories();
    }

    public void updateSong(Song song) throws SQLException {
        logicFacade.updateSong(song);
    }

    public void deleteSong(Song song) {
        logicFacade.deleteSong(song);
    }
}
