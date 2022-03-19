import java.util.List;

public class Grid {
    private  String[][] matrix;
    private static final int ROWS = 6;
    private static final int COLUMNS = 7;

    public Grid(){
        matrix = new String[6][7];
        for (int i=0;i<6;i++)
            for (int j=0;j<7;j++)
                matrix[i][j] = ".";
    }
    public int getRowsSize(){
        return ROWS;
    }

    public int getColumnsSize() {
        return COLUMNS;
    }
    public String getToken(int row, int column) {
        return matrix[row][column];
    }

    public void insertToken(String token, int column)  {
        if(column>6) throw new IllegalArgumentException("column should not be greater than 6");
        if(column<0) throw new IllegalArgumentException("column should not be less than 0");
        for(int i=5;i>=0;i--) {
            if (matrix[i][column].equals(".")) {
                matrix[i][column] = token;
                return;
            }
        }
        throw new RuntimeException("all rows are full");

    }
    public void reset(){
        for (int i=0;i<6;i++)
            for (int j=0;j<7;j++)
                matrix[i][j] = ".";
    }

    public String show() {
        String result="";
        for (int i=0;i<6;i++){
            for (int j=0;j<7;j++){
                result+=matrix[i][j]+" ";
            }
            result+="\n";
        }
            return result;
    }

    public boolean isEmpty(){
        for(int i=0; i<6; i++){
            for(int j=0; j<7; j++){
                if(!matrix[i][j].equals(".")) return false;
            }
        }
        return true;
    }
    public List<String[]> getRows(){
        return null;
    }
    public List<String[]> getColumn(){
        return null;
    }
    public List<String[]> getDiagonal(){
        return null;
    }
}
