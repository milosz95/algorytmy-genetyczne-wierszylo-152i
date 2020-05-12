/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorytmygeneryczne;

/**
 *
 * @author Miłosz
 */
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class Main {
    private static String slowo;
    public static char[] tabelaZnakow;
    public static char[] rodzic;
    public static char[] dziecko;

    public Main() {
        //definicja zmiennych

    }

    public static void main(String[] args) {
        slowo="Dajcie mi święta!";
        tabelaZnakow=zamianaStringaNaTablice(slowo);
        rodzic=new char[tabelaZnakow.length];
        //od tego momentu liczymy czas
        Instant start=Instant.now();
        int najlepszyFitnes,obecnyFitnes=0;
    AlgorytmyGeneryczne algorytmyGeneryczne=new AlgorytmyGeneryczne();
        //wygenerowanie losowej tablicy znakow ktora jest pierwszym rodzicem
         for (int i=0;i<tabelaZnakow.length;i++) {
        rodzic[i]=losujLitere();
        }
    najlepszyFitnes=algorytmyGeneryczne.fitnes(rodzic,tabelaZnakow);
    //wykonujemy pętlę która będzie trwała dopóki wartość fitnes
        // nie będzie równa ilosci znaków sowa
    while(obecnyFitnes<tabelaZnakow.length){
        //generujemy dziecko poprzez mutacje rodzica,
        // uważając żeby wartość funkcji fitnes nie była mniejsza po mutacji
        //dlatego przekazujemy tabele liter słowa żeby algorytm mutacji sprawdzać fitnes
        dziecko=algorytmyGeneryczne.mutation(rodzic,tabelaZnakow);

        //wyliczenie fitnesu po
        obecnyFitnes=algorytmyGeneryczne.fitnes(dziecko,tabelaZnakow);
        if(najlepszyFitnes<=obecnyFitnes)
        {
            //Jeżeli obecny fitness jest lepszy niż dotychczasowy, to wyświetlamy
            // go wraz z wskaznikiem czasu w milisekundach jako roznica miedzy startem a momentemwyświetlenia
            System.out.println("czas: "+ChronoUnit.MILLIS.between(start, Instant.now()) +"(ms)"+"\nznalezione Słowo: "+zamianaTablicyNaString(dziecko) +"  obecny fitnes:"+obecnyFitnes);

            //gdy obecny fitnes jest równy lub większy rodzicowi to wychodzimy
            if (obecnyFitnes>=rodzic.length)
                break;

            najlepszyFitnes=obecnyFitnes;
            //podmieniamy tablice do kolejnej mutacji w pętli
            rodzic=dziecko;}
           }


    }
//losuje randomową literkę z listy dostepnych znakow
    public static char losujLitere(){
        Random random=new Random();
        String listaZnakow = " aąbcćdeęfghijklłmnoópqrsśtuvwxyzźżABCĆDEFGHIJKLMNOÓPQRSŚTUVWXYZŹŻ!.";
        char litera = listaZnakow.charAt(random.nextInt(listaZnakow.length()));
        return litera;
    }

    public static char[] zamianaStringaNaTablice(String slowo){
        char[] tablica= new char[slowo.length()];
        for (int i = 0; i < slowo.length(); i++) {
            tablica[i] = slowo.charAt(i);
        }
        return tablica;
    }
    public static String zamianaTablicyNaString(char []tab){
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=0;i<tab.length;i++)
        {
            stringBuilder.append(tab[i]);
        }
        return stringBuilder.toString();
    }
}
