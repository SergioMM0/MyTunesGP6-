package bll;

import be.Playlist;
import be.Song;
import dal.MyTunesDalController;
import dal.MyTunesDalFacade;

import java.sql.SQLException;
import java.util.List;

/**
 * Author: Sergio M.
 * @SergioMM0 on GitHub
 */

public class MyTunesLogicController implements MyTunesLogicFacade {

    private final MyTunesDalFacade dalFacade;

    public MyTunesLogicController() {
        dalFacade = new MyTunesDalController();
    }

    @Override
    public List<Song> getAllSongs() {
        return dalFacade.getAllSongs();
    }

    @Override
    public Song addSong(Song song) throws SQLException {
        return dalFacade.addSong(song);
    }

    @Override
    public void deleteSong(Song song) {
        dalFacade.deleteSong(song);
    }

    @Override
    public void updateSong(Song song) throws SQLException {
        dalFacade.updateSong(song);
    }

    @Override
    public List<String> getCategories() {
        return dalFacade.getCategories();
    }

    @Override
    public List<Playlist> getAllPlaylist() {
        return dalFacade.getAllPlaylist();
    }

    @Override
    public void addPlaylist(String name) {
        dalFacade.addPlaylist(name);
    }

    @Override
    public void deletePlaylist(Playlist playlist) {
        dalFacade.deletePlaylist(playlist);
    }

    @Override
    public void renamePlaylist(Playlist playlist) {
        dalFacade.renamePlaylist(playlist);
    }

    @Override
    public Playlist getPlaylist(int id) {
        return dalFacade.getPlaylist(id);
    }

    @Override
    public List<Song> getAllSongsInPlaylist(Playlist playlist) {
        return dalFacade.getAllSongsInPlaylist(playlist);
    }

    @Override
    public void updateSongPosition(Playlist playlist, Song selected, Song pushed){
        dalFacade.updateSongPosition(playlist,selected,pushed);
    }

    @Override
    public void deleteSongOnPlaylist(Playlist playlist, Song song) {
        subtractDuration(playlist,song);
        dalFacade.deleteSongOnPlaylist(playlist,song);
        if (playlist.getHowManySongs()==0){
            playlist.setHowManySongs(0);
        }
        else playlist.setHowManySongs(playlist.getHowManySongs()-1);
        dalFacade.updatePlaylist(playlist);

    }

    @Override
    public void addSongToPlaylist(Playlist playlist, Song song) {
        addDuration(playlist,song);
        dalFacade.addSongToPlaylist(playlist,song);
        playlist.setHowManySongs(playlist.getHowManySongs()+1);
        dalFacade.updatePlaylist(playlist);
    }

    @Override
    public void deleteRemainingSongs(Playlist playlist){
        dalFacade.deleteRemainingSongs(playlist);
    }

    private void addDuration(Playlist playlist,Song song){
        int durationPlaylist = getDurationOfPlaylist(playlist);
        int durationSong = getDurationOfSong(song);
        int result = durationPlaylist + durationSong;
        String totalRepTime = parseToTime(result);
        playlist.setTotalReproductionTime(totalRepTime);
    }

    private void subtractDuration(Playlist playlist,Song song){
        int durationPlaylist = getDurationOfPlaylist(playlist);
        int durationSong = getDurationOfSong(song);
        int result = durationPlaylist - durationSong;
        String totalRepTime = parseToTime(result);
        playlist.setTotalReproductionTime(totalRepTime);
    }

    private int getDurationOfPlaylist(Playlist playlist){
        String playlistTotalTime = playlist.getTotalReproductionTime();
        String[] pSplit = playlistTotalTime.split(":");
        int hourInS = Integer.parseInt(pSplit[0])*3600;
        int minInS = Integer.parseInt(pSplit[1])*60;
        int seconds = Integer.parseInt(pSplit[2]);
        int total = hourInS+minInS+seconds;
        System.out.println("Playlist actual rep time: " + total);
        return total;
    }

    private int getDurationOfSong(Song song){
        String duration = song.getDuration();
        String[] split = duration.split(":");
        int songInSeconds = (Integer.parseInt(split[0])*60) + Integer.parseInt(split[1]);
        System.out.println("Song rep time: "+ songInSeconds);
        return songInSeconds;
    }

    private String parseToTime(int seconds){
        int totalSec = seconds % 60;
        int totalMin = (seconds/60)%60;
        int totalHour = seconds /3600;
        String fixedH;
        String fixedM;
        String fixedS;
        if (10>totalHour){
            fixedH = "0" + totalHour;
        }
        else fixedH = String.valueOf(totalHour);
        if (10>totalMin){
            fixedM = "0"+ totalMin;
        }
        else fixedM = String.valueOf(totalMin);
        if (10> totalSec){
            fixedS = "0"+ totalSec;
        }
        else fixedS = String.valueOf(totalSec);
        String totalRepTime = fixedH + ":" + fixedM + ":" + fixedS;
        System.out.println(totalRepTime);
        return totalRepTime;
    }
}
