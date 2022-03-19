import java.util.Optional;

public class App {
    private View view;
    private Grid grid;
    private Analyzer analyzer;
    public App( View v, Grid g, Analyzer a){
        view = v;
        grid = g;
        analyzer = a;
    }
    public void start() {
        this.view.display("Player 1, please choose a column from 1 to 7");
        this.view.display(this.grid.show());
        System.out.println(this.grid.show());
        int c = this.view.read();
        this.grid.insertToken("R", c);
        Optional<String> res = this.analyzer.verifyGrid(this.grid);
        this.view.display("Player "+res.get()+" Win");
        }
    }

