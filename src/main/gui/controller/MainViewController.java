package gui.controller;

import gui.model.SongModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {
    @FXML
    private Label welcomeText;

    SongModel songModel = SongModel.getInstance();

    @FXML
    protected void onHelloButtonClick() {


        songModel.getAllSongs();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Media media = new Media("/Users/daniel/Documents/GitHub/MyTunesGP6-/Michael.mp3");
        MediaPlayer mp = new MediaPlayer(media);
        mp.play();
    }
}