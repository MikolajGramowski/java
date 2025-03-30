package com.nhlstenden.exam;

import java.util.HashSet;

public class Team
{
    private HashSet<Player> players;
    private String name;

    public Team(HashSet<Player> players, String name)
    {
        this.players = players;
        this.name = name;
    }

    public HashSet<Player> getPlayers()
    {
        return players;
    }

    public void setPlayers(HashSet<Player> players)
    {
        this.players = players;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
