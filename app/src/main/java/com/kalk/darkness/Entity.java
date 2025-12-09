package com.kalk.darkness;

public class Entity
{
    protected Game game;
    public String tile;
    public GameVec position;

    public GameVec getPosition() {
        return position;
    }

    public void setPosition(GameVec position) {
        this.position = position;
    }
    
    public Game getGame()
    {
        return game;
    }

    public void setGame(Game game)
    {
        this.game = game;
    }

    public Entity(Game _game, String _tile)
    {
        this.game = _game;
        this.tile = _tile;
    }

    public static boolean isWalkable(String[][] map, GameVec position, int type)
    {
        String cell = map[position.getY()][position.getX()];

        if (type == 0)
        {
            if (position.getY() < 0 || position.getX() < 0 || position.getY() >= map.length || position.getX() >= map[0].length)
                return false;

            if (cell.equals("empty_tile") || cell.equals("gonchaja_territory_tile") || cell.equals("river_tile") || cell.equals("bushes_tile"))
                return true;
        }

        else if (type == 1)
        {
            if (position.getY() < 0 || position.getX() < 0 || position.getY() >= map.length || position.getX() >= map[0].length)
                return false;

            if (!cell.equals("wall_tile"))
                return true;
        }

        return false;
    }

    public void movement(Direction direction, String[][] map)
    {
        this.position = position.offSet(this.position, direction, 1);
    }

    public void onPlayerCollision(String difficulty)
    {
        game.endGame();
    }

    public boolean playerCanExit()
    {
        return true;
    }
    
    public void tick()
    {
        
    }
}