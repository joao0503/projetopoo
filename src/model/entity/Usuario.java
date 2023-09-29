package model.entity;

public class Usuario extends Pessoa {
	private String usuario;
	private String senha;
	private Long usuarioId;

	public Usuario(String nome, String cpf, String endereco, String usuario, String senha, 
			Long pessoaId, Long usuarioId) {
		super(nome, cpf, endereco, pessoaId);
		setUsuario(usuario);
		setSenha(senha);
		setUsuarioId(usuarioId);
	}

	public Usuario(){}

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
	
	
	public Long getUsuarioId() {
		return usuarioId;
	}
	
	public void setUsuarioId(Long usuarioId) {
		if(usuarioId > 0) {
			this.usuarioId = usuarioId;
		}
	}
}
