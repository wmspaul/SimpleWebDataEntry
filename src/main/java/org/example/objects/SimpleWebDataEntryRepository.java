package org.example.objects;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimpleWebDataEntryRepository extends JpaRepository<SimpleWebDataEntryEntity, Long> {

}
