package gui.controller;

import gui.model.PlaylistModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewPlaylistController {

    private PlaylistModel playlistModel;

    @FXML
    private Button addPlaylistButton;

    @FXML
    private Button closeWindowButton;

    @FXML
    private TextField nameOfNewPlaylist;

    public NewPlaylistController(){
        try{
            playlistModel = new PlaylistModel();
        }
        catch (Exception e) {
            e.printStackTrace();}
    }

    @FXML
    void addPlaylist(ActionEvent event) {
        if(nameOfNewPlaylist != null){
            playlistModel.addPlaylist();
        }
    }

    @FXML
    void closeWindow(ActionEvent event) {
        Stage st = (Stage) closeWindowButton.getScene().getWindow();
        st.close();
    }

}
