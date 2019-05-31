package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.CallableStatement;

import entity.EntityFactory;
import entity.Map;

public class DAOMap {

	/** The connection. */
//	private final Connection connection;
	
	
	public DAOMap() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Creates the.
	 *
	 * @param entity
	 *          the entity
	 * @return true, if successful
	 */
	public boolean create(final Map entity)
	{
		//for send in DB, don't need to do it now
		return false;
	}

	/**
	 * Delete.
	 *
	 * @param entity
	 *          the entity
	 * @return true, if successful
	 */
	public boolean delete(final Map entity)
	{
		//for delete in DB, don't need to do it now
		return false;
	}

	/**
	 * Update.
	 *
	 * @param entity
	 *          the entity
	 * @return true, if successful
	 */
	public boolean update(final Map entity) {
		//for update in DB, don't need to do it now
		return false;
	}
	
	/**
	 * Find.
	 *
	 * @param id
	 *          the id
	 * @return the map
	 */
	public Map find(int id)
	{
		/////   access base de donnee   /////
		String urlString = "jdbc:mysql://127.0.0.1/jpublankproject?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String loginString = "root";
		String passwdString = "";
		Connection cnConnection = null;
		CallableStatement stStatement = null;
		ResultSet rsResultset = null;

		String sqlRequestString = "{call MapByID(?)}";
		/////////////////////////////////////
		
		Map TEMP_map = new Map();

		try {
			// 1): Chargement du driver // sur la vm ?
			//Class.forName(connectorString);//plus necessaire apparament (d'apres le message d'erreur)
			// 2): Connexion
			cnConnection = DriverManager.getConnection(urlString, loginString, passwdString);
			// 3): creation du statement (jsp ce que c'est)
			stStatement = (CallableStatement) cnConnection.prepareCall(sqlRequestString);
			stStatement.setInt(1, id);
			stStatement.execute();
			// 4): execute requete
			rsResultset = stStatement.getResultSet();
			// 5):
			if (rsResultset.first()) {//on fait vraiment un while là, on est sencé avoir une seul route
				int width = rsResultset.getInt("width");//y
				System.out.println(width);
				int height = rsResultset.getInt("height");//x
				System.out.println(height);
				int diamondToWin = rsResultset.getInt("diamond");
				TEMP_map = new Map(width, height);
				TEMP_map.setDiamondToWin(diamondToWin);

				String TEMP_mapText_FromSQL = rsResultset.getString("content");
				TEMP_mapText_FromSQL = TEMP_mapText_FromSQL.replaceAll("\r\n", "");

				System.out.println(TEMP_mapText_FromSQL);

				for(int y=0; y < height; y++)
				{
					for(int x=0; x < width; x++)
					{
						TEMP_map.setEntityOnTheMap(x, y, EntityFactory.getFromSymbol(TEMP_mapText_FromSQL.charAt(y*width + x)));//(y*width + x)
//						System.out.println(y*width + x);
					}
				}
			}
			else {
				System.out.println("<ERROR : map not found>");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// 6): on vide la mémoire
				cnConnection.close();
				stStatement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("Diamond to Win : " + TEMP_map.getDiamondToWin());
		System.out.println(TEMP_map.getEntity(0, 0).toString());
		System.out.println(TEMP_map.getEntity(1, 1).toString());
		System.out.println(TEMP_map.getEntity(3, 2).toString());
		return TEMP_map;
	}


}
