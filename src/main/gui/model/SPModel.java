package gui.model;

import be.Playlist;
import be.Song;
import bll.MyTunesLogicController;
import bll.MyTunesLogicFacade;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Author: Sergio M.
 * @SergioMM0 on Github
 */

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
        return logicFacade.getAllSongsInPlaylist(getSelectedPlaylist());
    }

    public void updateSongPosition(Playlist playlist,Song selected, Song pushed) {
        logicFacade.updateSongPosition(playlist,selected,pushed);
    }

    public void deleteSongOnPlaylist(Playlist playlist, Song song){
        logicFacade.deleteSongOnPlaylist(playlist, song);
    }

    public void addSongToPlaylist(Playlist playlist, Song song){
        logicFacade.addSongToPlaylist(playlist,song);
    }
}
