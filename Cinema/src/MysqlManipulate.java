import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;

public class MysqlManipulate {
	
	public Connection connect(String url, String user, String pass) {
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(url, user, pass);
			if(conn != null) {
				System.out.println("Connected");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return conn;
	}
	
	public void selectClie(Connection conn, String nome){
		//List<String> lstModel = new ArrayList<>();
		
		try {
			//Statement statement = conn.createStatement();
			PreparedStatement preparedStmt = conn.prepareStatement("SELECT * FROM cliente WHERE nomeCliente=?");
			preparedStmt.setString(1, nome);
			ResultSet result = preparedStmt.executeQuery();
				
			if (result.next()) {
				//if(result.getString("nomeCliente") != null) {
				System.out.println("O cliente existe na BD");
				//}
			
			} else {
					
				System.out.println("O cliente não existe na BD");
			}

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Boolean insert(Connection conn, String nome, String hora, String minuto, String nomeFilme) {
			
			try {
				PreparedStatement preparedStmt = conn.prepareStatement("Insert into cliente (nomeCliente, horaChegada, minutoChegada, nomeFilme)" + 
						" values (?,?,?,?)");  //o obj preparedStmt tem uma serie de metodos incluindo o setString(_,___)
				
				preparedStmt.setString(1, nome);
				preparedStmt.setString(2, hora);
				preparedStmt.setString(3, minuto);
				preparedStmt.setString(4, nomeFilme);
				preparedStmt.execute();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //Este metodo ajuda a fazer o insert...Prepared mais para insert
			
			return true;
		}

}