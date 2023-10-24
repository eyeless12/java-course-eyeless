package edu.hw2.Task3.Managers;

import edu.hw2.Task3.Connections.Connection;
import edu.hw2.Task3.Connections.FaultyConnection;
import edu.hw2.Task3.Connections.StableConnection;
import java.util.Random;

public class DefaultConnectionManager implements ConnectionManager {
    private static final int RND_BOUND = 10;
    private static final int RND_UPPER_VALUE = 3;
    private final Random random;

    public DefaultConnectionManager() {

        this.random = new Random();
    }

    @Override
    public Connection getConnection() {
        if (random.nextInt(RND_BOUND) < RND_UPPER_VALUE) {
            return new FaultyConnection();
        }
        return new StableConnection();
    }
}
