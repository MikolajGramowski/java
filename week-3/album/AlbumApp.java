package album;

import java.util.List;

public class AlbumApp {
    public static void main(String[] args) {
        Album album = new Album("Pink Floyd", "The Dark Side of the Moon");

        Song song1 = new Song("Time", 412);
        Song song2 = new Song("Money", 382);
        Song song3 = new Song("Us and Them", 462);

        album.addSong(song1);
        album.addSong(song2);
        album.addSong(song3);

        song1.play();
        song1.play();
        song2.play();

        System.out.println("Most popular song: " + album.getMostPopularSong().getTitle());
        System.out.println("Total play time: " + album.getTotalPlayTime() + " seconds");
        System.out.println("Road trip worthy? " + (album.isRoadTripWorthy() ? "Yes" : "No"));

        List<Song> filteredSongs = album.filterSongsByTitle("time");
        System.out.println("Songs with 'time' in title:");
        for (Song song : filteredSongs) {
            System.out.println("- " + song.getTitle());
        }
    }
}
