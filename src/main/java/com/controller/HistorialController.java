/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.dao.TelefonosDao;
import com.dao.UsuariosDao;
import com.entitys.Telefonos;
import com.entitys.Usuarios;
import com.jsonEntitys.Llamadas;
import com.jsonEntitys.Recarga;
import com.util.httpHistorial;
import com.util.httpRecargas;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author jorge
 */
@Controller
public class HistorialController {

    HttpSession sesion;
    String sesionUser;
    String mensaje;

    @RequestMapping("historial.htm")
    public ModelAndView Historial(HttpServletRequest request) {
        sesion = request.getSession();
        ModelAndView mav = new ModelAndView();

        if (sesion.getAttribute("usuario") == null) {
            mensaje = "No esta logeado para obtener las vistas";
            mav.addObject("mensaje", mensaje);
            mav.setViewName("login/login");

        } else {
            mav.setViewName("historial/historial");
        }

        return mav;

    }

    @RequestMapping(value = "getHistorial.htm", method = RequestMethod.POST)
    public ModelAndView getHistorial(HttpServletRequest request) {
        sesion = request.getSession();
        ModelAndView mav = new ModelAndView();

        if (sesion.getAttribute("usuario") == null) {
            mensaje = "No esta logeado para obtener las vistas";
            mav.addObject("mensaje", mensaje);
            mav.setViewName("login/login");

        } else {
            String telUser = sesion.getAttribute("usuario").toString();
            Usuarios usuario = new Usuarios();
            UsuariosDao userDao = new UsuariosDao();
            Telefonos telefono = new Telefonos();
            TelefonosDao telDao = new TelefonosDao();
            telefono = telDao.getTelefono(telUser);
            usuario = userDao.getUsuario(telefono.getUsuarios().getIdUsuario());
            String idAccount = usuario.getIdAccount();
            //String idAccount ="22";

            String page = request.getParameter("page");
            String max = request.getParameter("max");
            String startDate = request.getParameter("startDate");
            String endDate = request.getParameter("endDate");
            String destination = request.getParameter("destination");
            
            System.out.println(idAccount +" "+page+" "+max+" "+startDate+" "+endDate+" "+destination+" ");

            httpHistorial historial = new httpHistorial();

            List<Llamadas> llamadas = historial.getHistorial(idAccount, page, max, startDate, endDate, destination);
            if (llamadas.isEmpty()) {
                mensaje = "No Existe historial de llamadas en las fechas comprendidas";
                mav.addObject("mensaje", mensaje);
                mav.setViewName("historial/historial");
            } else {
                mav.addObject("llamadas", llamadas);
                mav.setViewName("historial/historial");
            }
        }

        return mav;
    }
    @RequestMapping("recargas.htm")
    public ModelAndView Recargas(HttpServletRequest request) {
        sesion = request.getSession();
        ModelAndView mav = new ModelAndView();

        if (sesion.getAttribute("usuario") == null) {
            mensaje = "No esta logeado para obtener las vistas";
            mav.addObject("mensaje", mensaje);
            mav.setViewName("login/login");

        } else {
            mav.setViewName("historial/recargas");
        }

        return mav;

    }

    @RequestMapping(value = "getRecargas.htm", method = RequestMethod.POST)
    public ModelAndView getRecargas(HttpServletRequest request) {
        sesion = request.getSession();
        ModelAndView mav = new ModelAndView();

        if (sesion.getAttribute("usuario") == null) {
            mensaje = "No esta logeado para obtener las vistas";
            mav.addObject("mensaje", mensaje);
            mav.setViewName("login/login");

        } else {
            String telUser = sesion.getAttribute("usuario").toString();
            Usuarios usuario = new Usuarios();
            UsuariosDao userDao = new UsuariosDao();
            Telefonos telefono = new Telefonos();
            TelefonosDao telDao = new TelefonosDao();
            telefono = telDao.getTelefono(telUser);
            usuario = userDao.getUsuario(telefono.getUsuarios().getIdUsuario());
            String idAccount = usuario.getIdAccount();
            //String idAccount ="22";

            String page = request.getParameter("page");
            String max = request.getParameter("max");
            String startDate = request.getParameter("startDate");
            String endDate = request.getParameter("endDate");
           
            
            System.out.println(idAccount +"Pagina "+page+" Maximo  "+max+" fecha inicial "+startDate+" fecha final "+endDate);

            httpRecargas recargaHelper = new httpRecargas();

            List<Recarga> recargas = recargaHelper.getRecargas(idAccount, page, max, startDate, endDate);
            if (recargas.isEmpty()) {
                mensaje = "No se encontro historial de recargas";
                mav.addObject("mensaje", mensaje);
                mav.setViewName("historial/recargas");
            } else {
                mav.addObject("recargas", recargas);
                mav.setViewName("historial/recargas");
            }
        }

        return mav;
    }
   
}
