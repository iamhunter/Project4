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

public class Main {
    public static void main(String[] args) {
        // Be sure that the user has provided arguments.
        if(args.length == 0) {
            System.err.println("No file path was specified at the command-line.");
            System.err.println("Unrecoverable. Program terminating.");
            System.exit(1);
        }

        // Notify the user that only the first argument is relevant.
        if(args.length > 1) {
            System.err.println("Incorrect number of parameters:  " + args.length + ".");
            System.err.println("Should be 1.");
            System.err.println("Will ignore all parameters but the first.");
        }

        // Get a path to the file specified.
        Path path = null;
        try {
            path = Paths.get(args[0]);
        } catch(InvalidPathException e) {
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

        // Parse the words out of line one and line two.
        GenericSetExtended firstLine = new GenericSet2();
        GenericSetExtended secondLine = new GenericSet2();

        int count = 0;
        for(int i = 0; lines[i] != null; i++)
        {
            count++;
        }
        if(count%2 != 0)
        {
            count--;
        }

        for(int i = 0; i < count; i = i + 2) {
            for (String word : lines[i].split(" "))
                if (!firstLine.contains(word))
                    firstLine.insert(word);
            for (String word : lines[i+1].split(" "))
                if (!secondLine.contains(word))
                    secondLine.insert(word);

            // Run the union, intersection, and difference operators.
            GenericSet union = new GenericSet2(), intersection = new GenericSet2(), difference = new GenericSet2();

            firstLine.union(secondLine);
            firstLine.intersect(secondLine);
            firstLine.difference(secondLine);

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

