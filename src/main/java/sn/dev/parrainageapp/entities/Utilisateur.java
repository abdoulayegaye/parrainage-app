package sn.dev.parrainageapp.entities;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Utilisateur {
    private int id;
    private String nom, prenom, login, password;
    private int actived;
    private Role profil;
}
