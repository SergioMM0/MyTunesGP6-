package gui.model;

import be.Song;
import bll.MyTunesLogicController;
import bll.MyTunesLogicFacade;
import gui.controller.MainViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SPModel {

    private MyTunesLogicFacade logicFacade;
    private MainViewController mController;
    private final ObservableList<Song> songs;

    public SPModel() {
        logicFacade = new MyTunesLogicController();
        mController = new MainViewController();
        songs = FXCollections.observableArrayList();

    }
}
