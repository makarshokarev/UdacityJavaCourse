public class U2 extends Rocket {

    U2(){
        budget = 120;
        currentWeight = 18000;
        maxWeight = 29000;
        weightOfCargo = 0;
        cargoLimit = maxWeight - cargoLimit;
    }

    public boolean land(){
        double randDouble = Math.random() * 8 + 1; //weight the random number same with probality of explosion
        double chanceOfExplo = 8 * weightOfCargo / (double) cargoLimit;
        return  chanceOfExplo <= randDouble;
    }

    public boolean launch(){
        double randDouble = Math.random() * 4 + 1; //weight the random number same with probality of explosion
        double chanceOfExplo = 4 * randDouble / (double) cargoLimit;
        return  chanceOfExplo <= randDouble;
    }
}

