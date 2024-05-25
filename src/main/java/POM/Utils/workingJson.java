package POM.Utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class workingJson {
    private static String baseUrl = "src/main/java/POM/Utils/json.json";

    public static JsonNode getResourcesFromJson() throws IOException {
        File file = new File(baseUrl);
        String absolutePath = file.getAbsolutePath();
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(new File(absolutePath));
        return jsonNode;
    }
}
