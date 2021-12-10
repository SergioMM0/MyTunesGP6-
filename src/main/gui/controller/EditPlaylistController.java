package gui.controller;

import be.Playlist;
import gui.model.PlaylistModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EditPlaylistController {

    @FXML
    private Label PlainText1;

    @FXML
    private Text TXT;

    @FXML
    private Button closeWindowButton;

    @FXML
    private TextField newName;

    @FXML
    private Button renamePlaylistButton;

    private static PlaylistModel model;
    private MainViewController mController;

    public EditPlaylistController(){
        try{
            model = new PlaylistModel();
            mController = new MainViewController();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void closeWindowACT(ActionEvent event) {
        closeWindow();
    }

    @FXML
    void renamePlaylistACT(ActionEvent event) {
        Playlist p = mController.getPlaylist();
        model.renamePlaylist(p);
        closeWindow();
    }

    private void closeWindow(){
        Stage st = (Stage) closeWindowButton.getScene().getWindow();
        st.close();
    }

}
