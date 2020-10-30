import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    //This method creates a list with items.
    ArrayList<Item> loadItems(String pathName) throws FileNotFoundException {

        ArrayList<Item> loadItems = new ArrayList<>();
        File file = new File(pathName);
        Scanner scanner = new Scanner(file);

        while(scanner.hasNextLine()){
            Item newItem = new Item();
            String[] tokens = scanner.nextLine().split("=");
            newItem.name = tokens[0];
            newItem.weight = Integer.parseInt(tokens[tokens.length - 1]);

            loadItems.add(newItem);
        }
        return loadItems;
    }

    // How many rockets U1 we need to carry all the stuff.
    ArrayList<U1> loadU1(ArrayList<Item> list) throws Exception{
        ArrayList<U1> rocketsOne = new ArrayList<>();
        U1 newOne = new U1();
        int total = 0;

        for (Item item : list){
            total += item.weight;
            if (total <= newOne.cargoLimit){
                newOne.weightOfCargo += item.weight;
            } else{
                rocketsOne.add(newOne);
                newOne = new U1();
                newOne.weightOfCargo += item.weight;
                total += item.weight;
            }
        }
        return rocketsOne;
    }

    //How many rockets U2 we need to carry all the stuff.
    ArrayList<U2> loadU2(ArrayList<Item> list) throws Exception{
        ArrayList<U2> rocketsTwo = new ArrayList<>();
        U2 newTwo = new U2();
        int total = 0;

        for (Item item : list){
            total += item.weight;
            if (total <= newTwo.cargoLimit){
                newTwo.weightOfCargo += item.weight;
            } else {
                rocketsTwo.add(newTwo);
                newTwo = new U2();
                newTwo.weightOfCargo += item.weight;
                total += item.weight;
            }
        }
        return rocketsTwo;
    }

    //Runes simulation of rockets fleet.
    public int runSimulation(ArrayList<Rocket> list){
        int totalRockets = 0;

        for (Rocket rocket : list){
            boolean launchStatus = rocket.launch();
            boolean landStatus = rocket.land();
            totalRockets++;

            while (!(landStatus && launchStatus)){
                launchStatus = rocket.launch();
                landStatus = rocket.land();
                totalRockets++;
            }
        }
        return totalRockets;
    }
}
