package be.jasper.domain.pdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.*;

@Configuration
@EnableScheduling
public class PDFReader {
    private String baseUrl = "C:\\wd\\pdf\\";
    private File folder = new File(baseUrl);
    private BufferedWriter pdfToTxt;
    private String klant = "";


    @Scheduled(fixedDelay = 50000)
    public void pdfLezer() throws IOException {
        File[] listOfFiles = folder.listFiles();
        BufferedWriter bufferedWriter = txtFileVoorbereiden();
        pdfToTxt = pdfToTxtVoorbeiden();
        int count = 0;

        for (File file : listOfFiles) {
            String text = "";
            if (file.isFile()) {
                try {
                    text = getText(file);
                    //TODO: SOUT verwijderen
                    System.out.println("Text in PDF: " + text);
                    schrijfWegNaarTxtFile(bufferedWriter, file.getName());
                    schrijfWegNaarTxtFile(pdfToTxt, text);
                    ++count;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        schrijfWegNaarTxtFile(bufferedWriter, count + " PDF's in totaal!");
        bufferedWriter.close();
    }

    private BufferedWriter pdfToTxtVoorbeiden() throws IOException {
        FileWriter fileWriter = new FileWriter(baseUrl + "pdfToTxt.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.flush();
        return bufferedWriter;
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

    @Scheduled(fixedDelay = 5000)
    public void readTextFromTxt() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(baseUrl + "pdfToTxt.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        int sizeOfTextFile = 91;
        int klantLine = 1;
        for (int line = 0; line <= sizeOfTextFile; line++) {
            if (line == klantLine || line == 89) {
                klant = bufferedReader.readLine();
                System.out.println(klant);
            }
//            if (line == sizeOfTextFile-1 && !bufferedReader.readLine().isEmpty()) {
//                sizeOfTextFile += 90;
//                klantLine +=90;
//            }
        }
    }
}
