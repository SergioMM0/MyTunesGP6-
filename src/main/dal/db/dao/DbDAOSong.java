package dal.db.dao;

import be.Song;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import dal.db.DBConnectionProvider;
import dal.interfaces.ISongRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbDAOSong implements ISongRepository {

    private final DBConnectionProvider connectionProvider = new DBConnectionProvider();

    @Override
    public List<Song> getAllSongs() {
        List<Song> allSongs = new ArrayList<>();
        String sql = ("SELECT * FROM Song");
        try (Connection connection = connectionProvider.getConnection()){
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                allSongs.add(new Song (rs.getInt("Id"),
                        rs.getString("Title"),
                        rs.getString("Artist"),
                        rs.getString("Category"),
                        rs.getInt("Duration"),
                        rs.getString("FilePath")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return allSongs;
    }

    @Override
    public Song addSong(Song song) throws SQLException {
        Song addedSong = null;
        String sql = ("INSERT INTO Song(Title, Artist, Category, Duration, FilePath) VALUES (?,?,?,?,?)");
        try (Connection connection = connectionProvider.getConnection()) {
            PreparedStatement st = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            st.setString(1, song.getName());
            st.setString(2, song.getArtist());
            st.setString(3, song.getCategory());
            st.setInt(4, song.getDuration());
            st.setString(5, song.getFilePath());
            st.execute();
            ResultSet rs = st.getGeneratedKeys();
            rs.next();
                addedSong = new Song(rs.getInt(1 ),song.getName(), song.getArtist(),
                            song.getCategory(), song.getDuration(), song.getFilePath());
        } catch (SQLServerException throwables) {
            throwables.printStackTrace();
        }
        return addedSong;
    }

    @Override
    public void deleteSong(Song song) {
        String sql = ("DELETE FROM Song WHERE id = ?");
        int id = song.getId();
        try (Connection connection = connectionProvider.getConnection()){
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1,id);
            st.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void updateSong(Song song) throws SQLException {
        String sql = ("UPDATE Song SET Title = ? , Artist = ? , Category = ? , Duration = ? , FilePath = ? WHERE Id = ?");
        int id = song.getId();
        String name = song.getName();
        String artist = song.getArtist();
        String category = song.getCategory();
        int duration = song.getDuration();
        String filepath = song.getFilePath();
        try(Connection connection = connectionProvider.getConnection()){
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1,name);
            st.setString(2,artist);
            st.setString(3,category);
            st.setInt(4,duration);
            st.setString(5,filepath);
            st.setInt(6,id);
            st.execute();
        } catch (SQLServerException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Song getSong(int id) throws SQLException {
        Song songSearched = null;
        String sql = ("SELECT * FROM SONG WHERE id=?");
        try(Connection connection = connectionProvider.getConnection()){
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1,id);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                songSearched = new Song(
                        rs.getInt("Id"),
                        rs.getString("Title"),
                        rs.getString("Artist"),
                        rs.getString("Category"),
                        rs.getInt("Duration"),
                        rs.getString("FilePath")
                );
            }
        } catch (SQLServerException throwables) {
            throwables.printStackTrace();
        }
        return songSearched;
    }
}
