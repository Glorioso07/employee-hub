package com.employee.hub.entity;

import com.employee.hub.util.CellUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.poi.ss.usermodel.Row;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Employee {

	public enum Gender {
		MALE, FEMALE
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@NotNull
	private String employeeCode;

	@NotNull
	private String firstName;

	@NotNull
	private String lastName;

	@NotNull
	@Enumerated(EnumType.ORDINAL)
	private Gender gender;

	@NotNull
	private Date dob;

	@NotNull
	private String email;

	@NotNull
	private String contactNumber;

	@NotNull
	@ManyToOne
	private Department department;

	public Employee(Row row, Department department) {
		this.employeeCode = CellUtil.sanitizeCellValue(row.getCell(CellUtil.EMPLOYEE_CODE));
		this.firstName = CellUtil.sanitizeCellValue(row.getCell(CellUtil.FIRST_NAME));
		this.lastName = CellUtil.sanitizeCellValue(row.getCell(CellUtil.LAST_NAME));
		this.gender = CellUtil.sanitizeCellValue(row.getCell(CellUtil.GENDER)).equalsIgnoreCase(Gender.MALE.name()) ? Gender.MALE : Gender.FEMALE;
		this.dob = row.getCell(CellUtil.DOB).getDateCellValue();
		this.contactNumber = CellUtil.sanitizeCellValue(row.getCell(CellUtil.CONTACT_NUMBER));
		this.email = CellUtil.sanitizeCellValue(row.getCell(CellUtil.EMAIL));
		this.department = department;
	}

}
