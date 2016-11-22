/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.entitys.Detalles;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author intercitydev
 */
@Controller
public class CuotasController {
    HttpSession sesion;
    String sesionUser;
    
     @RequestMapping("cuotas.htm")
    public ModelAndView getCuotas(HttpServletRequest request) {
        sesion = request.getSession();
        ModelAndView mav = new ModelAndView();
        String mensaje = null;
        Detalles detalle = (Detalles) sesion.getAttribute("cuenta");
        
        String country = detalle.getCiudad();
        String amount = "5";
        String myURL = "http://192.168.5.39/app_dev.php/public/get/rates";
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
                String data = URLEncoder.encode("country", "UTF-8") + "=" + URLEncoder.encode(country, "UTF-8");
                data += "&" + URLEncoder.encode("amount", "UTF-8") + "=" + URLEncoder.encode(amount, "UTF-8");
                
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
        String resultado = sb.toString();

       if (sesion.getAttribute("usuario") == null) {
           
            mav.setViewName("login/login");

        } else {
            sesionUser = sesion.getAttribute("usuario").toString();
             //Detalles detalle = (Detalles) sesion.getAttribute("cuenta");
            mav.addObject("country",detalle.getCiudad());
             mav.addObject("resultado", resultado);
            
            if (sesion.getAttribute("tipoUsuario").toString().compareTo("Administrador") == 0) {
                mav.setViewName("viewsAdmin/cuotasAdmin");
                System.out.println("el usuario es administrador");
            } else {
                mav.setViewName("panel/cuotas");
            }
        }
        return mav;
    }
      @RequestMapping("cuotasAdmin.htm")
    public ModelAndView getCuotasAdmin(HttpServletRequest request) {
        sesion = request.getSession();
        ModelAndView mav = new ModelAndView();
        String mensaje = null;
        Detalles detalle = (Detalles) sesion.getAttribute("cuenta");
        
        String country = detalle.getCiudad();
        String amount = "5";
        String myURL = "http://192.168.5.39/app_dev.php/public/get/rates";
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
                String data = URLEncoder.encode("country", "UTF-8") + "=" + URLEncoder.encode(country, "UTF-8");
                data += "&" + URLEncoder.encode("amount", "UTF-8") + "=" + URLEncoder.encode(amount, "UTF-8");
                
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
        String resultado = sb.toString();

       if (sesion.getAttribute("usuario") == null) {
           
            mav.setViewName("login/login");

        } else {
            sesionUser = sesion.getAttribute("usuario").toString();
             //Detalles detalle = (Detalles) sesion.getAttribute("cuenta");
            mav.addObject("country",detalle.getCiudad());
             mav.addObject("resultado", resultado);
            
            if (sesion.getAttribute("tipoUsuario").toString().compareTo("Administrador") == 0) {
                mav.setViewName("viewsAdmin/cuotasAdmin");
                System.out.println("el usuario es administrador");
            } else {
                mav.setViewName("panel/cuotas");
            }
        }
        return mav;
    }
    @RequestMapping(value = "postCuotas.htm", method = RequestMethod.POST)
    public ModelAndView postCuotas(HttpServletRequest request) {
        
        sesion = request.getSession();
        String country = request.getParameter("country");
        String amount = request.getParameter("amount");
        
       Detalles detalle = (Detalles) sesion.getAttribute("cuenta");
       System.out.print(detalle.getCiudad());

        String myURL = "http://192.168.5.39/app_dev.php/public/get/rates";
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
                String data = URLEncoder.encode("country", "UTF-8") + "=" + URLEncoder.encode(country, "UTF-8");
                data += "&" + URLEncoder.encode("amount", "UTF-8") + "=" + URLEncoder.encode(amount, "UTF-8");
                
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
        String resultado = sb.toString();
        
        
         ModelAndView mav = new ModelAndView();
         if (sesion.getAttribute("usuario") == null) {
           
            mav.setViewName("login/login");

        } else {
            sesionUser = sesion.getAttribute("usuario").toString();
             //Detalles detalle = (Detalles) sesion.getAttribute("cuenta");
            mav.addObject("country",detalle.getCiudad());
             mav.addObject("resultado", resultado);
            
            if (sesion.getAttribute("tipoUsuario").toString().compareTo("Administrador") == 0) {
                mav.setViewName("viewsAdmin/cuotasAdmin");
                System.out.println("el usuario es administrador");
            } else {
                mav.setViewName("panel/cuotas");
            }
        }
        return mav;
        

    }
    
}
