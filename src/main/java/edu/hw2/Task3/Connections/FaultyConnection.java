package edu.hw2.Task3.Connections;

import edu.hw2.Task3.ConnectionException;
import java.util.Random;

public class FaultyConnection implements Connection {
    private static final int RND_BOUND = 10;
    private static final int RND_UPPER_VALUE = 5;

    private final Random random;

    public FaultyConnection() {

        this.random = new Random();
    }

    @Override
    public void execute(String command) throws ConnectionException {
        if (random.nextInt(RND_BOUND) < RND_UPPER_VALUE) {
            throw new ConnectionException();
        }
    }

    @Override
    public void close() throws Exception {

    }
}
