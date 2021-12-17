package be;

public class Song {

    private int id;
    private String name;
    private String artist;
    private String category;
    private String duration;
    private String filePath;
    private int position;

    public Song(int id, String name, String artist, String category, String duration,String filePath,int position) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.category = category;
        this.duration = duration;
        this.filePath = filePath;
        this.position = position;
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

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return id + "  " +
                name + "  " +
                artist + "  " +
                category + "  " +
                duration + "  " +
                filePath;
    }
}
