package httpserver.core;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.io.IOException ;


public class HttpConnectionWorkerThread extends Thread {
    private Socket socket;

    public HttpConnectionWorkerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
             InputStream inputStream = socket.getInputStream();
             OutputStream outputStream = socket.getOutputStream();


            String html = "<html><head><title>Server</title></head><body><h1>This is a simple HTTP server</h1></body></html>";

            final String CRLF = "\n\r";
            String response = "HTTP/1.1 200 OK" + CRLF +
                    "Content-Length: " + html.getBytes().length + CRLF +
                    CRLF +
                    html +
                    CRLF + CRLF;


            outputStream.write(response.getBytes());
            inputStream.close();
            outputStream.close();
            socket.close();

        } catch (Exception e) {

        } finally {

        }

        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Connection processing finished");
    }
}
