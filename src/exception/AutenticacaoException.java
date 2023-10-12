package exception;

public class AutenticacaoException extends Exception{
	private static final long serialVersionUID = 1L;

	public AutenticacaoException() {
		super ("Usuário ou senha não encontrados");
	}

}
