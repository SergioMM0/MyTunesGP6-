package gui.controller;

import be.Playlist;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;


public class NewEditPlaylist {
    public TextField playlistname;
    public Button cancel1btn;
    public Button save1btn;
    private MainViewController controller;

    public void closeNEPWindow(MouseEvent mouseEvent) {

    }

    public void newPlaylist(MouseEvent mouseEvent) {

    }

    public void setParentController(MainViewController controller){
        this.controller = controller;
    }

    public void setPlaylistName(ObservableList<Playlist> selectedItems) {playlistname.setText(String.valueOf(selectedItems));
    }
}
