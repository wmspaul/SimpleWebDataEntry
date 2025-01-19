package org.example.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.example.services.SimpleWebDataEntryRestService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/simple-web-data-entry")
public class SimpleWebDataEntryRestCalls {
    @Autowired
    private SimpleWebDataEntryRestService restService;

    /**
     * This method will return 100 records according to an offset provided
     * @param offset Where to start in the data entry records
     * @return A JSON Object with the next 100 records according to offset
     */
    @GetMapping("/data")
    public ResponseEntity<JSONObject> getAllData(HttpServletRequest request, @RequestParam("offset") int offset) {
        return new ResponseEntity<>(restService.getRecords(100, offset), HttpStatus.OK);
    }

    /**
     * This method will allow submitting new records
     * @return
     */
    @PostMapping("/data")
    public ResponseEntity<JSONObject> dataEntry(
            HttpServletRequest req,
            @RequestParam("name") String name,
            @RequestParam("age") Integer age,
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "hometown", required = false) String hometown
    ) {
        return new ResponseEntity<>(restService.createNewRecord(name, age, title, hometown), HttpStatus.OK);
    }

}
