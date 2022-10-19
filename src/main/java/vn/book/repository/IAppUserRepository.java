package vn.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.book.model.AppUser;

import javax.transaction.Transactional;

@Transactional
public interface IAppUserRepository extends JpaRepository<AppUser, Integer> {

    @Query(value = "select * from app_user a where a.username = :name and is_deleted = 0", nativeQuery = true)
    AppUser findAppUserByName(@Param("name") String name);

    @Query(value = "SELECT username from app_user where username = ?1 and is_deleted = 0", nativeQuery = true)
    String existsByUserName(String username);

    @Modifying
    @Query(value = "update app_user set password =?1 where username = ?2", nativeQuery = true)
    void saveNewPassword(String password, String name);
}
