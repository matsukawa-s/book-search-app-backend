package com.example.booksearchapp.mappers;

import com.example.booksearchapp.entities.Tag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TagMapper {
    public List<Tag> tagList();
}
