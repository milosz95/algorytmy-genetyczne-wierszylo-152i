/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operacjegenetyczne;

/**
 *
 * @author Miłosz
 */


import java.util.ArrayList;
import java.util.Random;

public class OperacjeGenetyczne {

    public ArrayList<int[]> populacja=new ArrayList<int[]>();

    public OperacjeGenetyczne() {
       // stworzenie losowej populacji
        populacja.add(losowanie(new int[100]));
        populacja.add(losowanie(new int[100]));
        populacja.add(losowanie(new int[100]));
        populacja.add(losowanie(new int[100]));
    }

    public OperacjeGenetyczne(ArrayList<int[]> populacja) {
        this.populacja = populacja;
    }

    // mutacja pobiera ilosc mutacji, pozycje oras chromosom który ma byc zmutowany
    public int[] mutacja(int[] chromosom1, int ileMutacji,int pozycja){
        Random p=new Random();
        for(int i=0;i<ileMutacji;i++){
            //losowanie genu w chromosomie
            chromosom1[pozycja]=p.nextInt(100);
        }
        return chromosom1;
    }
    public ArrayList<int[]> getPopulacja() {
        return populacja;
    }

    public void setPopulacja(ArrayList<int[]> populacja) {
        this.populacja = populacja;
    }
    
    public ArrayList<int[]> krzyzowanie(int[] chromosom1,int[] chromosom2,int punkt){
       //wykorzystanie zmiennej pomocniczej do zamiany wartości funkcji
        int pomocnicza= chromosom1[punkt];
       chromosom1[punkt]=chromosom2[punkt];
       chromosom2[punkt]=pomocnicza;
       //zwrocona zostaje lista z dwoma chromosomami pierwszym, i drugim po operacji krzyzowania
       ArrayList<int[]> zwracana=new ArrayList<>();
       zwracana.add(chromosom1);
       zwracana.add(chromosom2);
       return zwracana;
    }

    public int fitness(int[] chromosom){
        int parzyste=0;
        int nieparzyste=0;
        for(int i=0;i<10;i++){
            //sprawdzenie parzystości numeru indeksu w chromosomie
            if(i%2==0)
                parzyste=parzyste+chromosom[i];
            else
            nieparzyste=nieparzyste+chromosom[i];
        }
        //funkcja fitnes jest różnicą sumy indeksów parzystych i nieparzystych
        return parzyste-nieparzyste;
    }

    public int[] losowanie(int[] tab){
        //uzupełnienie tablicy losowymi wartościami
        Random r = new Random();
        for(int i=0;i<10;i++) {
            tab[i] = r.nextInt(100);
        }
        return tab;
    }

    public ArrayList<int[]> getpopulacja() {
        return populacja;
    }

    public void setpopulacja(ArrayList<int[]> populacja) {
        this.populacja = populacja;
    }
}
