package org.example.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NonNull;
import org.example.objects.SimpleWebDataEntryServiceException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimpleWebDataEntryRestService {
    @Autowired
    SimpleWebDataEntryRepositoryService repositoryService;

    public JSONObject getRecords(int numberOfRecords, int offset) {
        ObjectMapper om = new ObjectMapper();
        try {
            JSONObject response = new JSONObject();
            response.append("results", om.writeValueAsString(
                    repositoryService.findData(numberOfRecords, offset)
            ));

            return response;
        }
        catch (Exception e) {
            throw new SimpleWebDataEntryServiceException(e.getMessage());
        }
    }

    public JSONObject createNewRecord(@NonNull String name, @NonNull Integer age, String title, String hometown) {
        repositoryService.addData(name, age, title, hometown);
        JSONObject response = new JSONObject();
        response.append("results", "New data entry added!");
        return response;
    }
}
