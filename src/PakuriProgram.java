import java.util.Scanner;

public class PakuriProgram {


    // display menu
    public static void displayMenu() {
        System.out.println("\nPakudex Main Menu\n" +
                "-----------------\n" +
                "1. List Pakuri\n" +
                "2. Show Pakuri\n" +
                "3. Add Pakuri\n" +
                "4. Evolve Pakuri\n" +
                "5. Sort Pakuri\n" +
                "6. Exit\n");
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        boolean bool;
        int maxCap = 0;
        String dispSpecies;

        // display welcome message
        System.out.println("Welcome to Pakudex: Tracker Extraordinaire!");

        // Prompt for / read Pakudex capacity & confirm
        System.out.print("Enter max capacity of the Pakudex: ");

        do {
            if (input.hasNextInt())
            {
                maxCap = input.nextInt();
                if (maxCap > 0) {
                    bool = true;
                } else {
                    bool = false;
                    System.out.println("Please enter a valid size.");
                    System.out.print("Enter max capacity of the Pakudex: ");
                    input.next();
                }
            } else {
                System.out.println("Please enter a valid size.");
                System.out.print("Enter max capacity of the Pakudex: ");
                bool = false;
                input.next();
            }
        } while (bool == false);
        System.out.println("The Pakudex can hold " + maxCap + " species of Pakuri");

        Pakudex pDex = new Pakudex(maxCap);
        String menu = "";

        while (true) {

            // Display the menu
            displayMenu();
            System.out.print("What would you like to do? ");
            menu = input.next();

            if (menu.equals("1") || menu.equals("2") || menu.equals("3") ||
                    menu.equals("4") || menu.equals("5") || menu.equals("6"))
            {
                if (menu.equals("1"))
                {
                    // option 1: List Pakuri
                    String[] pakuriList = pDex.getSpeciesArray();
                    if (pakuriList == null)
                    {
                        System.out.println("No Pakuri in Pakudex yet!");
                        continue;
                    }else
                    {
                        System.out.println("Pakuri In Pakudex:");
                        for (int i = 0; i < pakuriList.length; i++)
                        {
                            System.out.println((i + 1) + ". " + pakuriList[i]);
                        }
                        continue;
                    }

                }
                else if (menu.equals("2"))
                {
                 // display species
                    System.out.print("\nEnter the name of the species to display: ");
                     dispSpecies = input.next();
                    int[] stats = pDex.getStats(dispSpecies);
                    if (stats == null)
                    {
                        System.out.println("Error: No such Pakuri!");
                        continue;
                    }

                    else
                    {
                        System.out.println("Species: " + dispSpecies);
                        System.out.println("Attack: " + stats[0]);
                        System.out.println("Defense: " + stats[1]);
                        System.out.println("Speed: " + stats[2]);
                        continue;
                    }
                }
                else if (menu.equals("3"))
                {
                 // adding species
                    if (pDex.getCapacity() == pDex.getSize())
                    {
                        System.out.println("Error: Pakudex is full!");
                        continue;
                    }
                    else
                    {
                        System.out.print("\nEnter the name of the species to add: ");
                        dispSpecies = input.next();
                        pDex.addPakuri(dispSpecies);
                        continue;
                    }
                }
                else if (menu.equals("4"))
                {
                 // evolving species
                    System.out.print("\nEnter the name of the species to evolve: ");
                    dispSpecies = input.next();

                    if (pDex.evolveSpecies(dispSpecies))
                    {
                        System.out.println(dispSpecies + " has evolved!");
                        continue;
                    }

                    else
                        {
                        System.out.println("Error: No such Pakuri!");
                        continue;
                    }

                }

                else if (menu.equals("5"))
                // sorting pakuri
                    pDex.sortPakuri();
                System.out.println("Pakuri have been sorted!");
                continue;
                } else if (menu.equals("6"))
                {
                    System.out.println("\nThanks for using Pakudex! Bye!");
                    break;
                }
             else
            {
                System.out.println("Unrecognized menu selection!");
                continue;
            }
        }
    }
}

