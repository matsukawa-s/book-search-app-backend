package com.example.booksearchapp.responses;

import com.example.booksearchapp.entities.Tag;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

public class TagResponse {
    Integer id;
    String name;

    public static TagResponse from(Tag tag){
        TagResponse tagResponse = new TagResponse();
        tagResponse.setId(tag.getId());
        tagResponse.setName(tag.getName());
        return tagResponse;
    }

    public static List<TagResponse> from(List<Tag> tags){
        List<TagResponse> result = new ArrayList<>();
        for (Tag tag : tags){
            result.add(TagResponse.from(tag));
        }
        return result;
    }
}