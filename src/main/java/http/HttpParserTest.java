package http;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HttpParserTest {

    private HttpParser httpParser;

    @BeforeAll
    public void beforeClass(){
        httpParser = new HttpParser();
    }

    @org.junit.jupiter.api.Test
    void parseHttpRequest() {
        httpParser.parseHttpRequest(
                generateValidTestCase()
        );
    }

    private InputStream generateValidTestCase() {
        String rawData ="GET / HTTP/1.1\r\n" +
                "Host: localhost:8080\r\n" +
                "Connection: keep-alive\r\n" +
                "Cache-Control: max-age=0\r\n" +
                "sec-ch-ua: \"Chromium\";v=\"106\", \"Google Chrome\";v=\"106\", \"Not;A=Brand\";v=\"99\"\r\n" +
                "sec-ch-ua-mobile: ?0\r\n" +
                "sec-ch-ua-platform: \"Windows\"\r\n" +
                "Upgrade-Insecure-Requests: 1\r\n" +
                "User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/106.0.0.0 Safari/537.36\r\n" +
                "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9\r\n" +
                "Sec-Fetch-Site: none\r\n" +
                "Sec-Fetch-Mode: navigate\r\n" +
                "Sec-Fetch-User: ?1\r\n" +
                "Sec-Fetch-Dest: document\r\n" +
                "Accept-Encoding: gzip, deflate, br\r\n" +
                "Accept-Language: en-US,en;q=0.9,vi;q=0.8\r\n" +
                "Cookie: _xsrf=2|594f6b61|905d973c908ba3e368041f1d81f72160|1663039360; username-localhost-8889=\"2|1:0|10:1663641121|23:username-localhost-8889|44:Yzc3ZDM1OGMwZTQ5NGY5OTgyNzcxZjQ5ZTRkM2FhNDQ=|6865a878f536ae649738de109b54336c3c1e2ded1a30d6f328745923b05094cd\"; username-localhost-8890=\"2|1:0|10:1663642273|23:username-localhost-8890|44:ODg0YzlhNjE0MmIyNDI3MGI2Zjc3NjU3NGFkYmU2Mjc=|5236852a7c8b1ca1f83460fb9a53fcf7cae2cb5a4d7cc1e93de86b42c1f7fdf2\"; username-localhost-8891=\"2|1:0|10:1663648668|23:username-localhost-8891|44:OWYzMjE0OTNlZDBmNGNiM2FkZWY0MjY0NjI4NDI3ZTY=|895b78e250ec74e20e1fe2b9e8be0989060447827f2fddc09fbd33eebe53a64d\"; username-localhost-8888=\"2|1:0|10:1664854001|23:username-localhost-8888|44:NWY1ODA2NGViMjYyNDNiNzlkOWU0NzVhODk3Y2UyODg=|4368f94ba8a95bdf959371e5196cf71bf6ca610cc2b61aaadf1d9027d1a1b9c7\"\r\n" +
                "\r\n";

        InputStream inputStream = new ByteArrayInputStream(
                rawData.getBytes(
                        StandardCharsets.US_ASCII
                )
        );
                return inputStream;
    }
}