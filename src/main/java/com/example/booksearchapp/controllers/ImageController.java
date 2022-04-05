package com.example.booksearchapp.controllers;

import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping
public class ImageController {
    /**
     * 本の画像を表示する
     * @param image
     * @return 本のimage pass
     * @throws IOException
     */
    @GetMapping(
            value = "/image/{image}",
            produces = MediaType.IMAGE_JPEG_VALUE
    )
    public @ResponseBody
    byte[] getImageWithMediaType(@PathVariable String image) throws IOException {
        InputStream in = getClass()
                .getResourceAsStream("/static/images/" + image);
        if(in == null){
            in = getClass()
                    .getResourceAsStream("/static/images/noimage.jpg");
        }
        return IOUtils.toByteArray(in);
    }
}
