package main.java.jumpdupe.network;

import main.java.jumpdupe.Handler;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ServerConnection {

    private String serverUrl = "";
    private String response = "";
    private String requestBody;
    public HttpURLConnection urlConnection;

    public ServerConnection(){
        this.requestBody = Handler.output;
    }

    public void request(String requestUrl, String requestType){

        try {
            URL url = new URL("https://" + serverUrl + requestUrl);

            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod(requestType);

            //ADD HEADERS HERE
            addHeaders();
            //ADD HEADERS HERE

            urlConnection.setDoOutput(true);
            //BODY HERE
            DataOutputStream outputStream = new DataOutputStream(urlConnection.getOutputStream());
            outputStream.writeBytes(requestBody);
            //BODY HERE


            urlConnection.connect();

            response = requestResponse(urlConnection);
            //System.out.println(serverUrl + " " + response);
        }catch (Exception e){
            System.out.println("Error in request: " + e.getMessage());
        }

    }

    private void addHeaders(){
        urlConnection.setRequestProperty("accept", "*/*");
        urlConnection.setRequestProperty("accept-encoding", "gzip, deflate");
        urlConnection.setRequestProperty("content-type", "application/json");
        urlConnection.setRequestProperty("host", serverUrl);
        urlConnection.setRequestProperty("user-agent", "UnityPlayer/2019.4.36f1 (UnityWebRequest/1.0, libcurl/7.75.0-DEV)");
    }

    private String requestResponse(HttpURLConnection urlConnection){
        String line, info = "";
        try {
            int responseCode = urlConnection.getResponseCode();
            BufferedReader reader;
            if (200 <= responseCode && responseCode <= 299) {
                reader = new BufferedReader(new InputStreamReader((urlConnection.getInputStream())));
            } else reader = new BufferedReader(new InputStreamReader(urlConnection.getErrorStream()));
            while ((line = reader.readLine()) != null) {
                info += line;
            }
            reader.close();
        }catch (Exception e){
            System.out.println("Error in requestResponse:" + e.getMessage());
        }
        return info;
    }

    public String getResponse(){
        return response;
    }

    public void setServerUrl(String serverUrl){
        this.serverUrl = serverUrl;
    }

}
