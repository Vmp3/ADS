package model.bo;

import java.util.ArrayList; 
import model.vo.UsuarioVO;
import model.dao.UsuarioDAO;

public class UsuarioBO {
	
	
	public UsuarioVO realizarLoginBo(UsuarioVO usuarioVo) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		return usuarioDAO.realizarLoginDao(usuarioVo);
	}
	
	
public UsuarioVO cadastrarUsusarioBo(UsuarioVO usuarioVO) {
	UsuarioDAO usuarioDAO = new UsuarioDAO();
	
	if(usuarioDAO.verificarCadastroUsuarioBaseDadosDAO(usuarioVO)){
		System.out.println("Usuario ja cadastrado!");
	}else {
			usuarioVO = usuarioDAO.cadastrarUsuarioDao(usuarioVO);
		}
	
	return usuarioVO;
	}

public boolean atualizarUsuarioBO(UsuarioVO usuarioVO) {
	boolean resultado = false;
	 UsuarioDAO usuarioDAO= new UsuarioDAO();
	 if(usuarioDAO.verificarCadastroUsuarioBaseDadosDAO(usuarioVO)) {
		 resultado = usuarioDAO.atualizarUsuarioDAO(usuarioVO);
	 }else {
		 System.out.println("Usuario não existe!");
	 }
	 return resultado;
}

public boolean excluirUsuarioBO(UsuarioVO usuarioVO) {
	boolean resultado = false;
	 UsuarioDAO usuarioDAO= new UsuarioDAO();
	 if(usuarioDAO.verificarCadastroUsuarioBaseDadosDAO(usuarioVO)) {
		 resultado = usuarioDAO.excluirUsuarioDAO(usuarioVO);
	 }else {
		 System.out.println("Usuario não existe!");
	 }
	 return resultado;
	}
	public ArrayList<UsuarioVO> consultarTodosUsuariosBO(){
		UsuarioDAO usuarioDAO= new UsuarioDAO();
		ArrayList<UsuarioVO> listaUsuarioVO = usuarioDAO.consultarTodosUsuariosDAO();
		if(listaUsuarioVO.isEmpty()) {
			System.out.println("\n A lista da pessoa estar vazia.");
		}
		return listaUsuarioVO;
	}
	
	public UsuarioVO consultarUsuarioBO(UsuarioVO usuarioVO) {
		UsuarioDAO  usuarioDAO= new UsuarioDAO();
		UsuarioVO usuario = usuarioDAO.consultarUsuarioDAO(usuarioVO);
		if(usuario == null) {
			System.out.println("\n Usuario não localizado.");
		}
		return usuario;
	}
	
	
}



/*package model.bo;

import java.util.ArrayList;

import model.dao.UsuarioDao;
import model.vo.UsuarioVo;

public class UsuarioBo {

	public UsuarioVo realizarLoginBo(UsuarioVo usuarioVo) {
		UsuarioDao usuarioDao = new UsuarioDao();
		return usuarioDao.realizarLoginDao(usuarioVo);
	}
	
	//Create
	public UsuarioVo cadastrarUsuarioBo (UsuarioVo usuarioVo) {
		UsuarioDao usuarioDao = new UsuarioDao();
		if(usuarioDao.verificarCadastroUsuarioBaseDadosDao(usuarioVo)) {
			System.out.println("Usuário ja cadastrado!");
		}else {
			usuarioVo = usuarioDao.cadastrarUsuarioDao(usuarioVo);
		}
		return usuarioVo;
	}
	
	//Read all
	public ArrayList<UsuarioVo> consultarTodosUsuariosBo () {
		UsuarioDao usuarioDao = new UsuarioDao();
		ArrayList<UsuarioVo> listaUsuariosVo = usuarioDao.consultarTodosUsuariosDao();
		if(listaUsuariosVo.isEmpty()) {
			System.out.println("Lista de Usuários está vazia!");
		}
		return listaUsuariosVo;
	}
	
	//Read one
	public UsuarioVo consultarUsuarioBo (UsuarioVo usuarioVo) {
		UsuarioDao usuarioDao = new UsuarioDao();
		UsuarioVo usuario = usuarioDao.consultarUsuarioDao(usuarioVo);
		if(usuario == null) {
			System.out.println("\nUsuário não localizado!");
		}
		return usuario;
	}
	
	//Update
	public boolean atualizarUsuarioBo (UsuarioVo usuarioVo) {
		boolean resultado = false;
		UsuarioDao usuarioDao = new UsuarioDao();
		if(usuarioDao.verificarCadastroUsuarioBaseDadosDao(usuarioVo)) {
			resultado = usuarioDao.atualizarUsuarioDao(usuarioVo);
		}else {
			System.out.println("usuario não existe");
		}
		return resultado;
	}
	
	//Delete
	public boolean excluirUsuarioBo(UsuarioVo usuarioVo) {
		boolean resultado = false;
		UsuarioDao usuarioDao = new UsuarioDao();
		if(usuarioDao.verificarCadastroUsuarioBaseDadosDao(usuarioVo)) {
			resultado = usuarioDao.excluirUsuarioDao(usuarioVo);
		}else {
			System.out.println("Usuario não existe na base de dados");
		}
		return resultado;

	}
}*/