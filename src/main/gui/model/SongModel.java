package gui.model;

import be.Song;
import bll.MyTunesLogicController;
import bll.MyTunesLogicFacade;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SongModel {

    private final ObservableList<Song> songs;
    private MyTunesLogicFacade logicFacade;

    public SongModel(){
    songs = FXCollections.observableArrayList();
    logicFacade = new MyTunesLogicController();
    songs.addAll(logicFacade.getAllSongs());
    }

    public ObservableList<Song> getSongs() {
        return songs;
    }

    public String getFilePathOfCurrentPlayingSong() {
        return null;
    }
}
