package edu.hw6.task6;

import java.net.InetSocketAddress;
import java.net.Socket;
import static edu.hw6.task6.PortDescriptor.getPortDescription;

public class PortScanner {
    private final static int MAX_PORT = 49151;

    public String scan(ScannerWay way) {
        var resultSb = new StringBuilder();
        resultSb.append("PORT STATUS DESCRIPTION\n");
        for (int p = 0; p < MAX_PORT; p++) {
            String description = null;
            try {
                description = getPortDescription(p);
                Socket scannerSocket = new Socket();
                scannerSocket.connect(new InetSocketAddress("localhost", p));
                scannerSocket.close();
                if (way == ScannerWay.ALL || way == ScannerWay.OPEN) {
                    resultSb.append(String.format("%d open %s\n", p, description));
                }
            } catch (Exception e) {
                if (way == ScannerWay.ALL || way == ScannerWay.CLOSED) {
                    resultSb.append(String.format("%d closed %s\n", p, description));
                }
            }
        }

        return resultSb.toString();
    }

    public String scan() {
        return scan(ScannerWay.ALL);
    }

    public enum ScannerWay {
        OPEN,
        CLOSED,
        ALL
    }
}
