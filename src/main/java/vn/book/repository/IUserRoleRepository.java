package vn.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.book.model.AppUser;
import vn.book.model.UserRole;

import java.util.List;

public interface IUserRoleRepository extends JpaRepository<UserRole, Integer> {
    List<UserRole> findAllByAppUser(AppUser appUser);
}
