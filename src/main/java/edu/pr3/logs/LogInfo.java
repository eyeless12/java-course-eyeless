package edu.pr3.logs;

import java.time.OffsetDateTime;

public class LogInfo {
    public final String remoteIp;
    public final OffsetDateTime dateTime;
    public final HttpResponseInfo responseInfo;
    public final String userClient;

    public LogInfo(String remoteIp, OffsetDateTime dateTime, HttpResponseInfo info, String userClient) {
        this.remoteIp = remoteIp;
        this.dateTime = dateTime;
        this.userClient = userClient;
        responseInfo = info;
    }
}
