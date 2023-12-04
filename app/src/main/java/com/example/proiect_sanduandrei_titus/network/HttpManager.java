package com.example.proiect_sanduandrei_titus.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpManager {
    private HttpURLConnection connection;
    private InputStream inputStream;
    private InputStreamReader inputStreamReader;
    private BufferedReader bufferedReader;
    private URL url;
    private final String urlAddress;

    public HttpManager(String urlAddress) {
        this.urlAddress = urlAddress;
    }

    public String process() {
        try {
            url = new URL(urlAddress);
            connection = (HttpURLConnection) url.openConnection();
            inputStream = connection.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);

            StringBuilder result = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                result.append(line);
            }

            return result.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            closeConnection();
        }
    }

    private void closeConnection() {
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        if (inputStreamReader != null) {
            try {
                inputStreamReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        if (connection != null) {
            connection.disconnect();
        }
    }
}
