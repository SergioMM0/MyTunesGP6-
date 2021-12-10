package gui.controller;

import be.Playlist;
import gui.model.PlaylistModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class EditPlaylistController implements Initializable {

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
    private Playlist selected;

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
        if( newName != null || newName.getText() != ""){ //not working if statement
            selected.setName(newName.getText());
            model.renamePlaylist(selected);
            mController.updatePLaylistTableView();
            closeWindow();
        }
        else {
            PlainText1.setText("Introduce a new name");
        }
    }

    public void setSelectedPlaylist(Playlist playlist){
        this.selected = playlist;
    }

    private void closeWindow(){
        Stage st = (Stage) closeWindowButton.getScene().getWindow();
        st.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setController(MainViewController mainViewController) {
        this.mController = mainViewController;
    }
}
