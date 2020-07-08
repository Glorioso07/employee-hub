package com.employee.hub.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImporterService {

    void parseAndStore(MultipartFile file) throws IOException;

}
