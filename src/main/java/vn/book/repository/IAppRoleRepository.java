package vn.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.book.model.AppRole;

public interface IAppRoleRepository extends JpaRepository<AppRole, Integer> {
}
