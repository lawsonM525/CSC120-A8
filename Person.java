public class Person implements Contract {
    Inventory myInventory;// person's personal inventory
    Boolean awake;//whether the person is awake or not
    String name;//name of the person
    String[] size;//size of the person
    int[] coordinates;//coordinates of the person


    /**
     * Constructor for objects of class Person
     */
    public Person(String name){
        this.myInventory = new Inventory();
        this.awake = true;
        this.name = name;
        this.size = new String[] {"small", "medium", "large"};
        this.coordinates = new int[] {0, 0, 0};
    }

    
    /** 
     * grabs an item from the room and puts it in the inventory
     * @param item item being grabbed
     */
    public void grab(String item){
        if (this.myInventory.content.containsKey(item)){
            this.myInventory.content.put(item, this.myInventory.content.get(item) + 1);
        } else {
            this.myInventory.content.put(item, 1);
        }
    }

    
    /** 
     * drops item from inventory
     * @param item item being dropped
     * @return String declaring item being dropped
     */
    public String drop(String item){
        if (this.myInventory.content.containsKey(item)){
            if (this.myInventory.content.get(item) > 1){
                this.myInventory.content.put(item, this.myInventory.content.get(item) - 1);
                return "You dropped " + item + ".";
            } else {
                this.myInventory.content.remove(item);
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
        if (direction.equals("north")){
            this.coordinates[1] += 1;
            return true;
        } else if (direction.equals("south")){
            this.coordinates[1] -= 1;
            return true;
        } else if (direction.equals("east")){
            this.coordinates[0] += 1;
            return true;
        } else if (direction.equals("west")){
            this.coordinates[0] -= 1;
            return true;
        } else {
            System.out.println("Invalid direction");
            return false;
        }
    }

    /**
     * lets person teleport to a different location
     * @param x x coordinate
     * @param y y coordinate
     */
    public boolean fly(int x, int y){
        this.coordinates[2] = 1;//person is now flying
        System.out.println("You are now flying");
        this.coordinates[0] = x;
        this.coordinates[1] = y;
        this.coordinates[2] = 0;//person is now on the ground
        System.out.println("You have landed at " + this.coordinates[0] + ", " + this.coordinates[1]);
    }

    /**
     * changes current awake status to not awake
     */
    private void rest(){
        if (this.awake == true){
            this.awake = false;
        } else {
            System.out.println("You are already asleep");
        }
    }


    private void wake(){
        if (this.awake == false){
            this.awake = true;
        } else {
            System.out.println("You are already awake");
        }
    }

    private void undo(){
        System.out.println("Previous action undone!");
    }

    
    /** 
     * @param item
     */
    private void use(String item){
        if (this.myInventory.content.containsKey(item)){
            this.myInventory.content.remove(item);
        }
    }

    private void shrink(){
        if (this.size[0].equals("small")){
            System.out.println("You are already at your smallest size!");
        } else if (this.size[0].equals("medium")){
            this.size[0] = "small";
        } else if (this.size[0].equals("large")){
            this.size[0] = "medium";
        }
    }

    private void grow(){
        if (this.size[0].equals("large")){
            System.out.println("You are already at your largest size!");
        } else if (this.size[0].equals("medium")){
            this.size[0] = "large";
        } else if (this.size[0].equals("small")){
            this.size[0] = "medium";
        }
    }

    private void turnItemLeft(){
        System.out.println("Item turned left!");
    }

    private void turnItemRight(){
        System.out.println("Item turned right!");
    }

    private void turnItemUp(){
        System.out.println("Item turned up!");
    }

    private void turnItemDown(){
        System.out.println("Item turned down!");
    }

    
    /** 
     * @param item
     */
    private void examine(String item){
        System.out.println("You are examining the " + item + ".");
        turnItemDown();
        turnItemUp();
        turnItemLeft();
        turnItemRight();
    }


    
}
