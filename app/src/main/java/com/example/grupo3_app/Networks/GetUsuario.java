package com.example.grupo3_app.Networks;

import com.example.grupo3_app.Teacher.Teacher;
import com.example.grupo3_app.User.User;

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

public class GetUsuario extends NetConfiguration implements Runnable {
    private final String theUrl = ddbbURL + "/teachers";

    private ArrayList<User> response;

    public GetUsuario() {
    }

    @Override
    public void run() {
        try {
            URL url = new URL(theUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");

            int responseCode = httpURLConnection.getResponseCode();
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

                JSONObject jsonUser = new JSONObject(theUnprocessedJSON);

                User user = new User();
                user = new User();
                user.setId(jsonUser.getInt("id"));
                user.setName(jsonUser.getString("name"));
                user.setSurname(jsonUser.getString("surname"));
                user.setEmail(jsonUser.getString("email"));
                user.setDescription(jsonUser.getString("description"));
                user.setLocation(jsonUser.getString("location"));
                user.setPhone(jsonUser.getString("phone"));
                user.setShift(jsonUser.getString("shift"));
                this.response.add(user);
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

    public ArrayList<User> getResponse() {
        return response;
    }
}