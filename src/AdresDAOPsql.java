import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdresDAOPsql implements AdresDAO{
    Connection conn;

    public AdresDAOPsql(Connection conn) throws SQLException{
        this.conn = conn;
    }

    @Override
    public boolean save(Adres adres) throws SQLException{
        boolean uitvoer = false;

        try {
            PreparedStatement save = conn.prepareStatement("INSERT INTO adres VALUES(?, ?, ?, ?, ?)");
            save.setInt(1, adres.getId());
            save.setString(2, adres.getPostcode());
            save.setString(3, adres.getHuisnummer());
            save.setString(4, adres.getStraat());
            save.setString(5, adres.getWoonplaats());
            save.executeUpdate();
            uitvoer = true;
        } catch (SQLException sq){
            System.err.println("verkeerde sql " + sq.getMessage());
        }
        return uitvoer;
    }

    @Override
    public boolean update(Adres adres) throws SQLException{
        boolean uitvoer = false;

        try {
            PreparedStatement update = conn.prepareStatement("UPDATE adres SET postcode=?, huisnummer=?, straat=?, woonplaats=? WHERE adres_id=?");
            update.setString(1, adres.getPostcode());
            update.setString(2, adres.getHuisnummer());
            update.setObject(3, adres.getStraat());
            update.setString(4, adres.getWoonplaats());
            update.setInt(5, adres.getId());
            update.executeUpdate();
            uitvoer = true;
        }catch (SQLException sq){
            System.err.println("verkeerde sql " + sq.getMessage());
        }
        return uitvoer;
    }

    @Override
    public boolean delete(Adres adres) throws SQLException{
        boolean uitvoer = false;
        try {
            PreparedStatement delete = conn.prepareStatement("DELETE FROM adres WHERE adres_id=?");
            delete.setObject(1, adres.getId());
            delete.executeUpdate();
            uitvoer = true;
        } catch (SQLException sq){
            System.err.println("verkeerde sql " + sq.getMessage());
        }
        return uitvoer;
    }

    @Override
    public Adres findByReiziger(Reiziger reiziger) throws SQLException {
        Reiziger reis = null
    }


}
