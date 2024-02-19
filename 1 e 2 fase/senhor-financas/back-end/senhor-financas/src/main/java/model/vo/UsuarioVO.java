package model.vo;
import java.time.LocalDate;

public class UsuarioVO {
	private int idUsuario;
	private String nome;
	private String cpf;
	private String email;
	private LocalDate datanascimento;
	private String login;
	private String senha;
	public UsuarioVO(int idUsuario, String nome, String cpf, String email, LocalDate datanascimento, String login,
			String senha) {
		super();
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.datanascimento = datanascimento;
		this.login = login;
		this.senha = senha;
	}
	public UsuarioVO() {
		super();
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getDatanascimento() {
		return datanascimento;
	}
	public void setDatanascimento(LocalDate datanascimento) {
		this.datanascimento = datanascimento;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	

}
