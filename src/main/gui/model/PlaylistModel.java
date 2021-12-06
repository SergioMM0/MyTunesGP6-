package gui.model;

import bll.MyTunesLogicController;
import bll.MyTunesLogicFacade;

public class PlaylistModel {

    private MyTunesLogicFacade logicFacade;

    public PlaylistModel(){
        logicFacade = new MyTunesLogicController();
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
