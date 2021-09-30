package apap.tutorial.emsidi.controller;

import apap.tutorial.emsidi.model.CabangModel;
import apap.tutorial.emsidi.model.PegawaiModel;
import apap.tutorial.emsidi.service.CabangService;
import apap.tutorial.emsidi.model.MenuModel;
import apap.tutorial.emsidi.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


@Controller
public class CabangController {

    @Qualifier("cabangServiceImpl")
    @Autowired
    private CabangService cabangService;

    @Autowired
    private MenuService menuService;

    @GetMapping("/cabang/add")
    public String addCabangForm(Model model){
        CabangModel cabang = new CabangModel();
        cabang.setListMenu(new ArrayList<>());
        model.addAttribute("cabang", new CabangModel());
        model.addAttribute("menu", new MenuModel());
//        model.addAttribute("listMenu", new ArrayList<>());
        return "form-add-cabang";
    }

    @PostMapping("/cabang/add")
    public String addCabangSubmit(
            @ModelAttribute CabangModel cabang,
            Model model
    ){
        cabangService.addCabang(cabang);
        model.addAttribute("noCabang", cabang.getNoCabang());
//        System.out.println("Masuk di cabang controller");
        return "add-cabang";
    }
    @PostMapping(value = "/cabang/add", params ={"add"})
    public String addMenuRow(
            @ModelAttribute CabangModel cabang,
            BindingResult bindingResult,
            Model model)
    {

        if(cabang.getListMenu() == null){
            cabang.setListMenu(new ArrayList<MenuModel>());
        }
        List<MenuModel> listMenu = menuService.getListMenu();
        cabang.getListMenu().add(new MenuModel());

        model.addAttribute("cabang", cabang);
        model.addAttribute("listMenuSatunya", listMenu);
        return "form-add-cabang";
    }

    @RequestMapping(value="/cabang/add",method = RequestMethod.POST , params = {"hapus"})
    public String deleteRowMenu(
            @ModelAttribute CabangModel cabang,
            final HttpServletRequest request,
            final BindingResult bindingResult,
            Model model
    ){
        final Integer idBaris = Integer.valueOf(request.getParameter("hapus"));
        cabang.getListMenu().remove(idBaris.intValue());

        model.addAttribute("cabang", cabang);
        model.addAttribute("listMenuSatunya", menuService.getListMenu());
        return "form-add-cabang";
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
            model.addAttribute("listMenu", cabang.getListMenu());
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
