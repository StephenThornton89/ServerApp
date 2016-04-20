/**
 * Created by Stephen Thornton on 02/04/2016.
 */
import org.json.JSONObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


@WebServlet("/InputToDatabase")
public class InputToDatabase extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String str = "";
        String inputString = request.getParameter("GameStats"); //put the sent json in a string
        System.out.println( "Match Details\n");
        try {

            JSONObject inputValues = new JSONObject(inputString);//create json to extract values

            String[] MatchDetails = new String[2];

            MatchDetails[0] = inputValues.getString("name");

            System.out.println(MatchDetails[0]);
            String driver = "com.mysql.jdbc.Driver";
            Class.forName(driver);
            //loading drivers for mysql


            //creating connection with the database
            Connection con= DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/details", "root", "stevo123");

            PreparedStatement ps=con.prepareStatement
                    ("insert into matchdetails values(?,?)");
            int a=2;
            ps.setInt(1,a);
            a++;
            ps.setString(2,MatchDetails[0]);
            int i=ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Servlet not connected");
            e.printStackTrace();
        }
        PrintWriter out = response.getWriter();
        out.println(str);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}

