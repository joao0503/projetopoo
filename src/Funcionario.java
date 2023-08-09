package src;

public class Funcionario{
    private String usuario;
    private String senha;
    private boolean isGerente;

    public Funcionario(String usuario, String senha, boolean isGerente){
        setUsuario(usuario);
        setSenha(senha);
        setGerente(isGerente);
    }
    //  fazer outro construtor para isGerente string e/ou para gerente já existente(?)

    public String getUsuario(){ return this.usuario; }
    public void setUsuario(String user){
        if (user != null && !user.isEmpty() && user.length() > 3){
            this.usuario = user;
        }
        else System.out.println("Usuário inválido, tente novamente");
    }

    public String getSenha(){ return this.senha;}
    public void setSenha(String senha){
        if (senha != null && !senha.isEmpty() && senha.length() > 4){
            this.senha = senha;
        }
        else System.out.println("Senha inválida, tente novamente");
    }

    public boolean getGerente(){ return this.isGerente; }
    public void setGerente(boolean isGerente){
        if (this.isGerente == false) this.isGerente = true;
        else System.out.println("Ja é gerente!");
    }
}