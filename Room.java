import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */
public class Room
{
    private String description;
    private HashMap<String, Room> exits;
    private List<Item> items;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description)
    {
        this.description = description;
        exits = new HashMap<String, Room>();
        items = new ArrayList<>();
    }
    /**
     * Define the exits of this room. Every direction either
     * leads to another room or is null (no exit there).
     */
    public void setExit(String direction, Room neighbor)
    {
        exits.put(direction, neighbor);
    }
    /**
     * Return the room that is reached if we go from this
     * room in direction "direction "If there is no room in
     * that direction, return null.
     */
    public Room getExit(String direction)
    {
        return exits.get(direction);
    }

    public String getExitString() {

        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }
    /**
     * Return the description of the room (the one that was
     * defined in the constructor).
     */
    public String getDescription()
    {
        return description;
    }

    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString() + ".\n" + "You see the following items on the ground: " + getallItems();
    }

    public void addItem(String name, String description){
        items.add(new Item(name, description));
    }
    public void removeItem(Item item){
        items.remove(item);
    }

    public String getallItems(){
        String s = "";
        for (Item item : items)
        {
            s = s +"\n" + item.description;
        }
        return s;
    }

    public List<Item> getItems(){
        return items;
    }
}
