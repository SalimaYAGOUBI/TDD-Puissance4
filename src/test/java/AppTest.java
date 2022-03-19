import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.verification.VerificationMode;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class AppTest {

    @Mock
    Grid grid = new Grid();

    @Mock
    Analyzer analyzer = new Analyzer();

    @Mock
    View view = new View();

    App app;

    String EMPTY_GRID = ". . . . . . .\n"+
            ". . . . . . .\n"+
            ". . . . . . .\n"+
            ". . . . . . .\n"+
            ". . . . . . .\n"+
            ". . . . . . .\n";

    String GRID_AFTER_CHOSE = ". . . . . . .\n"+
            ". . . . . . .\n"+
            ". . . . . . .\n"+
            ". . . . . . .\n"+
            ". . . . . . .\n"+
            ". . . . . . .\n";

    String FIRST_MSG = "Player 1, please choose a column from 1 to 7";
    String WINNER_MSG = "Player R Win";

   @Before
    public void setUp(){
        app = new App(view, grid, analyzer);
    }

    @Test
    public void shouldDisplayTheFirstMsg(){
        Mockito.when(analyzer.verifyGrid(grid)).thenReturn(Optional.of("R"));

        app.start();

        Mockito.verify(view,Mockito.times(1)).display(FIRST_MSG);
    }
    @Test
    public void shouldDisplayTheGrid(){
        Mockito.when(grid.show()).thenReturn(EMPTY_GRID);
        Mockito.when(analyzer.verifyGrid(grid)).thenReturn(Optional.of("R"));

        app.start();

        Mockito.verify(view,Mockito.times(1)).display(FIRST_MSG);
        Mockito.verify(view,Mockito.times(1)).display(EMPTY_GRID);
    }

    @Test
    public void shouldReadTheColumnChosed(){
        Mockito.when(grid.show()).thenReturn(EMPTY_GRID);
        Mockito.when(view.read()).thenReturn(2);
        Mockito.when(analyzer.verifyGrid(grid)).thenReturn(Optional.of("R"));

        app.start();

        Mockito.verify(view,Mockito.times(1)).display(FIRST_MSG);
        Mockito.verify(view,Mockito.times(1)).display(EMPTY_GRID);
        Mockito.verify(view,Mockito.times(1)).read();
    }

    @Test
    public void shouldInsertTokenInTheColumnChosed(){
        Mockito.when(grid.show()).thenReturn(EMPTY_GRID);
        Mockito.when(view.read()).thenReturn(2);
        Mockito.when(analyzer.verifyGrid(grid)).thenReturn(Optional.of("R"));

        app.start();

        Mockito.verify(view,Mockito.times(1)).display(FIRST_MSG);
        Mockito.verify(view,Mockito.times(1)).display(EMPTY_GRID);
        Mockito.verify(view,Mockito.times(1)).read();
        Mockito.verify(grid,Mockito.times(1)).insertToken("R",2);

    }
    @Test
    public void shouldVerifyTheGridAfterThePlayerChoose(){
        Mockito.when(grid.show()).thenReturn(EMPTY_GRID);
        Mockito.when(view.read()).thenReturn(2);
        Mockito.when(analyzer.verifyGrid(grid)).thenReturn(Optional.of("R"));

        app.start();

        Mockito.verify(view,Mockito.times(1)).display(FIRST_MSG);
        Mockito.verify(view,Mockito.times(1)).display(EMPTY_GRID);
        Mockito.verify(view,Mockito.times(1)).read();
        Mockito.verify(grid,Mockito.times(1)).insertToken("R",2);
        Mockito.verify(analyzer,Mockito.times(1)).verifyGrid(grid);

    }

    @Test
    public void shouldDisplayTheWinner(){
        Mockito.when(grid.show()).thenReturn(EMPTY_GRID);
        Mockito.when(view.read()).thenReturn(2);
        Mockito.when(analyzer.verifyGrid(grid)).thenReturn(Optional.of("R"));

        app.start();

        Mockito.verify(view,Mockito.times(1)).display(FIRST_MSG);
        Mockito.verify(view,Mockito.times(1)).display(EMPTY_GRID);
        Mockito.verify(view,Mockito.times(1)).read();
        Mockito.verify(grid,Mockito.times(1)).insertToken("R",2);
        Mockito.verify(analyzer,Mockito.times(1)).verifyGrid(grid);
        Mockito.verify(view,Mockito.times(1)).display(WINNER_MSG);

    }

}
