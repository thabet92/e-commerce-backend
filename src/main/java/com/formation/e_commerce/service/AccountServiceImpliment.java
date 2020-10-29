package com.formation.e_commerce.service;
import com.formation.e_commerce.dao.IPersonneRepository;
import com.formation.e_commerce.dao.IRoleRepository;
import com.formation.e_commerce.model.Administrateur;
import com.formation.e_commerce.model.Client;
import com.formation.e_commerce.model.Personne;
import com.formation.e_commerce.model.ResponsableVente;
import com.formation.e_commerce.model.Role;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpliment implements AccountService {

    private IPersonneRepository utilisateurVue;
    private IRoleRepository roleVue;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public AccountServiceImpliment(IPersonneRepository utilisateurVue, IRoleRepository roleVue,
            BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.utilisateurVue = utilisateurVue;
        this.roleVue = roleVue;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public Administrateur saveAdmin(Administrateur admin) {
        Personne utilisateur = utilisateurVue.findByUsername(admin.getUserName());

        if (utilisateur != null)
            throw new RuntimeException("User already exists");
        Administrateur admin1 = new Administrateur();
        admin1.setPassword(bCryptPasswordEncoder.encode(admin.getPassword()));
        System.out.println(bCryptPasswordEncoder.encode(admin.getPassword()));
        admin1.setFirstName(admin.getFirstName());
        admin1.setAdresse(admin.getAdresse());
        admin1.setCin(admin.getCin());
        admin1.setLastName(admin.getLastName());
        admin1.setMail(admin.getMail());
        admin1.setPhone(admin.getPhone());
        admin1.setUserName(admin.getUserName());
        Role role = roleVue.findByRoleName("Admin");
        if (role != null) {
            admin1.setRole(role);
            utilisateurVue.save(admin1);
        }
        addRoleToUser(admin.getUserName(), "Admin");

        return admin1;
    }

    /************************************************************************/
    /***************************** ----Client----- ***************************/
    /************************************************************************/

    @Override
    public Client saveClient(Client client) {
        Personne utilisateur = utilisateurVue.findByUsername(client.getUserName());

        if (utilisateur != null)
            throw new RuntimeException("User already exists");
        Client client2 = new Client();
        client2.setPassword(bCryptPasswordEncoder.encode(client.getPassword()));
        System.out.println(bCryptPasswordEncoder.encode(client.getPassword()));
        client2.setFirstName(client.getFirstName());
        client2.setAdresse(client.getAdresse());
        client2.setCin(client.getCin());
        client2.setLastName(client.getLastName());
        client2.setMail(client.getMail());
        client2.setUserName(client.getUserName());
        client2.setPhone(client.getPhone());
        client2.setCommandes(client.getCommandes());
        client2.setReclamations(client.getReclamations());

        Role role = roleVue.findByRoleName("Client");
        if (role != null) {
            client2.setRole(role);
            utilisateurVue.save(client2);
        }
        addRoleToUser(client.getUserName(), "Client");

        return client2;
    }

    @Override
    public Role save(Role role) {
        return roleVue.save(role);
    }

    @Override
    public Personne loadUserByUsername(String username) {
        return utilisateurVue.findByUsername(username);
    }

    @Override
    public void addRoleToUser(String username, String rolename) {

        Personne utilisateur = utilisateurVue.findByUsername(username);
        Role appRole = roleVue.findByRoleName(rolename);

        utilisateur.setRole(appRole);

    }

    @Override
    public ResponsableVente sResponsableVente(ResponsableVente responsableVente) {
        Personne utilisateur = utilisateurVue.findByUsername(responsableVente.getUserName());

        if (utilisateur != null)
            throw new RuntimeException("User already exists");
        ResponsableVente rVente = new ResponsableVente();
        rVente.setPassword(bCryptPasswordEncoder.encode(responsableVente.getPassword()));
        System.out.println(bCryptPasswordEncoder.encode(responsableVente.getPassword()));
        rVente.setFirstName(responsableVente.getFirstName());
        rVente.setAdresse(responsableVente.getAdresse());
        rVente.setCin(responsableVente.getCin());
        rVente.setLastName(responsableVente.getLastName());
        rVente.setPhone(responsableVente.getPhone());
        rVente.setMail(responsableVente.getMail());
        rVente.setReclamations(responsableVente.getReclamations());
        rVente.setUserName(responsableVente.getUserName());

        Role role = roleVue.findByRoleName("responsable");
        if (role != null) {
            rVente.setRole(role);
            utilisateurVue.save(rVente);
        }
        addRoleToUser(responsableVente.getUserName(), "responsable");

        return rVente;
    }
}


