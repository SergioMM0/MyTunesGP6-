package gui.controller;

import be.Playlist;
import be.Song;
import gui.model.PlaylistModel;
import gui.model.SongModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.Time;
import java.util.ResourceBundle;

public class MainViewController implements Initializable{

private PlaylistModel playlistModel;
private SongModel songModel;

    @FXML
    private TableView<Song> SongsListView; // Whole table of songs, do not write

    @FXML
    private Button addSongToPlaylist;

    @FXML
    private Label currentlyPlayingSongLabel;

    @FXML
    private Button deleteFromPlaylist;

    @FXML
    private Button deletePlaylistButton;

    @FXML
    private Button editPlaylistButton;

    @FXML
    private TextField filterTextField;

    @FXML
    private Button moveDownButton;

    @FXML
    private Button moveUpButton;

    @FXML
    private Button newPlaylistButton;

    @FXML
    private Button newSongButton;

    @FXML
    private Button nextSongButton;

    @FXML
    private Button playSongButton;

    @FXML
    private TableColumn<Playlist,String> playlistNameColumn;

    @FXML
    private TableColumn<Song,Integer> playlistNSongsColumn;

    @FXML
    private TableColumn<Song, String> playlistTimeColumn; /** TIME FOR PLAYLISTS */

    @FXML
    private TableView<Playlist> playlistTableView; // Whole table of Playlist, do not write

    @FXML
    private Button previousSongButton;

    @FXML
    private Button searchButton;

    @FXML
    private TableColumn<Song,String> songArtistColumn;

    @FXML
    private TableColumn<Song,String> songCategoryColumn;

    @FXML
    private TableColumn<Song,Time> songTimeColumn; /** TIME FOR SONGS*/

    @FXML
    private TableColumn<Song,String> songTitleColumn;

    @FXML
    private ListView<Song> songsOnPlaylistListView;

    @FXML
    private Slider volumeSlider;

    public MainViewController(){
    try{
        playlistModel = new PlaylistModel();
        songModel = new SongModel();
    }
    catch (Exception e) {
        e.printStackTrace();}
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    void addSongToPlaylist(ActionEvent event) {

    }

    @FXML
    void deletePlaylist(ActionEvent event) {

    }

    @FXML
    void deleteSongFromPlaylist(ActionEvent event) {

    }

    @FXML
    void handleVolume(MouseEvent event) {

    }

    @FXML
    void moveDownSongInPlaylist(ActionEvent event) {

    }

    @FXML
    void moveUpSongInPlaylist(ActionEvent event) {

    }

    @FXML
    void nextSong(ActionEvent event) {

    }

    @FXML
    void playSong(ActionEvent event) {

    }

    @FXML
    void previousSong(ActionEvent event) {

    }

    @FXML
    void searchSong(ActionEvent event) {

    }

    @FXML
    void searchSongTextField(ActionEvent event) {

    }

    @FXML
    void updatePlaylistButton(ActionEvent event) {

    }
}
