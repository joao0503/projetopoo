package model.VO;

public class UsuarioVO extends PessoaVO {
	private String usuario;
	private String senha;
	private String email;
	private Long usuarioId;

	public UsuarioVO(String nome, String cpf, String endereco, String numeroCelular, 
			String usuario, String senha, Long pessoaId, String email, 
			Long usuarioId) {
		super(nome, cpf, endereco, numeroCelular, pessoaId);
		setUsuario(usuario);
		setSenha(senha);
		setEmail(email);
		setUsuarioId(usuarioId);
	}

	public UsuarioVO(){}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		if(usuario != null && usuario.length() > 3) {
			this.usuario = usuario;
		}
	}

	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		if(senha != null && senha.length() > 4) {
			this.senha = senha;
		}
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public Long getUsuarioId() {
		return usuarioId;
	}
	
	public void setUsuarioId(Long usuarioId) {
		if(usuarioId > 0) {
			this.usuarioId = usuarioId;
		}
	}
}
