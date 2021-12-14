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

    //add y delete deben funcionar. Last check 14.12 / 00:03

    @Override
    public void addSongToPlaylist(Playlist playlist, Song song) {
        int newPosition = 0;
        String sql2 = "SELECT TOP (1) [Position] FROM SongsInPLaylist WHERE IdOfPlaylist = ? AND [Position] > ? ORDER BY Position DESC";
        try (Connection connection = dbConnectionProvider.getConnection()) {
            PreparedStatement st = connection.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);
            st.setInt(1,playlist.getId());
            st.setInt(2,0);
            ResultSet rs =st.executeQuery();
            while (rs.next()){
                newPosition = rs.getInt("Position")+1;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        String sql = "INSERT INTO SongsInPlaylist(IdOfPlaylist,IdOfSongInPlaylist,Position) VALUES (?,?,?)";
        try (Connection connection = dbConnectionProvider.getConnection()) {
            PreparedStatement st = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            st.setInt(1, playlist.getId());
            st.setInt(2, song.getId());
            st.setInt(3, newPosition);
            st.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Song> getAllSongsFromPlaylist(Playlist playlist) {
        List<Song> songsInPlaylist = new ArrayList<>();
        String sql = "SELECT Song.Id AS SongID, Song.Title, Song.Artist, Song.Category, Song.Duration, Song.FilePath, SongsInPLaylist.[Position] FROM Song INNER JOIN SongsInPlaylist ON IdOfSongInPlaylist = Song.Id WHERE SongsInPLaylist.IdOfPlaylist = ? ORDER BY SongsInPlaylist.Position";
        try (Connection connection = dbConnectionProvider.getConnection()) {
            PreparedStatement st = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            st.setInt(1, playlist.getId());
            st.execute();
            ResultSet rs = st.getResultSet();
            while (rs.next()) {
                songsInPlaylist.add(new Song(rs.getInt("SongID"), rs.getString("Title"), rs.getString("Artist"), rs.getString("Category"), rs.getString("Duration"), rs.getString("FilePath"),rs.getInt("Position")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return songsInPlaylist;
    }

    @Override
    public void updateSongPosition(Playlist playlist, Song selected, Song pushed) {
        String sql = "UPDATE SongsInPlaylist SET POSITION = ? WHERE IdOfPlaylist = ? AND IdOfSongInPlaylist = ? AND Position = ?";
        try (Connection connection = dbConnectionProvider.getConnection()) {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1,pushed.getPosition());
            st.setInt(2,playlist.getId());
            st.setInt(3,selected.getId());
            st.setInt(4,selected.getPosition());
            st.addBatch();
            st.setInt(1,selected.getPosition());
            st.setInt(2,playlist.getId());
            st.setInt(3,pushed.getId());
            st.setInt(4,pushed.getPosition());
            st.addBatch();
            st.executeBatch();
            int temporalPosition = selected.getPosition();
            selected.setPosition(pushed.getPosition());
            pushed.setPosition(temporalPosition);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteSongOnPlaylist(Song song) {
        String sql = "DELETE * FROM SongsInPLaylist WHERE Position = ?";
        try (Connection connection = dbConnectionProvider.getConnection()) {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, song.getPosition());
            st.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void deleteRemainingSongs(Playlist playlist){
        String sql = "DELETE * FROM SongsInPlaylist WHERE IdOfPlaylist = ?";
        try(Connection connection = dbConnectionProvider.getConnection()){
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1,playlist.getId());
            st.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

}
