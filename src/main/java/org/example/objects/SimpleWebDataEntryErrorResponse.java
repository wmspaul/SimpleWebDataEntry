package org.example.objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@JsonInclude(JsonInclude.Include.NON_NULL)
public record SimpleWebDataEntryErrorResponse(String userMessage, String developerMessage) {
}
