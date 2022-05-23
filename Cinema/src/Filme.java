//import java.util.List;

public class Filme {
	
	private String nome;
	private int hora;
	private int minuto;

	public Filme (String nome, int hora, int minuto ) {
		this.setNome(nome);
		this.setHora(hora);
		this.setMinuto(minuto);
	}
	
	public Filme() {}

	public String getNome() {
		return nome;
	}

	public Filme setNome(String nome) {
		this.nome = nome;
		return null;
	}

	public int getHora() {
		return hora;
	}

	void setHora(int hora) {
		this.hora = hora;
	}

	int getMinuto() {
		return minuto;
	}

	void setMinuto(int minuto) {
		this.minuto = minuto;
	}
	
	
}
