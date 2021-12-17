package gui.controller;

import be.Playlist;
import be.Song;
import gui.model.SongModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class EditSongController implements Initializable {

    @FXML
    private TextField ArtistTextField;

    @FXML
    private ComboBox<?> CategoriesComboBox;

    @FXML
    private Button CloseWindowButton;

    @FXML
    private TextField FilePathTextField;

    @FXML
    private Button NewCategoryButton;

    @FXML
    private TextField TitleTextField;

    @FXML
    private TextField DurationTextField;

    private SongModel songModel;
    private MainViewController mController;
    private Song selectedS;

    public EditSongController(){
        try{
            songModel = new SongModel();
            mController = new MainViewController();
        }
        catch (Exception e) {
            e.printStackTrace();}
    }

    @FXML
    void ChooseFilePath(ActionEvent event) {

    }

    @FXML
    void CloseWindow(ActionEvent event) {
        closeWindow();
    }

    @FXML
    void EditSong(ActionEvent event) {
        closeWindow();
    }

    @FXML
    void WriteNewCategory(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setController(MainViewController mainViewController) {
        this.mController = mainViewController;
    }

    private void closeWindow(){
        Stage st = (Stage) CloseWindowButton.getScene().getWindow();
        st.close();
    }

    public void setSelectedSong(Song song) {
        this.selectedS = song;
    }
}
