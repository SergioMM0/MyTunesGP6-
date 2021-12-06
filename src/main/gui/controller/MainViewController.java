package gui.controller;

import be.Playlist;
import be.Song;
import com.sun.tools.javac.Main;
import gui.model.PlaylistModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import gui.model.SongModel;

import java.io.IOException;

public class MainViewController {

    @FXML
    private Label Label;

    @FXML
    private ImageView backtrackBtn;

    @FXML
    private Button deletePlaylistBtn;

    @FXML
    private Button deleteSongBtn;

    @FXML
    private ImageView downBtn;

    @FXML
    private Button editPlaylistBtn;

    @FXML
    private Button editSongBtn;

    @FXML
    private ImageView moveBtn;

    @FXML
    private Button newPlaylistBtn;

    @FXML
    private Button newSongBtn;

    @FXML
    private ImageView playBtn;

    @FXML
    private TableView<Playlist> playlistList;

    @FXML
    private Button removeBtn;

    @FXML
    private TextField searchfilter;

    @FXML
    private ImageView skipBtn;

    @FXML
    private ListView<Song> songListFromPlayList;

    @FXML
    private ImageView upBtn;

    @FXML
    private Slider volslider;
    @FXML
    private TableView<Song> songTableList;
    SongModel songModel = SongModel.getInstance();

    @FXML
    protected void onHelloButtonClick() {
        songModel.getAllSongs();
    }


    public void playSong(MouseEvent mouseEvent) {
        songModel.playSong(songListFromPlayList.getSelectionModel().getSelectedItems());
    }

    public void previousSong(MouseEvent mouseEvent) {
        if(songListFromPlayList.getSelectionModel().getSelectedIndex()>-1)
            songModel.previousSong(songListFromPlayList.getItems().get(songListFromPlayList.getSelectionModel().getSelectedIndex()-1));
    }

    public void nextSong(MouseEvent mouseEvent) {
        if(songListFromPlayList.getSelectionModel().getSelectedIndex()>-1)
            songModel.nextSong(songListFromPlayList.getItems().get(songListFromPlayList.getSelectionModel().getSelectedIndex()+1));
    }

    public void changeVolume(DragEvent dragEvent) {
        //TODO implement Volume Slider
    }

    public void showResult(KeyEvent keyEvent) {
        songTableList.setItems(songModel.getResult(searchfilter.getText()));
    }

    public void addSong(MouseEvent mouseEvent) {
        songListFromPlayList.getItems().add(songTableList.getSelectionModel().getSelectedItem());
    }
    public void moveUp(MouseEvent mouseEvent) {

    }
    public void moveDown(MouseEvent mouseEvent) {

    }
    public void removeSong(ActionEvent actionEvent) {

    }
    public void editSong(ActionEvent actionEvent) {

    }
    public void newSong(ActionEvent actionEvent) {

    }
    public void deleteSong(ActionEvent actionEvent) {

    }
    @FXML
    public void openNEPWindow(ActionEvent actionEvent) throws IOException {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("NewEditPlaylist"));
            Parent root = loader.load();
            NewEditPlaylist newPlaylist = loader.getController();
            newPlaylist.setParentController(this);
    }
    public void editPlaylist(ActionEvent actionEvent) {

    }
    public void deletePlaylist(ActionEvent actionEvent) {

    }
}