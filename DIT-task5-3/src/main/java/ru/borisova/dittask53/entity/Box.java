package ru.borisova.dittask53.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "box")
public class Box {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "barcode")
    private String barcode;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "box")
    @JsonBackReference
    private List<Document> listDocs;

    public void addDocument(Document document) {
        if (document != null) {
            if (listDocs == null) {
                listDocs = new ArrayList<Document>();
            }
            listDocs.add(document);
            document.setBox(this);
        }
    }

    public Box() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public List<Document> getListDocs() {
        return listDocs;
    }

    public void setListDocs(List<Document> l){
        l.forEach(e -> e.setBox(this));
        this.listDocs = l;
    }

    /*public void addDocument(Document d){
        d.setBox(this);
        this.listDocs.add(d);
    }*/

    @Override
    public String toString() {
        return "Box{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", barcode='" + barcode + '\'' +
                '}';
    }
}

