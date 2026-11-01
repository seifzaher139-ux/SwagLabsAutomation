package utils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

//ملاحظة:الclass دا عملته بمساعدة الai
public class DataDriven {

    public static String jsonReader(String scenario, String key) {

        Path filePath = Path.of("src/test/resources/testData.json");

        try (Reader reader = Files.newBufferedReader(
                filePath, StandardCharsets.UTF_8)) {

            JsonObject data = JsonParser.parseReader(reader)
                    .getAsJsonObject();

            return data.getAsJsonObject(scenario)
                    .get(key)
                    .getAsString();

        } catch (IOException e) {
            throw new RuntimeException("تعذرت قراءة ملف testData.json", e);
        }
    }
}