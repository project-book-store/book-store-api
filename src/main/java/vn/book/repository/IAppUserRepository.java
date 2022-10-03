package vn.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.book.model.AppUser;

import javax.transaction.Transactional;

@Transactional
public interface IAppUserRepository extends JpaRepository<AppUser, Integer> {

    @Query(value = "select * from app_user a where a.name = :name", nativeQuery = true)
    AppUser findAppUserByName(@Param("name") String name);

    @Query(value = "SELECT `name` from app_user where `name` = ?1", nativeQuery = true)
    String existsByUserName(String username);

    @Modifying
    @Query(value = "update app_user set pass_word =?1 where `name` = ?2", nativeQuery = true)
    void saveNewPassword(String password, String name);
}
