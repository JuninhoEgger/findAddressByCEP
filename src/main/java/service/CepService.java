package service;

import address.Address;
import com.google.gson.Gson;
import exception.ErrorException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static utils.Util.convertJsonToString;

public class CepService {

    private static final String WEB_SERVICE = "http://viacep.com.br/ws/";
    private static final Integer OK = 200;

    private CepService() {
        //Construtor vazio inutilizado apontado pelo sonar
    }

    public static Address findAddressByCep(String cep) throws Exception {
        String urlConnection = WEB_SERVICE + cep + "/json";

        try {
            URL url = new URL(urlConnection);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            if (connection.getResponseCode() != OK) {
                throw new ErrorException("HTTP error code: " + connection.getResponseCode());
            } else {
                BufferedReader response = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder jsonString = convertJsonToString(response);

                Gson gson = new Gson();
                Address address;
                address = gson.fromJson(jsonString.toString(), Address.class);

                return address;
            }

        } catch (Exception e) {
            throw new ErrorException("ERRO: " + e);
        }

    }
}
