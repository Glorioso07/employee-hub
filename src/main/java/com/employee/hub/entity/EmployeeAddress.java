package com.employee.hub.entity;

import com.employee.hub.util.CellUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.poi.ss.usermodel.Row;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class EmployeeAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@NotNull
	private String addressLine1;

	private String addressLine2;

	@NotNull
	private String addressTown;

	@NotNull
	private String addressPostcode;

	@NotNull
	private String addressCountry;

	@NotNull
	private boolean isCurrent;

	@NotNull
	@ManyToOne
	private Employee employee;

	public EmployeeAddress(Row row, Employee employee) {
		this.addressLine1 = CellUtil.sanitizeCellValue(row.getCell(CellUtil.ADDRESS_LINE_1));
		this.addressLine2 = CellUtil.sanitizeCellValue(row.getCell(CellUtil.ADDRESS_LINE_2));
		this.addressTown = CellUtil.sanitizeCellValue(row.getCell(CellUtil.ADDRESS_TOWN));
		this.addressPostcode = CellUtil.sanitizeCellValue(row.getCell(CellUtil.ADDRESS_POSTCODE));
		this.addressCountry = CellUtil.sanitizeCellValue(row.getCell(CellUtil.ADDRESS_COUNTRY));
		this.isCurrent = CellUtil.sanitizeCellValue(row.getCell(CellUtil.IS_CURRENT)).equalsIgnoreCase("YES");
		this.employee = employee;
	}
}
