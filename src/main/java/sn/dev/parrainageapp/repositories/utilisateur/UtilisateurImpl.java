package sn.dev.parrainageapp.repositories.utilisateur;

import sn.dev.parrainageapp.DBConnection;
import sn.dev.parrainageapp.entities.Role;
import sn.dev.parrainageapp.entities.Utilisateur;
import sn.dev.parrainageapp.repositories.role.IRole;
import sn.dev.parrainageapp.repositories.role.RoleImpl;

import java.sql.ResultSet;

public class UtilisateurImpl implements IUtilisateur{
    private DBConnection db = new DBConnection();
    private ResultSet rs;
    @Override
    public Utilisateur seConnecter(String login, String password) {
        String sql = "SELECT * FROM user WHERE login = ? AND password = ?";
        Utilisateur user = null;
        try{
            //Préparation ou initialisation de la requete
            db.initPrepar(sql);
            //Passage de valeurs
            db.getPstm().setString(1, login);
            db.getPstm().setString(2, password);
            //Execution de la requete
            rs = db.executeSelect();
            if(rs.next()){
                user = new Utilisateur();
                user.setId(rs.getInt("id"));
                user.setNom(rs.getString("nom"));
                user.setPrenom(rs.getString(3));
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString(5));
                user.setActived(rs.getInt("actived"));
                IRole iRole = new RoleImpl();
                Role profil = iRole.getRoleById(rs.getInt("profil"));
                user.setProfil(profil);
            }
            db.closeConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }
}
