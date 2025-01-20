package org.example.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.NonNull;
import org.example.objects.SimpleWebDataEntryEntity;
import org.example.objects.SimpleWebDataEntryServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SimpleWebDataEntryRestService {
    @Autowired
    SimpleWebDataEntryRepositoryService repositoryService;

    public String getRecords(int numberOfRecords, int offset) {
        try {
            List<SimpleWebDataEntryEntity> results = repositoryService.findData(numberOfRecords, offset);
            Gson gson = new GsonBuilder().serializeNulls().create();
            Map<String, List<SimpleWebDataEntryEntity>> response = new HashMap<>();
            response.put("results", results);
            return gson.toJson(response);
        }
        catch (Exception e) {
            throw new SimpleWebDataEntryServiceException(e.getMessage());
        }
    }

    public String createNewRecord(@NonNull String name, @NonNull Integer age, String title, String hometown) {
        repositoryService.addData(name, age, title, hometown);
        Gson gson = new Gson();
        Map<String, String> response = new HashMap<>();
        response.put("results", "New data entry added!");
        return gson.toJson(response);
    }
}
