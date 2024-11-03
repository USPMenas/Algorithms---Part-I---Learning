package DynamicConnectivity;

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

public class DynamicConnectivity {
    static int numberOfTrees;
    static List<List<Integer>> components = new ArrayList<List<Integer>>();

    static int readFile(String fileName) throws FileNotFoundException {
        System.out.println("Entrei na função");
        int interations = 0;
        int aux = -1;
        int numberOfNodes = -1;
        int firstIndex = -1;
        int secondIndex = -1;
        boolean connected = false;
        Scanner scanner = new Scanner(new File(fileName));
        while (scanner.hasNextInt()) {
            System.out.println("Entrei no while");
            aux = scanner.nextInt();
            connected = false;
            if (interations == 0) {
                numberOfNodes = aux;
                System.out.println(aux);
            } else if (interations == 1) {
                System.out.println(aux);
                System.out.println(interations);
                System.out.println(numberOfNodes);
                List<Integer> newComponent = new ArrayList<Integer>();
                newComponent.add(aux);
                System.out.println(newComponent);
                components.add(newComponent);
                System.out.println(components);
                firstIndex = 0;
            } else {
                if ((interations % 2) == 0) {
                    System.out.println("Posição par, o número é o:");
                    System.out.println(aux);
                    for (List<Integer> innerList : components) {
                        for (Integer number : innerList) {
                            if (number == aux) {
                                System.out.println(aux);
                                secondIndex = components.indexOf(innerList);

                                connected = true;
                                break;
                            }
                        }
                    }
                    if (connected == false) {
                        System.out.println("oi");
                        System.out.println(aux);
                        components.get(firstIndex).add(aux);
                    } else {
                        if (secondIndex != firstIndex) {
                            components.get(firstIndex).addAll(components.get(secondIndex));
                            System.out.println(components);
                            components.remove(secondIndex);
                            System.out.println(components);
                        }
                    }
                } else {
                    System.out.println("Posição impar, o número é o:");
                    System.out.println(aux);

                    for (List<Integer> innerList : components) {
                        for (Integer number : innerList) {
                            if (number == aux) {
                                System.out.println(aux);
                                firstIndex = components.indexOf(innerList);
                                connected = true;
                            }
                        }
                    }
                    if (connected == false) {
                        System.out.println(aux);
                        List<Integer> newComponent = new ArrayList<Integer>();
                        newComponent.add(aux);
                        components.add(newComponent);
                        firstIndex = components.size() - 1;
                    }
                }
            }
            interations++;
            System.out.println(components);
            System.out.println("Interation: " + interations);

        }

        System.out.println(components);

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
