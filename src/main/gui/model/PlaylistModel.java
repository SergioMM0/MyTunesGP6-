package gui.model;

import be.Playlist;
import bll.MyTunesLogicController;
import bll.MyTunesLogicFacade;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class PlaylistModel {

    private final MyTunesLogicFacade logicFacade;
    private final ObservableList<Playlist> playlists;

    public PlaylistModel(){
        logicFacade = new MyTunesLogicController();
        playlists = FXCollections.observableArrayList();
        playlists.addAll(logicFacade.getAllPlaylist());
    }

    public List<Playlist> getAllPlaylist() {
        return logicFacade.getAllPlaylist();
    }

    public void addPlaylist(String newPlaylist) {
        logicFacade.addPlaylist(newPlaylist);
    }

    public void addSongToPlaylist() {
    }

    public void deletePlaylist(Playlist playlist) {
        logicFacade.deletePlaylist(playlist);
    }

    public void deleteSongFromPlaylist() {
    }

    public void moveDownSongInPlaylist() {
    }

    public void moveUpSongInPlaylist() {
    }

    public void updatePlaylist() {
    }

    public void renamePlaylist(Playlist playlist){
        logicFacade.renamePlaylist(playlist);
    }

    public Playlist getPlaylist(int id) {
        return logicFacade.getPlaylist(id);
    }
}
