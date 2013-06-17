/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ReSTAdaptor;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Barzgun
 */
@XmlRootElement
public class Transporttyp{
	
	//public Transportauftragstyp tat;
	public String nr;
        public String kundenname;
        public String kundenadresse;
	//public Date ausgangsdatum;
	public boolean lieferungErfolgt;
	//public Date lieferdatum;
	//public String transportdienstleister;

	public String toString(){
		String ausgabe = "";
		ausgabe += "\n           Lieferungsnummer: " + nr + "\n";
	//	ausgabe += "           Ausgangsdatum: " + ausgangsdatum;
		ausgabe += "Kundenname: "+kundenname;
		ausgabe += " Adresse: " + kundenadresse;
		return ausgabe;
	}
}
    

