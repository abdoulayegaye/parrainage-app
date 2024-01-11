package sn.dev.parrainageapp.repositories.role;

import sn.dev.parrainageapp.DBConnection;
import sn.dev.parrainageapp.entities.Role;

import java.sql.ResultSet;

public class RoleImpl implements IRole{
    private DBConnection db = new DBConnection();
    private ResultSet rs;
    @Override
    public Role getRoleById(int id) {
        String sql = "SELECT * FROM role WHERE id = ?";
        Role role = null;
        try{
            db.initPrepar(sql);
            db.getPstm().setInt(1, id);
            rs = db.executeSelect();
            if(rs.next()){
                role = new Role(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt("etat")
                );
            }
            db.closeConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
        return role;
    }
}
