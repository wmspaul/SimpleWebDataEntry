package org.example.services;

import lombok.NonNull;
import org.example.objects.SimpleWebDataEntryEntity;
import org.example.objects.SimpleWebDataEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimpleWebDataEntryRepositoryService {
    @Autowired
    private SimpleWebDataEntryRepository repository;

    public List<SimpleWebDataEntryEntity> findData(Integer limit, Integer offset) {
        Pageable pageable = PageRequest.of(offset, limit);
        Page<SimpleWebDataEntryEntity> page = repository.findAll(pageable);
        return page.getContent();
    }

    public void addData(@NonNull String name, @NonNull Integer age, String title, String hometown) {
        repository.save(
                SimpleWebDataEntryEntity.builder()
                        .name(name)
                        .age(age)
                        .title(title)
                        .hometown(hometown)
                .build()
        );
    }
}
