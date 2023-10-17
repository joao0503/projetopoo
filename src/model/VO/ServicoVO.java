package model.VO;

//import java.util.Date;

public class ServicoVO {
	private String nome;
	private String descricao;
	private Double valor;
	private int status;
	private PecaVO peca;
	private String dataInicio;
	private String dataFim;
	private Long funcionarioId;
	private Long clienteId;
	private Long automovelId;
	private Long servicoId;

	public ServicoVO(String nome, String descricao, Double valor, int status, PecaVO peca, String dataInicio,
			String dataFim, Long funcionarioId, Long clienteId, Long servicoId) {
		setNome(nome);
		setDescricao(descricao);
		setValor(valor);
		setStatus(status);
		setPeca(peca);
		setDataInicio(dataInicio);
		setDataFim(dataFim);
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
		if (!nome.isEmpty()) {
			this.nome = nome;
		} else {
			System.out.println("Nome inválido");
		}
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		if (valor > 0) {
			this.valor = valor;
		} else {
			System.out.println("Preço inválido");
		}
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		if (status > 0) {
			this.status = status;
		} else {
			System.out.println("Status inválido (não pode ser negativo)");
		}
	}

	public PecaVO getPeca() {
		return peca;
	}

	public void setPeca(PecaVO peca) {
		if (peca != null) {
			this.peca = peca;
		} else {
			System.out.println("Essa peça é inválida");
		}
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		/*
		 * if(dataInicio != null && dataInicio.isEmpty()) { Calendar calendario =
		 * Calendar.getInstance(); //SimpleDateFormat formato = new
		 * SimpleDateFormat("dd/MM/yyyy"); SimpleDateFormat formato = new
		 * SimpleDateFormat("yyyy-MM-dd"); this.dataInicio =
		 * formato.format(calendario.getTime());
		 * System.out.println("A dataInicio do serviço é: " + getDataInicio()); } else {
		 * this.dataInicio = dataInicio; }
		 */
	}

	public String getDataFim() {
		return dataFim;
	}

	public void setDataFim(String dataFim) {
		/*
		 * if(dataFim != null && dataFim.isEmpty()) { Calendar calendario =
		 * Calendar.getInstance(); //SimpleDateFormat formato = new
		 * SimpleDateFormat("dd/MM/yyyy"); SimpleDateFormat formato = new
		 * SimpleDateFormat("yyyy-MM-dd"); this.dataFim =
		 * formato.format(calendario.getTime());
		 * System.out.println("A dataFim do serviço é: " + getDataFim()); } else {
		 * this.dataFim = dataFim; }
		 */
	}

	public Long getFuncionarioId() {
		return funcionarioId;
	}

	public void setFuncionarioId(Long funcionarioId) {
		// if(funcionarioId > 0) {
		this.funcionarioId = funcionarioId;
		// }
	}

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		// if(clienteId > 0) {
		this.clienteId = clienteId;
		// }
	}

	public Long getAutomovelId() {
		return automovelId;
	}

	public void setAutomovelId(Long automovelId) {
		// if(automovelId > 0) {
		this.automovelId = automovelId;
		// }
	}

	public Long getServicoId() {
		return servicoId;
	}

	public void setServicoId(Long servicoId) {
		// if(servicoId > 0) {
		this.servicoId = servicoId;
		// }
	}
}