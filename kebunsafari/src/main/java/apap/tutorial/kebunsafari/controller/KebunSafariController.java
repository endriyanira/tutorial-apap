package apap.tutorial.kebunsafari.controller;
import apap.tutorial.kebunsafari.model.KebunSafariModel;
import apap.tutorial.kebunsafari.service.KebunSafariService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller

public class KebunSafariController{
    @Autowired
    private KebunSafariService kebunSafariService;

    @RequestMapping("/kebun-safari/add")
    public String addKebunSafari(
            @RequestParam (value="id", required = true) String idKebunSafari,
            @RequestParam (value="nama", required = true) String namaKebunSafari,
            @RequestParam (value="alamat", required = true) String alamat,
            @RequestParam (value="noTelepon", required = true) String noTelepon,
            Model model

    ){

        // Membuat Objek Kebun Safari baru
        KebunSafariModel kebunSafari= new KebunSafariModel(idKebunSafari, namaKebunSafari, alamat, noTelepon);

        // Memanggil service addKebunSafari
        kebunSafariService.addKebunSafari(kebunSafari);

        // Menambahkan variabel kebunSafari untuk dirender di Thymeleaf
        model.addAttribute("kebunSafari", kebunSafari);

        // Mereturn template html yang dipakai
        return "add-kebun-safari";
    }

    @RequestMapping("/")
    public String listKebunSafari(Model model){
        //Mendapatkan list seluruh objek Kebun Safari
        List<KebunSafariModel> listKebunSafari = kebunSafariService.getKebunSafariList();

        // Menambahkan List untuk dirender di Thymeleaf
        model.addAttribute("listKebunSafari", listKebunSafari);

        // Mereturn template html yang dipakai
        return "get-all-kebun-safari";
    }

    @RequestMapping("/kebun-safari")
    public String getKebunSafariById(@RequestParam(value="id", required = true) String idKebunSafari, Model model){
        //Mendapatkan Objek Kebun Safari sesuai dengan ID
        KebunSafariModel kebunSafari = kebunSafariService.getKebunSafariByIdKebunSafari(idKebunSafari);

        //Menambahkan objek untuk dirender di Thymeleaf
        model.addAttribute("kebunSafari", kebunSafari);

        //Mereturn template html yang dipakai
        return "detail-kebun-safari";
    }

    @GetMapping("/kebun-safari/view/{id}")
    public String viewKebunSafari(
            @PathVariable(value="id", required = true) String idKebunSafari, Model model) {

        //Mendapatkan Objek Kebun Safari sesuai dengan ID
        KebunSafariModel kebunSafari = kebunSafariService.getKebunSafariByIdKebunSafari(idKebunSafari);

        //Menambahkan objek untuk dirender di Thymeleaf
        model.addAttribute("kebunSafari", kebunSafari);

        //Mereturn data
        return "detail-kebun-safari";

    }

    @RequestMapping("/kebun-safari/update/{id}")
    public String updateKebunSafari(
        @PathVariable(value = "id") String idKebunSafari,
        @RequestParam(value= "noTelepon") String noTelepon,
        Model model){

        // Memanggil KebunSafariService
        kebunSafariService.updateKebunSafari(idKebunSafari, noTelepon);

        // Menambahkan variable KebunSafari ke "KebunSafari" untuk dirender ke Thymeleaf
        model.addAttribute("id", idKebunSafari);
        model.addAttribute("noTelepon", noTelepon);

        //Mereturn data
        return "view-kebun-safari-update";
    }

    @RequestMapping("/kebun-safari/delete/{id}")
    public String deleteKebunSafari(
            @PathVariable(value="id") String idKebunSafari,
            Model model){

        //Memanggil KebunSafariService
        kebunSafariService.deleteKebunSafari(idKebunSafari);

        //Menambahkan variable KebunSafari ke "Kebun Safari" untuk dirender pada Thymeleaf
        model.addAttribute("id", idKebunSafari);

        // Mereturn data
        return "view-kebun-safari-delete";
    }

//    @RequestMapping("/kebun-safari/delete/all")
//    public String deleteAll(Model model){
//        List<KebunSafariModel> listKebunSafari = KebunSafariService.deleteAllKebun();
//        model.addAttribute("listKebunSafari", listKebunSafari);
//        return "view-delete-all";
//    }

}
