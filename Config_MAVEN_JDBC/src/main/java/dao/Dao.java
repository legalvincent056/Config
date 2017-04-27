package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import metier.Client;

public class Dao implements IDao {

	@Override
	public long addClient(Client c) {
		try {
			// 1- charger le pilote
			Class.forName("com.mysql.jdbc.Driver");
			// 2- cr�er la connexion
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "");
			// 3- cr�er la requ�te
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Client(nom, prenom) VALUES (?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, c.getNom());
			ps.setString(2, c.getPrenom());
			// 4- executer la requ�te
			ps.executeUpdate();
			// 5- pr�senter les r�sultats
			ResultSet generatedKeys = ps.getGeneratedKeys();
			if (generatedKeys.next()) {
				c.setId(generatedKeys.getLong(1));
			}
			// 6- fermer la connexion
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c.getId();
	}
}
