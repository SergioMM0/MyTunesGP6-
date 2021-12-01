package dal.db.dao;

import be.Song;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import dal.db.DBConnectionProvider;
import dal.interfaces.ISongRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DbDAOSong implements ISongRepository {

    private final DBConnectionProvider connectionProvider = new DBConnectionProvider();

    @Override
    public Song addSong(int id, String name, String artist, String category, int duration,String filePath) throws SQLException {
        String sql = ("INSERT INTO song VALUES (?,?,?,?,?,?)");
        Song addedSong = null;
        try (Connection connection = connectionProvider.getConnection()) {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.setString(2, name);
            st.setString(3, artist);
            st.setString(4, category);
            st.setInt(5, duration);
            st.setString(6, filePath);
            boolean execute = st.execute();
            if (!execute) {
                addedSong = new Song(id, name, artist, category, duration, filePath);
            }
        } catch (SQLServerException throwables) {
            throwables.printStackTrace();
        }
        return addedSong;
    }

    @Override
    public void deleteSong(Song song) throws SQLServerException {
        String sql = ("DELETE FROM Song WHERE id = ?");


        try (Connection connection = connectionProvider.getConnection()){
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1,);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void updateSong(Song song) {

    }

    @Override
    public Song getSong(int id) {
        return null;
    }

    @Override
    public List<Song> getAllSongs() {
        return null;
    }
}
