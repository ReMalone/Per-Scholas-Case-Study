/**
 /**
 * This Business Object class is used to for Location Information
 * 
 * @author Cognizant
 * @contact Cognizant
 * @version 1.0
 */
package com.cts.insurance.homequote.bo;

import java.util.ArrayList;
import java.util.List;

import com.cts.insurance.homequote.dao.LocationDAO;
import com.cts.insurance.homequote.exception.HomequoteBusinessException;
import com.cts.insurance.homequote.exception.HomequoteSystemException;
import com.cts.insurance.homequote.model.Location;

public class LocationBO {

	/**
	 * @param location
	 * @return
	 * @throws HomequoteBusinessException
	 */
	public int saveHomeLocation(final Location location) throws HomequoteBusinessException{
		final LocationDAO locationDAO = new LocationDAO();
		System.out.println("System got into LocationBO line 28 and has object value of "+location);
		int quoteId = 0;
		try {
			
			 quoteId = locationDAO.saveLocation(location);
			} catch (HomequoteSystemException e) {
				throw new HomequoteBusinessException(e.getMessage());		
		}
		return quoteId;
	}
	
	/**
	 * @return
	 * @throws HomequoteBusinessException
	 * @throws HomequoteSystemException 
	 */
	public Location getHomeLocation(int quoteId) throws HomequoteBusinessException, HomequoteSystemException{

		Location location = new Location();
		final LocationDAO locationDAO = new LocationDAO();
		try {
			location = locationDAO.getLocation(quoteId);
			} catch (HomequoteSystemException e) {
				throw new HomequoteBusinessException(e.getMessage());		
		}
		return location;
	}
	
	/**
	 * @return
	 * @throws HomequoteBusinessException
	 * @throws HomequoteSystemException 
	 */
	public List<Location> getQuoteIds(String userName) throws HomequoteBusinessException, HomequoteSystemException{
		
		List<Location> quoteList = new ArrayList<Location>();
		final LocationDAO locationDAO = new LocationDAO();
		try {
			quoteList = locationDAO.getQuoteIds(userName);
			} catch (HomequoteSystemException e) {
				throw new HomequoteBusinessException(e.getMessage());		
		}
		return quoteList;
	}
	
}