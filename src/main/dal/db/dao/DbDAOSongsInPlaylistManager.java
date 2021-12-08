package dal.db.dao;

import be.Playlist;
import be.Song;
import dal.db.DBConnectionProvider;
import dal.interfaces.ISongsInPlaylistManager;

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
        List<Song> songsInPlaylist = new ArrayList<>();
        List<Integer> idsOfSongsInPlaylist = new ArrayList<>();
        String sql = "SELECT (IdOfSongInPlaylist) FROM SongsInPLaylist WHERE IdOfPlaylist = ?;";
        try (Connection connection = dbConnectionProvider.getConnection()) {
            PreparedStatement st = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            st.setInt(1, playlist.getId());
            st.execute();
            ResultSet rs = st.getResultSet();
            while (rs.next()) {
                idsOfSongsInPlaylist.add(rs.getInt("IdOfSongInPLaylist"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String sql2 = "SELECT Song.Id AS SongID, Song.Title, Song.Artist, Song.Category, Song.Duration, Song.FilePath FROM Song INNER JOIN SongsInPlaylist ON IdOfSongInPlaylist = Song.Id WHERE SongsInPLaylist.IdOfPlaylist = ?;";
        try (Connection connection = dbConnectionProvider.getConnection()) {
            PreparedStatement st = connection.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);
            st.setInt(1,playlist.getId());
            st.execute();
            ResultSet rs = st.getResultSet();
            while (rs.next()){
                songsInPlaylist.add(new Song(rs.getInt("SongID"),rs.getString("Title"),rs.getString("Artist"),rs.getString("Category"),rs.getString("Duration"),rs.getString("FilePath")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return songsInPlaylist;
    }

    @Override
    public void deleteSongOnPlaylist(Song song) {
        String sql = "DELETE FROM SongsInPLaylist WHERE IdOfSongInPlaylist = ?";
    }

}
