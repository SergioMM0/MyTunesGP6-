package gui.model;

import be.Playlist;
import be.Song;
import bll.MyTunesLogicController;
import bll.MyTunesLogicFacade;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class SongsInPlaylistManagerModel {

    private final ObservableList<Song> songs;
    private MyTunesLogicFacade logicFacade;

    public SongsInPlaylistManagerModel(){
        logicFacade = new MyTunesLogicController();
        songs = FXCollections.observableArrayList();
    }

    public List<Song> getAllSongsInPlaylist(Playlist playlist){
        songs.addAll(logicFacade.getAllSongsInPlaylist(playlist));
        return songs;
    }
}
