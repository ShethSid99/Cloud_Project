package lambda;

import saaf.Inspector;
import saaf.Response;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import java.util.Scanner;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Properties;
import saaf.Inspector;
import java.util.HashMap;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;

import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.ClientContext;
import com.amazonaws.services.lambda.runtime.CognitoIdentity;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.nio.charset.Charset;

/**
 * uwt.lambda_test::handleRequest
 *
 * @author Wes Lloyd
 * @author Robert Cordingly
 */
public class QuerySQL implements RequestHandler<Request, HashMap<String, Object>> {

    /**
     * Lambda Function Handler
     *
     * @param request Request POJO with defined variables from Request.java
     * @param context
     * @return HashMap that Lambda will automatically convert into JSON.
     */
    public HashMap<String, Object> handleRequest(Request request, Context context) {

        //Collect inital data.
        Inspector inspector = new Inspector();
        inspector.inspectAll();
        int j = 1;
        //****************START FUNCTION IMPLEMENTATION*************************
        LambdaLogger logger = context.getLogger();
        Response response = new Response();

        try {

            String url = "jdbc:mysql://team9-rds.cluster-c1egvakjnwad.us-east-2.rds.amazonaws.com:3306/TEST";
            String username = "team9";
            String password = "team9Password";
            String driver = "com.mysql.cj.jdbc.Driver";

            logger.log("Username: " + username);
            logger.log("url: " + url);
            logger.log("password: " + password);
            logger.log("driver: " + driver);
            
            String myTable = request.getMySQLTable();

            logger.log("Connecting to DB");

            try ( Connection con = DriverManager.getConnection(url, username, password)) {
                logger.log("Connection successful");

                //response.setValue("Hello, THIS WAS SUCCESSFUL!!");
                // Query mytable to obtain full resultset
                
  
                //String query = String.format("select * from %s",myTable);
                long startTime = System.nanoTime();              
                PreparedStatement ps = con.prepareStatement("select * from mytable;");
                //PreparedStatement ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                long stopTime = System.nanoTime();
                long elapsedTime = stopTime - startTime;

                
                logger.log("Query Select * run-time " + elapsedTime);
                
                //j++;
                rs.close();
                con.close();

                response.setValue("QUERY SQL (select *) Successful");
                response.setValue("list");

            }

        } catch (Exception e) {
            logger.log("Got an exception working with MySQL! ");
            logger.log(e.getMessage());
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            logger.log(sw.toString());
            response.setValue("QUERYSQL FAILED!!");
        }

        //scanning data line by line
        //Create and populate a separate response object for function output. (OPTIONAL)
        inspector.consumeResponse(response);

        //****************END FUNCTION IMPLEMENTATION***************************
        //Collect final information such as total runtime and cpu deltas.
        inspector.inspectAllDeltas();
        return inspector.finish();
    }
}
