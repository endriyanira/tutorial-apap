package apap.tutorial.emsidi.service;

import apap.tutorial.emsidi.model.CabangModel;
import apap.tutorial.emsidi.model.PegawaiModel;

import java.util.List;

public interface PegawaiService {
    void addPegawai(PegawaiModel pegawai);

    PegawaiModel getPegawaiByNoPegawai(long pegawai);

    PegawaiModel updatePegawai(PegawaiModel pegawai);

    List<PegawaiModel> getPegawaiList();

    List<PegawaiModel> getPegawaiListByNoCabang(Long noCabang);

    PegawaiModel deletePegawai(long noPegawai);


}
