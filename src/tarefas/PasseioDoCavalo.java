/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarefas;
import javax.swing.JOptionPane;
/**
 *
 * @author marcosceron
 */
public class PasseioDoCavalo {
    public int n; // tamanho do lado do tabuleiro
    public int i, j;
    public static final int max=10;
    
    public static void imprimir(int n, int m[][]) {
        int x, y;
        for (x=0; x<n; x++) {
            for(y=0; y<n; y++) {
                System.out.print(" " + m[x][y]);
            }
            System.out.println("");
        }
    }
    
    
    public static boolean passeio(int n, int x, int y, int pos, int m[][], int xMove[], int yMove[]) {
        int k, nextX, nextY;
        if (pos == n*n) {
            return true;
        }
        for (k=0; k<8; k++) {
            nextX = x + xMove[k];
            nextY = y + yMove[k];
            
            if (((nextX >= 0) && (nextX < n)) && ((nextY >= 0) && (nextY < n))) {
                if (m[nextX][nextY]==0) {
                    m[nextX][nextY]=pos+1;
                }
            }
            if (passeio(n, nextX, nextY, pos+1, m, xMove, yMove)) {
                return true;
            }
            else {
               m[nextX][nextY] = 0;
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
       
        int m[][] = new int[max][max];
        int x, y, n, startX, startY;
        
        int[] xMove = {2,1,-1,-2,-2,-1,1,2};
        int[] yMove = {1,2,2,1,-1,-2,-2,-1};
        
        n = Integer.parseInt(JOptionPane.showInputDialog("Tamanho do tabuleiro"));
        startX = Integer.parseInt(JOptionPane.showInputDialog("X Inicial"));
        startY = Integer.parseInt(JOptionPane.showInputDialog("Y Inicial"));
        
        for (x=0; x<n; x++) {
            for(y=0; y<n; y++) {
                m[x][y] = 0;
            }
        }
        m[startX-1][startY-1]=1;
        
        if(passeio(n, startX-1, startY-1, 1, m, xMove, yMove)) {
            imprimir(n, m);
        }
        else {
            System.out.println("Não existe solução!");
        }
        
    }
}
