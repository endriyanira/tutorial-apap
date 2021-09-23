package apap.tutorial.emsidi.service;

import apap.tutorial.emsidi.model.CabangModel;
import apap.tutorial.emsidi.model.PegawaiModel;
import apap.tutorial.emsidi.repository.PegawaiDb;
import net.bytebuddy.asm.Advice;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PegawaiServiceImpl implements PegawaiService {

    @Autowired
    PegawaiDb pegawaiDb;

    @Override
    public void addPegawai(PegawaiModel pegawai){
        pegawaiDb.save(pegawai);
    }

    @Override
    public PegawaiModel getPegawaiByNoPegawai(long noPegawai){
        Optional<PegawaiModel> pegawai = pegawaiDb.findByNoPegawai(noPegawai);

        //cek kalo objnya ada apa ga
        if(pegawai.isPresent()){
            return pegawai.get();
        }
        return null;
    }

    @Override
    public List<PegawaiModel> getPegawaiList(){
        return pegawaiDb.findAll();
    }

    @Override
    public List<PegawaiModel> getPegawaiListByNoCabang(Long noCabang) {
        List<PegawaiModel> listPegawai = getPegawaiList();
        List<PegawaiModel> listPegawaiByNoCabang = pegawaiDb.findAll();
        listPegawaiByNoCabang.clear()   ;

        for(PegawaiModel i : listPegawai){
            if(i.getCabang().getNoCabang().equals(noCabang)){
                listPegawaiByNoCabang.add(i);
            }
        }
        return listPegawaiByNoCabang;
    }

    @Override
    public PegawaiModel updatePegawai(PegawaiModel pegawai){
        PegawaiModel pegawai_ = null;
        //Dapatkan waktubuka dan tutup dari cabang pegawai
        LocalTime waktubuka = pegawai.getCabang().getWaktuBuka();
        LocalTime waktututup = pegawai.getCabang().getWaktuTutup();

        //apabila hanya melibatkan 1 hari yang sama untuk operasionalnya
        if(waktubuka.compareTo(waktututup) < 0) {
            if (LocalTime.now().isAfter(waktubuka) && LocalTime.now().isAfter(waktututup)) {
                pegawaiDb.save(pegawai);
                return pegawai;
            }
            else if (LocalTime.now().isBefore(waktubuka) && LocalTime.now().isBefore(waktututup)) {
                pegawaiDb.save(pegawai);
                return pegawai;
            }
        }

        //apabila operasional nya melibatkan pergantian hari
        else if(waktubuka.compareTo(waktututup) >0) {
            if (LocalTime.now().isBefore(waktubuka) && LocalTime.now().isAfter(waktututup)) {
                pegawaiDb.save(pegawai);
                return pegawai;
            }
        }

        return pegawai_;
    }

    @Override
    public PegawaiModel deletePegawai(long noPegawai){
        PegawaiModel pegawai_ = null;
        PegawaiModel pegawai = getPegawaiByNoPegawai(noPegawai);

        //Dapatkan waktubuka dan tutup dari cabang pegawai
        LocalTime waktubuka = getPegawaiByNoPegawai(noPegawai).getCabang().getWaktuBuka();
        LocalTime waktututup = getPegawaiByNoPegawai(noPegawai).getCabang().getWaktuTutup();

        //apabila hanya melibatkan 1 hari yang sama untuk operasionalnya
        if(waktubuka.compareTo(waktututup) < 0) {
            if (LocalTime.now().isAfter(waktubuka) && LocalTime.now().isAfter(waktututup)) {
                pegawaiDb.delete(getPegawaiByNoPegawai(noPegawai));
                return pegawai;
            }
            else if (LocalTime.now().isBefore(waktubuka) && LocalTime.now().isBefore(waktututup)) {
                pegawaiDb.delete(getPegawaiByNoPegawai(noPegawai));
                return pegawai;
            }
        }

        //apabila operasional nya melibatkan pergantian hari
        else if(waktubuka.compareTo(waktututup) >0) {
            if (LocalTime.now().isBefore(waktubuka) && LocalTime.now().isAfter(waktututup)) {
                pegawaiDb.delete(getPegawaiByNoPegawai(noPegawai));
                return pegawai;
            }
        }

        return pegawai_;
    }
}
