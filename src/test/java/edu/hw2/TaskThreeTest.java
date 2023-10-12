package edu.hw2;

import edu.hw2.TaskThree.ConnectionException;
import edu.hw2.TaskThree.Connections.FaultyConnection;
import edu.hw2.TaskThree.Connections.StableConnection;
import edu.hw2.TaskThree.Managers.ConnectionManager;
import edu.hw2.TaskThree.Managers.DefaultConnectionManager;
import edu.hw2.TaskThree.Managers.FaultyConnectionManager;
import edu.hw2.TaskThree.PopularCommandExecutor;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class TaskThreeTest {
    @Test
    void TestFaultyConnection() {
        var faultyConnection = new FaultyConnection();
        boolean exceptionThrowed = false;
        for (int i = 0; i < 100; i++) {
            try {
                faultyConnection.execute("1");
            } catch (ConnectionException e) {
                exceptionThrowed = true;
                break;
            }
        }
        assertThat(exceptionThrowed).isEqualTo(true);
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
