package model.VO;

import java.util.Date;

public class ServicoVO {
	private String nome;
	private double valor;
	private int status;
	// duas opções: criar o serviço com uma peça ou com uma lista de peças.
	private PecaVO peca;
	private Date dataInicio;
	private Date dataFim;
	private Long funcionarioId;
	private Long clienteId;
	private Long automovelId;
    private Long servicoId;

    public ServicoVO(String nome, double valor, int status, PecaVO peca, Long funcionarioId, Long clienteId, 
    		Long servicoId) {
        setNome(nome);
        setValor(valor);
        setStatus(status);
        setPeca(peca);
        setFuncionarioId(funcionarioId);
        setClienteId(clienteId);
        setServicoId(servicoId);
    }
    
    public ServicoVO() {
    	
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        if(nome != null && nome.equals("")) {
			this.nome = nome;
		} else {
			System.out.println("Nome inválido");
		}
    }

    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        if ( valor > 0  && valor < 10000){
            this.valor = valor;
        }
    }

    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        if(status < 0){
            System.out.println("Status inválido (não pode ser negativo)");
        }
        else {
            this.status = status;
        }
    }
    
    public PecaVO getPeca() {
    	return peca;
    }
    public void setPeca(PecaVO peca) {
    	if(peca != null) {
    		this.peca = peca;
    	} else {
    		System.out.println("Essa peça é inválida");
    	}
    }
    

    public Long getFuncionarioId() {
		return funcionarioId;
	}
	public void setFuncionarioId(Long funcionarioId) {
		if(funcionarioId > 0) {
			this.funcionarioId = funcionarioId;
		}
	}
	
	
    public Long getClienteId() {
		return clienteId;
	}
	public void setClienteId(Long clienteId) {
		if(clienteId > 0) {
			this.clienteId = clienteId;
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
	
	
    public Long getServicoId() {
		return servicoId;
	}
	public void setServicoId(Long servicoId) {
		if(servicoId > 0) {
			this.servicoId = servicoId;
		}
	}
}