package gui.controller;

import be.Song;
import gui.model.SongModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class NewSongController implements Initializable {

    @FXML
    private TextField ArtistTextField;

    @FXML
    private ComboBox<String> CategoriesComboBox;

    @FXML
    private TextField CategoryTextField;

    @FXML
    private Button CancelAddCategoryButton;

    @FXML
    private TextField FilePathTextField;

    @FXML
    private Button NewCategoryButton;

    @FXML
    private Button CloseWindowButton;

    @FXML
    private TextField TitleTextField;

    @FXML
    private TextField DurationTextField;

    private SongModel songModel;
    private MainViewController mController;
    private ObservableList<String> allCategories;
    private MediaPlayer mediaPlayer;

    public NewSongController(){
        try{
            songModel = new SongModel();
            mController = new MainViewController();
        }
        catch (Exception e) {
            e.printStackTrace();}
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadCategories();
        CategoryTextField.setVisible(false);
        CancelAddCategoryButton.setVisible(false);

    }

    private void loadCategories() {
        allCategories = FXCollections.observableArrayList();
        allCategories.addAll(songModel.getCategories());
        CategoriesComboBox.setItems(allCategories);
    }

    @FXML
    void AddSong(ActionEvent event) throws SQLException {
        if (TitleTextField != null && ArtistTextField != null && FilePathTextField != null){
            Song song = new Song(0,TitleTextField.getText(),ArtistTextField.getText(),getCategory(),DurationTextField.getText(),FilePathTextField.getText(),0);
            songModel.addSong(song);
            mController.updateSongTableView();
        }
        closeWindow();
    }

    @FXML
    void ChooseFilePath(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home") + System.getProperty("file.separator") + "Desktop"));
        fileChooser.setTitle("Select a song");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
                new FileChooser.ExtensionFilter("All Files", "*.*"));
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            FilePathTextField.setText(selectedFile.getAbsolutePath());
            mediaPlayer = new MediaPlayer(new Media(new File(selectedFile.getAbsolutePath()).toURI().toString()));
            setMediaPlayerTime();
        }
    }

    private void setMediaPlayerTime() {
        mediaPlayer.setOnReady(() -> {
            String averageSeconds = String.format("%1.0f", mediaPlayer.getMedia().getDuration().toSeconds());
            int minutes = Integer.parseInt(averageSeconds) / 60; //
            int seconds = Integer.parseInt(averageSeconds) % 60; //
            if (10 > seconds) {
                DurationTextField.setText(minutes + ":0" + seconds);
            } else {
                DurationTextField.setText(minutes + ":" + seconds);
            }
        });
    }

    public String getCategory(){
        if (CategoryTextField.isVisible() && CategoryTextField != null && CategoryTextField.getLength() > 0){
            return CategoryTextField.getText();
        }
        else return CategoriesComboBox.getValue();
    }

    @FXML
    void WriteNewCategory(ActionEvent event) {
        NewCategoryButton.setVisible(false);
        CategoriesComboBox.setVisible(false);
        CancelAddCategoryButton.setVisible(true);
        CategoryTextField.setVisible(true);

    }

    @FXML
    void CancelAddCategory(ActionEvent event) {
        NewCategoryButton.setVisible(true);
        CategoriesComboBox.setVisible(true);
        CancelAddCategoryButton.setVisible(false);
        CategoryTextField.setVisible(false);
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
}
