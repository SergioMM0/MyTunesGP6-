package gui.controller;

import gui.model.PlaylistModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewPlaylistController {

    public Button renamePlaylistButton;
    @FXML
    private Button addPlaylistButton;

    @FXML
    private Button closeWindowButton;

    @FXML
    private TextField nameOfNewPlaylist;

    private PlaylistModel playlistModel;

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
            String newPlaylist = nameOfNewPlaylist.getText();
            playlistModel.addPlaylist(newPlaylist);
            closeWindow();
        }
    }

    @FXML
    void closeWindow(ActionEvent event) {
        closeWindow();
    }

    private void closeWindow(){
        Stage st = (Stage) closeWindowButton.getScene().getWindow();
        st.close();
    }
}
