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
import java.util.Random;

public class AlgorytmyGeneryczne {
    //mutuje jedną randomową literkę w pętli while losuje tak dopoki nowa wartosc fitnes nie bedzie mniejsza niz stara
    public char[] mutation(char[] chromosom1,char[] szukaneSlowo) {
        char[] template=(char[])chromosom1.clone();
        int fit=fitnes(template,szukaneSlowo);
        Random p=new Random();
        while(fitnes(chromosom1,szukaneSlowo)<=fit)
        {
            chromosom1=(char[])template.clone();
            chromosom1[p.nextInt(chromosom1.length)]=Main.losujLitere();
        }
        return chromosom1;
    }
// zliczanie ilości liter pasujących do słowa poszukiwanego
    public int fitnes(char[] sprawdzaneSlowo,char[] szukaneSlowo){
        int licznik=0;
        for(int i=0;i<sprawdzaneSlowo.length;i++){
            if (sprawdzaneSlowo[i]==szukaneSlowo[i])
                licznik++;
        }
        return licznik;
    }

}
