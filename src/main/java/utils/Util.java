package utils;

import java.io.BufferedReader;
import java.io.IOException;

public class Util {

    private Util() {
    }

    public static StringBuilder convertJsonToString(BufferedReader bufferedReader) throws IOException {
        String response;
        StringBuilder jsonString = new StringBuilder();

        while ((response = bufferedReader.readLine()) != null) {
            jsonString.append(response);
        }

        return jsonString;
    }

}
