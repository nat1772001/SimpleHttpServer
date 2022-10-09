package httpserver;

import httpserver.config.Configuration;
import httpserver.config.ConfigurationManager;
import httpserver.core.ServerListenerThread;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {
    public static void main(String[] args) throws IOException {
        System.out.println("Server starting....");
        ConfigurationManager.getInstance().loadConfigurationFile("src/main/resources/http.json");
        Configuration conf = ConfigurationManager.getInstance().getCurrentConfiguration();
        System.out.println(conf.getPort());
        System.out.println(conf.getWebroot());

        ServerListenerThread serverListenerThread = new ServerListenerThread(conf.getPort(), conf.getWebroot());
        serverListenerThread.start();
    }
}
