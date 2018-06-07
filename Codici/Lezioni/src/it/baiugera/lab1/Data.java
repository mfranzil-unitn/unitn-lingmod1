/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.baiugera.lab1;

/**
 *
 * @author paolo.baiguera
 */
/*public class Data extends Main{
        
        public int giorno;
        public int mese;
        public int anno;
    
        Data(int giorno, int mese, int anno){
            this.giorno=giorno;
            this.mese= mese;
            this.anno= anno;
        }

    @Override
    public String toString() {
        String s= "";
        s+= this.giorno +"/" + this.mese + "/" + this.anno;
        return s; //To change body of generated methods, choose Tools | Templates.
    }
      

MIA VERSIONE;    
}*/

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Data {
	
	private GregorianCalendar c;
	
	public Data(){
		c = new GregorianCalendar();
	}
	
	public Data(int g, int m, int a){
		c = new GregorianCalendar(a,m-1,g);
	}
	
	
	//this - d
	public int getDifference(Data d){
		int diff=0;
		long cm = c.getTimeInMillis();
		long dm = d.c.getTimeInMillis();
		long diffm = cm - dm;
		diff = (int) (diffm / (24 * 60 * 60 * 1000));
		return diff;
	}
	
	public boolean equals(Object obj){
		if(obj == null) return false;
		
		if(!(obj instanceof Data)) return false;
		
		return c.equals((GregorianCalendar)obj);
		
	}
	
	public String toString(){
		int anno = c.get(Calendar.YEAR);
		int mese = c.get(Calendar.MONTH) + 1;
		int giorno = c.get(Calendar.DATE);
		return giorno+"/"+mese+"/"+anno;
	}

}
