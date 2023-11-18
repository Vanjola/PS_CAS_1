/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import baza.DBBroker;
import domain.Autor;
import domain.Knjiga;
import domain.Zanr;
import java.util.ArrayList;
import java.util.List;





/**
 *
 * @author vanja
 */
public class Controller {
private DBBroker dbb;  
private List<Knjiga> listaKnjiga;
private List<Autor> listaAutora;

public static Controller instance;

    public static Controller getInstance() {
        if(instance==null){
            instance=new Controller();
        }
        return instance;
    }


    private Controller() {
        dbb=new DBBroker();
//   Autor autor1=new Autor("Ivo","Andric",1892,"Biografija ivo bla bla");
//   Autor autor2=new Autor("Danilo","Kis",1935,"Biografija danilo bla bla");
//   Autor autor3=new Autor("Mesa","Selimovic",1910,"Biografija Mesa bla bla");
//
//   Knjiga knjiga1=new Knjiga("Na Drini cuprija",autor1,"123456789",1945,Zanr.DETEKTIVSKI);
//   Knjiga knjiga2=new Knjiga("Basta,pepeo",autor2,"987654321",1982,Zanr.ISTORIJSKI); 
//   Knjiga knjiga3=new Knjiga("Tvrdjava",autor3,"1122334455",1970,Zanr.ROMAN);
//   
//    listaKnjiga=new ArrayList<>();
//    listaAutora=new ArrayList<>();
//            
//    
//   listaKnjiga.add(knjiga1);
//   listaKnjiga.add(knjiga2);
//   listaKnjiga.add(knjiga3);
//   
//   
//   listaAutora.add(autor1);
//   listaAutora.add(autor2);
//   listaAutora.add(autor3);
//   
    }

    public List<Knjiga> getListaKnjiga() {
        return listaKnjiga;
    }

    public void setListaKnjiga(List<Knjiga> listaKnjiga) {
        this.listaKnjiga = listaKnjiga;
    }

    public List<Autor> getListaAutora() {
        return listaAutora;
    }

    public void setListaAutora(List<Autor> listaAutora) {
        this.listaAutora = listaAutora;
    }

    public void obrisiKnjigu(int selektovaniRed) {
        listaKnjiga.remove(selektovaniRed);
    }

    public void dodajKnjigu(Knjiga novaKnjiga) {
    listaKnjiga.add(novaKnjiga);
//        System.out.println("Knjiga je dodata");
//        System.out.println(listaKnjiga);
    }

    public List<Knjiga> ucitajListuKnjigaIzBaze() {
            return dbb.ucitajListuKnjigaIzBaze();
    }


}
