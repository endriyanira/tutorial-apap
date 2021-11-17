package apap.tutorial.emsidi.service;

import apap.tutorial.emsidi.model.PegawaiModel;
//import apap.tutorial.emsidi.rest.PegawaiDetail;
import apap.tutorial.emsidi.rest.PegawaiDetail;
import reactor.core.publisher.Mono;

import java.util.List;

public interface PegawaiRestService {
    String createPegawai(PegawaiModel pegawai);
    List<PegawaiModel> retrieveListPegawai();
    PegawaiModel getPegawaiByNoPegawai(Long noPegawai);
    String updatePegawai(Long noPegawai, PegawaiModel pegawaiUpdate);
    void deletePegawai(Long noPegawai);
    Mono<PegawaiDetail> getNama(String namaPegawai);
    Mono<PegawaiDetail> postStatus();
}
