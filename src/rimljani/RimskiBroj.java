/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rimljani;

/**
 *
 * @author JavaObuka
 */
public class RimskiBroj {
    private int vrednost;
    

    public RimskiBroj(int arapskibr) {
        this.vrednost = arapskibr;
        
    }

    public static int rimski2arapski(String broj) {
        int vred = 0;
        char [] niz = broj.toCharArray();
        for (int i = 0; i < niz.length; i++) {
     
            
        
            switch(niz[i]){
                case 'M': vred+=1000; break;
                case 'D': vred+=500; break;
                case 'C': vred+=100; break;
                case 'L': vred+=50; break;
                case 'X': vred+=10; break;
                case 'V': vred+=5; break;
                case 'I': 
                    if(((i+1)< niz.length) && (niz[i+1]== 'V' || niz[i+1]== 'X'))
                        vred -=1;
                        else vred += 1;
                    break;
                    
              
            }
        }
        
        
        return vred;
    }
    public String rimskiKonvertor(){
        StringBuilder r = new StringBuilder();
        int ostatak = vrednost;
        while (ostatak > 1000) {
            ostatak -= 1000;
            r.append('M');

        }
        while (ostatak >= 500) {
            ostatak -= 500;
            r.append('D');

        }
        while (ostatak >= 100) {
            ostatak -= 100;
            r.append('C');

        }
        while (ostatak >= 50) {
            ostatak -= 50;
            r.append('L');

        }
        while (ostatak >= 10) {
            ostatak -= 10;
            r.append('X');

        }
        while (ostatak >= 5) {
            ostatak -= 5;
            r.append('V');

        }
        while (ostatak > 0) {
            ostatak -= 1;
            r.append('I');

        }
       return r.toString().replaceAll("VIIII", "IX");
        
       
    }
    public int arapskiKonvertor(){
        
        return vrednost;
    }

    public static void main(String[] args) {
        RimskiBroj rb = new RimskiBroj (2400);
        System.out.println(rb.rimskiKonvertor());
        System.out.println(rimski2arapski("MMVIIII"));
        
     }
    
}
