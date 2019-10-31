package com.sunhome.framework.servlet.admin.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

@WebServlet(urlPatterns = "/upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;UTF-8");

        Part part = request.getPart("picFile");
        String fileName = getFileName(part);
        String path = getRealPath("/upload");
        // 写入
        part.write(path + "/" + fileName);

        response.getWriter().write("upload success");
        response.getWriter().flush();
    }


    private String getRealPath(String resourcesPath) {

        //获得文件上传位置uploadFiles的路径:xxx/xxx/uploadFiles
        String path = this.getServletContext().getRealPath("/" + resourcesPath);
        File file = new File(path);
        //如果file不存在,在这个路径下创建文件
        if (!file.exists()) {
            file.mkdirs();
        }
        return path;

    }

    private String getFileName(Part part) {

        //获得上传的文件名称
        String header = part.getHeader("Content-Disposition");

        int idx = header.lastIndexOf("filename=\"");

        return header.substring(idx + 10, header.length() - 1);
    }
}
