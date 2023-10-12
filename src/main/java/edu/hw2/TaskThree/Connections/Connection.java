package edu.hw2.TaskThree.Connections;

import edu.hw2.TaskThree.ConnectionException;

public interface Connection extends AutoCloseable {
    void execute(String command) throws ConnectionException;
}
