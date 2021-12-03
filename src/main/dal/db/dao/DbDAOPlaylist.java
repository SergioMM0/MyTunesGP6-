package dal.db.dao;

import be.Playlist;
import be.Song;
import dal.db.DBConnectionProvider;
import dal.interfaces.IPLaylistRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DbDAOPlaylist implements IPLaylistRepository {

    private final DBConnectionProvider connectionProvider = new DBConnectionProvider();

    @Override
    public List<Playlist> getAllPlaylist() {
        List<Playlist> allPlaylists = new ArrayList<>();
        String sql = ("SELECT * FROM Playlist");
        try (Connection connection = connectionProvider.getConnection()){
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                allPlaylists.add(new Playlist (rs.getInt("Id"),
                        rs.getString("Name"),
                        rs.getString("IdOfSongsInPLaylist"),
                        rs.getInt("NumberOfSongs"),
                        rs.getInt("TotalReproductionTime")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return allPlaylists;
    }

    @Override
    public Playlist addPlaylist(int id, String name) {
        Playlist addedPLaylist = null;
        String sql = "INSERT INTO Playlist (Id , Name, IdOfSongsInPLaylist, NumberOfSongs, TotalReproductionTime) " +
                "VALUES (? , ? , ? , ? , ?)";
        try (Connection connection = connectionProvider.getConnection()) {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1,id);
            st.setString(2,name);
            st.setString(3,"0");
            st.setInt(4,0);
            st.setInt(5, 0);
            st.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        addedPLaylist = new Playlist(id, name, "0", 0,0);
        return addedPLaylist;
    }

    @Override
    public void deletePlaylist(Playlist playlist) {
        String sql = "DELETE FROM Playlist WHERE Id=?";
        int id = playlist.getId();
        try (Connection connection = connectionProvider.getConnection()){
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1,id);
            st.executeUpdate();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void renamePlaylist(Playlist playlist) {
        String renamed = playlist.getName();
        int id = playlist.getId();
        String sql = "UPDATE Playlist SET Name = ? WHERE Id = ?";
        try (Connection connection = connectionProvider.getConnection()){
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1,renamed);
            st.setInt(2,id);
            st.executeUpdate();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Playlist getPlaylist(int id) {
        Playlist searched = null;
        String sql = "SELECT * FROM Playlist WHERE Id=?";
        try (Connection connection = connectionProvider.getConnection()){
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1,id);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                searched = new Playlist(rs.getInt("Id"),
                        rs.getString("Name"),
                        rs.getString("IdOfSongsInPLaylist"),
                        rs.getInt("NumberOfSongs"),
                        rs.getInt("TotalReproductionTime"));
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return searched;
    }

    @Override
    public Playlist getSongsFromPlaylist(Playlist playlist) {
        Playlist recollected = null;
        int id = playlist.getId();
        String sql = "SELECT IdOfSongsInPLaylist FROM Playlist WHERE Id = ?";
        try (Connection connection = connectionProvider.getConnection()){
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1,id);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                recollected = new Playlist(playlist.getId(),playlist.getName(),
                        rs.getString("IdOfSongsInPLaylist"), playlist.getHowManySongs(),
                        playlist.getTotalReproductionTime());
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return recollected;
    }

    @Override
    public Playlist addSongToPlaylist(Playlist playlist,Song song) {
            Playlist finalPlaylist = null;
            String idOfSongs = playlist.getIdOfSongsInPlaylist();
            String idOfNewSong = String.valueOf(song.getId());
            int idOfPlaylist = playlist.getId();
            String sql = "UPDATE Playlist (IdOfSongsInPLaylist) VALUE(?) WHERE Id=?;";
        try (Connection connection = connectionProvider.getConnection()){
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1,idOfSongs+","+idOfNewSong);
            st.setInt(2,idOfPlaylist);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                finalPlaylist = new Playlist(playlist.getId(),playlist.getName(),
                        rs.getString("IdOfSongsInPLaylist"),playlist.getHowManySongs(),
                        playlist.getTotalReproductionTime());
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return finalPlaylist;
    }
}
