package tarefas;
import javax.swing.JOptionPane;
/**
 *
 * @author marcosceron
 */
public class PasseioDoCavalo {
    public static int num;
    public static int max=10;
    public static int[][] tabuleiro = new int[max][max];
    public static int numSqr;
    public static int h[] = {2,1,-1,-2,-2,-1,1,2}; // Movimentos na horizontal
    public static int v[] = {1,2,2,1,-1,-2,-2,-1}; // Movimentos na vertical
    public static boolean done;
    public static int count=0;
    
    public static boolean aceitavel(int x, int y) {
        if (x>=0 && x<=num-1 && y>=0 && y<=num-1 && tabuleiro[x][y]==0) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public static boolean tenta(int i, int x, int y) {
        done = i > numSqr;
        int k=0, nextX, nextY;
        while (!done && k<8) {
            if (k==7) { // Se forem tentados todos os movimentos possíveis, backtracking.
                System.out.println("Backtracking " + count);
                count++;
            }
            nextX = x + h[k]; // Próximo movimento x
            nextY = y + v[k]; // Próximo moviment y
            if (aceitavel(nextX, nextY)) {
                tabuleiro[nextX][nextY] = i;
                done = tenta(i+1, nextX, nextY); // Tenta outro movimento
                if (!done) {
                    tabuleiro[nextX][nextY] = 0; // Sem sucesso, descarta movimento
                }
            }
            k++; // Passa ao próximo movimento possível
            
        }
        return done;
    }
    
    public static void imprime(int x, int y) {
        tabuleiro[x][y] = 1;
        done = tenta(2, x, y);
        String str = "";
        if (done) {
            for (x=0; x<num; x++) {
                for (y=0; y<num; y++) {
                    if (tabuleiro[x][y] < 10) {
                        str += "0" + tabuleiro[x][y] + " ";
                    }
                    else {
                        str += tabuleiro[x][y] + " ";
                    }
                }
                str += "\n";
            }
            System.out.print(str);
        }
        else {
            System.out.println("Não há passeio possível\n");
        }
    }
    
    public static void main(String[] args) {
       // n=6
       num=6; // Número de posições do tabuleiro.
       int startX = Integer.parseInt(JOptionPane.showInputDialog("X inicial: "));
       int startY = Integer.parseInt(JOptionPane.showInputDialog("Y inicial: "));
       numSqr=num*num;
       
       for (int x=0; x<num; x++) {
           for (int y=0; y<num; y++) {
               tabuleiro[x][y]=0;
           }
       }
       imprime(startX,startY);
    }
}
