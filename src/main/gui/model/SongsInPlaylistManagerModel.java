package gui.model;

import be.Playlist;
import be.Song;
import bll.MyTunesLogicController;
import bll.MyTunesLogicFacade;
import gui.controller.MainViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class SongsInPlaylistManagerModel {

    private final ObservableList<Song> songs;
    private MyTunesLogicFacade logicFacade;
    private List<Song> allSongs;
    private final MainViewController controller;

    public SongsInPlaylistManagerModel(){
        logicFacade = new MyTunesLogicController();
        controller = new MainViewController();
        songs = FXCollections.observableArrayList();
        //songs.addAll(logicFacade.getAllSongsInPlaylist(controller.getPlaylist()));
    }
    public ObservableList<Song> getSongs(){
        return songs;
    }
}
