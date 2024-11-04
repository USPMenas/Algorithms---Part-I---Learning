package QuickFind;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Input: txt with combinations of dots, I need to create the connections and in the and say how much objects we have
// txt format: number of nodes + pair of combinations.

// Algorithm idea and steps:
// 1. Read the first line to know how much nodes we have;
// 2. Go to next and verify in the nodes is already connected: isConnected: do nothing, isNotConnected: connect;
// To do this verification we will create a structure to each conjunct and always watch all the objects to verify;

public class QuickFind {
    static List<Integer> components = new ArrayList<Integer>();

    static int numberOfTrees;

    static int readFile(String fileName) throws FileNotFoundException {
        System.out.println("Entrei na função");
        int interations = 0;
        int aux = -1;
        int numberOfNodes = -1;
        int firstIndex = -1;
        int secondIndex = -1;
        List<Integer> auxComponents = new ArrayList<Integer>();
        System.out.println("Aqui" + auxComponents);

        Scanner scanner = new Scanner(new File(fileName));
        while (scanner.hasNextInt()) {
            System.out.println("Entrei no while");
            aux = scanner.nextInt();
            if (interations == 0) {
                numberOfNodes = aux;
                System.out.println(aux);
                for (int i = 0; i < numberOfNodes; i++) {
                    components.add(i);
                }
                auxComponents.clear();
                auxComponents.addAll(components);
            } else {
                auxComponents.clear();
                auxComponents.addAll(components);
                if ((interations % 2) == 0) {
                    secondIndex = aux;
                    int j = 0;
                    for (Integer number : components) {
                        if (number == components.get(firstIndex)) {
                            System.out.println("FirstValue:" + components.get(firstIndex));
                            System.out.println(components);
                            auxComponents.set(j, auxComponents.get(secondIndex));
                            System.out.println("FirstIndex:" + firstIndex);
                            System.out.println("Index:" + j);
                            System.out.println("Number:" + number);
                        }
                        j++;
                    }
                    components.clear();
                    components.addAll(auxComponents);
                } else {
                    firstIndex = aux;
                }
            }
            interations++;
            System.out.println(components);
            System.out.println("Interation: " + interations);

        }

        // System.out.println(components);

        return components.size();
    }

    // Main method to initialize and run the file reading
    public static void main(String[] args) {
        try {
            // Initialize the test array by calling readFile and assigning its result
            numberOfTrees = readFile("./DynamicConnectivity/input.txt");

            // Print the contents to verify
            System.out.println(numberOfTrees);
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }
}
