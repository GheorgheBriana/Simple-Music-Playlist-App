import java.util.ArrayList;
import java.util.List;

public class Playlist {
    // camp static pt instanta unica, tine obiectul unic
    private static Playlist instance;
    private List<Song> songs;

    // constructor privat
    private Playlist() {
        songs = new ArrayList<>();
    }

    // metoda statica pt obtinere instanta
    public static Playlist getInstance() {
        if(instance == null) {
            instance = new Playlist();
        }
        return instance;
    }

    // metoda adaugare cantec in playlist
    public void addSong(Song song) {
        if(songs.size() >= 30) {
            System.out.println("Playlist-ul este plin. Nu se mai pot adauga mai mult de 30 de cantece.");
            return;
        }

        songs.add(song);
        System.out.println("Cantecul a fost adaugat in lista.");
    }

    // afisare cantece din playlist
    public void displaySongs() {
        if(songs.isEmpty()) {
            System.out.println("Playlistul este gol.");
            return;
        }

        for(int i = 0; i < songs.size(); i++) {
            Song song = songs.get(i);
            System.out.println((i+1) + ". " + song.getTitle() + " - " + song.getArtist());
        }
    }

    public void removeSongByTitle(String title) {
        for(int i = 0; i < songs.size(); i++) {
            if(songs.get(i).getTitle().equalsIgnoreCase(title)) {
                songs.remove(i);
                System.out.println("Cantecul: " + title + " a fost sters.");
            }
        }
    }
}
