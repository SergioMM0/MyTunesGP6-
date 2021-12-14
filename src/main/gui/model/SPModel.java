package gui.model;

import be.Playlist;
import be.Song;
import bll.MyTunesLogicController;
import bll.MyTunesLogicFacade;
import gui.controller.MainViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class SPModel {

    private MyTunesLogicFacade logicFacade;
    private ObservableList<Song> songsP;
    private Playlist selectedPlaylist;

    public SPModel() {
        logicFacade = new MyTunesLogicController();
    }

    public void setSelectedPlaylist(Playlist playlist){
        this.selectedPlaylist = playlist;
    }

    public Playlist getSelectedPlaylist(){
        return this.selectedPlaylist;
    }

    public List<Song> getAllSongsInPlaylist(){
        songsP = FXCollections.observableArrayList();
        songsP.clear();
        songsP.addAll(logicFacade.getAllSongsInPlaylist(getSelectedPlaylist()));
        return songsP;
    }

    public void updateSongPosition(Playlist playlist,Song selected, Song pushed) {
        logicFacade.updateSongPosition(playlist,selected,pushed);
    }
}
