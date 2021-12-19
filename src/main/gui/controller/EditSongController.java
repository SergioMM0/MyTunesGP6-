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

/**
 * Author: Sergio M.
 * @SergioMM0 on Github
 */

public class EditSongController implements Initializable {

    @FXML
    private TextField ArtistTextField;

    @FXML
    private ComboBox<String> CategoriesComboBox;

    @FXML
    private Button CloseWindowButton;

    @FXML
    private TextField FilePathTextField;

    @FXML
    private Button NewCategoryButton;

    @FXML
    private TextField TitleTextField;

    @FXML
    private TextField CategoryTextField;

    @FXML
    private TextField DurationTextField;

    @FXML
    private Button CancelAddCategoryButton;

    private SongModel songModel;
    private MainViewController mController;
    private ObservableList<String> allCategories;
    private Song selectedS;
    private MediaPlayer mediaPlayer;

    public EditSongController() {
        try {
            songModel = new SongModel();
            mController = new MainViewController();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Allows to open a window in window explorer to select where is the song stored.
     */

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

    @FXML
    void CloseWindow(ActionEvent event) {
        closeWindow();
    }

    @FXML
    void EditSong(ActionEvent event) throws SQLException {
        if (TitleTextField != null && TitleTextField.getLength() > 0) {
            selectedS.setName(TitleTextField.getText());
        } else if (ArtistTextField != null && ArtistTextField.getLength() > 0) {
            selectedS.setArtist(ArtistTextField.getText());
        } else if (CategoriesComboBox.getValue() != null || (CategoryTextField != null && CategoryTextField.getLength() > 0)) {
            selectedS.setCategory(getCategory());
        } else if (DurationTextField != null && DurationTextField.getLength() > 0) {
            selectedS.setDuration(DurationTextField.getText());
        } else if (FilePathTextField != null && FilePathTextField.getLength() > 0) {
            selectedS.setFilePath(FilePathTextField.getText());
        }
        songModel.updateSong(selectedS);
        mController.updateSongTableView();
        closeWindow();
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadCategories();
        CancelAddCategoryButton.setVisible(false);
        CategoryTextField.setVisible(false);
    }

    public String getCategory() {
        if (CategoryTextField.isVisible() && CategoryTextField != null && CategoryTextField.getLength() > 0) {
            return CategoryTextField.getText();
        } else return CategoriesComboBox.getValue();
    }

    private void loadCategories() {
        allCategories = FXCollections.observableArrayList();
        allCategories.addAll(songModel.getCategories());
        CategoriesComboBox.setItems(allCategories);
    }

    public void setController(MainViewController mainViewController) {
        this.mController = mainViewController;
    }

    private void closeWindow() {
        Stage st = (Stage) CloseWindowButton.getScene().getWindow();
        st.close();
    }

    public void setSelectedSong(Song song) {
        this.selectedS = song;
    }
}
