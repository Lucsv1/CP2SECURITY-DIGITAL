package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/auth")
public class AuntenticController {
	
	@GetMapping("/login")
    public String login() {
        return "login";
    }
	
	@PostMapping("/login")
    public String loginSucesso() {
        return "redirect:/dashboard";
    }
	
	@GetMapping("/logout")
    public String logout() {
        return "redirect:/auth/login?logout";
    }
	

}
