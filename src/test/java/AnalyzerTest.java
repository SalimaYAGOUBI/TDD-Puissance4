import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.*;

@RunWith(MockitoJUnitRunner.class)
public class AnalyzerTest {

    @Mock
    Grid gridMock = new Grid();

    public Analyzer analyzer;


    @Before
    public void setUp() throws Exception{
        analyzer = new Analyzer();

    }

    @Test
    public void shouldReturnOptionalEmptyWhenGridIsEmpty(){
        Grid grid = new Grid();
        Optional<String> result = analyzer.verifyGrid(grid);
        Assert.assertEquals(Optional.empty(),result);
    }
    @Test
    public void shouldReturnRWhenVerify4RTokenOnTheSameRow(){
        String[] l = {".", ".", ".", ".", ".", ".", "."};
        List<String[]> rows =  new ArrayList<String[]>();
        rows.add(l);
        rows.add(l);
        rows.add(l);
        rows.add(l);
        rows.add(l);
        rows.add(new String[] {"R", "R", "R", "R", ".", ".", "."});
        Mockito.when(gridMock.getRows()).thenReturn(rows);
        Optional res = analyzer.verifyGrid(gridMock);
        Assert.assertEquals(Optional.of("R"),res);
    }
   @Test
    public void shouldReturnBWhenVerify4BTokenOnTheSameRow(){
        String[] l = {".", ".", ".", ".", ".", ".", "."};
        List<String[]> rows =  new ArrayList<String[]>();
        rows.add(l);
        rows.add(l);
        rows.add(l);
        rows.add(l);
        rows.add(l);
        rows.add(new String[] {"B", "B", "B", "B", ".", ".", "."});
        Mockito.when(gridMock.getRows()).thenReturn(rows);
        Optional res = analyzer.verifyGrid(gridMock);
        Assert.assertEquals(Optional.of("B"),res);
    }
    @Test
    public void shouldReturnEmptyWhen4TokenOnTheSameRowNotFound(){
        String[] l = {".", ".", ".", ".", ".", ".", "."};
        List<String[]> rows =  new ArrayList<String[]>();
        rows.add(l);
        rows.add(l);
        rows.add(l);
        rows.add(l);
        rows.add(l);
        rows.add(new String[] {"B", "R", "B", "B", ".", ".", "."});
        Mockito.when(gridMock.getRows()).thenReturn(rows);
        Optional res = analyzer.verifyGrid(gridMock);
        Assert.assertEquals(Optional.empty(),res);
    }
    @Test
    public void shouldReturnRWhenVerify4RTokenOnTheSameColumn(){
        String[] l = {".", ".", ".", ".", ".", "."};
        List<String[]> colums =  new ArrayList<String[]>();
        colums.add(l);
        colums.add(l);
        colums.add(l);
        colums.add(l);
        colums.add(new String[] {"B", ".", ".", ".", ".", "."});
        colums.add(new String[] {"B", "B", "B", ".", ".", "."});
        colums.add(new String[] {"R", "R", "R", "R", ".", "."});
        Mockito.when(gridMock.getColumn()).thenReturn(colums);
        Optional res = analyzer.verifyGrid(gridMock);
        Assert.assertEquals(Optional.of("R"),res);
    }
    @Test
    public void shouldReturnBWhenVerify4BTokenOnTheSameColumn(){
        String[] l = {".", ".", ".", ".", ".", "."};
        List<String[]> colums =  new ArrayList<String[]>();
        colums.add(l);
        colums.add(l);
        colums.add(l);
        colums.add(l);
        colums.add(new String[] {"B", "R", "R", ".", ".", "."});
        colums.add(new String[] {"B", "B", "B", "B", ".", "."});
        colums.add(new String[] {"R", "B", "R", "R", ".", "."});
        Mockito.when(gridMock.getRows()).thenReturn(colums);
        Optional res = analyzer.verifyGrid(gridMock);
        Assert.assertEquals(Optional.of("B"),res);
    }
    @Test
    public void shouldReturnEmptyWhen4TokenOnTheSameColumnNotFound(){
        String[] l = {".", ".", ".", ".", ".", "."};
        List<String[]> colums =  new ArrayList<String[]>();
        colums.add(l);
        colums.add(l);
        colums.add(l);
        colums.add(l);
        colums.add(new String[] {"B", ".", ".", ".", ".", "."});
        colums.add(new String[] {"B", ".", ".", ".", ".", "."});
        colums.add(new String[] {"R", "B", "R", "R", ".", "."});
        Mockito.when(gridMock.getColumn()).thenReturn(colums);
        Optional res = analyzer.verifyGrid(gridMock);
        Assert.assertEquals(Optional.empty(),res);
    }

