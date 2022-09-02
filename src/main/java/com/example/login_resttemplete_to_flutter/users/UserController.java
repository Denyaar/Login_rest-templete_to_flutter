package com.example.login_resttemplete_to_flutter.users;


import com.ctecx.elimucloud.generalsetup.AppSetupService;
import com.ctecx.elimucloud.generalsetup.EmailSetting;
import com.ctecx.elimucloud.util.Utility;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping("/users")
public class UserController {
    private  final UserService userService;

    private final AppSetupService appSetupService;


    public UserController(UserService userService, AppSetupService appSetupService) {
        this.userService = userService;

        this.appSetupService = appSetupService;
    }


    @GetMapping("/settings")
    public String registerUser(Model model){
        User user = new User();
        user.setEnabled(true);
        model.addAttribute("userd", user);
        model.addAttribute("rolesData",userService.roleList());
        model.addAttribute("usersList",userService.userList());


        return "settings/all_users";
    }


    @PostMapping("/save")
    public String saveUser(User user, HttpServletRequest request) throws UnsupportedEncodingException, MessagingException {
        userService.createUser(user);
        sendVerificationEmail(request,user);
        return "redirect:/users/settings";
    }

    private void sendVerificationEmail(HttpServletRequest request, User user) throws MessagingException, UnsupportedEncodingException {

     EmailSetting emailSettings = appSetupService.getEmailSettings();
       JavaMailSenderImpl mailSender= Utility.prepareMailSender(emailSettings);
       String toAddress= user.getEmail();
       String subject=emailSettings.getSubject();
       String content =emailSettings.getContent();

        MimeMessage message= mailSender.createMimeMessage();
        MimeMessageHelper messageHelper= new MimeMessageHelper(message);
        messageHelper.setFrom(emailSettings.getSenderEmail(),emailSettings.getSenderName());
        messageHelper.setTo(toAddress);
        messageHelper.setSubject(subject);
        String verifyUrl=Utility.getSiteUrl(request) +"/verify?code="+user.getEmail();
        content=content.replace("[[URL]]",verifyUrl);
        messageHelper.setText(content,true);

        mailSender.send(message);
    }
}
