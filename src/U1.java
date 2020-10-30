public class U1 extends Rocket {

    U1(){
        budget = 100;
        currentWeight = 10000;
        maxWeight = 18000;
        weightOfCargo = 0;
        cargoLimit = maxWeight - cargoLimit;
    }


    public boolean land(){
        double randDouble = Math.random() + 1;
        double chanceOfExplo = 1 * (weightOfCargo / (double)cargoLimit);  // Change of exploding changed to from 1% to 40%
//        System.out.println("land" + chanceOfExplo);
        return  chanceOfExplo <= randDouble;
    }

    public boolean launch(){
        double randDouble = Math.random() * 5 + 1;
        double chanceOfExplo = 5 * (weightOfCargo / (double)cargoLimit);
//        System.out.println("launch " + chanceOfExplo);
        return  chanceOfExplo <= randDouble;
    }
}
