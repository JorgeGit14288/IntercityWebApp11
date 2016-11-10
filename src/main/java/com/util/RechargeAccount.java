/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util;

import com.google.gson.Gson;
import com.jsonEntitys.Recarga;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author intercitydev
 */
public class RechargeAccount {

    public boolean isConnect() throws MalformedURLException, IOException {
        boolean conectado = false;
        try {
            String myURL = "http://192.168.5.44/app_dev.php/cus/getaccount/";
            URLConnection urlConn = null;
            URL url = new URL(myURL);
            urlConn = url.openConnection();
            if (urlConn == null) {
                conectado = false;
            } else {
                conectado = true;
            }
        } catch (Exception e) {
            conectado = false;
        }
        return conectado;
    }

    public List<Recarga> getRecargas(String idAccount, String page, String max, String startDate, String endDate) {

        
     //   System.out.println("OBTENER SOLO UN ARRAY DE CADENA JSON");
        String myURL = "http://192.168.5.44/app_dev.php/cus/recharges/history/" + idAccount + ".json";
       // System.out.println("Requested URL:" + myURL);
        StringBuilder sb = new StringBuilder();
        URLConnection urlConn = null;
        InputStreamReader in = null;
        try {
            URL url = new URL(myURL);
            urlConn = url.openConnection();
            if (urlConn != null) {
                urlConn.setReadTimeout(60 * 1000);
                urlConn.setDoOutput(true);
                String data = URLEncoder.encode("page", "UTF-8") + "=" + URLEncoder.encode(page, "UTF-8");
                data += "&" + URLEncoder.encode("max", "UTF-8") + "=" + URLEncoder.encode(max, "UTF-8");
                data += "&" + URLEncoder.encode("startDate", "UTF-8") + "=" + URLEncoder.encode(startDate, "UTF-8");
                data += "&" + URLEncoder.encode("endDate", "UTF-8") + "=" + URLEncoder.encode(endDate, "UTF-8");
                System.out.println("los Datos a enviar por POST son " + data);

                try ( //obtenemos el flujo de escritura
                        OutputStreamWriter wr = new OutputStreamWriter(urlConn.getOutputStream())) {
                    //escribimos
                    wr.write(data);
                    wr.flush();
//cerramos la conexiÃ³n
                }
            }
            if (urlConn != null && urlConn.getInputStream() != null) {
                in = new InputStreamReader(urlConn.getInputStream(),
                        Charset.defaultCharset());

                BufferedReader bufferedReader = new BufferedReader(in);
                if (bufferedReader != null) {
                    int cp;
                    while ((cp = bufferedReader.read()) != -1) {
                        sb.append((char) cp);
                    }
                    bufferedReader.close();
                }
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Exception while calling URL:" + myURL, e);
        }
        String jsonResult = sb.toString();
        System.out.println("DATOS ENVIADOS DEL SERVIDOR " + sb.toString());

       // System.out.println("\n\n--------------------OBTENEMOS OBJETO JSON NATIVO DE LA PAGINA, USAMOS EL ARRAY DATA---------------------------\n\n");
        JSONObject objJason = new JSONObject(jsonResult);
        // JSONArray dataJson = new JSONArray();
        //  dataJson = objJason.getJSONArray("data");
        String jdata = objJason.optString("data");
        String mensaje = objJason.optString("message");
        System.out.println("\n MENSAJE DEL SERVIDOR " + mensaje);
     //   System.out.println(" el objeto jdata es " + jdata);
        objJason = new JSONObject(jdata);
       // System.out.println("objeto normal 1 " + objJason.toString());
//
        jdata = objJason.optString("items");
       // System.out.println("\n\n el objeto jdata es " + jdata);
        JSONArray jsonArray = new JSONArray();
        Gson gson = new Gson();
        //objJason = gson.t
        jsonArray = objJason.getJSONArray("items");
       // System.out.println("\n\nEL ARRAY FINAL ES " + jsonArray.toString());
/*
        List<String> list = new ArrayList<String>();
        for (int i = 0; i
                < jsonArray.length(); i++) {
            list.add(String.valueOf(i));
            list.add(jsonArray.getJSONObject(i).getString("created_date"));
            list.add(jsonArray.getJSONObject(i).getString("description"));
            list.add(String.valueOf(jsonArray.getJSONObject(i).getInt("credit")));
            list.add(jsonArray.getJSONObject(i).getString("before_balance"));
            list.add(jsonArray.getJSONObject(i).getString("after_balance"));
        }
        System.out.println("\n\nel array java contiene "+ list.toString());
*/
        List<Recarga> recargas = new ArrayList<Recarga>();
        
        for (int i=0; i<jsonArray.length(); i++){
            Recarga recarga = new Recarga();
            recarga.setNo(i);
            recarga.setFecha(jsonArray.getJSONObject(i).getString("created_date"));
            recarga.setDescripcion(jsonArray.getJSONObject(i).getString("description"));
            recarga.setCredito(String.valueOf(jsonArray.getJSONObject(i).getInt("credit")));
            recarga.setSaldoAnterior(jsonArray.getJSONObject(i).getString("before_balance"));
            recarga.setSaldoPosterior(jsonArray.getJSONObject(i).getString("after_balance"));
            
            recargas.add(recarga);
        }
        
         for (int i = 0; i < recargas.size(); i++) {
            System.out.print("\n\nNo" + recargas.get(i).getNo());
            System.out.print("\nFecna " + recargas.get(i).getFecha());
            System.out.print("\nDescripcion " + recargas.get(i).getDescripcion());
            System.out.print("\nMonto " + recargas.get(i).getCredito());
            System.out.print("\nSaldo Anterior " + recargas.get(i).getSaldoAnterior());
            System.out.print("\nSaldo Posterior" + recargas.get(i).getSaldoPosterior());

        }
      return recargas;
        
  
    }

}
