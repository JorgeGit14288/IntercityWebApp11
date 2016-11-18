/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.dao.TelefonosDao;
import com.dao.UsuariosDao;
import com.jsonEntitys.Account;
import com.entitys.Telefonos;
import com.entitys.Usuarios;
import com.jsonEntitys.AccountLight;
import com.util.httpAccount;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
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

public class PerfilController {

    HttpSession sesion;
    String sesionUser;

    @RequestMapping("perfil.htm")
    public ModelAndView getPerfil(HttpServletRequest request) {
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

    @RequestMapping("editarPerfil.htm")
    public ModelAndView registrarUsuarios(HttpServletRequest request
    ) {
        sesion = request.getSession();
        ModelAndView mav = new ModelAndView();
        String mensaje = null;

        if (sesion.getAttribute("usuario") == null) {
            mav.setViewName("login/login");

        } else {
            String sesUser = sesion.getAttribute("usuario").toString();
            System.out.println("el usuario a editar es "+sesUser);
            httpAccount accountHelper = new httpAccount();
            String idAccount = accountHelper.getIdAccount(sesUser);
            
            TelefonosDao telDao = new TelefonosDao();
            Telefonos telefono = new Telefonos();
            telefono = telDao.getTelefono(sesUser);
            
            
            Usuarios usuario = new Usuarios();
            UsuariosDao userDao = new UsuariosDao();
            usuario = userDao.getUsuario(telefono.getUsuarios().getIdUsuario());
            
            mav.addObject("telefono", telefono);
            mav.addObject("user", usuario);

            if (sesion.getAttribute("tipoUsuario").toString().compareTo("Administrador") == 0) {
                mav.setViewName("viewsAdmin/editarPerfilAdmin");
            } else {
                mav.setViewName("panel/editarPerfil");
            }
        }
        return mav;
    }
     @RequestMapping("editarPerfilAdmin.htm")
    public ModelAndView editarPerfilAdmin(HttpServletRequest request
    ) {
        sesion = request.getSession();
        ModelAndView mav = new ModelAndView();
        String mensaje = null;

        if (sesion.getAttribute("usuario") == null) {
            mav.setViewName("login/login");

        } else {
            String sesUser = sesion.getAttribute("usuario").toString();
            System.out.println("el usuario a editar es "+sesUser);
            httpAccount accountHelper = new httpAccount();
            String idAccount = accountHelper.getIdAccount(sesUser);
            
            TelefonosDao telDao = new TelefonosDao();
            Telefonos telefono = new Telefonos();
            telefono = telDao.getTelefono(sesUser);
            
            
            Usuarios usuario = new Usuarios();
            UsuariosDao userDao = new UsuariosDao();
            usuario = userDao.getUsuario(telefono.getUsuarios().getIdUsuario());
            
            mav.addObject("telefono", telefono);
            mav.addObject("user", usuario);

            if (sesion.getAttribute("tipoUsuario").toString().compareTo("Administrador") == 0) {
                mav.setViewName("viewsAdmin/editarPerfilAdmin");
            } else {
                mav.setViewName("panel/editarPerfil");
            }
        }
        return mav;
    }

    @RequestMapping(value = "validarEditarPerfil.htm", method = RequestMethod.POST)
    public ModelAndView validarRegistrarUsuarios(HttpServletRequest request
    ) throws MalformedURLException, IOException {
        sesion = request.getSession();
        ModelAndView mav = new ModelAndView();
        String mensaje = null;
        if (sesion.getAttribute("usuario") == null) {
            mav.setViewName("login/login");
        } else {
            String idUsuario = request.getParameter("idUsuario");
            String TelArea = request.getParameter(sesion.getAttribute("usuario").toString());
            String nombres = request.getParameter("nombres");
            String apellidos = request.getParameter("apellidos");
            String direccion = request.getParameter("direccion");
            String ciudad = request.getParameter("ciudad");
            String codigoPostal = request.getParameter("codigoPostal");
            String email = request.getParameter("email");
            String lenguaje = request.getParameter("lenguaje");
            boolean notifyEmail = false;
            boolean notifyFlag = false;

            if (request.getParameter("notifyEmail") != null) {
                notifyEmail = true;
            }
            if (request.getParameter("notifyFlag") != null) {
                notifyFlag = true;
            }
            AccountLight account = new AccountLight();
            Usuarios usuario = new Usuarios();
            UsuariosDao userDao = new UsuariosDao();

            account.setAddress(direccion);
            account.setCity(ciudad);
            account.setEmail(email);
            account.setFirstName(nombres);
            account.setLastName(apellidos);
            account.setNotifyEmail(notifyEmail);
            account.setNotifyEmail(notifyEmail);
            account.setPostalCode(codigoPostal);
            account.setLanguaje_id(lenguaje);

            usuario = userDao.getUsuario(idUsuario);

            usuario.setApellidos(apellidos);
            usuario.setEmail(email);
            //usuario.setIdUsuario(idUsuario);
            System.out.print("el id del usuario es " + idUsuario);
            usuario.setNombres(nombres);
            usuario.setPais(ciudad);
            usuario.setStatus("Activo");

            httpAccount accountHelper = new httpAccount();

            if (userDao.updateUsuarios(usuario)) {

                usuario = userDao.getUsuario(idUsuario);
                if (usuario.getIdAccount() == null) {
                    System.out.println("No se ha enontrado el accountId del usuario se buscara");
                    usuario.setIdAccount(accountHelper.getIdAccount(TelArea));
                    userDao.updateUsuarios(usuario);
                    System.out.println("Se ha registrado el usuario con el servidor en linea ");
                } else {
                    System.out.println("Se encontro el accountId del usuario ");
                    accountHelper.setAccountObject(account, usuario.getIdAccount());
                    System.out.println("se ha actualizado el usuario al servidor ");
                }

                if (sesion.getAttribute("tipoUsuario").toString().compareTo("Administrador") == 0) {
                    mav.setViewName("viewsAdmin/perfilAdmin");
                } else {
                    mav.setViewName("panel/perfil");
                }
            } else {
                if (sesion.getAttribute("tipoUsuario").toString().compareTo("Administrador") == 0) {
                    mav.setViewName("viewsAdmin/editarPerfilAdmin");
                } else {
                    mav.setViewName("perfil/editarPerfil");
                }

            }
        }
        return mav;
    }
    
    

}
