package gui.model;

import be.Playlist;
import be.Song;
import bll.MyTunesLogicController;
import bll.MyTunesLogicFacade;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class PlaylistModel {

    private MyTunesLogicFacade logicFacade;
    private final ObservableList<Playlist> playlists;

    public PlaylistModel(){
        logicFacade = new MyTunesLogicController();
        playlists = FXCollections.observableArrayList();
        playlists.addAll(logicFacade.getAllPlaylist());
    }

    public List<Playlist> getAllPlaylist() {
        return logicFacade.getAllPlaylist();
    }

    public void addPlaylist() {
        //logicFacade.addPlaylist();
    }

    public void addSongToPlaylist() {
    }

    public void deletePlaylist() {
    }

    public void deleteSongFromPlaylist() {
    }

    public void moveDownSongInPlaylist() {
    }

    public void moveUpSongInPlaylist() {
    }

    public void updatePlaylist() {
    }
}
