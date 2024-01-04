package sn.dev.parrainageapp.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Utilisateur {
    private int id;
    private String nom, prenom, login, password;
    private int actived;
    private Role profil;
}
