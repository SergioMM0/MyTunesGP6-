package gui.controller;

import gui.model.PlaylistModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Author: Sergio M.
 * @SergioMM0 on Github
 */

public class NewPlaylistController implements Initializable {

    @FXML
    private Button closeWindowButton;

    @FXML
    private TextField nameOfNewPlaylist;

    private PlaylistModel playlistModel;
    private MainViewController mController;

    public NewPlaylistController(){
        try{
            playlistModel = new PlaylistModel();
            mController = new MainViewController();
        }
        catch (Exception e) {
            e.printStackTrace();}
    }

    public void setmController(MainViewController mainViewController){
        this.mController = mainViewController;
    }

    @FXML
    void addPlaylist(ActionEvent event) {
        if(nameOfNewPlaylist != null){
            String newPlaylist = nameOfNewPlaylist.getText();
            playlistModel.addPlaylist(newPlaylist);
            mController.updatePLaylistTableView();
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
