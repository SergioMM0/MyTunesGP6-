package dal.interfaces;

import be.Song;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.SQLException;
import java.util.List;

public interface ISongRepository {

    Song addSong(int id, String name, String artist, String category, int duration,String filePath)throws SQLException;

    void deleteSong(Song song) throws SQLServerException;

    void updateSong(Song song);

    Song getSong(int id);

    List<Song> getAllSongs();

}
