package model.dao;

import model.vo.DespesaVO;
import model.vo.UsuarioVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class DespesaDAO {
	
	public boolean verificarCadastroDespesaBaseDadosDAO(DespesaVO despesaVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado= null;
		boolean retorno = false;
		
		String query ="SELECT * FROM despesa WHERE  iddespesa" + despesaVO.getIdDespesa();
		try {
			resultado = stmt.executeQuery(query);
			if(resultado.next()){
				retorno = true;
			}
		}catch(SQLException erro) {
			System.out.println("\nErro ao executar a query do metodo verificarCadastrodespesaBaseDadosDAO!");
			System.out.println("Erro: " + erro.getMessage());
		}finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return retorno;
	}
	// insert
	public DespesaVO cadastrarDespesaDao(DespesaVO despesaVO) {
		String quary= "'INSERT INTO despesa ( idusuario, descricao, valor, datavencimento, datapagamento) VALUES( ?, ?, ?, ?, ?)'";
		Connection conn = Banco.getConnection();
		PreparedStatement pstmt= Banco.getPreparedStatement(conn, quary);
		try {
			pstmt.setInt(1,despesaVO.getidUsuario());
			pstmt.setString(2,despesaVO.getDescricao());
			pstmt.setDouble(3,despesaVO.getValor());
			pstmt.setObject(4,despesaVO.getDataVencimento());
			pstmt.setObject(5,despesaVO.getDataPagamento());
			pstmt.execute();
			ResultSet resultado = pstmt.getGeneratedKeys();
			if(resultado.next()) {
				despesaVO.getIdDespesa();
			}
		}catch(SQLException erro){
			System.out.println("\nErro ao executar a query do metodo cadastardespesaDAO!");
			System.out.println("Erro: " + erro.getMessage());
		}finally {
			Banco.closePreparedStatement(pstmt);
			Banco.closeConnection(conn);
		}
		return despesaVO;
	}

// UPDATE E DELETE
	
	public boolean atualizarDespesaDAO(DespesaVO despesaVO) {
		Connection conn= Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		boolean retorno= false;
		String query ="'UPDATE despesa SET iddespesa= '"+despesaVO.getIdDespesa()+
				"', idusuario= '"+despesaVO.getidUsuario()+"', descrição= '"+despesaVO.getDescricao()+
				"', valor= '"+despesaVO.getValor()+
				"', datavencimento'"+ despesaVO.getDataVencimento()+"', datapagamento= '"+despesaVO.getDataPagamento()+
				"WHERE iddespesa ='"+despesaVO.getIdDespesa();
		
		try {
			if(stmt.executeUpdate(query)==1) {
				retorno=true;
			}
		}catch (SQLException erro) {
			System.out.println("\nErro ao executar a query do metodo atuaoizardespesaDAO!");
			System.out.println("Erro: " + erro.getMessage());
		}finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return retorno;
	}
	
	public boolean excluirDespesaDAO(DespesaVO despesaVO) {
		Connection conn= Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		boolean retorno=false;
		String query ="DELETE FROM despesa WHERE iddespesa ="+despesaVO.getIdDespesa();
		try {
			if(stmt.executeUpdate(query)==1) {
				retorno = true;
			}
		}catch(SQLException erro) {
			System.out.println("\nErro ao executar a query do metodo excluirUsuarioDAO!");
			System.out.println("Erro: " + erro.getMessage());
		}finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		
		return retorno;
	}
	
	//select
	public DespesaVO consultarDespesaDAO(int iddespesa) {
		Connection conn=Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		
		DespesaVO despesa = new DespesaVO();
		String query = "SELECT iddespesa, idusuario, descricao, valor, datavencimento, datapagamento"+
		"FROM despesaVO WHERE iddespesa ="+iddespesa;
		try {
			resultado =stmt.executeQuery(query);
			if(resultado.next()) {
				DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				
				despesa.setIdDespesa(Integer.parseInt(resultado.getString(1)));
				despesa.setidUsuario(Integer.parseInt(resultado.getString(2)));
				despesa.setDescricao(resultado.getString(3));
				despesa.setValor(Double.parseDouble(resultado.getString(4)));
				despesa.setDataVencimento(LocalDate.parse(resultado.getString(5), dt));
				despesa.setDataPagamento(LocalDate.parse(resultado.getString(6), dt));
				
			}
		}catch(SQLException erro) {
			System.out.println("\nErro ao executar a query do metodo consultardespesaDAO!");
			System.out.println("Erro: " + erro.getMessage());
		}finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return despesa;
	}
	
	public ArrayList<DespesaVO> consultarTodosDespesaDAO(int idUsuario){
		Connection conn= Banco.getConnection();
		Statement stmt=Banco.getStatement(conn);
		
		ResultSet resultado = null;
		ArrayList<DespesaVO> listaDespesa = new ArrayList<DespesaVO>();
		String query = "SELECT iddespesa, idusuario, descricao, valor, datavencimento, datapagamento FROM despesa WHERE idususario ="+ idUsuario;
		
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				DespesaVO despesa = new DespesaVO();
				despesa.setIdDespesa(Integer.parseInt(resultado.getString(1)));
				despesa.setidUsuario(Integer.parseInt(resultado.getString(2)));
				despesa.setDescricao(resultado.getString(3));
				despesa.setValor(Double.parseDouble(resultado.getString(4)));;
				despesa.setDataVencimento(LocalDate.parse(resultado.getString(5), dt));
				despesa.setDataPagamento(LocalDate.parse(resultado.getString(6), dt));
				listaDespesa.add(despesa);
			}
		}catch(SQLException erro) {
			System.out.println("\nErro ao executar a query do metodo consultarTodasDespesaDAO!");
			System.out.println("Erro: " + erro.getMessage());
		}finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return listaDespesa;
	}
	
	

	
		

	}

/*public boolean verificarCadastroDespesaBaseDadosDao(DespesaDAO despesaVO) {
// TODO Auto-generated method stub
return false;
}

public DespesaDAO cadastrarDespesaDao(DespesaDAO despesaVo) {
// TODO Auto-generated method stub
return null;
}

public ArrayList<DespesaDAO> consultarTodasDespesasDao() {
// TODO Auto-generated method stub
return null;
}

public DespesaDAO consultarDespesaDao(DespesaDAO despesaVo) {
// TODO Auto-generated method stub
return null;
}

public boolean atualizarDespesaDao(DespesaDAO despesaVo) {
// TODO Auto-generated method stub
return false;
}

public boolean excluirDespesaDao(DespesaDAO despesaVo) {
// TODO Auto-generated method stub
return false;
}*/

