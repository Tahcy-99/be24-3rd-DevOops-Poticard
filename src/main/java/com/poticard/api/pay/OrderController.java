package com.poticard.api.pay;

import com.poticard.api.common.BaseResponse;
import com.poticard.api.common.Controller;
import com.poticard.api.pay.model.OrderDto;
import com.poticard.api.utils.JsonParser;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class OrderController implements Controller {
    @Override
    public BaseResponse process(HttpServletRequest req, HttpServletResponse resp) {
        if (req.getRequestURI().contains("verify") && req.getMethod().equals("POST")) {
            // paymentId를 전달받는다
            OrderDto payment = JsonParser.from(req, OrderDto.class);
            String paymentId = payment.getPaymentId();

            // 포트원에 paymentId로 결제한 정보를 조회
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.portone.io/payments/"+paymentId))
                    .header("Content-Type", "application/json")
                    .header("Authorization","PortOne "+System.getenv("API_SECRET_KEY"))
                    .method("GET", HttpRequest.BodyPublishers.ofString("{}"))
                    .build();
            Integer paidPrice = null;

            try {
                HttpResponse<String> res = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
                Map<String, Object> paymentRes = JsonParser.from(res.body(),Map.class);
                Map<String, Integer> amount = (Map) paymentRes.get("amount");
                System.out.println(paymentRes);
                paidPrice=amount.get("paid");

            } catch(IOException e){
                e.printStackTrace();
            } catch(InterruptedException e){
                e.printStackTrace();
            }

            // 결제한 정보랑 실제 상품 가격이랑 비교 후
            // 실제 상품 가격을 불러옴
            Integer realPrice = paidPrice;

            if (paidPrice == realPrice){
                // 일치하면 주문 생성
                System.out.println("create Order");
            }else{
                // 일치하지 않으면 환불
                System.out.println("execute refund");
            }

        }
        return null;
    }
}
