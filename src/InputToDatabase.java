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


@WebServlet("/InputToDatabase")
public class InputToDatabase extends HttpServlet {
    public  String Details ="";

    @Override

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println( "before************");
        String str = "";
        String inputString = request.getParameter("GameStats"); //put the sent json in a string
        System.out.println( "Match Details************");
        try {

            JSONObject inputValues = new JSONObject(inputString);//create json to extract values

            String[] MatchDetails = new String[2];

            MatchDetails[0] = inputValues.getString("name");


            // Details = MatchDetails[0];





            System.out.println( "Match Details************"+MatchDetails[0]);



        } catch (Exception e) {
            System.out.println("Servlet died");
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

