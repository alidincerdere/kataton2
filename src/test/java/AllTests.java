import org.junit.Before;
import org.junit.Test;
import util.FileOperator;
import util.impl.DefaultFileOperator;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by adere on 9.05.2019.
 */

public class AllTests {

    public static final String FILE_NAME = "demoinput.txt";

    public static FileOperator fileOperator;
    @Before
    public void setup() {

        fileOperator = new DefaultFileOperator(FILE_NAME);
        fileOperator.readContent();

    }


    @Test
    public void checkIfTargetExitst() {

        Integer endNode = Integer.parseInt(fileOperator.readLine(2));

        Integer myTarget = null;
        for (int i=3; i<fileOperator.getNumberOfRows(); i++) {

            String currentWord = fileOperator.readLine(i);
            //System.out.println(currentWord);

            myTarget = Integer.parseInt(currentWord.split("\\s+")[1]);

            if (myTarget == endNode) {
                break;
            }
        }

        assertEquals(myTarget, endNode);

    }

    @Test
    public void checkIfSourceExitst() {

        Integer sourceNode = Integer.parseInt(fileOperator.readLine(1));

        Integer mySource = null;
        for (int i=3; i<fileOperator.getNumberOfRows(); i++) {

            String currentWord = fileOperator.readLine(i);
            //System.out.println(currentWord);

            mySource = Integer.parseInt(currentWord.split("\\s+")[0]);

            if (mySource == sourceNode) {
                break;
            }
        }

        assertEquals(mySource, sourceNode);

    }

    @Test
    public void checkIfSourceAndTargetAreSame() {

        Integer sourceNode = Integer.parseInt(fileOperator.readLine(1));

        Integer endNode = Integer.parseInt(fileOperator.readLine(2));

        assertNotEquals(sourceNode,endNode);
    }

    @Test
    public void checkIfThereAreMoreThanOneEdges() {

        assertTrue(fileOperator.getNumberOfRows() - 3 > 1);
    }

    @Test
    public void checkIfNumberOfEdgesMatches() {

        Integer currentNum = null;

        Set<Integer> myEdges = new HashSet<Integer>();
        for (int i=3; i<fileOperator.getNumberOfRows(); i++) {

            String currentWord = fileOperator.readLine(i);

            currentNum = Integer.parseInt(currentWord.split("\\s+")[0]);

            myEdges.add(currentNum);

            currentNum = Integer.parseInt(currentWord.split("\\s+")[1]);

            myEdges.add(currentNum);

        }

        assertEquals(myEdges.size(),Integer.parseInt(fileOperator.readLine(0)));
    }


    @Test
    public void checkNoDuplicates() {

        Set<String> mySet = new HashSet<String>();

        String first = null;

        String second = null;

        for (int i=3; i<fileOperator.getNumberOfRows(); i++) {

            String currentWord = fileOperator.readLine(i);

            assertTrue(mySet.add(currentWord));

            first =  currentWord.split("\\s+")[0];

            second =  currentWord.split("\\s+")[1];

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(second + " " + first);

            assertTrue(mySet.add(stringBuilder.toString()));

        }
    }

}
