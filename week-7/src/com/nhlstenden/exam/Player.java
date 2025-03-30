package com.nhlstenden.exam;

import java.util.UUID;

public class Player
{
    private String name;
    private int jerseyNumber;
    private UUID id = UUID.randomUUID();

    public Player(String name, int jerseyNumber)
    {
        this.name = name;
        this.jerseyNumber = jerseyNumber;
    }

    public String getName()
    {
        return name;
    }

    public UUID getId()
    {
        return id;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getJerseyNumber()
    {
        return jerseyNumber;
    }

    public void setJerseyNumber(int jerseyNumber)
    {
        this.jerseyNumber = jerseyNumber;
    }

}
