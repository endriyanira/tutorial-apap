package apap.tutorial.emsidi.service;

import apap.tutorial.emsidi.model.CabangModel;
import java.util.List;

public interface CabangService {
    void addCabang(CabangModel cabang);
    void updateCabang(CabangModel cabang);
    List<CabangModel> getCabangList();
    List<CabangModel> getCabangListSort();
    CabangModel getCabangByNoCabang(Long noCabang);
    boolean checkWaktuTutupCabang(Long noCabang);

    boolean deleteCabang(Long noCabang);
}
