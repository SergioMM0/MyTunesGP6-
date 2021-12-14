package gui.controller;

import be.Playlist;
import be.Song;
import gui.model.PlaylistModel;
import gui.model.SPModel;
import gui.model.SongModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {

    private PlaylistModel playlistModel;
    private SongModel songModel;
    private SPModel spModel;

    @FXML
    private TableView<Song> songsListView;

    @FXML
    private TableColumn<Song, String> songArtistColumn;

    @FXML
    private TableColumn<Song, String> songCategoryColumn;

    @FXML
    private TableColumn<Song, String> songTimeColumn;

    @FXML
    private TableView<Playlist> playlistListView;

    @FXML
    private TableColumn<Playlist, String> playlistNameColumn;

    @FXML
    private TableColumn<Playlist, Integer> playlistNSongsColumn;

    @FXML
    private TableColumn<Playlist, String> playlistTimeColumn;

    @FXML
    private Button refreshPlaylistButton; //done

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
    private Button previousSongButton;

    @FXML
    private Button searchButton;

    @FXML
    private TableColumn<Song, String> songTitleColumn;

    @FXML
    private ListView<Song> songsOnPlaylistListView;

    @FXML
    private Slider volumeSlider;

    public MainViewController() {
        playlistModel = new PlaylistModel();
        songModel = new SongModel();
        spModel = new SPModel();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        updateSongTableView();
        updatePLaylistTableView();
    }

    public void updateSongTableView() {
        songsListView.getItems().clear();
        songsListView.refresh();
        songTitleColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        songArtistColumn.setCellValueFactory(new PropertyValueFactory<>("Artist"));
        songCategoryColumn.setCellValueFactory(new PropertyValueFactory<>("Category"));
        songTimeColumn.setCellValueFactory(new PropertyValueFactory<>("Duration"));
        songsListView.getItems().setAll(songModel.getSongs());
    }

    public void updatePLaylistTableView() {
        playlistListView.getItems().clear();
        playlistListView.refresh();
        playlistNameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        playlistNSongsColumn.setCellValueFactory(new PropertyValueFactory<>("HowManySongs"));
        playlistTimeColumn.setCellValueFactory(new PropertyValueFactory<>("TotalReproductionTime"));
        playlistListView.getItems().setAll(playlistModel.getAllPlaylist());
    }

    @FXML
    void selectPlaylist(MouseEvent event) {
        spModel.setSelectedPlaylist(playlistListView.getSelectionModel().getSelectedItem());
        updateSongsInPlaylistView();
    }

    public void updateSongsInPlaylistView() {
        songsOnPlaylistListView.getItems().clear();
        songsOnPlaylistListView.refresh();
        songsOnPlaylistListView.getItems().setAll(spModel.getAllSongsInPlaylist());
    }

    @FXML
    void refreshPlaylist(ActionEvent event) {
        updatePLaylistTableView();
    }

    @FXML
    void addSongToPlaylist(ActionEvent event) {
        playlistModel.addSongToPlaylist();
    }

    @FXML
    void deletePlaylist(ActionEvent event) {
        playlistModel.deletePlaylist(playlistListView.getSelectionModel().getSelectedItem());
        updatePLaylistTableView();
    }

    @FXML
    void openNewPlaylistView(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("gui/view/NewPlaylistView.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        NewPlaylistController newPlaylistController = loader.getController();
        newPlaylistController.setmController(this);
        Stage stage = new Stage();
        stage.setTitle("Add playlist");
        stage.setScene(new Scene(root, 405, 270));
        stage.show();
    }

    @FXML
    void openEditPlaylistView(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("gui/view/EditPlaylistView.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        EditPlaylistController editPlaylistController = loader.getController();
        editPlaylistController.setController(this);
        try {
            editPlaylistController.setSelectedPlaylist(playlistModel.getPlaylist(playlistListView.getSelectionModel().getSelectedItem().getId()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setTitle("Edit selected playlist");
        stage.setScene(new Scene(root, 405, 270));
        stage.show();
    }

    @FXML
    void deleteSongFromPlaylist(ActionEvent event) {
        playlistModel.deleteSongFromPlaylist();
    }

    @FXML
    void handleVolume(MouseEvent event) {

    }

    @FXML
    void moveDownSongInPlaylist(ActionEvent event) {
        int position = songsOnPlaylistListView.getSelectionModel().getSelectedIndex();
        if(position <= songsOnPlaylistListView.getItems().size()){
            spModel.updateSongPosition(playlistListView.getSelectionModel().getSelectedItem(),songsOnPlaylistListView.getItems().get(position),songsOnPlaylistListView.getItems().get(position+1));
        }
        updateSongsInPlaylistView();

    }

    @FXML
    void moveUpSongInPlaylist(ActionEvent event) {
        int position = songsOnPlaylistListView.getSelectionModel().getSelectedIndex();
        spModel.updateSongPosition(playlistListView.getSelectionModel().getSelectedItem(),songsOnPlaylistListView.getItems().get(position), songsOnPlaylistListView.getItems().get(position-1));
        updateSongsInPlaylistView();
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

    public void playSongFromPlaylist(MouseEvent mouseEvent) {
    }

    public void playSongFromSongs(MouseEvent mouseEvent) {
    }
}
