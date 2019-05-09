package util.impl;

import util.FileOperator;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by adere on 11.01.2019.
 */
public class DefaultFileOperator implements FileOperator {

    private String fileName;
    private int numOfRows;
    private List<String> allWords;
    private List<String> outputWords;

    public DefaultFileOperator(String fileName) {

        allWords = new ArrayList<String>();
        numOfRows = 0;
        this.fileName = fileName;
    }

    public boolean checkFileExist() {

        FileReader fr = null;

        try {
            fr = new FileReader(fileName);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }


    public int getNumberOfRows() {

        return numOfRows;
    }

    public String readLine(int rowNumber) {
        return allWords.get(rowNumber);
    }

    public List<String> getAllWords() {
        return allWords;
    }

    public void readContent() {

        allWords = new ArrayList<String>();

        BufferedReader br = null;
        FileReader fr = null;

        try {
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);

            String sCurrentLine;

            System.out.println("reading input file...");
            while ((sCurrentLine = br.readLine()) != null) {

                numOfRows++;
                allWords.add(sCurrentLine);

            }
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());
        } finally {

            try {

                if (br != null) {
                    br.close();
                }

                if (fr != null) {
                    fr.close();
                }

            } catch (IOException ex) {

                //ex.printStackTrace();
                System.out.println(ex.getMessage());

            }

        }


    }

    public void writeWordsToFile(String outputFileName) {

        BufferedWriter bw = null;
        FileWriter fw = null;

        try {

            fw = new FileWriter(outputFileName);
            bw = new BufferedWriter(fw);

            for(String currentWord: outputWords) {
                bw.write(currentWord + "\n");
            }

            System.out.println("Done");

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (bw != null)
                    bw.close();

                if (fw != null)
                    fw.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }

    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }


    public void setOutputWords(List<String> outputWords) {
        this.outputWords = outputWords;
    }
}
