package gui.controller;

import gui.model.SongModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainViewController {
    @FXML
    private Label welcomeText;

    SongModel songModel = SongModel.getInstance();

    @FXML
    protected void onHelloButtonClick() {
        songModel.getAllSongs();
    }
}