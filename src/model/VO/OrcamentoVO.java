package model.VO;

public class OrcamentoVO{
	// comentei peca porque uma oficina é uma empresa que realiza serviços, logo uma peca
	// faz parte de um serviço, caso queira saber o gasto em uma peca, basta pegar a peca
	// do servico.
    //private Peca peca;
    private ServicoVO servico;
    private double valor;
    private Long automovelId;
    private Long orcamentoId;

    public OrcamentoVO(PecaVO peca, ServicoVO servico, double valor){
        //setPeca(peca);
        setServico(servico);
        setValor(valor);
        setAutomovelId(automovelId);
        setOrcamentoId(orcamentoId);
    }

    public OrcamentoVO(){}


    public ServicoVO getServico(){ 
    	return this.servico;
    }
    public void setServico(ServicoVO servico){
        if (servico != null){ // verificar depois se o serviço existe na lista de serviço
            this.servico = servico;
        }
    }
    
    
    public double getValor(){ 
    	return this.valor;
    }
    public void setValor(double valor){
        if ( valor > 0  && valor < 10000){
            this.valor = valor;
        }
    }
    
    
    
	public Long getAutomovelId() {
		return automovelId;
	}
	public void setAutomovelId(Long automovelId) {
		if(automovelId > 0) {
			this.automovelId = automovelId;
		}
	}
	
    
    public Long getOrcamentoId() {
		return orcamentoId;
	}
	public void setOrcamentoId(Long orcamentoId) {
		if(orcamentoId > 0) {
			this.orcamentoId = orcamentoId;
		}
	}
}