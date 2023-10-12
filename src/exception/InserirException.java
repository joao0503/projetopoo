package exception;

import java.sql.SQLException;

public class InserirException extends SQLException{
	private static final long serialVersionUID = 1L;

	public InserirException(String mensagem) {
		super(mensagem);
	}
}
