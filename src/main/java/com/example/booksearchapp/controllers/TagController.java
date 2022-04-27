package com.example.booksearchapp.controllers;

import com.example.booksearchapp.entities.Tag;
import com.example.booksearchapp.responses.TagResponse;
import com.example.booksearchapp.services.ITagService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("tags")
public class TagController {
    private final ITagService tagService;

    public TagController(ITagService tagService) {
        this.tagService = tagService;
    }

    /**
     * タグの取得
     * @return タグ一覧
     */
    @GetMapping("")
    public List<TagResponse> tagList() {
        List<Tag> tagList = tagService.tagList();
        return TagResponse.from(tagList);
    }
}
