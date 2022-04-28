package service;

import address.Address;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static utils.Util.convertJsonToString;

public class CepService {

    private static final String WEB_SERVICE = "http://viacep.com.br/ws/";
    private static final Integer OK = 200;

    private CepService() {
        //FIX-mE
    }

    public static Address findAddressByCep(String cep) throws Exception {
        String urlConnection = WEB_SERVICE + cep + "/json";

        try {
            URL url = new URL(urlConnection);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            if (connection.getResponseCode() != OK) {
                throw new RuntimeException("HTTP error code: " + connection.getResponseCode());
            } else {
                BufferedReader response = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder jsonString = convertJsonToString(response);

                Gson gson = new Gson();
                Address address;
                address = gson.fromJson(jsonString.toString(), Address.class);

                return address;
            }

        } catch (Exception e) {
            throw new Exception("ERRO: " + e);
        }

    }
}
