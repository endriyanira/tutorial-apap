package apap.tutorial.emsidi.controller;

import apap.tutorial.emsidi.model.CabangModel;
import apap.tutorial.emsidi.model.PegawaiModel;
import apap.tutorial.emsidi.service.CabangService;
import apap.tutorial.emsidi.service.PegawaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class PegawaiController {
    @Qualifier("pegawaiServiceImpl")
    @Autowired
    PegawaiService pegawaiService;

    @Qualifier("cabangServiceImpl")
    @Autowired
    CabangService cabangService;

    @GetMapping("/pegawai/add/{noCabang}")
    public String addPegawaiForm(@PathVariable Long noCabang, Model model){
        PegawaiModel pegawai = new PegawaiModel();
        CabangModel cabang = cabangService.getCabangByNoCabang(noCabang);
        pegawai.setCabang(cabang);
        model.addAttribute("noCabang", noCabang);
        model.addAttribute("pegawai", pegawai);
        return "form-add-pegawai";
    }

    @PostMapping("/pegawai/add")
    public String addPegawaiSubmit(
            @ModelAttribute PegawaiModel pegawai,
            Model model
    ){
        pegawaiService.addPegawai(pegawai);
        model.addAttribute("noCabang", pegawai.getCabang().getNoCabang());
        model.addAttribute("namaPegawai", pegawai.getNamaPegawai());
        return "add-pegawai";
    }


    @GetMapping("/pegawai/update/{noCabang}/{noPegawai}")
    public String updatePegawaiForm(
            @PathVariable Long noCabang,
            @PathVariable long noPegawai,
            Model model
    ){
        PegawaiModel pegawai = pegawaiService.getPegawaiByNoPegawai(noPegawai);
        model.addAttribute("pegawai", pegawai);
        model.addAttribute("noCabang", noCabang);
        return "form-update-pegawai";
    }

    @PostMapping("/pegawai/update")
    public String updatePegawaiSubmit(
            @ModelAttribute PegawaiModel pegawai,
            Model model
    ){
        PegawaiModel pegawai_ = pegawaiService.updatePegawai(pegawai);
        if(pegawai_ == null){
            return "tidak-bisa-update";
        }

        else{
            model.addAttribute("noPegawai", pegawai.getNoPegawai());
            return "update-pegawai";
        }

    }

    @GetMapping("/pegawai/viewall/{noCabang}")
    public String listPegawai(
            @PathVariable(value= "noCabang") Long noCabang,
            Model model){

        List<PegawaiModel> listPegawaibyNoCabang = pegawaiService.getPegawaiListByNoCabang(noCabang);
//        System.out.println(listPegawaibyNoCabang.size());
        model.addAttribute("listPegawaiByNoCabang", listPegawaibyNoCabang);
        model.addAttribute("noCabang", noCabang);
        return "viewall-pegawai";
    }

    @GetMapping("/pegawai/view/noCabang/{noCabang}/noPegawai/{noPegawai}")
    public String viewDetailCabang(
            @PathVariable(value = "noCabang") Long noCabang,
            @PathVariable(value = "noPegawai") long noPegawai,
            Model model
    ){
        CabangModel cabang = cabangService.getCabangByNoCabang(noCabang);
        List<PegawaiModel> listPegawai = cabang.getListPegawai();

        model.addAttribute("noCabang", noCabang);
        model.addAttribute("noPegawai", noPegawai);
        model.addAttribute("listPegawai", listPegawai);

        return "view-pegawai";
    }

    @GetMapping("/pegawai/delete/{noPegawai}")
    public String deletePegawaiByNoPegawai(
            @PathVariable (value = "noPegawai") long noPegawai,
            Model model
    ){

        PegawaiModel pegawai_ = pegawaiService.deletePegawai(noPegawai);
        if(pegawai_ == null){
//            System.out.println("masuk di sini");
            return "tidak-bisa-delete";
        }

        else{
            model.addAttribute("noPegawai", pegawai_.getNoPegawai());
            return "delete-pegawai";
        }
    }



}
