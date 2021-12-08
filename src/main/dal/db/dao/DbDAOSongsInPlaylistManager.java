package dal.db.dao;

import be.Playlist;
import be.Song;
import dal.db.DBConnectionProvider;
import dal.interfaces.ISongsInPlaylistManager;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbDAOSongsInPlaylistManager implements ISongsInPlaylistManager {

    private final DBConnectionProvider dbConnectionProvider;

    public DbDAOSongsInPlaylistManager() {
        dbConnectionProvider = new DBConnectionProvider();
    }

    @Override
    public void addSongToPlaylist(Playlist playlist, Song song) {
        String sql = "INSERT INTO SongsInPlaylist(IdOfPlaylist,IdOfSongInPlaylist) VALUES (?,?)";
        try (Connection connection = dbConnectionProvider.getConnection()) {
            PreparedStatement st = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            st.setInt(1, playlist.getId());
            st.setInt(2, song.getId());
            st.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Song> getSongsFromPlaylist(Playlist playlist) {
        List<Song> songsInPlaylist;
        List<Integer> idsOfSongsInPlaylist = new ArrayList<>();;
        String sql = "SELECT (IdOfSongInPlaylist) FROM SongsInPLaylist WHERE IdOfPlaylist = ?;";
        String sql2 = "SELECT * FROM Song WHERE Id = ?";
        try (Connection connection = dbConnectionProvider.getConnection()) {
            PreparedStatement st = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            st.setInt(1,playlist.getId());
            st.execute();
            ResultSet rs = st.getResultSet();
            while (rs.next()){
                idsOfSongsInPlaylist.add(rs.getInt("IdOfSongInPLaylist"));
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        for (int i = 1; i < idsOfSongsInPlaylist.size(); i++) {
            try (Connection connection = dbConnectionProvider.getConnection()){
                PreparedStatement st = connection.prepareStatement(sql2,Statement.RETURN_GENERATED_KEYS);
                st.setInt(1, idsOfSongsInPlaylist.get(i));//cuidao con las posiciones
                st.execute();
                ResultSet rs = st.getResultSet();

            }
            catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void updateSongsInPlaylist(int idOfPlaylist, String[] idOfSongs) {

    }
}
