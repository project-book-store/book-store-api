package vn.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import vn.book.model.AppRole;
import vn.book.model.AppUser;
import vn.book.model.Customer;
import vn.book.model.UserRole;
import vn.book.service.IAppRoleService;
import vn.book.service.IAppUserService;
import vn.book.service.ICustomerService;
import vn.book.service.IUserRoleService;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/public")
public class AppUserController {

    @Autowired
    private IAppUserService appUserService;

    @Autowired
    private IUserRoleService userRoleService;

    @Autowired
    private IAppRoleService appRoleService;

    @Autowired
    private ICustomerService customerService;

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @PostMapping("/app-user/create")
    public ResponseEntity<?> createAppUser(@RequestBody @Valid AppUser appUser) {
        appUser.setPassword(passwordEncoder().encode(appUser.getPassword()));
        appUser.setCreationDate(LocalDate.now());
        appUser.setDeleted(false);
        appUserService.saveAppUser(appUser);
        UserRole userRole = new UserRole();
        List<AppRole> appRoles = appRoleService.findAllAppRole();
        userRole.setAppRole(appRoles.get(1));
        userRole.setAppUser(appUser);
        userRoleService.save(userRole);
        List<AppUser> appUsers = appUserService.findAllUser();
        Customer customer = new Customer();
        customer.setAppUser(appUsers.get(appUsers.toArray().length - 1));
        customerService.save(customer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/app-user/{username}")
    public ResponseEntity<AppUser> getUser(@PathVariable String username) {
        AppUser appUser = appUserService.findByName(username);
        return new ResponseEntity<>(appUser, HttpStatus.OK);
    }
}
