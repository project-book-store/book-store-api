package vn.book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.book.model.AppRole;
import vn.book.repository.IAppRoleRepository;
import vn.book.service.IAppRoleService;

import java.util.List;

@Service
public class AppRoleServiceImpl implements IAppRoleService {

    @Autowired
    private IAppRoleRepository appRoleRepository;

    @Override
    public List<AppRole> findAllAppRole() {
        return appRoleRepository.findAll();
    }
}
