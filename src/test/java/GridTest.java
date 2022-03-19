import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GridTest {
    Grid grid;
    @BeforeEach
    public void setUp(){
        grid = new Grid();
    }
    @Test
    public void shouldHave6LinesWhenInitializedGrid(){

        int result = grid.getRowsSize();
        assertEquals(6,result);
    }
    @Test
    public void shouldHave7ColumnsWhenInitializedGrid(){
        int result = grid.getColumnsSize();
        assertEquals(7,result);
    }

    @Test
    public void gridShouldBeInitializedWithPoints(){
       for (int i = 0; i<6 ;i++) {
           for (int j = 0; j < 7; j++) {
               String result = grid.getToken(i , j);
               assertEquals(".",result);
           }
       }
    }
    @Test
    public void shouldPutTokenOnTheLastLineOfEmptyColumn1() {
        String[][] expectedMatrix = {
                {".", ".", ".", ".", ".", ".", "."},
                {".", ".", ".", ".", ".", ".", "."},
                {".", ".", ".", ".", ".", ".", "."},
                {".", ".", ".", ".", ".", ".", "."},
                {".", ".", ".", ".", ".", ".", "."},
                {"R", ".", ".", ".", ".", ".", "."},
        };
        grid.insertToken("R",0);
                assertEquals(expectedMatrix[5][0],grid.getToken(5,0));
    }
    @Test
    public void shouldPutTokenOnTheLastLineOfAnyEmptyColumn() {
        String[][] expectedMatrix = {
                {".", ".", ".", ".", ".", ".", "."},
                {".", ".", ".", ".", ".", ".", "."},
                {".", ".", ".", ".", ".", ".", "."},
                {".", ".", ".", ".", ".", ".", "."},
                {".", ".", ".", ".", ".", ".", "."},
                {".", ".", "J", ".", ".", ".", "."},
        };
        grid.insertToken("J",2);
        assertEquals(expectedMatrix[5][2],grid.getToken(5,2));
    }
    @Test()
    public void shouldThrowExceptionWhenTryingToAddTokenInColumnGreaterThan6() {
        assertThrows(IllegalArgumentException.class,()->grid.insertToken("J",8));
    }
    @Test()
    public void shouldThrowExceptionWhenTryingToAddTokenInColumnLessThan0() {
        assertThrows(IllegalArgumentException.class,()->grid.insertToken("J",-1));
    }
    @Test
    public void shouldPutTokenOnThe4thRowAndThe2ndColumnWhenThe5thRowOf2ndColumnIsFull() {
        String[][] expectedMatrix = {
                {".", ".", ".", ".", ".", ".", "."},
                {".", ".", ".", ".", ".", ".", "."},
                {".", ".", ".", ".", ".", ".", "."},
                {".", ".", ".", ".", ".", ".", "."},
                {".", ".", "J", ".", ".", ".", "."},
                {".", ".", "J", ".", ".", ".", "."},
        };

        grid.insertToken("J",2);
        grid.insertToken("J",2);
        assertEquals(expectedMatrix[4][2],grid.getToken(4,2));

    }
    @Test
    public void shouldPutTokenOnTopOfExistingTokensInAColumn() {
        String[][] expectedMatrix = {
                {".", ".", ".", ".", ".", ".", "."},
                {".", ".", ".", ".", ".", ".", "."},
                {".", ".", ".", ".", ".", ".", "."},
                {".", ".", ".", "J", ".", ".", "."},
                {".", ".", ".", "J", ".", ".", "."},
                {".", ".", ".", "J", ".", ".", "."},
        };
        grid.insertToken("J",3);
        grid.insertToken("J",3);
        grid.insertToken("J",3);
        assertEquals(expectedMatrix[4][3],grid.getToken(3,3));

    }
    @Test
    public void shouldThrowExceptionWhenColumnIsFull()  {
        String[][] expectedMatrix = {
                {".", ".", ".", "J", ".", ".", "."},
                {".", ".", ".", "J", ".", ".", "."},
                {".", ".", ".", "J", ".", ".", "."},
                {".", ".", ".", "J", ".", ".", "."},
                {".", ".", ".", "J", ".", ".", "."},
                {".", ".", ".", "J", ".", ".", "."},
        };
        grid.insertToken("J",3);
        grid.insertToken("J",3);
        grid.insertToken("J",3);
        grid.insertToken("J",3);
        grid.insertToken("J",3);
        grid.insertToken("J",3);

        assertThrows(RuntimeException.class,()->{
            grid.insertToken("J",3);
        });
    }

    @Test
    public void gridShouldBeEmptyWhenCallReset(){

        grid.insertToken("R",1);
        grid.insertToken("R",1);
        grid.insertToken("R",1);
        grid.insertToken("R",1);
        grid.reset();
        for (int i = 0; i<6 ;i++) {
            for (int j = 0; j < 7; j++) {
                String result = grid.getToken(i , j);
                assertEquals(".",result);
            }
        }
    }
    @Test
    public void showShouldReturnVisualRepresentationOfTheGridWhenItsEmpty(){
        String result = ". . . . . . . \n" +
                ". . . . . . . \n" +
                ". . . . . . . \n" +
                ". . . . . . . \n" +
                ". . . . . . . \n" +
                ". . . . . . . \n";
        assertEquals(result,grid.show());
    }

    @Test
    public void showShouldReturnVisualRepresentationOfTheGridWhenItsInsterted(){
        String result = ". . . . . . . \n" +
                ". . . . . . . \n" +
                ". . . . . . . \n" +
                ". . . . . . . \n" +
                ". . . . . . . \n" +
                ". . . B . . . \n";
        grid.insertToken("B",3);
        assertEquals(result,grid.show());
    }

}
