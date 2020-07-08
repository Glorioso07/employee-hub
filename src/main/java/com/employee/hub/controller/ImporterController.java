package com.employee.hub.controller;

import com.employee.hub.service.EmployeeService;
import com.employee.hub.service.ImporterService;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.POIXMLException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;


@Slf4j
@Controller
@RequestMapping("importer")
public class ImporterController {

    private final EmployeeService employeeService;

    private final ImporterService importerService;

    public ImporterController(EmployeeService employeeService, ImporterService importerService) {
        this.employeeService = employeeService;
        this.importerService = importerService;
    }

    @RequestMapping()
    public String getImportFile() {
        return "importer/importFile";
    }

    @RequestMapping(value = "importFile", method = RequestMethod.POST)
    public String postImportFile(@RequestParam("file") MultipartFile file, Model model) {
        this.employeeService.resetResults();
        try {
            this.importerService.parseAndStore(file);
        } catch (POIXMLException e) {
            log.error("The file does not have a valid format");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        } catch (IOException e) {
            log.error("An error occurred importing the file");
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        model.addAttribute("insertedEmployees", this.employeeService.getInserted());
        model.addAttribute("updatedEmployees", this.employeeService.getUpdated());
        return "importer/importResults";
    }

}
