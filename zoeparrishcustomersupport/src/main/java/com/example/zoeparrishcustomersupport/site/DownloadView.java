package com.example.zoeparrishcustomersupport.site;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.View;

import java.util.Map;

public class DownloadView implements View{

    private final String filename;
    private final byte[] content;

    public DownloadView(String filename, byte[] content) {
        this.filename = filename;
        this.content = content;
    }

    @Override
    public String getContentType() {
        return View.super.getContentType();
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setHeader("Content-Disposition","attachment; filename="+ filename);
        response.setContentType("application/octet-stream");
        ServletOutputStream out = response.getOutputStream();
        out.write(content);
    }
}
