package vn.book.service;

import vn.book.model.AppUser;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public interface IAppUserService {

    AppUser findByName(String name);

    String existsByUserName(String username) throws MessagingException, UnsupportedEncodingException;

    void saveNewPassword(String password, String name);

    void saveAppUser(AppUser appUser);

    List<AppUser> findAllUser();
}
