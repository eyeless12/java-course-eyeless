package edu.pr3.logs;

public class HttpResponseInfo {
    public final HttpMethod httpMethod;
    public final String path;
    public final String httpVersion;
    public final int statusCode;
    public final int bytesSent;

    public HttpResponseInfo(HttpMethod httpMethod, String path, String httpVersion, int statusCode, int bytesSent) {
        this.httpMethod = httpMethod;
        this.path = path;
        this.httpVersion = httpVersion;
        this.statusCode = statusCode;
        this.bytesSent = bytesSent;
    }
}
