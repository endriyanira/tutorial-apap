package apap.tutorial.emsidi.restcontroller;

import apap.tutorial.emsidi.model.CabangModel;
import apap.tutorial.emsidi.model.PegawaiModel;
import apap.tutorial.emsidi.rest.CabangDetail;
import apap.tutorial.emsidi.rest.PegawaiDetail;
import apap.tutorial.emsidi.service.CabangRestService;
import apap.tutorial.emsidi.service.PegawaiRestService;
import org.apache.catalina.connector.Request;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

@RestController
@RequestMapping("/api/v1")
public class PegawaiRestController {
    @Autowired
    private PegawaiRestService pegawaiRestService;

    @PostMapping(value="/pegawai")
    private String createPegawai(@Valid @RequestBody PegawaiModel pegawai, BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field"
            );
        } else {
            return pegawaiRestService.createPegawai(pegawai);
        }
    }

    @GetMapping(value="/pegawai/{noPegawai}")
    private PegawaiModel retrievePegawai(
            @PathVariable("noPegawai") Long noPegawai){
        try{
            return pegawaiRestService.getPegawaiByNoPegawai(noPegawai);
        } catch (NoSuchElementException e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "ID Cabang " + String.valueOf(noPegawai) + " Not Found."
            );
        }
    }

    @DeleteMapping (value="/pegawai/{noPegawai}")
    private ResponseEntity deletePegawai (
            @PathVariable("noPegawai") Long noPegawai){
        try{
            pegawaiRestService.deletePegawai(noPegawai);
            return ResponseEntity.ok("Pegawai has been deleted");
        } catch (NoSuchElementException e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Pegawai with ID " + String.valueOf(noPegawai) + " Not Found!"
            );

        } catch (UnsupportedOperationException e){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Pegawai's cabang is still open!"
            );
        }
    }

    @PutMapping(value="/pegawai/{noPegawai}")
    private String updatePegawai(
            @PathVariable("noPegawai") Long noPegawai,
            @RequestBody PegawaiModel pegawai
    ){
        try{
            return pegawaiRestService.updatePegawai(noPegawai, pegawai);
        } catch (NoSuchElementException e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Pegawai with ID " + String.valueOf(noPegawai) + " Not Found!"
            );
        }
    }

    @GetMapping(value = "/list-pegawai")
    private List<PegawaiModel> retrieveListPegawai(){
        return pegawaiRestService.retrieveListPegawai();

    }

    @GetMapping(value="pegawai/umur/{noPegawai}")
    private Map<String, Object> retrievePredictAge(
            @PathVariable ("noPegawai") Long noPegawai
    ){
        PegawaiModel pegawai = pegawaiRestService.getPegawaiByNoPegawai(noPegawai);
        String namaPegawai = pegawai.getNamaPegawai();
        if(pegawai.getNamaPegawai().split(" ").length > 1){
            namaPegawai = pegawai.getNamaPegawai().split(" ")[0];
        }
        Mono<PegawaiDetail> pegawaiagify = pegawaiRestService.getNama(namaPegawai);
        pegawai.setUmur(pegawaiagify.block().getAge());
        pegawaiRestService.updatePegawai(noPegawai, pegawai);
        Map<String, Object> data = new HashMap<>();
        data.put("noPegawai", pegawai.getNoPegawai());
        data.put("namaPegawai", pegawai.getNamaPegawai());
        data.put("jenisKelamin", pegawai.getJenisKelamin());
        data.put("umur", pegawai.getUmur());
        return data;


    }






}
