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

public class EnviarEmail extends NetConfiguration implements Runnable {

    public EnviarEmail(){super();}
    private  String theUrl;
    private Resources res;
    private String loginJson;
    private LoginResponse loginResponse;
    private Logear response;

    public EnviarEmail(Context context, String loginJson, String url) {
        res = context.getResources();;
        this.loginJson = loginJson;
        theUrl = ddbbURL + url;
    }
    @Override
    public void run() {
        try{
            URL url = new URL(theUrl);
            System.out.println(url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod( "POST" );
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.setDoOutput(true);
            try (OutputStream ous = httpURLConnection.getOutputStream()) {
                byte[] output = loginJson.getBytes("utf-8");
                ous.write(output, 0, output.length);
            }
            int responseCode = httpURLConnection.getResponseCode();
            System.out.println("funciono");

            loginResponse = new LoginResponse();

            if (responseCode == 400) {
                loginResponse.setAcceso(false);
//                loginResponse.setMensajeRespuesta(res.getString(R.string.error_registro_user));
            }else if (responseCode == 500) {
                loginResponse.setAcceso(false);
//                loginResponse.setMensajeRespuesta(res.getString(R.string.error_registro_user));
            } else if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader( httpURLConnection.getInputStream() ) );

                StringBuffer stringBuffer = new StringBuffer();
                String inputLine;
                while ((inputLine = bufferedReader.readLine()) != null) {
                    stringBuffer.append( inputLine );
                }
                bufferedReader.close();
                String theUnprocessedJSON = stringBuffer.toString();
                System.out.println("funciono");
                JSONObject jsonUser = new JSONObject (theUnprocessedJSON);
                Logear email = new Logear();
                email = new Logear();
                email.setId(jsonUser.getLong("id"));
                email.setEmail(jsonUser.getString("email"));
                this.response = email;
//                for(int i=0; i<mainArray.length();i++){
//                    System.out.println("Entro al bucle");
//                    JSONObject log = mainArray.getJSONObject(i);
//                    logear = new Logear();
//                    logear.setId(log.getLong("id"));
//                    logear.setEmail(log.getString("email"));
//                    logear.setAdmin(log.getBoolean("admin"));
//                    logear.setAccesToken(log.getString("token"));
//                    this.response.add(logear);
//                }



//                loginResponse.setAcceso(true);
////                loginResponse.setMensajeRespuesta(res.getString(R.string.favorito_aniadido));
//                try(BufferedReader br = new BufferedReader(
//                        new InputStreamReader(httpURLConnection.getInputStream(), "utf-8"))) {
//                    StringBuilder response = new StringBuilder();
//                    String responseLine = null;
//                    while ((responseLine = br.readLine()) != null) {
//                        response.append(responseLine.trim());
//                    }
//                    br.close();
//                    System.out.println(Integer.parseInt(response.toString()));
//                    loginResponse.setSqlReturn(Integer.parseInt(response.toString()));
//                }
            }
        }
        catch (Exception e) {
            System.out.println("ERROR: "+e.getMessage());
        }
    }
    public Logear getResponse() {
        return response;
    }
}