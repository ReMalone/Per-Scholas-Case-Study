/**
 * This Business Object class is used to for Homeowner Information
 * 
 * @author Cognizant
 * @contact Cognizant
 * @version 1.0
 */
package com.cts.insurance.homequote.bo;

import java.io.IOException;
import java.sql.SQLException;

import com.cts.insurance.homequote.dao.HomeownerDAO;
import com.cts.insurance.homequote.exception.HomequoteBusinessException;
import com.cts.insurance.homequote.exception.HomequoteSystemException;
import com.cts.insurance.homequote.model.Homeowner;

public class HomeownerBO {

	/**
	 * @param quoteId
	 * @param lastName
	 * @param dob
	 * @param emailAddress
	 * @return
	 */
	public Homeowner getHomeownerInfo(final int quoteId) throws HomequoteBusinessException, ClassNotFoundException, SQLException, IOException{
		Homeowner homeowner = null;
		final HomeownerDAO HomeownerDAO = new HomeownerDAO();
		//Code Edit
		try {
			homeowner = HomeownerDAO.getHomeowner(quoteId);
			} catch (HomequoteSystemException e) {
				throw new HomequoteBusinessException(e.getMessage());		
		}
		return homeowner;
		//Code Finish
	}
	/**
	 * @param homeowner
	 * @throws HomequoteBusinessException
	 */
	public void saveHomeownerInfo(final Homeowner homeowner) throws HomequoteBusinessException, ClassNotFoundException, IOException{
		final HomeownerDAO HomeownerDAO = new HomeownerDAO();
		//Code Edit
		try {
			HomeownerDAO.saveHomeowner(homeowner);
			} catch (HomequoteSystemException e) {
				throw new HomequoteBusinessException(e.getMessage());	
		}
		//Code Finish
	}
}
