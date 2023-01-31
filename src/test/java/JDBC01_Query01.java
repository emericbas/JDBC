import java.sql.*;

public class JDBC01_Query01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1--Ilgili Driver'i yuklemeliyiz.MySQL kullandigimizi bildiriyoruz
        //Driver'i bulamama ihtimaline karsi bizden forName methodu icin
        // ClassNotFoundException method signature'a exception olarak firlatmamizi istiyor

        Class.forName("com.mysql.cj.jdbc.Driver");//icine yazilani internetten bulduk.Sabit

        //2--Baglantiyi olusturmak icin username ve password girmeliyiz
        //Burada da bu userName ve password'un  yanlis olma ihtimaline karsi SQLException firlattik.
        // Alti kirmizi uzerine tiklayip exception a tikladik

        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root", "1234");

        // 3--SQL query'leri icin bir statement objesi olusturup,
        // Java'da SQL sorgularimiz icin bir alan acacagiz

        Statement st=con.createStatement();

        //4--SQL query'lerimizi yazip ,calistirabiliriz

       ResultSet query=st.executeQuery("SELECT * FROM personel");

       //5-- Sonuclari gormek icin Iteration ile Set icindeki elemanlari
        // bir while dongusu ile yazdiriyoruz

        while (query.next()){
            System.out.println(query.getInt(1)+" "+query.getString(2)+" "+query.getString(3)+
                    " "+query.getInt(4)+" "+query.getString(5));
        }// index 1'den basliyor.Burasi SQL, Java degil

        //6--Olusturulan nesneleri close() ile  kapatalim ki bellekten kaldirilsin
        con.close();
        st.close();
        query.close();
    }



}
