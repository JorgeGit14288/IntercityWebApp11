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
import com.jsonEntitys.Account;
import com.jsonEntitys.AccountLight;
import com.util.httpAccount;
import java.io.IOException;
import java.net.MalformedURLException;
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
 * @author intercitydev
 */
@Controller
public class AdminController {

    HttpSession sesion;
    String mensaje;
    String sesionUser;

    @RequestMapping("panelAdmin.htm")
    public ModelAndView getPanel(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        sesion = request.getSession();
        if (sesion.getAttribute("usuario") == null) {
            mensaje = "Ingrese sus datos para poder ingresar al sistema";
            mav.addObject("mensaje", mensaje);
            mav.setViewName("login/login");

        } else {
            if (sesion.getAttribute("tipoUsuario").toString().compareTo("Administrador") == 0) {
                mav.setViewName("viewsAdmin/panelAdmin");
            } else {
                mav.setViewName("panel/panel");
            }
        }
        return mav;
    }

    @RequestMapping("listUsuarios.htm")
    public ModelAndView getListUsuarios(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        sesion = request.getSession();
        if (sesion.getAttribute("usuario") == null) {
            mensaje = "Ingrese sus datos para poder ingresar al sistema";
            mav.addObject("mensaje", mensaje);
            mav.setViewName("login/login");

        } else {
            if (sesion.getAttribute("tipoUsuario").toString().compareTo("Administrador") == 0) {

                UsuariosDao userDao = new UsuariosDao();
                List<Usuarios> listUser = userDao.getAllUsuarios();
                mav.addObject("listaUsuarios", listUser);
                //sesion.setAttribute("listaUsuarios", listUser);
                mav.setViewName("viewsAdmin/listUsuarios");
            } else {
                mav.setViewName("panel/panel");
            }
        }
        return mav;
    }

    @RequestMapping("listTelefonos.htm")
    public ModelAndView getlistTelefonos(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        sesion = request.getSession();
        if (sesion.getAttribute("usuario") == null) {
            mensaje = "Ingrese sus datos para poder ingresar al sistema";
            mav.addObject("mensaje", mensaje);
            mav.setViewName("login/login");

        } else {
            if (sesion.getAttribute("tipoUsuario").toString().compareTo("Administrador") == 0) {
                mav.setViewName("viewsAdmin/listTelefonos");
            } else {
                mav.setViewName("panel/panel");
            }
        }
        return mav;
    }

    @RequestMapping(value = "editUsuarios.htm", method = RequestMethod.POST)
    public ModelAndView getEditUsuarios(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        sesion = request.getSession();
        if (sesion.getAttribute("usuario") == null) {
            mensaje = "Ingrese sus datos para poder ingresar al sistema";
            mav.addObject("mensaje", mensaje);
            mav.setViewName("login/login");

        } else {
            if (sesion.getAttribute("tipoUsuario").toString().compareTo("Administrador") == 0) {
                mav.setViewName("viewsAdmin/editUsuarios");
            } else {
                mav.setViewName("panel/panel");
            }
        }
        return mav;
    }

    @RequestMapping(value = "editTelefonos.htm", method = RequestMethod.POST)
    public ModelAndView getEditTelefonos(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        sesion = request.getSession();
        if (sesion.getAttribute("usuario") == null) {
            mensaje = "Ingrese sus datos para poder ingresar al sistema";
            mav.addObject("mensaje", mensaje);
            mav.setViewName("login/login");

        } else {
            if (sesion.getAttribute("tipoUsuario").toString().compareTo("Administrador") == 0) {
                mav.setViewName("viewsAdmin/editTelefonos");
            } else {
                mav.setViewName("panel/panel");
            }
        }
        return mav;
    }

    // ATRIBUTOS INICIALES ----------------------------------------------------
    @RequestMapping("perfilAdmin.htm")
    public ModelAndView getPerfilAdmin(HttpServletRequest request) {
        sesion = request.getSession();
        ModelAndView mav = new ModelAndView();
        String mensaje = null;

        if (sesion.getAttribute("usuario") == null) {

            mav.setViewName("login/login");

        } else {
            String sesUser = sesion.getAttribute("usuario").toString();
            String temp = sesUser.replace("-", "");
            System.out.println(temp);
            Account account = new Account();
            httpAccount accountHelper = new httpAccount();
            account = accountHelper.getAccountObject(temp);
            System.out.println("Regrese con datos para la vista " + account.getFirst_name() + account.getLanguaje_id());
            mav.addObject("account", account);
            sesionUser = sesion.getAttribute("usuario").toString();
            if (sesion.getAttribute("tipoUsuario").toString().compareTo("Administrador") == 0) {
                mav.setViewName("viewsAdmin/perfilAdmin");
                System.out.println("el usuario es administrador");
            } else {
                mav.setViewName("panel/perfil");
            }
        }
        return mav;
    }

   
}
