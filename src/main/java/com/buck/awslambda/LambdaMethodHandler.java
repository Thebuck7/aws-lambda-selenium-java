package com.buck.awslambda;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.beust.jcommander.internal.Lists;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import java.util.List;


public class LambdaMethodHandler implements RequestHandler<LambdaRequest, LambdaResponse> {

    @Override
    public LambdaResponse handleRequest(LambdaRequest lambdaRequest, Context context) {
        LambdaResponse response = new LambdaResponse();

        if (lambdaRequest.getOption().equals("selenium")){
//            File carpeta = new File("/var/task");
//            String[] listado = carpeta.list();
//            if (listado == null || listado.length == 0) {
//                System.out.println("No hay elementos dentro de la carpeta actual");
//            }
//            else {
//                for (String s : listado) {
//                    System.out.println(s);
//                }
//            }
            TestListenerAdapter tla = new TestListenerAdapter();
            TestNG testng = new TestNG();
            List<String> suites = Lists.newArrayList();
            suites.add("/var/task/testng/testng.xml");//path to xml..
//            suites.add("c:/tests/testng2.xml");
            testng.setTestSuites(suites);
            testng.run();

            response.setName("Qi");
            response.setLastname("D");

        }
        else if (lambdaRequest.getOption().equals("1")){
            response.setName("Juan");
            response.setLastname("Hub");

        }else {
            response.setName("Buck");
            response.setLastname("Se");
        }

        return response;
    }
}
