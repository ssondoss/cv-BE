package com.example.cv;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Builder {



    public Builder() {
    }

    public void generatePdf() throws IOException {

        var resource = new ClassPathResource("static/index.html");

        String html = new String(resource.getInputStream().readAllBytes(), StandardCharsets.UTF_8);

        FileOutputStream fos= new FileOutputStream("index-output.pdf");

        PdfRendererBuilder builder = new PdfRendererBuilder();

        builder.withHtmlContent(html,null);
        builder.toStream(fos);
        builder.run();
        fos.close();
        System.out.println("Saving to: " + new File("index-output.pdf").getAbsolutePath());


    }
}
