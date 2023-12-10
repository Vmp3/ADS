package model.dao;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
 
import model.vo.ReceitaVO;
 
public class ReceitaDAO {
 
	// cadastrar
	public ReceitaVO cadastrarReceitaDAO(ReceitaVO receitaVO) {
		String query = "INSERT INTO receita (idusuario , descricao , valor, datareceita) VALUES (?,?,?,?)";
		Connection conn = Banco.getConnection();
		PreparedStatement pstmt = Banco.getPreparedStatementWithPk(conn, query);
 
		try {
 
			pstmt.setInt(1, receitaVO.getidUsuario());
			pstmt.setString(2, receitaVO.getDescricao());
			pstmt.setDouble(3, receitaVO.getValor());
			pstmt.setObject(4, receitaVO.getDataReceita());
			pstmt.execute();
			ResultSet resultado = pstmt.getGeneratedKeys();
			if (resultado.next()) {
				receitaVO.setIdReceita(resultado.getInt(1));
			}
 
		} catch (SQLException erro) {
			System.out.println("\nErro ao executar a query no CadastrarReceitaDAO");
			System.out.println("Erro" + erro.getMessage());
		} finally {
			Banco.closeStatement(pstmt);
			Banco.closeConnection(conn);
		}
		return receitaVO;
 
	}
 
	// listar 
	public ArrayList<ReceitaVO> listarTodasReceitasDAO(int idUsuario) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
 
		ArrayList<ReceitaVO> listaReceitas = new ArrayList<ReceitaVO>();
		String query = "SELECT idreceita,idusuario,descricao,valor,datareceita FROM receita WHERE idusuario = "
				+ idUsuario;
 
		try {
			resultado = stmt.executeQuery(query);
			while (resultado.next()) {
				DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				ReceitaVO receita = new ReceitaVO();
				receita.setIdReceita(Integer.parseInt(resultado.getString(1)));
				receita.setidUsuario(idUsuario);
				receita.setDescricao(resultado.getString(3));
				receita.setValor(Double.parseDouble(resultado.getString(4)));
				receita.setDataReceita(LocalDate.parse(resultado.getString(5), dt));
				listaReceitas.add(receita);
 
			}
		} catch (SQLException erro) {
			System.out.println("\nErro ao executar a query no listarTodasReceitasDAO");
			System.out.println("Erro" + erro.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
 
		return listaReceitas;
 
	}
 
	// pesquisar
 
	public ReceitaVO consultarReceitaDAO(int idReceita) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
 
		ReceitaVO receita = new ReceitaVO();
		String query = "SELECT idreceita , idusuario, descricao , valor, datareceita FROM receita WHERE "
				+ " idreceita = " + idReceita;
 
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
 
				DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				receita.setIdReceita(Integer.parseInt(resultado.getString(1)));
				receita.setidUsuario(idReceita);
				receita.setDescricao(resultado.getString(3));
				receita.setValor(Double.parseDouble(resultado.getString(4)));
				receita.setDataReceita(LocalDate.parse(resultado.getString(5), dt));
			}
		} catch (SQLException erro) {
			System.out.println("\nErro ao executar a query no consultarReceitaDAO");
			System.out.println("Erro" + erro.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return receita;
 
	}
 
	// atualizar
	public boolean atualizarReceitaDAO(ReceitaVO receitaVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
 
		boolean retorno = false;
		String query = "UPDATE receita SET descricao = '" + receitaVO.getDescricao() + "' , valor = '"
				+ receitaVO.getValor() + " ', datareceita = '" + receitaVO.getDataReceita() + "' WHERE idreceita = "
				+ receitaVO.getIdReceita();
		try {
			if(stmt.executeUpdate(query)==1) {
				retorno = true;
			}
		} catch (SQLException erro) {
			System.out.println("\nErro ao executar a query no atualizarReceitaDAO");
			System.out.println("Erro" + erro.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return retorno;
	}
 
	// verificar
	public boolean verificarCadastroReceita(ReceitaVO receitaVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		boolean retorno = false;
		String query = "SELECT idreceita FROM receita where idreceita = " + receitaVO.getIdReceita();
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
				retorno = true;
			}
		} catch (SQLException erro) {
			System.out.println("\nErro ao executar a query no verificarCadastroReceita");
			System.out.println("Erro" + erro.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return retorno;
	}
 
	// excluir
	public boolean excluirReceitaDAO(ReceitaVO receitaVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		boolean retorno = false;
		String query = "DELETE FROM receita WHERE idreceita = " + receitaVO.getIdReceita();
 
		try {
			if (stmt.executeUpdate(query) == 1) {
				retorno = true;
			}
		} catch (SQLException erro) {
			System.out.println("\nErro ao executar a query no excluirReceitaDAO");
			System.out.println("Erro" + erro.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
 
		return retorno;
 
	}
 
}