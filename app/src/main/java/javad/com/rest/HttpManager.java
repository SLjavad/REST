package javad.com.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by javad on 2/19/2017.
 */

public class HttpManager {

    public String GetData(String uri)
    {
        BufferedReader bf = null;
        try {
            URL url = new URL(uri);
            HttpURLConnection client = (HttpURLConnection) url.openConnection();
            StringBuilder sb = new StringBuilder();
            bf = new BufferedReader(new InputStreamReader(client.getInputStream()));

            String data;
            while ((data = bf.readLine()) != null)
            {
                sb.append(data + "\n");
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        finally {
            if (bf != null)
            {
                try {
                    bf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return  null;
                }
            }
        }
    }
}
