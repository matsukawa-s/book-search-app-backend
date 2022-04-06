package com.example.booksearchapp.services;

import com.example.booksearchapp.entities.Tag;
import com.example.booksearchapp.mappers.TagMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService implements ITagService {
    private final TagMapper tagMapper;

    public TagService(TagMapper tagMapper) {
        this.tagMapper = tagMapper;
    }

    @Override
    public List<Tag> tagList() {
        return tagMapper.tagList();
    }

}
