package apap.tutorial.emsidi.controller;

import apap.tutorial.emsidi.model.CabangModel;
import apap.tutorial.emsidi.model.PegawaiModel;
import apap.tutorial.emsidi.model.RoleModel;
import apap.tutorial.emsidi.model.UserModel;
import apap.tutorial.emsidi.service.RoleService;
import apap.tutorial.emsidi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping(value="/add")
    private String addUserFormPage(Model model){
        UserModel user = new UserModel();
        List<RoleModel> listRole = roleService.findAll();
        model.addAttribute("user", user);
        model.addAttribute("listRole", listRole);
        return "form-add-user";
    }

    @PostMapping(value="/add")
    private String addUserSubmit(
            @ModelAttribute UserModel user,
            Model model){
        userService.addUser(user);
        model.addAttribute("user", user);
        return "redirect:/";
    }

//    @PreAuthorize("hasRole('Admin')")
    @GetMapping(value="/viewall")
    private String viewallUser(
            Model model
    ){
        System.out.println("masuk sini");
        List<UserModel> listUser = userService.getUserList();
        model.addAttribute("listUser", listUser);
        return "viewall-user";
    }
    @GetMapping("/delete/{username}")
    public String deleteCabangByNoCabang(
            @PathVariable (value = "username") String username,
            Model model
    ){
        UserModel user = userService.getUserByUsername(username);
        userService.deleteUser(user);
        return "delete-user";
    }

    @RequestMapping(value="/updatePassword", method = RequestMethod.GET)
    private String updatePassword(
            Model model
    ){
        model.addAttribute("teks", "");
        return "form-update-password";
    }

    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    private String updatePasswordSubmit(
            @RequestParam String oldPass, String newPass, String confirmPass, String username, Model model
    ){
        UserModel user = userService.getUserByUsername(username);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if(encoder.matches(oldPass, user.getPassword())){
            if(newPass.equals(confirmPass)){
                userService.updatePassword(user, newPass);
                model.addAttribute("teks","Password berhasil diubah");
            }
            else{
                model.addAttribute("teks", "Password baru tidak sesuai");
            }
        }
        else{
            model.addAttribute("teks", "Password lama salah");
        }
        return "form-update-password";
    }


}
