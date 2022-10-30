package core.basesyntax.filework.impl;

import core.basesyntax.filework.ReportWriteToFile;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class ReportWriteToFileImpl implements ReportWriteToFile {
    private static final String OUTPUT_DATA_FILE = "src/main/resources/reportWriteToFile.csv";

    @Override
    public void writeReportToFile(String report) {
        File file = new File(OUTPUT_DATA_FILE);

        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            Files.write(file.toPath(), report.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
