package edu.hw2.Task3.Connections;

import edu.hw2.Task3.ConnectionException;

public interface Connection extends AutoCloseable {
    void execute(String command) throws ConnectionException;
}
