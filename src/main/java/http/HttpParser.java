package http;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class HttpParser {

    private static final int SP = 0x20;
    private static final int CR = 0x80;
    private static final int LF = 0x0A;

    public HttpRequest parseHttpRequest(InputStream inputStream) throws IOException {
        HttpRequest request = new HttpRequest();
        InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.US_ASCII);
        parseRequestLine(reader,request);
        parseHeaders(reader, request);
        parseBody(reader, request);
    
        return request;

    }

    private void parseBody(InputStreamReader reader, HttpRequest request) {
    }

    private void parseHeaders(InputStreamReader reader, HttpRequest request) {
        
    }

    private void parseRequestLine(InputStreamReader reader, HttpRequest request) throws IOException {
        int _byte;
        while ((_byte = reader.read()) >=0 ) {
            if (_byte == CR){
                _byte = reader.read();
                if (_byte == LF) {
                    return;
                }
            }
        }

    }
}
