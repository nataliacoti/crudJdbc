package factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	public static Connection getConnection() {

		try {

			var host = "jdbc:postgresql://localhost:5432/bd_aula_java03";
			var uses = "postgres";
			var pass = "coti";

			return DriverManager.getConnection(host, uses, pass);

		} catch (Exception e) {
			System.out.println("\nFALHA AO CONECTAR COM O POSTGRESQL:");
			System.out.println(e.getMessage());
			return null;
		}
	}
}
