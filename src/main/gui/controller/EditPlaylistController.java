package gui.controller;

import be.Playlist;
import gui.model.PlaylistModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditPlaylistController {

    @FXML
    private Button closeWindowButton;

    @FXML
    private TextField newNameOfPlaylist;

    @FXML
    private Button renamePlaylistButton;

    PlaylistModel playlistModel;

    public EditPlaylistController(){
        try{
            playlistModel = new PlaylistModel();
        }
        catch (Exception e) {
            e.printStackTrace();}
    }

    @FXML
    void closeWindow(ActionEvent event) {
        closeWindow();
    }

    @FXML
    void renamePlaylist(ActionEvent event, Playlist playlist) {
        if (newNameOfPlaylist != null){
            playlistModel.renamePlaylist(playlist);
        }
    }

    private void closeWindow() {
        Stage st = (Stage) closeWindowButton.getScene().getWindow();
        st.close();
    }
}

