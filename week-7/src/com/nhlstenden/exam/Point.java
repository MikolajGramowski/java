package com.nhlstenden.exam;

import java.time.LocalDateTime;

public class Point
{
    private Player player;
    private LocalDateTime timeScored;

    public Point(Player player, LocalDateTime timeScored)
    {
        this.player = player;
        this.timeScored = timeScored;
    }

    public Player getPlayer()
    {
        return player;
    }

    public void setPlayer(Player player)
    {
        this.player = player;
    }

    public LocalDateTime getTimeScored()
    {
        return timeScored;
    }

    public void setTimeScored(LocalDateTime timeScored)
    {
        this.timeScored = timeScored;
    }
}
