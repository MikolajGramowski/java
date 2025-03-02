package album;

import java.util.ArrayList;
import java.util.List;

class Album {
    private String artist;
    private String name;
    private List<Song> songs;

    public Album(String artist, String name) {
        this.artist = artist;
        this.name = name;
        this.songs = new ArrayList<>();
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public Song getMostPopularSong() {
        if (songs.isEmpty())
            return null;

        Song mostPlayed = songs.get(0);
        for (Song song : songs) {
            if (song.getPlayCount() > mostPlayed.getPlayCount()) {
                mostPlayed = song;
            }
        }
        return mostPlayed;
    }

    public int getTotalPlayTime() {
        int total = 0;
        for (Song song : songs) {
            total += song.getPlayTime();
        }
        return total;
    }

    public boolean isRoadTripWorthy() {
        return getTotalPlayTime() > 3600;
    }

    public List<Song> filterSongsByTitle(String keyword) {
        List<Song> filteredSongs = new ArrayList<>();
        for (Song song : songs) {
            if (song.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                filteredSongs.add(song);
            }
        }
        return filteredSongs;
    }
}
