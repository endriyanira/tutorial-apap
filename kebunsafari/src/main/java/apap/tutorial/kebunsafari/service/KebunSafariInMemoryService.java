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
        KebunSafariModel ksm_model = getKebunSafariList().get(0);
        List <KebunSafariModel> list_ksm = getKebunSafariList();
        for (KebunSafariModel kbn : list_ksm ){
            if(kbn.getIdKebunSafari().equals(idKebunSafari)){
                ksm_model = kbn;
            }
        }
        return ksm_model;    }
}