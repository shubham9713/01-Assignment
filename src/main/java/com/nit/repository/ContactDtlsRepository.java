package com.nit.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.entity.ContactDtlsEntity;

public interface ContactDtlsRepository extends JpaRepository<ContactDtlsEntity, Serializable> {

}
