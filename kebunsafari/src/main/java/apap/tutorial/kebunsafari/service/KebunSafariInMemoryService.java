package apap.tutorial.kebunsafari.service;

import apap.tutorial.kebunsafari.model.KebunSafariModel;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class KebunSafariInMemoryService implements KebunSafariService{
    private List<KebunSafariModel> listKebunSafari;

    //constructor
    public KebunSafariInMemoryService(){
        listKebunSafari = new ArrayList<>();

    }

    @Override
    public void addKebunSafari(KebunSafariModel kebunSafari){
        listKebunSafari.add(kebunSafari);

    }

    @Override
    public List<KebunSafariModel> getKebunSafariList(){
        return listKebunSafari;
    }

    @Override
    public KebunSafariModel getKebunSafariByIdKebunSafari(String idKebunSafari){
        KebunSafariModel target = new KebunSafariModel();
        for (KebunSafariModel i : listKebunSafari ){
            if(i.getIdKebunSafari().equals(idKebunSafari)){
                target = i;
            }
        }
        return target;
    }

    @Override
    public void updateKebunSafari(String idKebunSafari, String noTelepon){
        KebunSafariModel idcheck = getKebunSafariByIdKebunSafari(idKebunSafari);
        idcheck.setNoTelepon(noTelepon);
    }

    @Override
    public void deleteKebunSafari(String idKebunSafari){
        KebunSafariModel idcheck = getKebunSafariByIdKebunSafari(idKebunSafari);
        int idx = listKebunSafari.indexOf(idcheck);
        listKebunSafari.remove(idx);
    }
//
    @Override
    public List<KebunSafariModel> deleteAllKebun(){
        if(listKebunSafari.size() != 0){
            listKebunSafari.clear();
        }
        return listKebunSafari;
    }

}