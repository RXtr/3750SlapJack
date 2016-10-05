/**
 * Created by Nick Marietti on 10/5/2016.
 */

public class Player {
    public String Name;
    private GroupOfCards Hand;

    public void NewHand(GroupOfCards newhand){
        Hand = newhand;
    }

    public void placeCard(GroupOfCards pile)
    {
        if (Hand.getGroup().size() > 0) {
            pile.getGroup().add(Hand.getGroup().get(0));
            Hand.getGroup().remove(0);
        }
    }
}
