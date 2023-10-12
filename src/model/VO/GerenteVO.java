package model.VO;

public class GerenteVO extends UsuarioVO {
	//private boolean ehGerente;
	private double bonus;
	private Long gerenteId;

    public GerenteVO(String nome, String cpf, String endereco, String usuario, String senha, Long pessoaId,
    		Long usuarioId, String numeroCelular, double bonus, Long gerenteId) {
        super(nome, cpf, endereco, usuario, senha, numeroCelular, usuarioId, numeroCelular, pessoaId);
        //setEhGerente(ehGerente);
        setBonus(bonus);
        setGerenteId(gerenteId);
    }
    
    public GerenteVO() {}
    
    
    public double getBonus() {
    	return bonus;
    }
    public void setBonus(double bonus) {
    	if(bonus > 0) {
    		this.bonus = bonus;
    	}
    }
    
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
