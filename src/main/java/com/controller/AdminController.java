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
import com.jsonEntitys.Llamadas;
import com.jsonEntitys.Recarga;
import com.util.httpAccount;
import com.util.httpHistorial;
import com.util.httpRecargas;
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
                mav.setViewName("viewsAdmin/listUsuarios");
            } else {
                mav.setViewName("panel/panel");
            }
        }
        return mav;
    }

    @RequestMapping("buscarUsuarios.htm")
    public ModelAndView getBuscarUsuarios(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        sesion = request.getSession();
        if (sesion.getAttribute("usuario") == null) {
            mensaje = "Ingrese sus datos para poder ingresar al sistema";
            mav.addObject("mensaje", mensaje);
            mav.setViewName("login/login");

        } else {
            if (sesion.getAttribute("tipoUsuario").toString().compareTo("Administrador") == 0) {
                String parametro = request.getParameter("parametro");
                String dato = request.getParameter("dato");

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

    @RequestMapping("perfilAdmin.htm")
    public ModelAndView getPerfilAdmin(HttpServletRequest request) {
        sesion = request.getSession();
        ModelAndView mav = new ModelAndView();
        String mensaje = null;

        if (sesion.getAttribute("usuario") == null) {

            mav.setViewName("login/login");

        } else {
            if (sesion.getAttribute("tipoUsuario").toString().compareTo("Administrador") == 0) {
                // sesionUser = sesion.getAttribute("usuario").toString();
                mav.setViewName("viewsAdmin/perfilAdmin");
            } else {
                mav.setViewName("panel/perfil");
            }
        }

        return mav;
    }

    @ModelAttribute("account")
    public Account getAccountAdmin(HttpServletRequest request) {
        sesion = request.getSession();
        //Data referencing for web framework checkboxes
        Account account = new Account();
        ModelAndView mav = new ModelAndView();
        if (sesion.getAttribute("usuario") == null) {

        } else {
            String sesUser = sesion.getAttribute("usuario").toString();
            String temp = sesUser.replace("-", "");
            System.out.println(temp);
            httpAccount accountHelper = new httpAccount();
            account = accountHelper.getAccountObject(temp);
            System.out.println("Regrese con datos para la vista " + account.getFirst_name() + account.getLanguaje_id());
            mav.addObject("account", account);
        }

        return account;

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

            mav.setViewName("viewsAdmin/editarPerfil");
        }
        return mav;
    }

    @RequestMapping(value = "validarEditarPerfil.htm", method = RequestMethod.POST)
    public ModelAndView validarEditarAdmin(HttpServletRequest request
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

                mav.setViewName("viewsAdmin/perfilAdmin");
            } else {
                mav.setViewName("viewsAdmin/editarPefil");
            }
        }
        return mav;
    }

    @ModelAttribute("idAccount")
    public String getidAccount(HttpServletRequest request
    ) {
        sesion = request.getSession();
        String uSesion = sesion.getAttribute("usuario").toString();
        //Data referencing for web framework checkboxes
        ModelAndView mav = new ModelAndView();
        httpAccount accountHelper = new httpAccount();
        String resultado = accountHelper.getIdAccount(uSesion);

        return resultado;
    }

    @ModelAttribute("user")
    public Usuarios getUsuario(HttpServletRequest request
    ) {
        sesion = request.getSession();
        String usr = sesion.getAttribute("usuario").toString();
        //Data referencing for web framework checkboxes
        ModelAndView mav = new ModelAndView();
        UsuariosDao userDao = new UsuariosDao();
        Usuarios user = new Usuarios();
        Telefonos tel = new Telefonos();
        TelefonosDao telDao = new TelefonosDao();
        tel = telDao.getTelefono(usr);
        user = userDao.getUsuario(tel.getUsuarios().getIdUsuario());

        return user;
    }

    @ModelAttribute("tel")
    public Telefonos getTelefono(HttpServletRequest request
    ) {
        sesion = request.getSession();
        String uSesion = sesion.getAttribute("usuario").toString();
        //Data referencing for web framework checkboxes
        ModelAndView mav = new ModelAndView();
        Telefonos tel = new Telefonos();
        TelefonosDao telDao = new TelefonosDao();
        tel = telDao.getTelefono(uSesion);

        return tel;
    }

    
    
    
    /// historial del admin
    
    @RequestMapping("historialAdmin.htm")
    public ModelAndView Historial(HttpServletRequest request) {
        sesion = request.getSession();
        ModelAndView mav = new ModelAndView();

        if (sesion.getAttribute("usuario") == null) {
            mensaje = "No esta logeado para obtener las vistas";
            mav.addObject("mensaje", mensaje);
            mav.setViewName("login/login");

        } else {
            mav.setViewName("viewsAdmin/historialAdmin");
        }

        return mav;

    }

    @RequestMapping(value = "getHistorialAdmin.htm", method = RequestMethod.POST)
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
                mav.setViewName("viewsAdminl/historialAdmin");
            } else {
                mav.addObject("llamadas", llamadas);
                mav.setViewName("viewsAdminl/historialAdmin");
            }
        }

        return mav;
    }
    @RequestMapping("recargasAdmin.htm")
    public ModelAndView Recargas(HttpServletRequest request) {
        sesion = request.getSession();
        ModelAndView mav = new ModelAndView();

        if (sesion.getAttribute("usuario") == null) {
            mensaje = "No esta logeado para obtener las vistas";
            mav.addObject("mensaje", mensaje);
            mav.setViewName("login/login");

        } else {
            mav.setViewName("viewsAdmin/recargasAdmin");
        }

        return mav;

    }

    @RequestMapping(value = "getRecargasAdmin.htm", method = RequestMethod.POST)
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
                mav.setViewName("viewsAdmin/recargasAdmin");
            } else {
                mav.addObject("recargas", recargas);
                mav.setViewName("viewsAdmin/recargasAdmin");
            }
        }

        return mav;
    }
}
