package model.bo;

import java.util.ArrayList;

import model.dao.DespesaDAO;
import model.vo.DespesaVO;

public class DespesaBO {
	
	
	
	
	/*public DespesaVO realizarLoginBo(DespesaVO despesaVO) {
		DespesaDAO despesaDAO = new DespesaDAO();
		return despesaDAO.realizarLoginDao(despesaVO);
	}*/
	
	
public DespesaVO cadastrarDespesaBo(DespesaVO despesaVO) {
	
	DespesaDAO despesaDAO = new DespesaDAO();
	despesaVO = despesaDAO.cadastrarDespesaDao(despesaVO);

	return despesaVO;
	}

public boolean atualizarDespesaBO(DespesaVO despesaVO) {
	boolean resultado = false;
	 DespesaDAO despesaDAO= new DespesaDAO();
	 if(despesaDAO.atualizarDespesaDAO(despesaVO)) {
		 resultado = despesaDAO.atualizarDespesaDAO(despesaVO);
	 }else {
		 System.out.println("Usuario não existe!");
	 }
	 return resultado;
}

public boolean excluirDespesaBO(DespesaVO despesaVO) {
	boolean resultado = false;
	 DespesaDAO despesa= new DespesaDAO();
	 if(despesa.verificarCadastroDespesaBaseDadosDAO(despesaVO)) {
		 resultado = despesa.excluirDespesaDAO(despesaVO);
	 }else {
		 System.out.println("Usuario não existe!");
	 }
	 return resultado;
	}
	public ArrayList<DespesaVO> consultarTodasDespesasBO(int idDespesa){
		DespesaDAO despesa= new DespesaDAO();
		ArrayList<DespesaVO> listaDespesaVO = despesa.consultarTodosDespesaDAO(idDespesa);
		if(listaDespesaVO.isEmpty()) {
			System.out.println("\n A lista da pessoa estar vazia.");
		}
		return listaDespesaVO;
	}
	
	public DespesaVO consultarDespesaBO(int iddespesa) {
		DespesaDAO  despesaDAO= new DespesaDAO();
		DespesaVO despesa =despesaDAO.consultarDespesaDAO(iddespesa);
		if(despesa == null) {
			System.out.println("\n Usuario não localizado.");
		}
		return despesa;
	}
	

}
