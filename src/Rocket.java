public class Rocket implements SpaceShip {

    int budget;
    int currentWeight;
    int maxWeight;
    int weightOfCargo = 0;
    int cargoLimit = maxWeight - currentWeight;


    @Override
    public boolean launch() {
        return true ;
    }

    @Override
    public boolean land() {
        return true;
    }

    @Override
    public boolean canCarry(Item item) {
        return false;
    }

    @Override
    public boolean carry(Item item) {
        return false;
    }

    public int getCost(){
        return budget;
    }

}
