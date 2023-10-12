package edu.hw2.TaskThree.Managers;

import edu.hw2.TaskThree.Connections.Connection;
import edu.hw2.TaskThree.Connections.FaultyConnection;
import edu.hw2.TaskThree.Connections.StableConnection;
import java.util.Random;

public class DefaultConnectionManager implements ConnectionManager {
    public DefaultConnectionManager() {

        this.random = new Random();
    }

    private final Random random;
    private static final int RND_BOUND = 10;
    private static final int RND_UPPER_VALUE = 3;

    @Override
    public Connection getConnection() {
        if (random.nextInt(RND_BOUND) < RND_UPPER_VALUE) {
            return new FaultyConnection();
        }
        return new StableConnection();
    }
}
