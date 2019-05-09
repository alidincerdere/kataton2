// A Java program for Dijkstra's single source shortest path algorithm.
// The program is for adjacency matrix representation of the graph
import util.FileOperator;
import util.impl.DefaultFileOperator;

import java.util.*;
import java.lang.*;
import java.io.*;

public class ShortestPath
{

    public static final String FILE_NAME = "facebook_combined.txt";

    // Driver method
    public static void main (String[] args)
    {

        FileOperator fileOperator = new DefaultFileOperator(FILE_NAME);
        fileOperator.readContent();

        //System.out.println(fileOperator.readLine(0));
        Integer size = Integer.parseInt(fileOperator.readLine(0));

        Integer startNode = Integer.parseInt(fileOperator.readLine(1));
        Integer endNode = Integer.parseInt(fileOperator.readLine(2));



		Graph graph = new Graph(size);
		Integer first = 0;
		Integer second = 0;
		for (int i=3; i<fileOperator.getNumberOfRows(); i++) {

		    String currentWord = fileOperator.readLine(i);
		    //System.out.println(currentWord);

		    first = Integer.parseInt(currentWord.split("\\s+")[0]);

		    second = Integer.parseInt(currentWord.split("\\s+")[1]);

		    graph.addEdge(first,second);
        }

        int[] results = graph.shortestReach(startNode);

		/*
        for (int i=0; i<results.length; i++) {

            System.out.println(i + " " + results[i]);
        }
        */
		System.out.println(results[endNode]);

    }
}
//This code is contributed by Aakash Hasija
