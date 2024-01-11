package sn.dev.parrainageapp.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sn.dev.parrainageapp.entities.Utilisateur;
import sn.dev.parrainageapp.repositories.utilisateur.IUtilisateur;
import sn.dev.parrainageapp.repositories.utilisateur.UtilisateurImpl;
import sn.dev.parrainageapp.tools.Notification;
import sn.dev.parrainageapp.tools.Outils;

public class LoginController {

    @FXML
    private TextField loginTfd;

    @FXML
    private PasswordField passwordTfd;

    private IUtilisateur userDao = new UtilisateurImpl();

    @FXML
    void login(ActionEvent event) {
        String login = loginTfd.getText();
        String password = passwordTfd.getText();
        if(login.trim().equals("") || password.trim().equals("")){
            Notification.NotifError("Erreur","Tous les champs sont obligatoires !");
        }else{
            Utilisateur user = userDao.seConnecter(login, password);
            if(user != null){
                try{
                    Notification.NotifSuccess("Succés","Connexion réussie !");
                    switch (user.getProfil().getName()){
                        case "ROLE_ADMIN":
                            Outils.load(event, "Bienvenue", "/pages/admin.fxml");
                            break;
                        case "ROLE_CANDIDAT":
                            break;
                        case "ROLE_ELECTEUR":
                            break;
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }else
                Notification.NotifError("Erreur","Login et/ou password incorrects !");
        }
    }

}
