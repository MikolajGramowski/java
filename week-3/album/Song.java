package album;

class Song {
    private String title;
    private int playTime;
    private int playCount;

    public Song(String title, int playTime) {
        this.title = title;
        this.playTime = playTime;
        this.playCount = 0;
    }

    public void play() {
        playCount++;
    }

    public int getPlayCount() {
        return playCount;
    }

    public int getPlayTime() {
        return playTime;
    }

    public String getTitle() {
        return title;
    }
}
