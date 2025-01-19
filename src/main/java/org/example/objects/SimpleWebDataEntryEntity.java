package org.example.objects;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "data")
@Getter
@Setter
@Builder
public class SimpleWebDataEntryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;

    @Basic(optional = false)
    @Column(nullable = false)
    private String name;

    @Basic(optional = false)
    @Column(nullable = false)
    private Integer age;

    private String title;
    private String hometown;

    @Override
    public String toString() {
        return String.format(
                "DataEntry[name='%s', age='%s', title='%s', hometown='%s']",
                name, age, title, hometown
        );
    }
}
