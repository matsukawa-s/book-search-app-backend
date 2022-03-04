package com.example.booksearchapp.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Tag {
    Integer id;
    String name;
    Integer sortNumber;
    Integer tagGroupId;
    Boolean isDeleted;
}