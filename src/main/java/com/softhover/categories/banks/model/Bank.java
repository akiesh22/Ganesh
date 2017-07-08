package com.softhover.categories.banks.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="bank")
public class Bank {
	@Id
	@GeneratedValue
	long id;
	@Column
	String bankName;
	@Column
	String branchName;
	@Column
	long accNumber;
	@Column
	String swiftCode;
}
