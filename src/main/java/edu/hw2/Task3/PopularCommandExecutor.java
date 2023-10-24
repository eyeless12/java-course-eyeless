package edu.hw2.Task3;

import edu.hw2.Task3.Managers.ConnectionManager;

public final class PopularCommandExecutor {
    private final ConnectionManager manager;
    private final int maxAttempts;

    public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
        this.manager = manager;
        this.maxAttempts = maxAttempts;
    }

    public void updatePackages() {
        tryExecute("apt update && apt upgrade -y");
    }

    private void tryExecute(String command) throws ConnectionException {
        int attempts = 0;
        while (attempts <= maxAttempts) {
            try (var connection = manager.getConnection()) {
                connection.execute(command);
                break;
            } catch (ConnectionException e) {
                attempts++;
                if (attempts > maxAttempts) {
                    throw new ConnectionException(e);
                }
            } catch (Exception ignored) {
            }
        }
    }
}
