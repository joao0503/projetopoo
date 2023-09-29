package model.entity;

public class Gerente extends Usuario {
	//private boolean ehGerente;
	private Long gerenteId;

    public Gerente(String nome, String cpf, String endereco, String usuario, String senha, Long pessoaId,
    		Long usuarioId, Long gerenteId) {
        super(nome, cpf, endereco, usuario, senha, usuarioId, pessoaId);
        //setEhGerente(ehGerente);
        setGerenteId(gerenteId);
    }
    
    public Gerente() {}
    
    
    public Long getGerenteId() {
    	return gerenteId;
    }
    public void setGerenteId(Long gerenteId) {
    	if(gerenteId > 0) {
    		this.gerenteId = gerenteId;
    	}
    }
    
    
    /*public boolean getEhGerente() {
    	return ehGerente;
    }
    public void setEhGerente(boolean autenti) {
    	if(autenti) {
    		this.ehGerente = autenti;
    	}
    }*/
}
