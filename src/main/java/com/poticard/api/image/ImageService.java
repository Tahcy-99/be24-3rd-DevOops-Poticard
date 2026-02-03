package com.poticard.api.image;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public interface ImageService {
    public String upload(HttpServletRequest req) throws IOException, ServletException;
}
