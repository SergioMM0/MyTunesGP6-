package dal.db.dao;

import be.Playlist;
import be.Song;
import dal.db.DBConnectionProvider;
import dal.interfaces.IPLaylistRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public class DbDAOPlaylist implements IPLaylistRepository {

    private final DBConnectionProvider connectionProvider = new DBConnectionProvider();

    @Override
    public Playlist addPlaylist(int id, String name) {
        Playlist addedPLaylist = null;
        String sql = "INSERT INTO Playlist (Id , Name, IdOfSongsInPLaylist, NumberOfSongs, TotalReproductionTime ) VALUES (? , ? , ? , ? , ?)";
        try (Connection connection = connectionProvider.getConnection()) {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1,id);
            st.setString(2,name);
            st.setInt(3,0);
            st.setInt(4,0);
            st.setInt(5, 0);
            int executed = st.executeUpdate();
            if(executed == 0 ){
                addedPLaylist = new Playlist(id, name, 0, 0,0);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return addedPLaylist;
    }

    @Override
    public void deletePlaylist(Playlist playlist) {

    }

    @Override
    public void renamePlaylist(Playlist playlist) {

    }

    @Override
    public Playlist getPlaylist(int id) {
        return null;
    }

    @Override
    public Playlist addSongToPlaylist(Song song) {
        return null;
    }
}
