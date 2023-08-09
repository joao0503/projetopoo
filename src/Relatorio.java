package src;

import java.time.LocalDate;

public class Relatorio{
    private String nomeCliente;
    private Orcamento orcamento;
    private String vendedor;
    private LocalDate dataVenda;
    
    public Relatorio(String nomeCliente, Orcamento orcamento, String vendedor, LocalDate dataVenda) {
        setNomeCliente(nomeCliente);
        setOrcamento(orcamento);
        setVendedor(vendedor);
        setDataVenda(dataVenda);
    }

    public String getNomeCliente() {
        return nomeCliente;
    }
    public void setNomeCliente(String nomeCliente) {
        if(nomeCliente != null && nomeCliente.equals("")) {
			this.nomeCliente = nomeCliente;
		} else {
			System.out.println("Nome inválido");
		}
    }

    public Orcamento getOrcamento() {
        return orcamento;
    }
    public void setOrcamento(Orcamento orcamento) { // Tem que averiguar esse setOrçamento
        if (nomeCliente != null) {
            this.orcamento = orcamento;
        }
        else {
            System.out.println("Orçamento inválido");
        }
    }

    public String getVendedor() {
        return vendedor;
    }
    public void setVendedor(String vendedor) {
        if(vendedor != null && vendedor.equals("")) {
			this.vendedor = vendedor;
		} else {
			System.out.println("Vendedor inválido");
		}
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }
    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }
}