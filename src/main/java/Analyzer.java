import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Analyzer {
    public Optional<String> verifyGrid(Grid grid) {
        if(grid.isEmpty()) return Optional.empty();

        String RowWinner = check(grid.getRows());
        if(!RowWinner.equals(""))
            return Optional.of(RowWinner);

       String ColumnWinner = check(grid.getColumn());
        if(!ColumnWinner.equals(""))
            return Optional.of(ColumnWinner);

        String DiagonalWinner = check(grid.getDiagonal());
        if(!DiagonalWinner.equals(""))
            return Optional.of(DiagonalWinner);

        return Optional.empty();
    }

    private String check(List<String[]> lists) {
        int count =0;
        String winner = "";
        for(int i=0; i<lists.size() ; i++){
            String[] list = lists.get(i);
            winner = list[0];
            count = 1;
            for(int j=1; j<list.length; j++) {
                if (!winner.equals(".")) {
                    if (list[j].equals(winner)) {
                        count++;
                        if (count == 4) return winner;
                    } else {
                        winner = list[j];
                        count = 1;
                    }
                }
            }
        }
        return "";
    }


}
