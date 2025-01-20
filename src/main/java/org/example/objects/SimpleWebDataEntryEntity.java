package org.example.objects;

import com.fasterxml.jackson.annotation.JsonInclude;
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
@JsonInclude
public class SimpleWebDataEntryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty
    private Long id;

    @Basic(optional = false)
    @Column(nullable = false)
    @JsonProperty
    private String name;

    @Basic(optional = false)
    @Column(nullable = false)
    @JsonProperty
    private Integer age;

    @JsonProperty
    private String title;

    @JsonProperty
    private String hometown;

    @Override
    public String toString() {
        return String.format(
                "DataEntry[name='%s', age='%s', title='%s', hometown='%s']",
                name, age, title, hometown
        );
    }
}
