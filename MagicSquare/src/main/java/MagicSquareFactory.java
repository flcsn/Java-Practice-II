
public class MagicSquareFactory {

    public MagicSquare createMagicSquare(int size) {

        MagicSquare square = new MagicSquare(size);

        // implement the creation of a magic square with the Siamese method algorithm here
        int midpoint = size/2;
        int row = size-1;
        int column = midpoint;
        square.placeValue(column, row, 1);
        
        for (int i = 2; i <= size*size; i++) {
            if (square.readValue((column + 1) % size, (row + 1) % size) == 0) {
                column = (column + 1) % size;
                row = (row + 1) % size;                
                square.placeValue(column, row, i);

            } else {
                row = (row - 1) % size;
                square.placeValue(column, row, i);
            }            
        }

        
        
        return square;
    }
    
    public int nextRow(int currentRow, int size) {
        int next = currentRow--;
        if (next < 0) {
            next = next + size;
        }
        return next;
    }
    
    public int nextColumn(int currentColumn, int size) {
        int next = currentColumn++;
        if (next >= size) {
            next = next - size;
        }
        return next;
    }
}
