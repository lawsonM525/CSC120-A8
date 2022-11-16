import java.util.ArrayList;
public class Person implements Contract {
    Inventory myInventory;// person's personal inventory
    Boolean awake;//whether the person is awake or not
    String name;//name of the person
    String[] size;//size of the person
    int[] coordinates;//coordinates of the person
    String lastAction;//last action taken by person
    ArrayList<String> undoableActions;


    /**
     * Constructor for objects of class Person
     */
    public Person(String name){
        this.myInventory = new Inventory();
        this.awake = true;
        this.name = name;
        this.size = new String[] {"small", "medium", "large"};
        this.coordinates = new int[] {0, 0, 0};
        this.lastAction = "spawned";
        this.undoableActions = new ArrayList<String>();//list of actions that can be undone
            undoableActions.add("grab");
            undoableActions.add("drop");
            undoableActions.add("rest");
            undoableActions.add("wake");
            undoableActions.add("walk");
            undoableActions.add("grow");
            undoableActions.add("shrink");
    }

    
    /** 
     * grabs an item from the room and puts it in the inventory
     * @param item item being grabbed
     */
    public void grab(String item){
        if (this.myInventory.content.containsKey(item)){//if the item is already in the inventory, increase the quantity
            this.myInventory.content.put(item, this.myInventory.content.get(item) + 1);//
            this.lastAction = "grab "+item;//update last action
        } else {//if the item is not in the inventory, add it
            this.myInventory.content.put(item, 1);
        }
    }

    
    /** 
     * drops item from inventory
     * @param item item being dropped
     * @return String declaring item being dropped
     */
    public String drop(String item){
        if (this.myInventory.content.containsKey(item)){//if the item is in the inventory, reduce quantity or remove it
            if (this.myInventory.content.get(item) > 1){
                this.myInventory.content.put(item, this.myInventory.content.get(item) - 1);
                this.lastAction = "drop " +item;//update last action
                return "You dropped " + item + ".";
            } else {
                this.myInventory.content.remove(item);
                this.lastAction = "drop "+item;
                return "You dropped " + item + ".";
            }
        }
        else{
            return "You don't have that item.";
        }
    }

    
    /** 
     * lets person move around on a plane
     * @param direction direction in which the person is moving
     * @return boolean whether the person moved or not
     */
    public boolean walk(String direction){
        if (direction.equals("north")){//if the person is moving north, increase y coordinate
            this.coordinates[1] += 1;
            this.lastAction = "walk north";
            return true;
        } else if (direction.equals("south")){//if the person is moving south, decrease y coordinate
            this.coordinates[1] -= 1;
            this.lastAction = "walk south";
            return true;
        } else if (direction.equals("east")){//if the person is moving east, increase x coordinate
            this.coordinates[0] += 1;
            this.lastAction = "walk east";
            return true;
        } else if (direction.equals("west")){//if the person is moving west, decrease x coordinate
            this.coordinates[0] -= 1;
            this.lastAction = "walk west";
            return true;
        } else {//if the person cannot move, return false
            System.out.println("Invalid direction");
            return false;
        }
    }

    /**
     * lets person teleport to a different location
     * @param x x coordinate
     * @param y y coordinate
     * @return T/F : Has the person just flown?
     */
    public boolean fly(int x, int y){
        this.coordinates[2] = 1;//person is now flying
        System.out.println("You are now flying");
        this.coordinates[0] = x;
        this.coordinates[1] = y;
        this.coordinates[2] = 0;//person is now on the ground
        System.out.println("You have landed at " + this.coordinates[0] + ", " + this.coordinates[1]);
        return true; // person has just flown
    }

    /**
     * changes current awake status to not awake
     */
    public void rest(){
        if (this.awake == true){//if the person is awake, change to not awake
            this.awake = false;
            System.out.println("Good night! You're sleeping now!");
            System.out.println("Zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
            this.lastAction ="rest";
        } else {
            System.out.println("You are already asleep");
        }
    }

    /**
     * wakes person up
     */
    public void wake(){
        if (this.awake == false){//if the person is not awake, change to awake
            this.awake = true;
            System.out.println("Good morning! You're awake now!");
            this.lastAction = "wake";
        } else {
            System.out.println("You are already awake");
        }
    }

    /**
     * reduce size
     * @return number of sizes reduced
     */
    public Number shrink(){
        if (this.size[0].equals("small")){//if the person is already small, do nothing
            System.out.println("You are already at your smallest size!");
            return 0;
        } else if (this.size[0].equals("medium")){//if the person is medium, change to small
            this.size[0] = "small";
            System.out.println("You are now small!");
            return 1;
        } else if (this.size[0].equals("large")){//if the person is large, change to medium
            System.out.println("lastAction");
            this.size[0] = "medium";
            System.out.println("You are now medium!");
            return 1;
        }
        else {
            System.err.println("Invalid size");
            return 0;
        }
    }

    /**
     * increase size
     * @return number of sizes increased
     */
    public Number grow(){
        if (this.size[0].equals("large")){
            System.out.println("You are already at your largest size!");
            return 0;
        } else if (this.size[0].equals("medium")){
            this.size[0] = "large";
            System.out.println("You are now large!");
            return 1;
        } else if (this.size[0].equals("small")){
            this.size[0] = "medium";
            System.out.println("You are now medium!");
            return 1;
        }
        else{
            System.err.println("Invalid size");
            return 0;
        }
    }

    /**
     * 
     */
    public void undo(){
        // if (this.lastAction in [""]){
        //     System.out.println("Previous action undone!");
        // }    
        
    }

    
    /** 
     * @param item
     */
    public void use(String item){
        if (this.myInventory.content.containsKey(item)){
            this.myInventory.content.remove(item);
        }
    }
   
    
    public void turnItemLeft(){
        System.out.println("Item turned left!");
    }

    public void turnItemRight(){
        System.out.println("Item turned right!");
    }

    public void turnItemUp(){
        System.out.println("Item turned up!");
    }

    public void turnItemDown(){
        System.out.println("Item turned down!");
    }

    
    /** 
     * @param item
     */
    public void examine(String item){
        System.out.println("You are examining the " + item + ".");
        turnItemDown();
        turnItemUp();
        turnItemLeft();
        turnItemRight();
    }

    public static void main(String[] args){
        Person player1 = new Person("Steve");//create a new person named Steve
        player1.grow();//grow Steve
        player1.grow();//grow Steve
        player1.shrink();//shrink Steve
        player1.shrink();//shrink Steve
        player1.shrink();//shrink Steve
        player1.fly(20,30);//fly Steve to 20, 30
    }


    
}
