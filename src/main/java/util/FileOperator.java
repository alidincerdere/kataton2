package util;

import java.util.List;

/**
 * Created by adere on 9.05.2019.
 */
public interface FileOperator {

    boolean checkFileExist();

    int getNumberOfRows();

    String readLine(int rowNumber);

    List<String> getAllWords();

    void readContent();

    void writeWordsToFile(String outputFile);

    void setOutputWords(List<String> outputWords);

}