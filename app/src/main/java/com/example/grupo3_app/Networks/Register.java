package com.example.grupo3_app.Networks;

import android.content.Context;
import android.content.res.Resources;

import com.example.grupo3_app.R;
import com.example.grupo3_app.Response.RegisterResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class Register extends NetConfiguration implements Runnable {

    private final String theUrl = ddbbURL + "/auth/signup";
    private RegisterResponse registerResponse;
    private Resources res;
    private String userRegisterJson;

    public Register (Context context, String userRegisterJson) {
        res = context.getResources();
        this.userRegisterJson = userRegisterJson;
    }

    @Override
    public void run() {
        try {
            URL url = new URL(theUrl);
            System.out.println("URL: " + theUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.setDoOutput(true);

            try (OutputStream ous = httpURLConnection.getOutputStream()) {
                byte[] output = userRegisterJson.getBytes("utf-8");
                ous.write(output, 0, output.length);
            }

            int responseCode = httpURLConnection.getResponseCode();

            System.out.println(responseCode);
            System.out.println(userRegisterJson);
            registerResponse = new RegisterResponse();

            if (responseCode == 400) {
                registerResponse.setAcceso(false);
            } else if (responseCode == 500) {
                registerResponse.setAcceso(false);
            } else if (responseCode == HttpURLConnection.HTTP_CREATED) {
                registerResponse.setAcceso(true);

//                try (BufferedReader br = new BufferedReader(
//                        new InputStreamReader(httpURLConnection.getInputStream(), "utf-8"))) {
//                    StringBuilder response = new StringBuilder();
//                    String responseLine = null;
//                    while ((responseLine = br.readLine()) != null) {
//                        response.append(responseLine.trim());
//                    }
//                    br.close();
//                    registerResponse.setSqlReturn(Integer.parseInt(response.toString()));
//                }
            }
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public RegisterResponse getRegisterResponse () {
//        return registerResponse;
//    }
}
