import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ficheiro {
	
	public void EscritaFicheiro(Cliente clie) {
		// TODO Auto-generated method stub
		try {
			//Cliente clie = new Cliente();
			FileWriter myWriter =  new FileWriter("Cinema.txt", true);
			
			myWriter.write(String.valueOf(clie.getHoraChegada()));
			myWriter.write(":");
			myWriter.write(String.valueOf(clie.getMinutoChegada()));
			myWriter.write(System.getProperty( "line.separator" ));
			myWriter.write(clie.getNome());
			myWriter.write(System.getProperty( "line.separator" ));
			myWriter.write(clie.getNomeFilme());
			myWriter.write(System.getProperty( "line.separator" ));
			myWriter.write("---------------------------------------------\n");
			myWriter.write(System.getProperty( "line.separator" ));
			
			myWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void LeituraFicheiro() {
		try {
			FileInputStream fstream = new FileInputStream("Cinema.txt");
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			String strLine;
			
			while((strLine = br.readLine()) != null) {
				System.out.println(strLine);
			}
		}catch (FileNotFoundException e) {
			System.out.println("Ficheiro não existe");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Ficheiro existe, mas não pode ser lido");
		}
	}

	
}
