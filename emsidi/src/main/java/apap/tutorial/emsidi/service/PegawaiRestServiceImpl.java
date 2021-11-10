package apap.tutorial.emsidi.service;

import apap.tutorial.emsidi.model.PegawaiModel;
import apap.tutorial.emsidi.repository.PegawaiDb;
import apap.tutorial.emsidi.rest.PegawaiDetail;
import apap.tutorial.emsidi.rest.Setting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;
import java.time.LocalTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional

public class PegawaiRestServiceImpl implements PegawaiRestService{
    private final WebClient webClient;

    @Autowired
    private PegawaiDb pegawaiDb;

    public PegawaiRestServiceImpl(WebClient.Builder webClientBuilder){
        this.webClient = webClientBuilder.baseUrl(Setting.pegawaiUrl).build();
    }

    @Override
    public String createPegawai(PegawaiModel pegawai) {
        pegawaiDb.save(pegawai);
        return "Create pegawai success";
    }

    @Override
    public List<PegawaiModel> retrieveListPegawai() {
        return pegawaiDb.findAll();
    }


    @Override
    public PegawaiModel getPegawaiByNoPegawai(Long noPegawai) {
        Optional<PegawaiModel> pegawai = pegawaiDb.findByNoPegawai(noPegawai);

        if(pegawai.isPresent()){
            return pegawai.get();
        }
        else{
            throw new NoSuchElementException();
        }
    }

    @Override
    public String updatePegawai(Long noPegawai, PegawaiModel pegawaiUpdate) {
        PegawaiModel pegawai = getPegawaiByNoPegawai(noPegawai);
        pegawai.setNamaPegawai(pegawaiUpdate.getNamaPegawai());
        pegawai.setJenisKelamin(pegawaiUpdate.getJenisKelamin());
        pegawai.setCabang(pegawaiUpdate.getCabang());
        pegawaiDb.save(pegawai);
        return "Update pegawai success";
    }

    @Override
    public void deletePegawai(Long noPegawai) {
        LocalTime now = LocalTime.now();
        PegawaiModel pegawai = getPegawaiByNoPegawai(noPegawai);

        if((now.isBefore(pegawai.getCabang().getWaktuBuka()) || now.isAfter(pegawai.getCabang().getWaktuTutup()))){
            pegawaiDb.delete(pegawai);

        } else {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public Mono<PegawaiDetail> getNama(String namaPegawai) {
        return this.webClient.get().uri("https://api.agify.io/?name=" + namaPegawai)
                .retrieve()
                .bodyToMono(PegawaiDetail.class);
    }

    @Override
    public Mono<PegawaiDetail> postStatus() {
        return null;
    }

}
