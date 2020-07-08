package com.employee.hub.entity;

import com.employee.hub.util.CellUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.poi.ss.usermodel.Row;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@NotNull
	private String departmentCode;

	@NotNull
	private String departmentName;

	public Department(Row row) {
		this.departmentCode = CellUtil.formatDepartmentCode(row.getCell(CellUtil.DEPARTMENT_CODE));
		this.departmentName = CellUtil.sanitizeCellValue(row.getCell(CellUtil.DEPARTMENT_NAME));
	}

}
