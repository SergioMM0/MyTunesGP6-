//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package gui.controller;

import be.Playlist;
import be.Song;
import com.sun.tools.javac.Main;
import gui.model.SongModel;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

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

    public MainViewController() {
    }

    @FXML
    protected void onHelloButtonClick() {
        this.songModel.getAllSongs();
    }

    public void playSong(MouseEvent mouseEvent) {
        this.songModel.playSong(this.songListFromPlayList.getSelectionModel().getSelectedItems());
    }

    public void previousSong(MouseEvent mouseEvent) {
        if (this.songListFromPlayList.getSelectionModel().getSelectedIndex() > -1) {
            this.songModel.previousSong((Song)this.songListFromPlayList.getItems().get(this.songListFromPlayList.getSelectionModel().getSelectedIndex() - 1));
        }

    }

    public void nextSong(MouseEvent mouseEvent) {
        if (this.songListFromPlayList.getSelectionModel().getSelectedIndex() > -1) {
            this.songModel.nextSong((Song)this.songListFromPlayList.getItems().get(this.songListFromPlayList.getSelectionModel().getSelectedIndex() + 1));
        }

    }

    public void changeVolume(DragEvent dragEvent) {
    }

    public void showResult(KeyEvent keyEvent) {
        this.songTableList.setItems(this.songModel.getResult(this.searchfilter.getText()));
    }

    public void addSong(MouseEvent mouseEvent) {
        this.songListFromPlayList.getItems().add((Song)this.songTableList.getSelectionModel().getSelectedItem());
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
        Parent root = (Parent)loader.load();
        NewEditPlaylist newPlaylist = (NewEditPlaylist)loader.getController();
        newPlaylist.setParentController(this);
        Stage stage = new Stage();
        stage.setTitle("New Playlist");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void editPlaylist(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("NewEditPlaylist"));
        Parent root = (Parent)loader.load();
        NewEditPlaylist newPlaylist = (NewEditPlaylist)loader.getController();
        newPlaylist.setPlaylistName(this.playlistList.getSelectionModel().getSelectedItems());
        newPlaylist.setParentController(this);
        Stage stage = new Stage();
        stage.setTitle("Edit Playlist");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void deletePlaylist(ActionEvent actionEvent) {
    }
}