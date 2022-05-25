package amw.ecb.ecbconsumer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SQLiteOperations {

    public void addData (Currency currency){

        Statement status = null;
        Connection connect = null;

        try{
            connect = DriverManager.getConnection("jdbc:sqlite:EbcDB.db");
            status = connect.createStatement();

            String addSQL = "INSERT INTO CURRENCIES (Date, FromCurrency, ToCurrency, Rate) VALUES ('"
                    + currency.getDate() + "','"
                    + currency.getFrom()+ "','" + currency.getTo()
                    + "'," + currency.getRate()
                    + ");";
            status.executeUpdate(addSQL);
            status.close();
            connect.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deleteData (){
        Statement status = null;
        Connection connect = null;

        try{
            connect = DriverManager.getConnection("jdbc:sqlite:EbcDB.db");
            status = connect.createStatement();

            String deleteSQL = "DELETE FROM CURRENCIES;";

            status.executeUpdate(deleteSQL);
            status.close();
            connect.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
