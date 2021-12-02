package be;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private int id;
    private String name;
    List<Song> listOfSongs;
    private int howManySongs;
    private int totalReproductionTime;

    public Playlist(int id, String name, List<Song> songsInPlaylist, int howManySongs, int totalReproductionTime) {
        this.id = id;
        this.name = name;
        listOfSongs = songsInPlaylist;
        this.howManySongs = howManySongs;
        this.totalReproductionTime = totalReproductionTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Song> getListOfSongs(){
        listOfSongs = new ArrayList<>();
        return listOfSongs;
    }

    public void addSongToPlaylist(Song song){
        List<Song> list = getListOfSongs();
        list.add(song);
    }

    public void deleteSongFromPlaylist(Song song){
        List<Song> list = getListOfSongs();
        list.remove(song);
    }
    public int getHowManySongs(){
        List<Song> list = getListOfSongs();
        for (Song song : list){
            howManySongs++;
        }
        return howManySongs;
    }
    //TODO implement total duration
}
