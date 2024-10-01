package no.uio.aeroscript.ast.stmt;

public class Execution extends Statement {
    // Add all the variables that you need for the exeuction

    public Execution(/* Add all the variables needed */) {
    }

    public void receiveMessage(String message) {
        // When you receive a message you need to execute its content
        // Hint: for messages you can use listeners to trigger the execution
    }

    @Override
    public void execute() {
        // Hint: When you start running an execution, you need to push a copy of the corresponding code from the EXECUTION_TABLE on the stack
        // Hint: you should check if you have nested execution
        // Hint: you should keep track of the executed statements to avoid infinite loops
    }
}

