package gui.controller;

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
import java.sql.SQLException;
import java.util.ResourceBundle;

public class NewSongController implements Initializable {

    @FXML
    private TextField ArtistTextField;

    @FXML
    private ComboBox<String> CategoriesComboBox;

    @FXML
    private TextField FilePathTextField;

    @FXML
    private Button NewCategoryButton;

    @FXML
    private Button CloseWindowButton;

    @FXML
    private TextField TitleTextField;

    private SongModel songModel;
    private MainViewController mController;

    public NewSongController(){
        try{
            songModel = new SongModel();
            mController = new MainViewController();
        }
        catch (Exception e) {
            e.printStackTrace();}
    }

    @FXML
    void AddSong(ActionEvent event) throws SQLException {
        // Fix the duration, should be loaded from a file reader
        // Categories should get the choosen Category from combo box or hide an a field text should appear to add a new Category
        if (TitleTextField != null && ArtistTextField != null && FilePathTextField != null){
            Song song = new Song(0,TitleTextField.getText(),ArtistTextField.getText(),CategoriesComboBox.getValue(),"00",FilePathTextField.getText(),0);
            songModel.addSong(song);
        }
        closeWindow();
    }

    @FXML
    void ChooseFilePath(ActionEvent event) { //Fix
        //TODO
    }

    @FXML
    void WriteNewCategory(ActionEvent event) {
        // Categories should get the choosen Category from combo box or hide an a field text should appear to add a new Category
    }

    @FXML
    public void CloseWindow(ActionEvent actionEvent) {
        closeWindow();
    }

    public void setController(MainViewController mainViewController) {
        this.mController = mainViewController;
    }

    private void closeWindow(){
        Stage st = (Stage) CloseWindowButton.getScene().getWindow();
        st.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
