package apap.tutorial.emsidi.service;

import apap.tutorial.emsidi.model.CabangModel;
import apap.tutorial.emsidi.model.PegawaiModel;
import apap.tutorial.emsidi.repository.CabangDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CabangServiceImpl implements CabangService{

    @Autowired
    CabangDb cabangDb;

    @Override
    public void addCabang(CabangModel cabang){
        cabangDb.save(cabang);
    }

    @Override
    public void updateCabang(CabangModel cabang){
        cabangDb.save(cabang);
    }

    @Override
    public List<CabangModel> getCabangList(){
        return cabangDb.findAll();
    }

    @Override
    public List<CabangModel> getCabangListSort(){
        return cabangDb.findAll(Sort.by(Sort.Direction.ASC, "namaCabang"));
    }

    @Override
    public CabangModel getCabangByNoCabang(Long noCabang){
        Optional<CabangModel> cabang = cabangDb.findByNoCabang(noCabang);
        if(cabang.isPresent()){
            return cabang.get();
        }
        return null;
    }

    @Override
    public boolean checkWaktuTutupCabang(Long noCabang){
        CabangModel cabang_ = getCabangByNoCabang(noCabang);
        //Dapatkan waktubuka dan tutup dari cabang pegawai
        LocalTime waktubuka = cabang_.getWaktuBuka();
        LocalTime waktututup = cabang_.getWaktuTutup();

        //apabila hanya melibatkan 1 hari yang sama untuk operasionalnya
        if(waktubuka.compareTo(waktututup) < 0) {
            if (LocalTime.now().isBefore(waktubuka) && LocalTime.now().isBefore(waktututup)){
                return true;
            }
            else if (LocalTime.now().isAfter(waktubuka) && LocalTime.now().isAfter(waktututup)){
                return true;
            }
        }

        //apabila operasional nya melibatkan pergantian hari
        else if(waktubuka.compareTo(waktututup) >0) {
            if (LocalTime.now().isBefore(waktubuka) && LocalTime.now().isAfter(waktututup)){
                return true;
            }
        }
        return false;

    }

    @Override
    public boolean deleteCabang(Long noCabang){
        CabangModel cabang = getCabangByNoCabang(noCabang);
        int isiPegawaiCabang = cabang.getListPegawai().size();

        if((isiPegawaiCabang == 0) && checkWaktuTutupCabang(noCabang)){
            cabangDb.delete(getCabangByNoCabang(noCabang));
            return true;
        }
        else{
            return false;
        }
    }
}
