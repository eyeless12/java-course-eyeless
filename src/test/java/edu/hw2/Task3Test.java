package edu.hw2;

import edu.hw2.Task3.ConnectionException;
import edu.hw2.Task3.Connections.FaultyConnection;
import edu.hw2.Task3.Connections.StableConnection;
import edu.hw2.Task3.Managers.ConnectionManager;
import edu.hw2.Task3.Managers.DefaultConnectionManager;
import edu.hw2.Task3.Managers.FaultyConnectionManager;
import edu.hw2.Task3.PopularCommandExecutor;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task3Test {
    @Test
    void TestFaultyConnection() {
        var faultyConnection = new FaultyConnection();
        ConnectionException exceptionThrowed;
        while (true) {
            try {
                faultyConnection.execute("1");
            } catch (ConnectionException e) {
                exceptionThrowed = e;
                break;
            }
        }
        assertThat(exceptionThrowed).isInstanceOf(ConnectionException.class);
    }

    @Test
    void TestFaultyConnectionManager() {
        ConnectionManager manager = new FaultyConnectionManager();
        assertThat(manager.getConnection()).isInstanceOf(FaultyConnection.class);
    }

    @Test
    void TestDefaultConnectionManager() {
        ConnectionManager manager = new DefaultConnectionManager();
        int stableConnectionsCounter = 0;
        int faultyConnectionsCounter = 0;
        for (int i = 0; i < 10; i++) {
            var connection = manager.getConnection();
            if (connection.getClass().equals(StableConnection.class)) {
                stableConnectionsCounter++;
            }
            else {
                faultyConnectionsCounter++;
            }
        }
        assertThat(stableConnectionsCounter).isGreaterThan(0);
        assertThat(faultyConnectionsCounter).isGreaterThan(0);
    }

    @Test
    void TestExecutorFaultyConnection() {
        var executorFaulty = new PopularCommandExecutor(new FaultyConnectionManager(), 1);
        boolean conncetionExceptionIsThrown = false;
        try {
            for (int i = 0; i < 10; i++) {
                executorFaulty.updatePackages();
            }
        } catch (ConnectionException e) {
            conncetionExceptionIsThrown = true;
        }
        assertThat(conncetionExceptionIsThrown).isEqualTo(true);
    }
}
