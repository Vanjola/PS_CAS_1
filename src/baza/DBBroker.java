/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baza;
import domain.Autor;
import java.sql.*;
import domain.Knjiga;
import domain.Zanr;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vanja
 */
public class DBBroker {

    public List<Knjiga> ucitajListuKnjigaIzBaze() {
        List<Knjiga> lista=new ArrayList<>();
        try { 
           String upit="SELECT * FROM knjiga k JOIN autor a ON k.autorId=a.id";
           Statement st=Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {                
                int id=rs.getInt("k.id");
                String naslov=rs.getString("k.naslov");
                int godIzdanja=rs.getInt("k.godIzdanja");
                String isbn=rs.getString("k.ISBN");
                String zanr=rs.getString("k.Zanr");
                System.out.println(zanr);
                Zanr z=Zanr.valueOf(zanr);
                String ime=rs.getString("a.ime");
                String prezime=rs.getString("a.prezime");
                String biografija=rs.getString("a.biografija");
                int godRodjenja=rs.getInt("a.godinaRodjenja");
                int idAutora=rs.getInt("a.id");
                Autor a=new Autor(ime, prezime, godRodjenja, biografija, idAutora);
                Knjiga k=new Knjiga(naslov, a, isbn, godIzdanja, z, id);
                lista.add(k);
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}