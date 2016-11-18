/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.dao.TelefonosDao;
import com.dao.UsuariosDao;
import com.jsonEntitys.AccountLight;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.entitys.Telefonos;
import com.entitys.Usuarios;
import com.util.httpAccount;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 *
 * @author jorge
 */
@Controller
public class UsuariosController {

    public UsuariosController() {

    }

    HttpSession sesion;
    String sesionUser;
    String mensaje;
    
    @RequestMapping("usuarios.htm")
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
                mav.setViewName("usuarios/usuarios");
            } else {
                mav.setViewName("panel/panel");
            }
        }
        return mav;
    }
    
    @RequestMapping(value = "editarUsuarios.htm", method = RequestMethod.GET)
    public ModelAndView getEditUsuarios(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        sesion = request.getSession();
        if (sesion.getAttribute("usuario") == null) {
            mensaje = "Ingrese sus datos para poder ingresar al sistema";
            mav.addObject("mensaje", mensaje);
            mav.setViewName("login/login");

        } else {
            String userId = request.getParameter("idUsuario");
            UsuariosDao userDao= new UsuariosDao();
            Usuarios usuario = userDao.getUsuario(userId);
            
            if (sesion.getAttribute("tipoUsuario").toString().compareTo("Administrador") == 0) {
                mav.addObject("usuario", usuario);
                mav.setViewName("usuarios/editarUsuarios");
            } else {
                mav.addObject("usuario", usuario);
                mav.setViewName("panel/editarPerfil");
            }
        }
        return mav;
    }
}
