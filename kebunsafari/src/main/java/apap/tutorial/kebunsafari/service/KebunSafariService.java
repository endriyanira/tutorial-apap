package apap.tutorial.kebunsafari.service;

import apap.tutorial.kebunsafari.model.KebunSafariModel;

import java.util.List;

public interface KebunSafariService{
    // Method untuk menambahkan KebunSafari baru
    void addKebunSafari(KebunSafariModel kebunSafari);

    // Method untuk mendapatkan seluruh daftar kebunSafari
    List<KebunSafariModel> getKebunSafariList();

    //Method untuk menambahkan data sebuah KebunSafari berdasarkan ID yang dimiliki
    KebunSafariModel getKebunSafariByIdKebunSafari(String idKebunSafari);

    //Method untuk mengupdate data sebuah KebunSafari
    void updateKebunSafari(String idKebunSafari, String noTelepon);

    //Method untuk menghapus kebunsafari berdasarkan id
    void deleteKebunSafari(String idKebunSafari);

    // Method untuk menghapus seluruh daftar kebunSafari
    List<KebunSafariModel> deleteAllKebun();
}