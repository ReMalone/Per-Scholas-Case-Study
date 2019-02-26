/**
 * This DAO class is used to for Homeowner Information
 *
 * @author Cognizant
 * @contact Cognizant
 * @version 1.0
 */
package com.cts.insurance.homequote.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.cts.insurance.homequote.exception.HomequoteSystemException;
import com.cts.insurance.homequote.model.Homeowner;
import com.cts.insurance.homequote.util.HomeInsuranceConstants;
import com.cts.insurance.homequote.util.SqlQueries;

public class HomeownerDAO {
	
	private final static Logger LOG = Logger.getLogger(HomeownerDAO.class);

	/**
	 * @param homeowner
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public void saveHomeowner(final Homeowner homeowner) throws HomequoteSystemException, ClassNotFoundException, IOException
	{
		LOG.info("HomeownerDAO.saveHomeowner - starts");
		Connection conn = null;
		//Code Edit 
		PreparedStatement stmt = null;
		
		try {
			final AbstractDAOFactory daoFactory = AbstractDAOFactory.getDaoFactory(HomeInsuranceConstants.MYSQL);
			conn = daoFactory.getConnection();
			stmt = conn.prepareStatement(SqlQueries.SAVE_HOMEOWNER);
			stmt.setInt(1, homeowner.getQuoteId());
			stmt.setString(2, homeowner.getFirstName());
			stmt.setString(3, homeowner.getLastName());
			stmt.setString(4, homeowner.getDob());
			stmt.setString(5, homeowner.getIsRetired());
			stmt.setString(6, homeowner.getSsn());
			stmt.setString(7, homeowner.getEmailAddress());
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			throw new HomequoteSystemException(e.getMessage());
		} finally {
			try {
				stmt.close();
			}
			catch (SQLException e) {
				LOG.error("Exception while trying to close Connection : " + e.getMessage() );
			}
		}
		LOG.info("HomeownerDAO.saveHomeowner - ends");
		//Code End
	}
	

	/**
	 * @param homeowner
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public Homeowner getHomeowner(final int quoteId) throws HomequoteSystemException, ClassNotFoundException, IOException {
		LOG.info("HomeownerDAO.getHomeowner - starts");
		Connection conn = null;
		Homeowner homeowner = null;
		ResultSet resultSet = null;
		PreparedStatement stmt = null;
		//Code Edit
		try {
			final AbstractDAOFactory daoFactory = AbstractDAOFactory.getDaoFactory(HomeInsuranceConstants.MYSQL);
			conn = daoFactory.getConnection();
			stmt = conn.prepareStatement(SqlQueries.GET_HOMEOWNER);
			stmt.setInt(1, quoteId);
			resultSet = stmt.executeQuery();
			while(resultSet.next()) {
				homeowner = new Homeowner();
				homeowner.setQuoteId(resultSet.getInt(1));
				homeowner.setFirstName(resultSet.getString(2));
				homeowner.setLastName(resultSet.getString(3));
				homeowner.setDob(resultSet.getString(4));
				homeowner.setIsRetired(resultSet.getString(5));
				homeowner.setSsn(resultSet.getString(6));
				homeowner.setEmailAddress(resultSet.getString(7));
			}		
		} catch (SQLException e) {
			throw new HomequoteSystemException(e.getMessage());
		} finally {
			try {
				resultSet.close();
				stmt.close();
				conn.close();
			} 
			catch (SQLException e) {
				LOG.error("Exception while trying to close Connection : " + e.getMessage() );
			}
		}
		LOG.info("PolicyDAO.getPolicies - ends");
		return homeowner;
		//Code End
	}

}
