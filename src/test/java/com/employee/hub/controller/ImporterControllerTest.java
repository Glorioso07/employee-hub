package com.employee.hub.controller;

import com.employee.hub.service.EmployeeService;
import com.employee.hub.service.ImporterService;
import org.apache.poi.POIXMLException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RunWith(SpringRunner.class)
@WebMvcTest(ImporterController.class)
public class ImporterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @MockBean
    private ImporterService importerService;

    @Test
    public void getImporterStatusOk() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/importer"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void importFileStatusOk() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.multipart("/importer/importFile")
                .file(new MockMultipartFile("file", "xlsx".getBytes())))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void importFileStatusBadRequest() throws Exception {
        Mockito.doThrow(POIXMLException.class).when(this.importerService).parseAndStore(Mockito.any(MultipartFile.class));
        mockMvc.perform(MockMvcRequestBuilders.multipart("/importer/importFile")
                .file(new MockMultipartFile("file", "xlsx".getBytes())))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void importFileStatusInternalServerError() throws Exception {
        Mockito.doThrow(IOException.class).when(this.importerService).parseAndStore(Mockito.any(MultipartFile.class));
        mockMvc.perform(MockMvcRequestBuilders.multipart("/importer/importFile")
                .file(new MockMultipartFile("file", "xlsx".getBytes())))
                .andExpect(MockMvcResultMatchers.status().isInternalServerError());
    }
}
