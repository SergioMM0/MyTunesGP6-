package be;

public class Playlist {
    private int id;
    private String name;
    private String idOfSongsInPlaylist;
    private int howManySongs;
    private String totalReproductionTime;

    public Playlist(int id, String name, String idOfSongsInPlaylist, int howManySongs, String totalReproductionTime) {
        this.id = id;
        this.name = name;
        this.idOfSongsInPlaylist = idOfSongsInPlaylist;
        this.howManySongs = howManySongs;
        this.totalReproductionTime = totalReproductionTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdOfSongsInPlaylist() {
        return idOfSongsInPlaylist;
    }

    public int getHowManySongs() {
        return howManySongs;
    }

    public void setHowManySongs(int howManySongs) {
        this.howManySongs = howManySongs;
    }

    public String getTotalReproductionTime() {
        return totalReproductionTime;
    }

    public void setTotalReproductionTime(String totalReproductionTime) {
        this.totalReproductionTime = totalReproductionTime;
    }

    @Override
    public String toString() {
        return id + "  " +
                name + "  " +
                idOfSongsInPlaylist + "  " +
                howManySongs + "  " +
                totalReproductionTime;
    }
}
