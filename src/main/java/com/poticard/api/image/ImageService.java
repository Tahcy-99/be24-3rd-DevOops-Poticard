package com.poticard.api.image;

import jakarta.servlet.http.Part;

import java.io.IOException;

public interface ImageService {
    public String upload(Part file) throws IOException;
}
