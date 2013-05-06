/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Verkauf;

import java.util.List;

/**
 *
 * @author NED
 */
public interface IAuftragManager {
     public List<Auftrag> sucheAuftrage(String kundenName);

    public Auftrag schliesseAuftrag(Auftrag auftrag);
    
    public Auftrag erstelleAuftrag(Angebot angebot);
}
