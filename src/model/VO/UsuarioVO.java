package model.VO;

public class UsuarioVO extends PessoaVO {
	private String usuario;
	private String senha;
	private String email;
	private Integer tipoDeUsuario;
	// private String nomeDoTipo;
	private Long usuarioId;

	
	public UsuarioVO(String nome, String cpf, String endereco, String numeroCelular, Long pessoaId, 
			String usuario, String senha, String email, Integer tipoDeUsuario, Long usuarioId) {
		super(nome, cpf, endereco, numeroCelular, pessoaId);
		setUsuario(usuario);
		setSenha(senha);
		setEmail(email);
		setTipoDeUsuario(tipoDeUsuario);
		setUsuarioId(usuarioId);
	}

	public UsuarioVO(){}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		if(usuario.length() > 5) {
			this.usuario = usuario;
		}
	}

	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		if(senha.length() > 4) {
			this.senha = senha;
		}
	}
	
	
	public Integer getTipoDeUsuario() {
		return tipoDeUsuario;
	}
	public void setTipoDeUsuario(Integer tipoDeUsuario) {
		//if(tipoDeUsuario > 0) {
		this.tipoDeUsuario = tipoDeUsuario;
		//}
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
		//if(usuarioId > 0) {
		this.usuarioId = usuarioId;
		//}
	}
	
	

	@Override
	public String toString() {
		return super.toString() + "\nUsuário: " + getUsuario() + "\nSenha: " + getSenha() 
		+ "\nEmail: " + getEmail() + "\nTipo de Usuário" + getTipoDeUsuario() + "\nUsuarioId " + getUsuarioId();
	}
}
