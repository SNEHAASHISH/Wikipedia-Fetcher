package tech.codingclub.Step_13_HttpURLConnection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class httpURLConnectionExample {
    private final static String USER_AGENT = "Mozilla/5.0";

    //HTTP GET request
    public static String sendGet(String urlStr) throws Exception {
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader read = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ( (line = read.readLine()) != null ) {
            result.append(line);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        try {
            System.out.println(sendGet("https://codingclub.tech/test-get-request?name=Sneh"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
