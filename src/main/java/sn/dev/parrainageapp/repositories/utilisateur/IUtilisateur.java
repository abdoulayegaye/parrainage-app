package sn.dev.parrainageapp.repositories.utilisateur;

import sn.dev.parrainageapp.entities.Utilisateur;

public interface IUtilisateur {
    public Utilisateur seConnecter(String login, String password);
}
