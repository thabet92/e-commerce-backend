package com.formation.e_commerce.service;
import com.formation.e_commerce.model.Administrateur;
import com.formation.e_commerce.model.Client;
import com.formation.e_commerce.model.Personne;
import com.formation.e_commerce.model.ResponsableVente;
import com.formation.e_commerce.model.Role;

import java.util.Date;

public interface AccountService {

    Role save(Role role);
    Administrateur saveAdmin(Administrateur admin);
    Client saveClient( Client client);
    ResponsableVente sResponsableVente(ResponsableVente responsableVente);

    Personne loadUserByUsername(String username);
    void addRoleToUser(String username, String rolename);

}
