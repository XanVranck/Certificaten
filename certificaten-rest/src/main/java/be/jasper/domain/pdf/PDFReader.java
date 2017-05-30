package be.jasper.domain.pdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Configuration
@EnableScheduling
public class PDFReader {
    private String baseUrl = "C:\\wd\\pdf\\";
    private File folder = new File(baseUrl);

    @Scheduled(fixedDelay=5000)
    public void pdfLezer() throws IOException {
        File[] listOfFiles = folder.listFiles();
        BufferedWriter bufferedWriter = txtFileVoorbereiden();
        int count = 0;
        
        for (File file : listOfFiles) {
            if (file.isFile()) {
                try {
                    String text = getText(file);
                    //TODO: SOUT verwijderen
                    System.out.println("Text in PDF: " + text);
                    schrijfWegNaarTxtFile(bufferedWriter, file.getName());
                    ++count;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        schrijfWegNaarTxtFile(bufferedWriter, count + " PDF's in totaal!");
        bufferedWriter.close();
    }

    private BufferedWriter txtFileVoorbereiden() throws IOException {
        FileWriter fileWriter = new FileWriter(baseUrl + "overzicht.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.flush();
        schrijfWegNaarTxtFile(bufferedWriter, "Volgende PDF's zijn weggeschreven: ");
        return bufferedWriter;
    }

    private void schrijfWegNaarTxtFile(BufferedWriter bufferedWriter, String name) throws IOException {
        bufferedWriter.write(name);
        bufferedWriter.newLine();
    }

    public String getText(File pdfFile) throws IOException {
        PDDocument doc = PDDocument.load(pdfFile);
        return new PDFTextStripper().getText(doc);
    }
}