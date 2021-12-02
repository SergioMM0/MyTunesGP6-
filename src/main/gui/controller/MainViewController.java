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

    @FXML
    protected void playSong() {

    }

    @FXML
    protected void nextSong() {

    }
    @FXML
    protected void previousSong() {

    }

    @FXML
    protected void changeVolume() {

    }

    @FXML
    protected void showResult() {

    }

    @FXML
    protected void addSong() {

    }

    @FXML
    protected void newPlaylist() {

    }

    @FXML
    protected void editPlaylist() {

    }

    @FXML
    protected void deletePlaylist() {

    }

    @FXML
    protected void moveUp() {

    }

    @FXML
    protected void moveDown() {

    }

    @FXML
    protected void removeSong() {

    }

    @FXML
    protected void editSong() {

    }

    @FXML
    protected void newSong() {

    }

    @FXML
    protected void deleteSong() {

    }


}