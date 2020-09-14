package com.nit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Entity
@Data
@Table(name="contact_details")
public class ContactDtlsEntity {

	@Id
	@Column(name="contact_id")
	@GeneratedValue
	private Integer cid;
	
	
	//@NotNull(message="is required")
	@Column(name="contact_name")
	private String cname;
	
	//@Pattern(regexp = "^[0-9]{10}",message="only digits")
	@Column(name="contact_number")
	private Long cnum;
	
	@Column(name="contact_mail")
	private String email;
}
