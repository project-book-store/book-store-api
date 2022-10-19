package vn.book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.book.model.UserRole;
import vn.book.repository.IUserRoleRepository;
import vn.book.service.IUserRoleService;

@Service
public class UserRoleServiceImpl implements IUserRoleService {

    @Autowired
    private IUserRoleRepository userRoleRepository;

    @Override
    public void save(UserRole userRole) {
        userRoleRepository.save(userRole);
    }
}
