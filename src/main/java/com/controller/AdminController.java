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
    
    @RequestMapping("panelAdmin.htm")
    public ModelAndView getPanel(HttpServletRequest request)
    {
        ModelAndView mav = new ModelAndView();
        sesion = request.getSession();
        if (sesion.getAttribute("usuario")==null)
        {
            mensaje ="Ingrese sus datos para poder ingresar al sistema";
            mav.addObject("mensaje", mensaje);
            mav.setViewName("login/login");
            
        }
        else
        {
            if(sesion.getAttribute("tipoUsuario").toString().compareTo("Administrador")==0)
            {
                mav.setViewName("viewsAdmin/panelAdmin");
            }
            else
            {
                mav.setViewName("panel/panel");
            }
        }
        return mav;   
    }
    @RequestMapping("listUsuarios.htm")
    public ModelAndView getListUsuarios(HttpServletRequest request)
    {
        ModelAndView mav = new ModelAndView();
        sesion = request.getSession();
        if (sesion.getAttribute("usuario")==null)
        {
            mensaje ="Ingrese sus datos para poder ingresar al sistema";
            mav.addObject("mensaje", mensaje);
            mav.setViewName("login/login");
            
        }
        else
        {
            if(sesion.getAttribute("tipoUsuario").toString().compareTo("Administrador")==0)
            {
                mav.setViewName("viewsAdmin/listUsuarios");
            }
            else
            {
                mav.setViewName("panel/panel");
            }
        }
        return mav;   
    }
     @RequestMapping("listTelefonos.htm")
    public ModelAndView getlistTelefonos(HttpServletRequest request)
    {
        ModelAndView mav = new ModelAndView();
        sesion = request.getSession();
        if (sesion.getAttribute("usuario")==null)
        {
            mensaje ="Ingrese sus datos para poder ingresar al sistema";
            mav.addObject("mensaje", mensaje);
            mav.setViewName("login/login");
            
        }
        else
        {
            if(sesion.getAttribute("tipoUsuario").toString().compareTo("Administrador")==0)
            {
                mav.setViewName("viewsAdmin/listTelefonos");
            }
            else
            {
                mav.setViewName("panel/panel");
            }
        }
        return mav;   
    }
    @RequestMapping(value="editUsuarios.htm", method = RequestMethod.POST)
    public ModelAndView getEditUsuarios(HttpServletRequest request)
    {
        ModelAndView mav = new ModelAndView();
        sesion = request.getSession();
        if (sesion.getAttribute("usuario")==null)
        {
            mensaje ="Ingrese sus datos para poder ingresar al sistema";
            mav.addObject("mensaje", mensaje);
            mav.setViewName("login/login");
            
        }
        else
        {
            if(sesion.getAttribute("tipoUsuario").toString().compareTo("Administrador")==0)
            {
                mav.setViewName("viewsAdmin/editUsuarios");
            }
            else
            {
                mav.setViewName("panel/panel");
            }
        }
        return mav;   
    }
    @RequestMapping(value="editTelefonos.htm", method = RequestMethod.POST)
    public ModelAndView getEditTelefonos(HttpServletRequest request)
    {
        ModelAndView mav = new ModelAndView();
        sesion = request.getSession();
        if (sesion.getAttribute("usuario")==null)
        {
            mensaje ="Ingrese sus datos para poder ingresar al sistema";
            mav.addObject("mensaje", mensaje);
            mav.setViewName("login/login");
            
        }
        else
        {
            if(sesion.getAttribute("tipoUsuario").toString().compareTo("Administrador")==0)
            {
                mav.setViewName("viewsAdmin/editTelefonos");
            }
            else
            {
                mav.setViewName("panel/panel");
            }
        }
        return mav;   
    }
    
    
    
    // ATRIBUTOS INICIALES ----------------------------------------------------
        @ModelAttribute("telefonosList")
    public List<Telefonos> listaTelefonos() {
        //Data referencing for web framework checkboxes
        ModelAndView mav = new ModelAndView();
        TelefonosDao userHelper = new TelefonosDao();
        List<Telefonos> telefonosList = userHelper.getAllTelefonos();
        return telefonosList;
    }

    @ModelAttribute("userTels")
    public List<Telefonos> listaTelUser(HttpServletRequest request) {
        sesion = request.getSession();
        String uSesion = sesion.getAttribute("usuario").toString();
        System.out.println("Buscando los telefonos de " + uSesion);
        ModelAndView mav = new ModelAndView();
        TelefonosDao userHelper = new TelefonosDao();
        
        List<Telefonos> telefonosList = userHelper.getAllTelUser(uSesion);
        
        System.out.println("Pase por el controlador");
        return telefonosList;
    }
    
  
    
       //ATRIBUTOS PARA CONSULTAR
    @ModelAttribute("listUser")
    public List<Usuarios> listaUsuarios() {

        //Data referencing for web framework checkboxes
        ModelAndView mav = new ModelAndView();
        UsuariosDao userDao = new UsuariosDao();
        List<Usuarios> listUser = userDao.getAllUsuarios();
        return listUser;
    }

    
    
}
