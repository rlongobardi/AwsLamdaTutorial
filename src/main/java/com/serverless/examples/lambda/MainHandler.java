package com.serverless.examples.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import com.serverless.examples.model.Request;
import com.serverless.examples.model.Response;
import org.springframework.util.StringUtils;

import java.util.logging.Logger;


/**
 * Created by rosario.longobardi on 13/07/2017.
 */

public class MainHandler implements RequestHandler<Request, Response> {

    private final static Logger log = Logger.getLogger(MainHandler.class.toString());


    private Response myGreetings(Request req, Context context) {

        String firstName = req.getFirstName();
        String lastName = req.getLastName();

        validateRequest(firstName,lastName);

        String greetings = String.format("Hello %s %s", firstName, lastName);
        Response res = new Response(greetings);
        log.info("The response is: " + res.getGreetings());
        return res;
    }

    private void validateRequest(String firstName, String lastName) throws IllegalArgumentException {

        if (!StringUtils.hasText(firstName)) {
            throw new IllegalArgumentException("Name is empty or invalid input!");
        } else if (!StringUtils.hasText(lastName)) {
            throw new IllegalArgumentException("Lastname is empty or invalid input!");
        }
    }

    public Response handleRequest(Request request, Context context) {

        log.info("Handler invoked with request id: " + context.getAwsRequestId().toString());
        return myGreetings(request, context);
    }
}
