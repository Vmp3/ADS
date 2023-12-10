package model.bo;

import java.util.ArrayList;

import model.dao.ReceitaDAO;
import model.vo.ReceitaVO;

public class ReceitaBO {

	
	public ReceitaVO cadastrarReceitaBo(ReceitaVO receitaVO) {
		
		ReceitaDAO receitaDAO = new ReceitaDAO();
		receitaVO = receitaDAO.cadastrarReceitaDAO(receitaVO);

		return receitaVO;
		}

	public boolean atualizarReceitaBO(ReceitaVO receitaVO) {
		boolean resultado = false;
		 ReceitaDAO receitaDAO= new ReceitaDAO();
		 if(receitaDAO.atualizarReceitaDAO(receitaVO)) {
			 resultado = receitaDAO.atualizarReceitaDAO(receitaVO);
		 }else {
			 System.out.println("Receita não existe!");
		 }
		 return resultado;
	}

	public boolean excluirReceitaBO(ReceitaVO receitaVO) {
		boolean resultado = false;
		 ReceitaDAO receita= new ReceitaDAO();
		 if(receita.verificarCadastroReceita(receitaVO)) {
			 resultado = receita.excluirReceitaDAO(receitaVO);
		 }else {
			 System.out.println("Receita não existe!");
		 }
		 return resultado;
		}
		public ArrayList<ReceitaVO> consultarTodasReceitasBO(int idUsuario){
			ReceitaDAO receita= new ReceitaDAO();
			ArrayList<ReceitaVO> listaReceitaVO = receita.listarTodasReceitasDAO(idUsuario);
			if(listaReceitaVO.isEmpty()) {
				System.out.println("\n A lista da pessoa estar vazia.");
			}
			return listaReceitaVO;
		}
		
		public ReceitaVO consultarReceitaBO(int idReceita) {
			ReceitaDAO  receitaDAO= new ReceitaDAO();
			ReceitaVO receita =receitaDAO.consultarReceitaDAO(idReceita);
			if(receita == null) {
				System.out.println("\n Receita não localizado.");
			}
			return receita;
		}
		
}
