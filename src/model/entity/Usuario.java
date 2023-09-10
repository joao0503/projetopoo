package model.entity;

public abstract class Usuario {
	private String usuario;
	private String senha;
	private Long id;

	public Usuario(String usuario, String senha) {
		setUsuario(usuario);
		setSenha(senha);
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

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		if(id > 0) {
			this.id = id;
		}
	}
}
