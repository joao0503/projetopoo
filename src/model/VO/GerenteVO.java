package model.VO;

public class GerenteVO extends UsuarioVO {
	private double bonus;
	private Long gerenteId;

    public GerenteVO(String nome, String cpf, String endereco, String numeroCelular, Long pessoaId, 
			String usuario, String senha, String email, Integer tipoDeUsuario, Long usuarioId, 
			double bonus, Long gerenteId) {
        super(nome, cpf, endereco, numeroCelular, pessoaId, usuario, senha, email, tipoDeUsuario, 
        		usuarioId);
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
    	//if(gerenteId > 0) {
    	this.gerenteId = gerenteId;
    	//}
    }
}
