package co.edu.udea.iw.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.IWDaoException;
import co.edu.udea.iw.exception.IWServiceException;
import co.edu.udea.iw.service.UsuarioService;
import co.edu.udea.iw.web.dto.UsuarioWS;

@Component
@Path("Usuario")
public class UsuarioWebService {

	@Autowired
	UsuarioService usuarioService;
	
	@Path("Listar")
	@Produces(MediaType.APPLICATION_XML)
	@GET
	public List<UsuarioWS> obtener() throws javassist.tools.rmi.RemoteException{
		List<UsuarioWS> lista = new ArrayList<UsuarioWS>();
		try{
			for(Usuario usuario: usuarioService.obtener()){
				UsuarioWS usuarioWS = new UsuarioWS();
				usuarioWS.setLogin(usuario.getLogin());
				usuarioWS.setRol(usuario.getRol());
				usuarioWS.setEstadoUsuario(usuario.getEstadoUsuario());
				lista.add(usuarioWS);
			}
		}catch(IWDaoException e){
			throw new javassist.tools.rmi.RemoteException(e);
		}
		return lista;
	}
	
	@Path("Guardar")
	@Produces(MediaType.TEXT_PLAIN)
	@POST
	public String guardar(@QueryParam("login")String login,@QueryParam("contrasena")String contrasena,
			@QueryParam("rol")String rol,@QueryParam("estadoUsuario")String estadoUsuario){
	
				try {
					usuarioService.guardarUsuario(login, contrasena, rol, estadoUsuario);
					return "Usuario guardado correctamente";
				} catch (IWDaoException e) {
					e.printStackTrace();
					return "No se pudo guardar";
				} catch (IWServiceException e) {
					return e.getMessage();
				}
				
	}

	@Produces(MediaType.TEXT_PLAIN)
	@Path("Modificar")
	@PUT
	public String modificar(@QueryParam("login")String login,@QueryParam("estadoUsuario")String estadoUsuario){
		
		try {
			usuarioService.actualizarUsuario(login, estadoUsuario);
			return "Usuario actualizado correctamente";
		} catch (IWDaoException e) {
			e.printStackTrace();//holi
			return "No se pudo actualizar";
		} catch (IWServiceException e) {
			e.printStackTrace();
			return "No se pudo actualizar";
		}
		
	}
	
	@Produces(MediaType.TEXT_PLAIN)
	@Path("Eliminar")
	@DELETE
	public String eliminar(@QueryParam("login")String login){
		try {
			usuarioService.eliminarUsuario(login);
			return "Usuario elimindado correctamente";
		} catch (IWDaoException e) {
			e.printStackTrace();
			return "No se pudo eliminar";
		} catch (IWServiceException e) {
			e.printStackTrace();
			return "No se pudo eliminar";
		}
	}
	
	@Path("ObtenerLogin")
	@Produces(MediaType.APPLICATION_XML)
	@GET
	public String obtenerLogin(@QueryParam("login")String login) throws javassist.tools.rmi.RemoteException, IWServiceException{
		UsuarioWS usuarioWS=null;
		Usuario usuario=new Usuario();
		try{
			usuario=usuarioService.obtenerLogin(login);
			usuarioWS.setLogin(usuario.getLogin());
		}catch(IWDaoException e){
			throw new javassist.tools.rmi.RemoteException(e);
		}catch (IWServiceException e) {
			e.printStackTrace();
		}
		return usuarioWS.getLogin();
	}

	
}
