package com.ngatdo.soapws.endpoint;

import com.ngatdo.soapws.utils.GetSumRequest;
import com.ngatdo.soapws.utils.GetSumResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
public class CalculatorEndpoint {
    private static final String NAMESPACE_URI = "http://soa.com/soap/calculator";

    /**
     * WS get sum of two number
     * @param request
     * @return
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getSumRequest")
    @ResponsePayload
    public GetSumResponse sum(@RequestPayload GetSumRequest request) {
        GetSumResponse response = new GetSumResponse();
        response.setResult(request.getFirstNumber() + request.getSecondNumber());
        response.setError(null);
        return response;
    }
}
