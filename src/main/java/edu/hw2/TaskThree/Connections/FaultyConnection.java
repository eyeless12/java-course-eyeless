package edu.hw2.TaskThree.Connections;

import edu.hw2.TaskThree.ConnectionException;
import java.util.Random;

public class FaultyConnection implements Connection {
    public FaultyConnection() {

        this.random = new Random();
    }

    private final Random random;
    private static final int RND_BOUND = 10;
    private static final int RND_UPPER_VALUE = 5;

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
