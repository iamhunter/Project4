package edu.clemson.cpsc2150.project4;

/**
 * Created by andrewmarionhunter on 10/22/16.
 */
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Be sure that the user has provided arguments.
        if (args.length == 0) {
            System.err.println("No file path was specified at the command-line.");
            System.err.println("Unrecoverable. Program terminating.");
            System.exit(1);
        }

        // Notify the user that only the first argument is relevant.
        if (args.length > 1) {
            System.err.println("Incorrect number of parameters:  " + args.length + ".");
            System.err.println("Should be 1.");
            System.err.println("Will ignore all parameters but the first.");
        }

        // Get a path to the file specified.
        Path path = null;
        try {
            path = Paths.get(args[0]);
        } catch (InvalidPathException e) {
            System.err.println("Could not resolve the given filepath: " + args[0] + ".");
            System.err.println("Unrecoverable. Program terminating.");
            System.exit(1);
        }

        // Read all of the lines from the file.
        String[] lines = new String[100];
        try {
            Files.readAllLines(path, StandardCharsets.US_ASCII).toArray(lines);

        } catch (IOException e) {
            System.err.println("Coud not read all lines from the file at the given path.");
            System.err.println("Unrecoverable. Program terminating.");
            System.exit(1);
        }

        boolean customBool = false;
        System.out.print("Enter 'JCL' or 'Custom' to use either JCL set objects or Custom set objects: ");
        Scanner scanner = new Scanner(System.in);
        String nameCustomForBool = scanner.next();

        if(Objects.equals(nameCustomForBool, "Custom") || Objects.equals(nameCustomForBool, "custom"))
        {
            System.out.println();
            System.out.println("You entered " + nameCustomForBool + " so the program will execute using the Custom set objects\n");
            customBool = true;
        }

        else if(Objects.equals(nameCustomForBool, "JCL") || Objects.equals(nameCustomForBool, "jcl"))
        {
            System.out.println();
            System.out.println("You entered " + nameCustomForBool + " so the program will execute using the Custom set objects\n");
            customBool = false;
        }
        else
        {
            System.out.println();
            System.err.println("Your input, " + nameCustomForBool + " is not a valid input. Next time, please try inputting 'Custom' or 'JCL' Terminating program.");
            return;
        }



        if (customBool)
        {
            // Parse the words out of line one and line two.
            GenericSetExtended firstLine = new GenericSet1(100);
            GenericSetExtended secondLine = new GenericSet2();

            int count = 0;
            for (int i = 0; lines[i] != null; i++) {
                count++;
            }
            if (count % 2 != 0) {
                count--;
            }

            for (int i = 0; i < count; i = i + 2) {
                for (Object word : lines[i].split(" "))
                    if (!firstLine.contains(word))
                        firstLine.insert(word);
                for (Object word : lines[i + 1].split(" "))
                    if (!secondLine.contains(word))
                        secondLine.insert(word);

                // Run the union, intersection, and difference operators.
                GenericSetExtended union = new GenericSet2(), intersection = new GenericSet2(), difference = new GenericSet2(), temporary = new GenericSet2();

                while (firstLine.size() > 0) {
                    Object temp = firstLine.removeAny();
                    union.insert(temp);
                    intersection.insert(temp);
                    difference.insert(temp);
                    temporary.insert(temp);
                }
                while (temporary.size() > 0) {
                    firstLine.insert(temporary.removeAny());
                }


                union.union(secondLine);
                intersection.intersect(secondLine);
                difference.difference(secondLine);

                // Print all of the sets, including the state of the initial sets.
                System.out.println("First line: " + firstLine);
                System.out.println("Second line: " + secondLine);

                System.out.println();

                System.out.println("Union: " + union);
                System.out.println("Intersection: " + intersection);
                System.out.println("Difference: " + difference);

                System.out.println();
            }
        }
        else
        {
            // Parse the words out of line one and line two.
            HashSet firstLine = new HashSet();
            TreeSet secondLine = new TreeSet();

            int count = 0;
            for (int i = 0; lines[i] != null; i++) {
                count++;
            }
            if (count % 2 != 0) {
                count--;
            }

            for (int i = 0; i < count; i = i + 2) {
                for (Object word : lines[i].split(" "))
                    if (!firstLine.contains(word))
                        firstLine.add(word);
                for (Object word : lines[i + 1].split(" "))
                    if (!secondLine.contains(word))
                        secondLine.add(word);



                // Run the union, intersection, and difference operators.
                GenericSetExtended union = new GenericSet2(), intersection = new GenericSet2(), difference = new GenericSet2(), secondLine2 = new GenericSet2();

                Iterator firstIter = firstLine.iterator();
                while(firstIter.hasNext())
                {
                    Object temp = firstIter.next();
                    union.insert(temp);
                    intersection.insert(temp);
                    difference.insert(temp);
                }

                Iterator secondIter = secondLine.iterator();
                while(secondIter.hasNext())
                {
                    secondLine2.insert(secondIter.next());
                }

                union.union(secondLine2);
                intersection.intersect(secondLine2);
                difference.difference(secondLine2);

                // Print all of the sets, including the state of the initial sets.
                System.out.println("First line: " + firstLine);
                System.out.println("Second line: " + secondLine);

                System.out.println();

                System.out.println("Union: " + union);
                System.out.println("Intersection: " + intersection);
                System.out.println("Difference: " + difference);

                System.out.println();
            }

        }
    }
}

