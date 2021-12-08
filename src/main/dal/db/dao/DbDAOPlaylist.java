package dal.db.dao;

import be.Playlist;
import be.Song;
import dal.db.DBConnectionProvider;
import dal.interfaces.IPLaylistRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbDAOPlaylist implements IPLaylistRepository {

    private final DBConnectionProvider connectionProvider;

    public DbDAOPlaylist(){
         connectionProvider = new DBConnectionProvider();
    }

    /**
     * Collect all Playlist from database
     * @return List of PLaylist
     */
    @Override
    public List<Playlist> getAllPlaylist() {
        List<Playlist> allPlaylists = new ArrayList<>();
        String sql = ("SELECT * FROM Playlist");
        try (Connection connection = connectionProvider.getConnection()) {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                allPlaylists.add(new Playlist(rs.getInt("Id"),
                        rs.getString("Title"),
                        rs.getInt("NumberOfSongs"),
                        rs.getString("TotalReproductionTime")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return allPlaylists;
    }

    /**
     * Adds a Playlist to the database based on name
     * @param name
     * @return Playlist
     */

    @Override
    public Playlist addPlaylist(String name) {
        Playlist addedPLaylist = null;
        String sql = "INSERT INTO Playlist (Title, NumberOfSongs, TotalReproductionTime) " +
                "VALUES (? , ? , ?)";
        try (Connection connection = connectionProvider.getConnection()) {
            PreparedStatement st = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            st.setString(1, name);
            st.setInt(2, 0);
            st.setInt(3, 0);
            st.execute();
            ResultSet rs = st.getGeneratedKeys();
            rs.next();
            addedPLaylist = new Playlist(rs.getInt(1), name, 0, "0");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return addedPLaylist;
    }

    @Override
    public void deletePlaylist(Playlist playlist) {
        String sql = "DELETE FROM Playlist WHERE Id=?";
        int id = playlist.getId();
        try (Connection connection = connectionProvider.getConnection()) {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void renamePlaylist(Playlist playlist) {
        String renamed = playlist.getName();
        int id = playlist.getId();
        String sql = "UPDATE Playlist SET Title = ? WHERE Id = ?";
        try (Connection connection = connectionProvider.getConnection()) {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, renamed);
            st.setInt(2, id);
            st.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Playlist getPlaylist(int id) {
        Playlist searched = null;
        String sql = "SELECT * FROM Playlist WHERE Id=?";
        try (Connection connection = connectionProvider.getConnection()) {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                searched = new Playlist(rs.getInt("Id"),
                        rs.getString("Title"),
                        rs.getInt("NumberOfSongs"),
                        rs.getString("TotalReproductionTime"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return searched;
    }

    @Override
    public Playlist updatePlaylist(Playlist playlist) {
        String sql = "UPDATE Playlist SET Title = ?, NumberOfSongs = ? , TotalReproductionTime = ? WHERE Id = ?;";
        try (Connection connection = connectionProvider.getConnection()) {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1,playlist.getName());
            st.setInt(2,playlist.getHowManySongs());
            st.setString(3,playlist.getTotalReproductionTime());
            st.setInt(4,playlist.getId());
            st.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return new Playlist(playlist.getId(), playlist.getName(), playlist.getHowManySongs(), playlist.getTotalReproductionTime());
    }
}