    @Test
    public void shouldReturnBWhenVerify4BTokenOnTheSameDiagonalToDown(){
        List<String[]> colums =  new ArrayList<String[]>();
        colums.add(new String[] {"."});
        colums.add(new String[] {".", "."});
        colums.add(new String[] {".", ".", "."});
        colums.add(new String[] {".", ".", ".","."});
        colums.add(new String[] {".", ".", ".",".","."});
        colums.add(new String[] {".", ".", ".", "B",".","."});
        colums.add(new String[] {".", ".", "R", ".",".","."});
        colums.add(new String[] {".","R", "R", ".", "."});
        colums.add(new String[] {"B", "B", "B", "B"});
        colums.add(new String[] {"B", "R", "R"});
        colums.add(new String[] {"R", "B"});
        colums.add(new String[] {"R"});
        Mockito.when(gridMock.getDiagonal()).thenReturn(colums);
        Optional res = analyzer.verifyGrid(gridMock);
        Assert.assertEquals(Optional.of("B"),res);
    }
    @Test
    public void shouldReturnRWhenVerify4RTokenOnTheSameDiagonalToUp(){
        List<String[]> colums =  new ArrayList<String[]>();
        colums.add(new String[] {"."});
        colums.add(new String[] {".", "."});
        colums.add(new String[] {"R", ".", "."});
        colums.add(new String[] {"B", ".", ".","."});
        colums.add(new String[] {"B", ".", ".",".","."});
        colums.add(new String[] {"R", "R", "R", "R",".","."});
        colums.add(new String[] {"B", "B", "B", ".",".","."});
        colums.add(new String[] {"B","R", ".", ".", "."});
        colums.add(new String[] {"R", ".", ".", "."});
        colums.add(new String[] {".", ".", "."});
        colums.add(new String[] {".", "."});
        colums.add(new String[] {"."});
        Mockito.when(gridMock.getDiagonal()).thenReturn(colums);
        Optional res = analyzer.verifyGrid(gridMock);
        Assert.assertEquals(Optional.of("R"),res);
    }

    @Test
    public void shouldReturnEmptyWhen4TokenOnTheSameDiagonalNotFound(){
        List<String[]> colums =  new ArrayList<String[]>();
        colums.add(new String[] {"."});
        colums.add(new String[] {".", "."});
        colums.add(new String[] {"R", ".", "."});
        colums.add(new String[] {"B", ".", ".","."});
        colums.add(new String[] {"B", ".", ".",".","."});
        colums.add(new String[] {"R", "R", "B", "R",".","."});
        colums.add(new String[] {"B", "B", "B", ".",".","."});
        colums.add(new String[] {"B","R", ".", ".", "."});
        colums.add(new String[] {"R", ".", ".", "."});
        colums.add(new String[] {".", ".", "."});
        colums.add(new String[] {".", "."});
        colums.add(new String[] {"."});
        Mockito.when(gridMock.getDiagonal()).thenReturn(colums);
        Optional res = analyzer.verifyGrid(gridMock);
        Assert.assertEquals(Optional.empty(),res);
    }

    @Test
    public void shouldReturnEmptyWhenGridIsFullAndNoWinner(){
        List<String[]> colums =  new ArrayList<String[]>();
        colums.add(new String[] {"B"});
        colums.add(new String[] {"R", "B"});
        colums.add(new String[] {"R", "R", "R"});
        colums.add(new String[] {"B", "B", "B","R"});
        colums.add(new String[] {"B", "B", "R","R","R"});
        colums.add(new String[] {"R", "R", "B", "R","B","B"});
        colums.add(new String[] {"B", "B", "B", "R","R","B"});
        colums.add(new String[] {"B","R", "B", "B", "B"});
        colums.add(new String[] {"R", "R", "R", "B"});
        colums.add(new String[] {"R", "B", "R"});
        colums.add(new String[] {"R", "B"});
        colums.add(new String[] {"R"});
        Mockito.when(gridMock.getDiagonal()).thenReturn(colums);
        Optional res = analyzer.verifyGrid(gridMock);
        Assert.assertEquals(Optional.empty(),res);
    }
}
