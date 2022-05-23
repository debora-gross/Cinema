import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
//import java.util.Scanner;

//import javax.swing.text.StyledEditorKit.BoldAction;

public class Recepcionista {
	//Ficheiro fich = new Ficheiro();
	
	public Recepcionista() {
		
		
	}
	
	public String localizarClie(String nomeClie) {
		//Scanner nomeClie = new Scanner(System.in);
		String Flag = null;
		String line;
		
		try{
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(new FileReader("Cinema.txt"));
		
			//Scanner scannedFile = new Scanner();
			while((line = br.readLine()) != null){
	            //String starr[] = string.split(" ");
			
				//System.out.println(search);
				if(line.contains(nomeClie)) 
				{
					Flag = "O cliente existe";
					
					return Flag;
				}
			
			}
		} catch (IOException e) {
            e.printStackTrace();
        }
		
		return "Cliente não existe";
		
	}
	
		
	public String validarEntrada( Cliente cliente, List<Filme> lstFilme) {
		
		for (int i = 0; i < lstFilme.size(); i++) {
		
			if  (cliente.getNomeFilme().equals(lstFilme.get(i).getNome()))
			{
				int horaFilme = (lstFilme.get(i).getHora() *60) + lstFilme.get(i).getMinuto();
				int horaChegada = (cliente.getHoraChegada() * 60) + cliente.getMinutoChegada();
				
				if (horaChegada > horaFilme - 30 && horaChegada < horaFilme + 15) 
				{
					return "Cliente pode Entrar";
				}
				else if(horaChegada < horaFilme - 30){
				
					return "Cliente não pode entrar. Deve esperar!";
					
				}else 
				{
					
					return "Cliente não pode entrar. Já passou mais de 15 minutos do Inicio do Filme";
						
				}
			}
		}
			
				return "O cliente vai ver um filme que não está em cartaz";
				
			
		}

	
}