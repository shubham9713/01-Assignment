package com.nit.service;

import java.util.List;

import com.nit.dto.ContactDTO;

public interface ContactService {

	/**
	 * Take Contact form as input, save data in db and return msg
	 * 
	 */
	public boolean saveContact(ContactDTO dto);
	/**
	 * 
	 * select all rows and give List<T>
	 */
	public List<ContactDTO> getAllConatct();
	/**
	 * Takes edit form data as input and returns contact
	 */
	
	public ContactDTO getContactById(Integer cid);
	
	/**
	 * Takes edit from data as input and perform update operation
	 */
	public boolean updateContact(ContactDTO dto);
	 	
	/**
	 * Takes PK(ID) as input and perform delete operation 
	 */
	public boolean deleteContact(Integer cid);
}
