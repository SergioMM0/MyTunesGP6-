package gui.model;

import be.Song;

import java.util.ArrayList;
import java.util.List;

public class SongModel {
    // Static variable reference of single_instance
    // of type Singleton
    private static SongModel single_instance = null;

    // Declaring a variable of type String
    private List<Song> cachedSongs;

    // Constructor
    // Here we will be creating private constructor
    // restricted to this class itself
    private SongModel()
    {
        cachedSongs = new ArrayList<>();
        //cahcedSongs = bllInterface.getAllSongs;
    }

    // Static method
    // Static method to create instance of Singleton class
    public static SongModel getInstance()
    {
        if (single_instance == null)
            single_instance = new SongModel();

        return single_instance;
    }

    public List<Song> getAllSongs(){
        return cachedSongs;
    }

}
