package gui.controller;

import be.Playlist;
import be.Song;
import gui.model.PlaylistModel;
import gui.model.SPModel;
import gui.model.SongModel;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Author: Sergio M.
 * @SergioMM0 on Github
 */

public class MainViewController implements Initializable {

    private final PlaylistModel playlistModel;
    private final SongModel songModel;
    private final SPModel spModel;
    private List<Song> songsRecord;
    private MediaPlayer mediaPlayer;
    private boolean playingFromSongs = false;
    private boolean playingFromPlaylist = false;
    private int numberOfListener = 0; //Keeps track. 1 for playing a song from all songs table or 2 for playing a song from Playlist table

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
    private Label currentlyPlayingSongLabel;

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
        songsRecord = new ArrayList<>();
        addListener();
    }

    /**
     * The following 5 methods handle the refresh of the List View.
     */

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
    public void RefreshSongs(ActionEvent actionEvent) {
        updateSongTableView();
    }

    //

    @FXML
    public void deleteSong(ActionEvent actionEvent) {
        songModel.deleteSong(songsListView.getSelectionModel().getSelectedItem());
        updateSongTableView();
    }

    @FXML
    void selectPlaylist(MouseEvent event) {
        spModel.setSelectedPlaylist(playlistListView.getSelectionModel().getSelectedItem());
        updateSongsInPlaylistView();
    }

    @FXML
    void deletePlaylist(ActionEvent event) {
        playlistModel.deletePlaylist(playlistListView.getSelectionModel().getSelectedItem());
        updatePLaylistTableView();
        songsOnPlaylistListView.getItems().clear();
        songsOnPlaylistListView.refresh();
    }

    /**
     * The following 4 methods handle the open of new windows.
     */

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
        newPlaylistController.setmController(this); //establishes the main controller as the controller.
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
    public void OpenAddSongView(ActionEvent actionEvent) {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("gui/view/NewSongView.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        NewSongController newSongController = loader.getController();
        newSongController.setController(this);

        Stage stage = new Stage();
        stage.setTitle("Add a new Song");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

    @FXML
    public void OpenEditSongView(ActionEvent actionEvent) {

        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("gui/view/EditSongView.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        EditSongController editSongController = loader.getController();
        editSongController.setController(this);
        try {
            editSongController.setSelectedSong(songsListView.getSelectionModel().getSelectedItem());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setTitle("Edit selected song");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();

    }

    /**
     * The following 4 methods handle operations in between song and playlist.
     */

    @FXML
    void deleteSongFromPlaylist(ActionEvent event) {
        spModel.deleteSongOnPlaylist(playlistListView.getSelectionModel().getSelectedItem(),songsOnPlaylistListView.getSelectionModel().getSelectedItem());
        playlistListView.refresh();
        updateSongsInPlaylistView();
    }

    @FXML
    void addSongToPlaylist(ActionEvent event) {
        spModel.addSongToPlaylist(playlistListView.getSelectionModel().getSelectedItem(),songsListView.getSelectionModel().getSelectedItem());
        updateSongsInPlaylistView();
        playlistListView.refresh();
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

    /**
     * The following 8 methods handle the media player operations.
     */

    @FXML
    void playStopSong(ActionEvent event) {
        if (playingFromSongs){
            mediaPlayer.pause();
            playingFromSongs = false;
        }
        else if (playingFromPlaylist){
            mediaPlayer.pause();
            playingFromPlaylist = false;
        }
        else {
            if (numberOfListener == 1 && mediaPlayer != null){
                playingFromSongs = true;
                mediaPlayer.play();
            }
            else if (numberOfListener == 2 && mediaPlayer != null){
                playingFromPlaylist = true;
                mediaPlayer.play();
            }
        }
    }

    @FXML
    void nextSong(ActionEvent event) {
        stopPlaying();
        if (numberOfListener == 1){
            songsListView.getSelectionModel().selectNext();
            File f = new File(songsListView.getSelectionModel().getSelectedItem().getFilePath());
            mediaPlayer = new MediaPlayer(new Media(f.toURI().toString()));
            mediaPlayer.play();
            playingFromSongs = true;
            songsRecord.add(songsListView.getSelectionModel().getSelectedItem());
            currentlyPlayingSongLabel.setText(songsListView.getSelectionModel().getSelectedItem().getName());
        }
        else if (numberOfListener == 2){
            songsOnPlaylistListView.getSelectionModel().selectNext();
            File f = new File(songsOnPlaylistListView.getSelectionModel().getSelectedItem().getFilePath());
            mediaPlayer = new MediaPlayer(new Media(f.toURI().toString()));
            mediaPlayer.play();
            playingFromPlaylist = true;
            songsRecord.add(songsOnPlaylistListView.getSelectionModel().getSelectedItem());
            currentlyPlayingSongLabel.setText(songsOnPlaylistListView.getSelectionModel().getSelectedItem().getName());
        }
    }

    @FXML
    void previousSong(ActionEvent event) {
        stopPlaying();
        if (numberOfListener == 1){
            Song previous = getLastSong(songsRecord);
            File f = new File(previous.getFilePath());
            mediaPlayer = new MediaPlayer(new Media(f.toURI().toString()));
            mediaPlayer.play();
            playingFromSongs = true;
            currentlyPlayingSongLabel.setText(previous.getName());
        }
        else if (numberOfListener == 2) {
            Song previous = getLastSong(songsRecord);
            File f = new File(previous.getFilePath());
            mediaPlayer = new MediaPlayer(new Media(f.toURI().toString()));
            mediaPlayer.play();
            playingFromPlaylist = true;
            currentlyPlayingSongLabel.setText(previous.getName());
        }
    }

    public Song getLastSong(List<Song> list){
        if (list.size() != 0){
            Song last = list.get(list.size()-1);
            list.remove(list.size()-1);
            System.out.println("Deleted last song");
            return last;
        }
        else return null;
    }

    public void addListener(){
        volumeSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                mediaPlayer.setVolume(volumeSlider.getValue() * 0.01);
            }
        });
    }

    @FXML
    public void ClickOnPlaylist(MouseEvent mouseEvent) {
        stopPlaying();
        File f = new File(songsOnPlaylistListView.getSelectionModel().getSelectedItem().getFilePath());
        mediaPlayer = new MediaPlayer(new Media(f.toURI().toString()));
        mediaPlayer.play();
        numberOfListener = 2;
        playingFromPlaylist = true;
        songsRecord.add(songsOnPlaylistListView.getSelectionModel().getSelectedItem());
        currentlyPlayingSongLabel.setText(songsOnPlaylistListView.getSelectionModel().getSelectedItem().getName());

    }

    @FXML
    public void ClickOnSongs(MouseEvent mouseEvent) {
        stopPlaying();
        File f = new File(songsListView.getSelectionModel().getSelectedItem().getFilePath());
        mediaPlayer = new MediaPlayer(new Media(f.toURI().toString()));
        mediaPlayer.play();
        numberOfListener = 1;
        playingFromSongs = true;
        songsRecord.add(songsListView.getSelectionModel().getSelectedItem());
        currentlyPlayingSongLabel.setText(songsListView.getSelectionModel().getSelectedItem().getName());
    }

    private void stopPlaying(){
        if (mediaPlayer != null || playingFromPlaylist || playingFromSongs){
            mediaPlayer.stop();
            playingFromPlaylist = false;
            playingFromSongs = false;
        }
    }

    // Handle Search Song TO BE IMPLEMENTED (Lack of time...)

    @FXML
    void searchSong(ActionEvent event) {

    }

    @FXML
    void searchSongTextField(ActionEvent event) {

    }
}
