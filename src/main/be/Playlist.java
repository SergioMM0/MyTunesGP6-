package be;

public class Playlist {
    private static int id;
    private static String name;

    public Playlist(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Playlist.id = id;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Playlist.name = name;
    }
}
