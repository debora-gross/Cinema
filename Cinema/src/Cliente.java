
public class Cliente {

	private int horaChegada;
	private int minutoChegada;
	private String nome;
	//private Filme f;
	String nomeFilme;
	
	public Cliente(int horaChegada, int minutoChegada, String nome, String nomeFilme ) {
		this.setHoraChegada(horaChegada);
		this.setMinutoChegada(minutoChegada);
		this.setNome(nome);
		this.nomeFilme = nomeFilme;
		//this.f = f;
		//this.f.setFilme(f);
	}

	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	int getHoraChegada() {
		return horaChegada;
	}

	void setHoraChegada(int horaChegada) {
		this.horaChegada = horaChegada;
	}

	int getMinutoChegada() {
		return minutoChegada;
	}

	void setMinutoChegada(int minutoChegada) {
		this.minutoChegada = minutoChegada;
	}

	public String getNome() {
		return nome;
	}

	void setNome(String nome) {
		this.nome = nome;
	}

	//public Object getFilme() {//antes fiz public String, mas a IDE deu a sugestão do Object
	//	return f.getNome();
	//}

	String getNomeFilme() {
		return nomeFilme;
	}

	/*public Object getFilme() {
		// TODO Auto-generated method stub
		return null;
	}*/

	/*void setFilme(Filme f) {
		nomeFilme = f.getNome();
		this.f = f.setNome(nomeFilme);;
	}*/
	
	
	//List<Cliente> lstClie = new ArrayList<Cliente>();
	

	
	/*public void EscritaFicheiro(Cliente clie) {
			
			try {
				//Cliente clie = new Cliente();
				FileWriter myWriter =  new FileWriter("Cinema.txt", true);
				myWriter.write(clie.horaChegada);
				myWriter.write(System.getProperty( "line.separator" ));
				myWriter.write(clie.minutoChegada);
				myWriter.write(System.getProperty( "line.separator" ));
				myWriter.write(clie.nome);
				myWriter.write(System.getProperty( "line.separator" ));
				myWriter.write(clie.nomeFilme);
				myWriter.write(System.getProperty( "line.separator" ));
				myWriter.write("---------------------------------------------");
			
				myWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		// não posso usar a variavel myWriter fora do TRYCATCH 
		
		
		
	}*/
	
	
	
}
