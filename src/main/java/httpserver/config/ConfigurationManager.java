package httpserver.config;

import com.fasterxml.jackson.databind.JsonNode;
import httpserver.util.Json;

import java.io.FileReader;
import java.io.IOException;

public class ConfigurationManager {
    private static ConfigurationManager myConfigurationManager;
    private static Configuration myCurrentConfiguration;
    private ConfigurationManager() {
    }

    public static ConfigurationManager getInstance() {
        if (myConfigurationManager == null) {
            myConfigurationManager = new ConfigurationManager();
        }
        return myConfigurationManager;
    }

    public void loadConfigurationFile(String filePath) throws IOException {
        FileReader reader = new FileReader(filePath);
        StringBuffer sb = new StringBuffer();
        int i;
        while ((i = reader.read()) != -1) {
            sb.append((char) i);
        }
        JsonNode conf = Json.parse(sb.toString());
        myCurrentConfiguration = Json.fromJson(conf, Configuration.class);
    }

    public Configuration getCurrentConfiguration() {
        if (myCurrentConfiguration == null) {
            throw new HttpConfigurationException("No current configuration set");
        }

        return myCurrentConfiguration;
    }
}
