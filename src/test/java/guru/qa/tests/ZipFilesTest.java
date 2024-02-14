package guru.qa.tests;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipFilesTest {
    private final ClassLoader cl = ZipFilesTest.class.getClassLoader();

    @Test
    @DisplayName("Проверка содержимого PDF")
    void pdfParsingTest() throws Exception {
        try (InputStream is = cl.getResourceAsStream("sample.zip"); ZipInputStream zis = new ZipInputStream(is)) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().endsWith(".pdf")) {
                    PDF pdf = new PDF(zis);
                    Assertions.assertTrue(pdf.text.contains("JUnit 5 User Guide"));
                }
            }
        }
    }
    @Test
    @DisplayName("Проверка содержимого CSV")
    void csvParsingTest() throws Exception {
        try (InputStream is = cl.getResourceAsStream("sample.zip"); ZipInputStream zis = new ZipInputStream(is)) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().endsWith(".csv")) {
                    CSVReader csvReader = new CSVReader(new InputStreamReader(zis));
                    List<String[]> content = csvReader.readAll();
                    Assertions.assertArrayEquals(new String[] {"QAGURU", "Yes"}, content.get(0));
                }
            }
        }
    }
    @Test
    @DisplayName("Проверка содержимого XLSX")
    void xlsParsingTest() throws Exception {
        try (InputStream is = cl.getResourceAsStream("sample.zip"); ZipInputStream zis = new ZipInputStream(is)) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().endsWith(".xlsx")) {
                    XLS xls = new XLS(zis);
                    Assertions.assertEquals("Dulce",
                            xls.excel.getSheet("sheet1").getRow(1).getCell(0).getStringCellValue()
                    );
                }
            }
        }
    }
}