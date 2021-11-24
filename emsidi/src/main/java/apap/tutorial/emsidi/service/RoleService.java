package apap.tutorial.emsidi.service;


import apap.tutorial.emsidi.model.RoleModel;

import java.util.List;

public interface RoleService {
    RoleModel addRole(RoleModel role);

    List<RoleModel> findAll();
}
