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

public class Main {
    //stworzenie listy ktora jest populacja
   public static ArrayList<int[]> populacja;
   //wykorzystanie obiektu klasy Operacje Genetyczne
   public static OperacjeGenetyczne operacjeGenetyczne;
    public Main() {
    }
    //wyswietla populacje
    public static void wyswietlPopulacje(ArrayList<int[]> populacja){
        System.out.println("\n\nCALOSC POPULACJI PONIZEJ:");
        for (int[] i:populacja) {
            wyswielChromosom(i);
        }
    }

    //wyswietla chromosom
    public static void wyswielChromosom(int[] person){
        System.out.println("Chromosom:");
        for(int i=0;i<10;i++) {
            System.out.print(person[i]+" ");
        }
        System.out.println("WARTOSC FUNKCJI FITNESS"+ operacjeGenetyczne.fitness(person));
    }

    public static void main(String[] args) {
        operacjeGenetyczne =new OperacjeGenetyczne();
        populacja = operacjeGenetyczne.getPopulacja();
        //wyswietlnenie pierwszej populacji
        wyswietlPopulacje(populacja);

        System.out.println("OPERACJA MUTACJI");
        ArrayList<int[]> drugaPopulacja=new ArrayList<>();
        //wykonanie mutacji na 2 i 4 chromosomie (osobniku) przy użyciu metody mutacja klasy OperacjeGenetyczne
        drugaPopulacja.add(populacja.get(0));
        drugaPopulacja.add( operacjeGenetyczne.mutacja(populacja.get(1),2,1));
        drugaPopulacja.add(populacja.get(2));
        drugaPopulacja.add( operacjeGenetyczne.mutacja(populacja.get(3),2,1));
        wyswietlPopulacje(drugaPopulacja);
        //wykonanie operacji krzyżowania z klasy Operacja genetyczna
        System.out.println("OPERACJA KRZYZOWANIA");
        ArrayList<int[]> trzeciaPopulacja=new ArrayList<>();
        ArrayList<int[]> z= operacjeGenetyczne.krzyzowanie(drugaPopulacja.get(0),drugaPopulacja.get(1),2 );
        trzeciaPopulacja.add(z.get(0));
        trzeciaPopulacja.add(z.get(1));
        z= operacjeGenetyczne.krzyzowanie(populacja.get(2),populacja.get(3),5 );
        trzeciaPopulacja.add(z.get(1));
        trzeciaPopulacja.add(z.get(1));
        wyswietlPopulacje(trzeciaPopulacja);
       }

    }