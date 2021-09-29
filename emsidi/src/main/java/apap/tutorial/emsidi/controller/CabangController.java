package apap.tutorial.emsidi.controller;

import apap.tutorial.emsidi.model.CabangModel;
import apap.tutorial.emsidi.model.PegawaiModel;
import apap.tutorial.emsidi.service.CabangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;


@Controller
public class CabangController {

    @Qualifier("cabangServiceImpl")
    @Autowired
    private CabangService cabangService;

    @GetMapping("/cabang/add")
    public String addCabangForm(Model model){
        model.addAttribute("cabang", new CabangModel());
        return "form-add-cabang";
    }

    @PostMapping("/cabang/add")
    public String addCabangSubmit(
            @ModelAttribute CabangModel cabang,
            Model model
    ){
        cabangService.addCabang(cabang);
        model.addAttribute("noCabang", cabang.getNoCabang());
        return "add-cabang";
    }

    @GetMapping("/cabang/viewall")
    public String listCabang(Model model){
        List<CabangModel> listCabang = cabangService.getCabangList();
        if(listCabang.size() == 0){
            model.addAttribute("message", "Ternyata tidak ada cabang yang terdaftar!");
            return "tidak-bisa";
        }
        model.addAttribute("listCabang", listCabang);
        return "viewall-cabang";
    }

    @GetMapping("/cabang/viewall/sort")
    public String sortListCabang(Model model){
        List<CabangModel> listCabang = cabangService.getCabangListSort();
        model.addAttribute("listCabang", listCabang);
        return "viewall-cabang-sort";
    }

    @GetMapping("/cabang/view")
    public String viewDetailCabang(
            @RequestParam(value = "noCabang") Long noCabang,
            Model model
    ){
        CabangModel cabang = cabangService.getCabangByNoCabang(noCabang);
        if(cabang == null){
            model.addAttribute("message", "No Cabang tidak ditemukan! Gagal melihat data.");
            return "tidak-bisa";
        }
        else{
            List<PegawaiModel> listPegawai = cabang.getListPegawai();
            model.addAttribute("cabang", cabang);
            model.addAttribute("listPegawai", listPegawai);
            return "view-cabang";
        }
    }

    @GetMapping("/cabang/update/{noCabang}")
    public String updateCabangForm(
            @PathVariable Long noCabang,
            Model model
    ){
        CabangModel cabang = cabangService.getCabangByNoCabang(noCabang);
        if(cabang == null){
            model.addAttribute("message", "No Cabang tidak ditemukan! Gagal mengupdate data.");
            return "tidak-bisa";
        }
        model.addAttribute("cabang", cabang);
        return "form-update-cabang";
    }

    @PostMapping("/cabang/update")
    public String updateCabangSubmit(
            @ModelAttribute CabangModel cabang,
            Model model
    ){
        cabangService.updateCabang(cabang);
        model.addAttribute("noCabang", cabang.getNoCabang());
        return "update-cabang";
    }

    @GetMapping("/cabang/delete/{noCabang}")
    public String deletePegawaiByNoPegawai(
            @PathVariable (value = "noCabang") Long noCabang,
            Model model
    ){
        CabangModel cabang = cabangService.getCabangByNoCabang(noCabang);
        boolean success = cabangService.deleteCabang(noCabang);
        if(cabang == null){
            model.addAttribute("message", "No Cabang tidak ditemukan! Gagal mendelete data.");
            return "tidak-bisa";
        }
        if(!success){
            model.addAttribute("message", "Cabang masih buka atau masih memiliki pegawai, gagal menghapus data cabang.");
            return "tidak-bisa";
        }
        else{
            model.addAttribute("noCabang", noCabang);
            return "delete-cabang";
        }
    }
}
