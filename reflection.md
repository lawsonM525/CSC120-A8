<p align="center">
  <a href="https://github.com/DenverCoder1/readme-typing-svg"><img src="https://readme-typing-svg.herokuapp.com?lines=meinKraft&center=true&width=500&height=50"></a>
</p>
<p>
Abby McIlraith and Michelle Lawson are german scientists building a pirated version of a certain Swedish game that cannot be accessed in our country. We implement the Contract interface created by Jordan Crouser.

(Markdown animation adapted from DenverCoder1 on GitHub)
</p>

<h3>Brainstorming Ideas:</h3>

    attributes?
    - game inventory -> hashTable < String itemName, int numAvailable >
        - content : hashTable
        - capacity - do we really want it?
    - coordinates for location - arr  int [x, y, z]
    - size String [tiny, small, medium, large, giant]
    - Boolean awake [either awake or asleep T/F]

    methods
    - grab from inventory
    - drop item in inventory
    - examine [turn left, turn right, turn front, turn to back (all print "You have turned this to the ___")]
    - use - deduct from inventory
    - walk - change coordinates (adds/subtracts x,y)
    - fly - changes to 1, changes x,y accordingly, changes z back to 0
    - shrink change size (with limitations)
    - grow chanvfjedfvbjrfbd yeah
    - rest change awake status
    - undo - checks lastAction, undoes it


Process:

After figuring out what each of our methods would do for the player, we struggled with how to implement the undo method. We decided to make a variable called lastAction that would change based on what the last method was, so that the undo method would know which method to undo. Then the undo method would call the opposite of the lastAction method (like call drop if lastAction = grab) and print an appropriate message. 

Sincerely,
the creators of meinKraft.



