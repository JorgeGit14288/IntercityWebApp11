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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
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
    String startDate;
    String endDate;
    String destination;
    String idAccount;
    int pagenext;
    int pageprevius;
    int page = 1;
    int max = 10;
    List<Llamadas> llamadas;
    List<Recarga> recargas;

    @RequestMapping("historial.htm")
    public ModelAndView Historial(HttpServletRequest request) {
        sesion = request.getSession();
        ModelAndView mav = new ModelAndView();

        Date Datenow = new Date(System.currentTimeMillis());
        SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat hour = new SimpleDateFormat("HH:mm:ss");

         endDate= date.format(Datenow);
         System.out.println(endDate);
      //  System.out.println(hour.format(Datenow));
       // System.out.println(Datenow);

        if (sesion.getAttribute("usuario") == null) {
            mensaje = "No esta logeado para obtener las vistas";
            mav.addObject("mensaje", mensaje);
            mav.setViewName("login/login");

        } else {
            page = 1;
            pagenext = page + 1;
            pageprevius = page - 1;
            mav.addObject("pagenext", pagenext);
            mav.addObject("pageprevius", pageprevius);
            mav.addObject("page", page);
            mav.addObject("max", max);
            mav.addObject("endDate", endDate);
            
            
            if (sesion.getAttribute("tipoUsuario").toString().compareTo("Administrador") == 0) {
                mav.setViewName("viewsAdmin/historialAdmin");
                System.out.println("El usuario es administrador ");
            } else {
                mav.setViewName("historial/historial");
            }

        }

        return mav;

    }

    @RequestMapping(value = "getHistorial.htm", method = RequestMethod.GET)
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
            idAccount = usuario.getIdAccount();

            //String idAccount = "22";
            String max2 = request.getParameter("max");
            String startDate2 = request.getParameter("startDate");
            String endDate2 = request.getParameter("endDate");
            String destination2 = request.getParameter("destination");
            String page2 = request.getParameter("page");
            if (max2 != null) {
                max = Integer.valueOf(max2);
            }
            if (startDate2 != null) {
                startDate = startDate2;
            }
            if (endDate2 != null) {
                endDate = endDate2;
            }
            if (destination2 != null) {
                destination = destination2;
            }
            if (page2 != null) {
                page = Integer.parseInt(page2);
            }
            if (page == 1) {
                pageprevius = 1;
            } else {
                pageprevius = page - 1;
            }

            pagenext = page + 1;

            System.out.println(idAccount + " " + page + " " + max + " " + startDate + " " + endDate + " " + destination + " ");

            this.llenarHistorial(idAccount, startDate, endDate, String.valueOf(page), String.valueOf(max), destination);
            if (llamadas.isEmpty()) {
                mensaje = "No Existe historial de llamadas en las fechas comprendidas";
                mav.addObject("startDate", startDate);
                mav.addObject("endDate", endDate);
                mav.addObject("page", page);
                mav.addObject("pagenext", pagenext);
                mav.addObject("pageprevius", pageprevius);
                mav.addObject("max", max);
                mav.addObject("destination", destination);
                mav.addObject("mensaje", mensaje);

                if (sesion.getAttribute("tipoUsuario").toString().compareTo("Administrador") == 0) {
                    mav.setViewName("viewsAdmin/historialAdmin");
                } else {
                    mav.setViewName("historial/historial");
                }

            } else {
                mav.addObject("startDate", startDate);
                mav.addObject("endDate", endDate);
                mav.addObject("pagenext", pagenext);
                mav.addObject("pageprevius", pageprevius);
                mav.addObject("page", page);
                mav.addObject("max", max);
                mav.addObject("destination", destination);
                mav.addObject("llamadas", llamadas);
                if (sesion.getAttribute("tipoUsuario").toString().compareTo("Administrador") == 0) {
                    mav.setViewName("viewsAdmin/historialAdmin");
                } else {
                    mav.setViewName("historial/historial");
                }

            }
        }
        return mav;
    }

    public void llenarHistorial(String idAccount, String startDate, String endDate, String page, String max, String destination) {
        httpHistorial historial = new httpHistorial();
        this.llamadas = historial.getHistorial(idAccount, page, max, startDate, endDate, destination);
    }

    public void llenarRecargas(String idAccount, String startDate, String endDate, String page, String max) {
        httpRecargas recargaHelper = new httpRecargas();
        recargas = recargaHelper.getRecargas(idAccount, page, max, startDate, endDate);
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
            page = 1;
            pagenext = page + 1;
            pageprevius = page - 1;
            mav.addObject("pagenext", pagenext);
            mav.addObject("pageprevius", pageprevius);
            mav.addObject("page", page);
            mav.addObject("max", max);
            if (sesion.getAttribute("tipoUsuario").toString().compareTo("Administrador") == 0) {
                mav.setViewName("viewsAdmin/recargasAdmin");
                System.out.println("el usuario es administrador");
            } else {
                mav.setViewName("historial/recargas");
            }
        }

        return mav;

    }

    @RequestMapping(value = "getRecargas.htm", method = RequestMethod.GET)
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
            idAccount = usuario.getIdAccount();

            //String idAccount = "22";
            String max2 = request.getParameter("max");
            String startDate2 = request.getParameter("startDate");
            String endDate2 = request.getParameter("endDate");
            String destination2 = request.getParameter("destination");
            String page2 = request.getParameter("page");
            if (max2 != null) {
                max = Integer.valueOf(max2);
            }
            if (startDate2 != null) {
                startDate = startDate2;
            }
            if (endDate2 != null) {
                endDate = endDate2;
            }
            if (destination2 != null) {
                destination = destination2;
            }
            if (page2 != null) {
                page = Integer.parseInt(page2);
            }
            if (page == 1) {
                pageprevius = 1;
            } else {
                pageprevius = page - 1;
            }

            pagenext = page + 1;

            System.out.println("account" + idAccount + " page  " + page + " max " + max + " startDate " + startDate + " endDate " + endDate);

            this.llenarRecargas(idAccount, startDate, endDate, String.valueOf(page), String.valueOf(max));
            if (recargas.isEmpty()) {
                mensaje = "No Existe historial de llamadas en las fechas comprendidas";
                mav.addObject("startDate", startDate);
                mav.addObject("endDate", endDate);
                mav.addObject("page", page);
                mav.addObject("pagenext", pagenext);
                mav.addObject("pageprevius", pageprevius);
                mav.addObject("max", max);
                mav.addObject("mensaje", mensaje);

                if (sesion.getAttribute("tipoUsuario").toString().compareTo("Administrador") == 0) {
                    mav.setViewName("viewsAdmin/recargasAdmin");
                    System.out.println("el usuario es administrador");
                } else {
                    mav.setViewName("historial/recargas");
                }

            } else {
                mav.addObject("startDate", startDate);
                mav.addObject("endDate", endDate);
                mav.addObject("pagenext", pagenext);
                mav.addObject("pageprevius", pageprevius);
                mav.addObject("page", page);
                mav.addObject("max", max);

                if (sesion.getAttribute("tipoUsuario").toString().compareTo("Administrador") == 0) {
                    mav.setViewName("viewsAdmin/recargasAdmin");
                } else {
                    mav.setViewName("historial/recargas");
                }
            }
        }
        return mav;
    }

}
