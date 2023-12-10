package controller;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import model.vo.UsuarioVO;
import model.bo.UsuarioBO;

@Path("/usuario")
public class UsuarioRest {
	
	@POST
	@Path("/cadastrar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public UsuarioVO cadastrarUsuarioVO(UsuarioVO usuarioVO) {
		UsuarioBO usuarioBO= new UsuarioBO();
		
		return usuarioBO.cadastrarUsusarioBo(usuarioVO);
	}
	
	
	@POST
	@Path("/logar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public UsuarioVO realizarLogin(UsuarioVO usuarioVO) {
		UsuarioBO usuarioBO= new UsuarioBO();
		
		return usuarioBO.realizarLoginBo(usuarioVO);
	}
}

   
