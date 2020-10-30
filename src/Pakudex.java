public class Pakudex
{
    private Pakuri[] size;
    private int cap = -1;


    //Default constructor; if called, the default size for the Pakudex should be 20
    public Pakudex() {
        size = new Pakuri[20];
    }

    //Initializes this object to contain exactly capacity objects when completely full
    public Pakudex(int capacity) {
        size = new Pakuri[capacity];
    }

    // Returns the number of critters currently being stored in the Pakudex
    public int getSize() {
        return cap + 1;
    }

    // Returns the number of critters that the Pakudex has the capacity to hold at most
    public int getCapacity() {
        return size.length;
    }

    // Returns a String array containing the species of the critters as ordered in the Pakudex;
    // if there are no species added yet, this method should return null
    public String[] getSpeciesArray() {
            int i;
            for (i = 0; i < size.length; i++) {
                if (size[i] == null) {
                    break;
                }
            }

            String[] container = new String[i];

            for (int j = 0; i < container.length; j++) {
                container[j] = size[j].getSpecies();
            }

            if (cap == -1) {
                return null;
            }

            return container;
        }

    // Returns an int array containing the attack, defense, and speed statistics of species at indices 0, 1,and 2 respectively;
    // if species is not in the Pakudex, returns null
    public int[] getStats(String species) {
        int[] stats = new int[3];
        boolean checkIf = false;
        for (int i = 0; i < size.length; i++) {
            if ((size[i] != null) && species.equals(size[i].getSpecies())) {
                checkIf = true;
            }
        }
        if (checkIf) {
            for (int j = 0; j < size.length; j++) {
                if ((size[j] != null) && species.equals(size[j].getSpecies())) {
                    stats[0] = size[j].getAttack();
                    stats[1] = size[j].getAttack();
                    stats[2] = size[j].getAttack();
                }
            }
            return stats;
        } else {
            return null;
        }

    }

    // Sorts the Pakuri objects in this Pakudex according to Java standard lexicographical ordering of species name
    public void sortPakuri() {
        for (int i = 0; i < size.length; i++) {
            int index = i;
            for (int j = i + 1; j < size.length; j++) {
                if ((size[j] != null) && (size[j].getSpecies().compareTo(size[index].getSpecies()) < 0)) {
                    index = j;
                }
            }
            Pakuri rand = size[i];
            size[i] = size[index];
            size[index] = rand;
        }
    }

    // Adds species to the Pakudex; if successful, return true, and false otherwise
    public boolean addPakuri(String species) {
        boolean successful = true;
        cap++;

        if (cap > size.length - 1) {
            successful = false;
            cap--;
            System.out.println("Error: Pakudex is full!");
        }

        if (successful) {
            for (int i = 0; i < size.length; i++) {
                if ((size[i] != null) && species.equalsIgnoreCase(size[i].getSpecies())) {
                    successful = false;
                    cap--;
                    System.out.println("Error: Pakudex already contains this species!");
                }
            }
        }

        if (successful) {
            Pakuri pakuri = new Pakuri(species);
            size[cap] = pakuri;
            System.out.println("Pakuri species " + species + " successfully added!");
        }
        return successful;
    }


    // Attempts to evolve species within the Pakudex; if successful, return true, and false otherwise
    public boolean evolveSpecies(String species)
    {
        {
            boolean successful = false;

            for (int i = 0; i < size.length; i++)
            {
                if ((size[i] != null) && species.equalsIgnoreCase(size[i].getSpecies()))
                {
                    size[i].evolve();
                    successful = true;
                }
            }

            return successful;
        }
    }
}
