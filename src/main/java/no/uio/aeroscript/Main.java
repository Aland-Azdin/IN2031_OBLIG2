package no.uio.aeroscript;

import no.uio.aeroscript.antlr.AeroScriptLexer;
import no.uio.aeroscript.antlr.AeroScriptParser;
import no.uio.aeroscript.runtime.Interpreter;
import no.uio.aeroscript.type.Memory;
import no.uio.aeroscript.type.Point;
import no.uio.aeroscript.ast.stmt.Statement;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.setProperty("org.jline.terminal.dumb", "true");
        HashMap<Memory, Object> heap = new HashMap<>();
        Stack<Statement> stack = new Stack<>();
        float batteryLevel;
        Point initialPosition;

        if (args.length < 1) {
            System.err.println("Usage: java -jar aeroscript.jar <path to file> [-b <battery level>] [-p <x> <y>]");
            System.exit(1);
        }
        String path = args[0];
        // check if the user used the option -b to set the battery level
        if (args.length > 1 && args[1].equals("-b")) {
            batteryLevel = Float.parseFloat(args[2]);
        } else if (args.length > 3 && args[4].equals("-b")) {
            batteryLevel = Float.parseFloat(args[5]);
        } else {
            batteryLevel = 100;
        }

        // check if the user used the option -p to set the initial position
        if (args.length > 1 && args[1].equals("-p")) {
            initialPosition = new Point(Float.parseFloat(args[2]), Float.parseFloat(args[3]));
        } else if (args.length > 3 && args[3].equals("-p")) {
            initialPosition = new Point(Float.parseFloat(args[4]), Float.parseFloat(args[5]));
        } else {
            initialPosition = new Point(0, 0);
        }

        float initialX = initialPosition.getX();
        float initialY = initialPosition.getY();
        float initialZ = 0;

        HashMap<Memory, HashMap<String, Object>> variables = new HashMap<>();
        variables.put(Memory.VARIABLES, new HashMap<>());
        HashMap<String, Object> vars = variables.get(Memory.VARIABLES);

        vars.put("initial position", initialPosition);
        vars.put("current position", initialPosition);
        // Add all other variables required by the stack
        // Hint: if you add a separate variable to check if the battery level is low, you can add a listener to trigger
        // the reaction

        heap.put(Memory.EXECUTION_TABLE, new HashMap<>());
        heap.put(Memory.REACTIONS, new HashMap<>());
        heap.put(Memory.MESSAGES, new HashMap<>());
        heap.put(Memory.VARIABLES, vars);

        try {
            // Read all bytes of the file for parsing using the interpreter.

            /*
            // Uncomment this block to enable the REPL
            // If you want to use listeners, you can see the REPL class for an example of how to implement them
            // If you want to use a different implementation, change the REPL accordingly
            REPL repl = new REPL(heap, interpreter.getListeners(), interpreter.getFirstExecution());
            System.out.println("Welcome to the AeroScript REPL!");
            while(!repl.isTerminating()) {
                System.setProperty("org.jline.terminal", "jline.UnsupportedTerminal");
                LineReader reader = LineReaderBuilder.builder().build();
                String next;
                String left;
                String[] splits;
                do {
                    next = reader.readLine("MO> ");
                    if (next == null) {
                        break;
                    }
                    splits = next.trim().split(" ", 2);
                    left = splits.length == 1 ? "" : splits[1].trim();
                } while (!repl.command(splits[0], left));
            }
            */

            // Print the initial position, initial battery capacity, final position, final battery level and distance travelled here

            System.out.println("Execution complete!");
        } catch (/*IOException e*/Exception e) {
            System.err.println("Error reading file: " + e.getMessage());
        }


        System.out.println("Assignment not yet implemented");
    }
}