package com.example.grupo3_app.Networks;

import android.content.Context;
import android.content.res.Resources;

import com.example.grupo3_app.Login.Logear;
import com.example.grupo3_app.Response.LoginResponse;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ResetPass extends NetConfiguration implements Runnable  {
    public ResetPass(){super();}
    private  String theUrl;
    private Resources res;
    private String loginJson;
    private LoginResponse loginResponse;

    public ResetPass(Context context, String loginJson, String url) {
        res = context.getResources();;
        this.loginJson = loginJson;
        theUrl = ddbbURL + url;
    }
    @Override
    public void run() {
        try{
            URL url = new URL(theUrl);

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod( "PUT" );
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.setDoOutput(true);
            try (OutputStream ous = httpURLConnection.getOutputStream()) {
                byte[] output = loginJson.getBytes("utf-8");
                ous.write(output, 0, output.length);
            }
            int responseCode = httpURLConnection.getResponseCode();
            System.out.println(responseCode);
            loginResponse = new LoginResponse();

            if (responseCode == 400) {
                loginResponse.setAcceso(false);
//                loginResponse.setMensajeRespuesta(res.getString(R.string.error_registro_user));
            }else if (responseCode == 500) {
                loginResponse.setAcceso(false);
//                loginResponse.setMensajeRespuesta(res.getString(R.string.error_registro_user));
            } else if (responseCode == HttpURLConnection.HTTP_OK) {
                System.out.println("url");
                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader( httpURLConnection.getInputStream() ) );

                StringBuffer stringBuffer = new StringBuffer();
                String inputLine;
                while ((inputLine = bufferedReader.readLine()) != null) {
                    stringBuffer.append( inputLine );
                }
                bufferedReader.close();
            }

        }
        catch (Exception e) {
            System.out.println("ERROR: "+e.getMessage());
        }
    }
}
