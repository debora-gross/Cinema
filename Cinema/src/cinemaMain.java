import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.Connection;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;


//import java.util.ArrayList;
//import java.util.List;

public class cinemaMain {
	static Scanner scanner = new Scanner(System.in);
	static Ficheiro fich = new Ficheiro();
	

	public static String Menu1() {
		
		
		System.out.println("Escolha uma opção ou Zero para sair: ");
		System.out.println("1 - Validar entrada cliente\n2 - Consultar Ficheiro\n3 - Pesquisar cliente\n4 - Pesquisar cliente na BD\n");
		String opcao = scanner.nextLine();
		
		return opcao;
		
	}
	
	public static Cliente InserirCliente() {
			
				
			System.out.println("Inserir Cliente:");
			System.out.println("Nome: ");
			String nome = scanner.nextLine();
			System.out.println("Hora da Chegada: ");
			String horaChegada = scanner.nextLine();
			int hChegada = Integer.valueOf(horaChegada);
			System.out.println("Minuto da Chegada: ");
			String minutoChegada = scanner.nextLine();
			int mChegada = Integer.valueOf(minutoChegada);
			System.out.println("Nome do Filme: ");
			String nomeFilme = scanner.nextLine();
			
			//Filme filme = new Filme("Titanic", 8, 30);
			Cliente clie = new Cliente(hChegada, mChegada, nome, nomeFilme);
			
		
		return clie;
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//List<Filme> lista = new ArrayList<Filme>();
		MysqlManipulate mMysql = new MysqlManipulate();
		Connection conn = mMysql.connect("jdbc:mysql://minhaligacao:8080/nome", "nome", "senha");
			
		String op = "0";
		Recepcionista rec = new Recepcionista();
		List<Filme> lstFilme = new ArrayList<Filme>();
		Filme filme = new Filme("Titanic", 8, 30);

		lstFilme.add(filme);
		filme = new Filme("Star Wars", 10, 30);
		lstFilme.add(filme);
		filme = new Filme("Nemo", 11, 30);
		lstFilme.add(filme);
		filme = new Filme("Mother", 14, 30);
		lstFilme.add(filme);
		
		
		
		do{
			op = Menu1();
			System.out.println("Voce escolheu a opção " + op);
			switch(op) 
			{
			 case "1":
				 Cliente clie;
				try {
					clie = InserirCliente();
					rec.validarEntrada(clie, lstFilme);
					
					try {
						fich.EscritaFicheiro(clie);
						mMysql.insert(conn, clie.getNome(), String.valueOf(clie.getHoraChegada()), String.valueOf(clie.getMinutoChegada()), clie.getNomeFilme());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
				break;
			 case "2":
				 fich.LeituraFicheiro();
				 
				 break;
			 case "3":
				 System.out.println("Digite o nome do cliente: ");
				 String nomeClie = scanner.nextLine();
				 String lCliente = rec.localizarClie(nomeClie);
				 System.out.println(lCliente);
				 break;
			 case "4":
				 System.out.println("Digite o nome do cliente: ");
				 String nomeClieBD = scanner.nextLine();
				 mMysql.selectClie(conn, nomeClieBD);
				 break;
			 default:
				
			}	
		
		}while(op != "0");
	
	}

}
