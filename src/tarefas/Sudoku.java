package tarefas;

public class Sudoku {
    public int[][] matriz = new int[][]{
            {0,0,1,8,0,0,3,0,0},
            {0,4,9,7,1,6,0,8,0},
            {0,2,0,0,9,0,0,0,0},
            {0,0,4,0,0,0,0,2,0},
            {0,5,6,0,0,1,8,0,0},
            {0,1,0,0,0,0,5,0,9},
            {0,0,0,0,0,0,4,3,0},
            {0,0,0,1,6,0,0,0,8},
            {7,0,0,0,0,2,0,0,1},
    };
    
    public void exibe() {
        int x,y;
        for (x=0; x<9; x++) {
            for(y=0; y<9; y++) {
                System.out.print(matriz[x][y] + " | ");
            }
            System.out.println();
        }
    }
    
    public boolean resolver() {
        int x=0, y=0;
        boolean vazio = false;

        for (int x2=0; x2<9 && !vazio; x2++) {
            for (int y2=0; y2<9 && !vazio; y2++) {
                if (matriz[x2][y2] == 0) {
                    vazio = true;
                    x = x2;
                    y = y2;
                }
                //System.out.println("Valor atual vazio: " + vazio);
            }
        }
        /**
        for (int i=0; i<x; i++) {
            for(int j=0; j<y; j++) {
                System.out.print(matriz[i][j] + " | ");
            }
            System.out.println();
        }
        **/
        // System.out.println("Valor vazio após for: " + vazio);
        /**
         * Quando esgota todas as tentativas vazio volta a ser falso
         * (com valores diferentes de zero nas células)
         */
        if (!vazio) {
            //System.out.println("Entrou aqui");
            return true;
        }

        for (int n=1; n<=9; n++) {
            if (validar(x, y, n)) {
                matriz[x][y] = n;
                if (resolver()) {                  
                    return true;
                }
                matriz[x][y] = 0; 
            }
        }
        
        return false; 
    }
    
    
    public boolean validar(int x, int y, int n) {
        for (int y2 = 0; y2 < n; y2++) {
            if (matriz[x][y2] == n) {
                return false;
            }
        }

        for (int x2 = 0; x2 < n; x2++) {
            if (matriz[x2][y] == n) {
                return false;
            }
        }

        int quadroX = x - x % 3;
        int quadroY = y - y % 3;

        for (int x2 = 0; x2 < 3; x2++) {
            for (int y2 = 0; y2 < 3; y2++) {
                if (matriz[quadroX + x2][quadroY + y2] == n) {
                    return false;
                }
            }
        }

        return true;
        
    }
    public static void main(String[] args) {
    
        Sudoku s = new Sudoku();
        if(s.resolver()) {
            s.exibe();
        }
        
    }
}
