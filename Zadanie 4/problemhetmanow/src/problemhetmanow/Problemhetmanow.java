/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemhetmanow;

/**
 *
 * @author Miłosz
 */
public class Problemhetmanow {
 
private static boolean dia_r[] = new boolean[256];
private static boolean dia_l[] = new boolean[256];
private static boolean column[] = new boolean[8];       // tablica zajętych kolumn
private static boolean chart[][] = new boolean[8][8];// tablica ustawień hetmanów
private static byte found = 0;                       // licznik znalezionych pozycji
 
@SuppressWarnings("unchecked")
private static void add_hetman(int row) {
for (int i=0; i<8; i++) {
if (!((column[i]) || (dia_r[i-row+128]) || (dia_l[row+i+128]))) {
dia_r[i-row+128] = true;     // dodawanie przekątnych
dia_l[row+i+128] = true;
column[i] = true;               // dodawanie kolumny
chart[i][row] = true;        // ustawienie hetmana w tablicy
if (row<7) {
add_hetman(row+1);       // analizuj nastepny wiersz
}
else {                       //ostatni hetman, nalezy zapisac wynik
found++;
printCombination();
}
//usuwanie hetmana i szukanie nowego ustawienia dla niego
dia_r[i-row+128] = false;
dia_l[row+i+128] = false;
column[i] = false;
chart[i][row] = false;
}      
}
}
 
public static void printCombination() {
System.out.println("kombinacja: " + found);
System.out.println("  ABCDEFGH");
System.out.println("");
for (int y=7; y>=0; y--) {
System.out.print(y+1 + " ");
for (int x=0; x<8; x++) {
if (chart[x][y]) {
System.out.print("H");
}
else {
System.out.print(" ");
}
}
System.out.println();
}
System.out.println("");
System.out.println("");
}
 
/**
* 
*/
public static void main(String[] args) {
add_hetman(0);             // ustawianie pierwszego hetmana
}
 
}

