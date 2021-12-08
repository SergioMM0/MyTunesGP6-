package dal.db.dao;

import be.Playlist;
import be.Song;
import dal.db.DBConnectionProvider;
import dal.interfaces.ISongsInPlaylistManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DbDAOSongsInPlaylistManager implements ISongsInPlaylistManager {

    private final DBConnectionProvider dbConnectionProvider;

    public DbDAOSongsInPlaylistManager(){
        dbConnectionProvider = new DBConnectionProvider();
    }

    @Override
    public Song addSongToPlaylist(Playlist playlist,Song song) {
        String sql = "INSERT INTO SongsInPlaylist(IdOfPlaylist,IdOfSongInPlaylist) VALUES (?,?)";
        try(Connection connection = dbConnectionProvider.getConnection()){
            PreparedStatement st = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            String playlistId = String.valueOf(playlist.getId());
            String songId = String.valueOf(song.getId());
            st.setString(1,playlistId);
            st.setString(2,songId);
            //Tofinish

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public List<Song> getSongsFromPlaylist(int idOfPlaylist) {
        return null;
    }

    @Override
    public void updateSongsInPlaylist(int idOfPlaylist, String[] idOfSongs) {

    }
}
