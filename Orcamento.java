package Classes;

public class Orcamento{
    private String peca;
    private String servico;
    private double valor;

    public Orcamento(String peca, String servico, double valor){
        setPeca(peca);
        setServico(servico);
        setValor(valor);
    }

    public String getPeca(){ return this.peca;}
    public void setPeca(String peca){
        if (peca != null && !peca.isEmpty()){ // verificar depois se a peça existe na lista de peças
            this.peca = peca;
        }
    }
    public String getServico(){ return this.servico;}
    public void setServico(String servico){
        if (servico != null && !servico.isEmpty()){ // verificar depois se o serviço existe na lista de serviço
            this.servico = servico;
        }
    }
    public double getValor(){ return this.valor;}
    public void SetValor(double valor){
        if ( valor > 0  && valor < 10000){
            this.valor = valor;
        }
    }
}