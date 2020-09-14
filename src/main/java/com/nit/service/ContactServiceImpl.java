package com.nit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.dto.ContactDTO;
import com.nit.entity.ContactDtlsEntity;
import com.nit.repository.ContactDtlsRepository;

@Service
public class ContactServiceImpl implements ContactService{

	@Autowired
	private ContactDtlsRepository repo;
	
	@Override
	public boolean saveContact(ContactDTO dto) {
		ContactDtlsEntity entity=null;
	
		entity=new ContactDtlsEntity();
		//convert dto to entity
		BeanUtils.copyProperties(dto, entity);
		
		/*entity=repo.save(entity);
		if(entity.getCid()!=null)
			return true;
		else
			return false; */
		
		return repo.save(entity).getCid() != null;
	}

	@Override
	public List<ContactDTO> getAllConatct() {
	List<ContactDtlsEntity> listEntity=null;
	List<ContactDTO> listDTO=new ArrayList();
	//use repo
	listEntity=repo.findAll();
	//convert listentity to listDTO
	listEntity.forEach(entity->{
		ContactDTO dto=new ContactDTO();
		BeanUtils.copyProperties(entity, dto);
		listDTO.add(dto);
	});
		return listDTO;
	}

	@Override
	public ContactDTO getContactById(Integer cid) {
		ContactDtlsEntity entity=null;
		ContactDTO dto=null;
		
		Optional<ContactDtlsEntity> opt=repo.findById(cid);
		if(opt.isPresent())
		{
		entity=	opt.get();
		dto=new ContactDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
		}
		return null;
	}

	@Override
	public boolean updateContact(ContactDTO dto) {
		ContactDtlsEntity entity=null;
		entity=new ContactDtlsEntity();
		
		
		//convert dto to entity
		BeanUtils.copyProperties(dto, entity);
		
		return repo.save(entity).getCid() != null;
	}

	@Override
	public boolean deleteContact(Integer cid) {
		
		repo.deleteById(cid);
		return true;
	}

}
