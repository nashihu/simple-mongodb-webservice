package com.ahmadmongo.ahmadmongo.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "matkul")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class MataKuliah {

    @Id
    private String id;
    private String name;
    private String teacherName;
    private int SKS;

}
