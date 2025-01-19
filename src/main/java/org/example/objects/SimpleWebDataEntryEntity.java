package org.example.objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "data")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SimpleWebDataEntryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    @JsonProperty("id")
    private Long id;

    @Basic(optional = false)
    @Column(nullable = false)
    @JsonProperty("name")
    private String name;

    @Basic(optional = false)
    @Column(nullable = false)
    @JsonProperty("age")
    private Integer age;

    @JsonProperty("title")
    private String title;

    @JsonProperty("hometown")
    private String hometown;

    @Override
    public String toString() {
        return String.format(
                "DataEntry[name='%s', age='%s', title='%s', hometown='%s']",
                name, age, title, hometown
        );
    }
}
