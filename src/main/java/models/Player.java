package models;

public class Player
{
    private String name;
    private int life = 5;

    public Player(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
}
