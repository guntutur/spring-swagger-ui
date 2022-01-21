package com.demo.springswagger.data.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "boook")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {
    @Id
    private String id;
    private String title;
    private String description;
    private boolean published;

    @Override
    public String toString() {
        return "TutorialRequest [id=" + id + ", title=" + title + ", desc=" + description + ", published=" + published + "]";
    }
}
