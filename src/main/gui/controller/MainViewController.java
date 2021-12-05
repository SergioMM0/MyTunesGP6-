package gui.controller;

import be.Playlist;
import be.Song;
import gui.model.PlaylistModel;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import gui.model.SongModel;

public class MainViewController {

    @FXML
    private Label Label;

    @FXML
    private ImageView btbtn;

    @FXML
    private ImageView dbtn;

    @FXML
    private Button dpbtn;

    @FXML
    private Button dsbtn;

    @FXML
    private Button epbtn;

    @FXML
    private Button esbtn;

    @FXML
    private ImageView mbtn;

    @FXML
    private Button npbtn;

    @FXML
    private Button nsbtn;

    @FXML
    private ImageView pbtn;

    @FXML
    private Button rmbtn;

    @FXML
    private ImageView sbtn;

    @FXML
    private TextField searchfilter;

    @FXML
    private ImageView ubtn;

    @FXML
    private Slider volslider;

    @FXML
    private ListView<Song> songListFromPlayList;

    @FXML
    private TableView<Playlist> playlistList;


    @FXML
    private Label welcomeText;
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


    public void editPlaylist(MouseEvent mouseEvent) {

    }

    public void deletePlaylist(MouseEvent mouseEvent) {

    }

    public void moveUp(MouseEvent mouseEvent) {

    }

    public void moveDown(MouseEvent mouseEvent) {

    }

    public void removeSong(MouseEvent mouseEvent) {

    }

    public void editSong(KeyEvent keyEvent) {

    }

    public void newSong(KeyEvent keyEvent) {

    }

    public void deleteSong(KeyEvent keyEvent) {

    }

    public void openNEPWindow(MouseEvent mouseEvent) {
    }

    public void newPlaylist(MouseEvent mouseEvent) {
    }

    public void closeNEPWindow(MouseEvent mouseEvent) {
    }
}