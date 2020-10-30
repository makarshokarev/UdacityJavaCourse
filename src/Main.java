import java.util.ArrayList;

public class Main {

    public static long costOfRocket1() throws Exception {
        ArrayList<Rocket> u1Rockets = new ArrayList<>();// How many U1 rockets do we need for Phase1 and Phase2.
        U1 rock1 = new U1();

        Simulation sim = new Simulation();
        ArrayList<Item> phase1StuffOnBoard = sim.loadItems("Phase1.txt");
        ArrayList<Item> phase2StuffOnBoard = sim.loadItems("Phase2.txt");

        ArrayList<U1> ph1Rockets1 = sim.loadU1(phase1StuffOnBoard);
        for (Rocket r1 : ph1Rockets1) {
            u1Rockets.add(r1);
        }

        ArrayList<U1> ph2Rockets1 = sim.loadU1(phase2StuffOnBoard);
        for (Rocket r1 : ph2Rockets1) {
            u1Rockets.add(r1);
        }

        int totalPhlRocket1 = sim.runSimulation(u1Rockets);
        long value = totalPhlRocket1 * rock1.budget;

        return value;
    }

    public static long costOfRocket2() throws Exception{
        ArrayList<Rocket> u2Rockets = new ArrayList<>();
        U2 rock2 = new U2();

        Simulation sim = new Simulation();
        ArrayList<Item> phase1StuffOnBoard = sim.loadItems("Phase1.txt");
        ArrayList<Item> phase2StuffOnBoard = sim.loadItems("Phase2.txt");

        ArrayList<U2> ph1Rockets2 = sim.loadU2(phase1StuffOnBoard);
        for (Rocket r2 : ph1Rockets2){
            u2Rockets.add(r2);
        }

        ArrayList<U2> ph2Rockets2 = sim.loadU2(phase2StuffOnBoard);
        for (Rocket r2 : ph2Rockets2){
            u2Rockets.add(r2);
        }

        int totalPhlRocket2 = sim.runSimulation(u2Rockets);
        long total = totalPhlRocket2 * rock2.budget;

        return total;
    }

    public static void main(String[] args) throws Exception {

        long cost1 = costOfRocket1();
        System.out.println("Total cost for fleet with U1 rockets: " + cost1 + " millions $");

        long cost2 = costOfRocket2();
        System.out.println("Total cost for fleet with U2 rockets: " + cost2 + " millions $");

    }
}
