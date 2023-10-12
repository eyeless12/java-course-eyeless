package edu.hw2.TaskThree.Managers;

import edu.hw2.TaskThree.Connections.Connection;
import edu.hw2.TaskThree.Connections.FaultyConnection;

public class FaultyConnectionManager implements ConnectionManager {
    @Override
    public Connection getConnection() {
        return new FaultyConnection();
    }
}
