package com.example.grupo3_app.Networks;

import com.example.grupo3_app.Teacher.Teacher;
import com.example.grupo3_app.Topics.Topics;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;

public class GetTopics extends NetConfiguration implements Runnable {

    private final String theUrl = ddbbURL + "/topics";

    private ArrayList<Topics> response;
    public GetTopics(){}

    @Override
    public void run() {
        try {
            URL url = new URL(theUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");

            int responseCode = httpURLConnection.getResponseCode();
            System.out.println(HttpURLConnection.HTTP_ACCEPTED);
            if (responseCode == 400) {
                System.out.println("Fallo");
            } else if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(httpURLConnection.getInputStream()));

                StringBuffer stringBuffer = new StringBuffer();
                String inputLine;
                while ((inputLine = bufferedReader.readLine()) != null) {
                    stringBuffer.append(inputLine);
                }
                bufferedReader.close();
                String theUnprocessedJSON = stringBuffer.toString();
                JSONArray mainArray = new JSONArray(theUnprocessedJSON);
                this.response = new ArrayList<Topics>();
                Topics teacher;
                for(int i=0; i<mainArray.length();i++){
                    JSONObject profesor = mainArray.getJSONObject(i);
                    teacher = new Topics();
                    teacher.setId(profesor.getInt("id"));
                    teacher.setName( profesor.getString("name"));

                    this.response.add(teacher);
                    System.out.println(response);
                }
            }
        } catch (ProtocolException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<Topics> getResponse() {
        return response;
    }
}
