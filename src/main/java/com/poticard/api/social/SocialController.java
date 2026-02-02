package com.poticard.api.social;

import com.poticard.api.common.BaseResponse;
import com.poticard.api.common.Controller;
import com.poticard.api.utils.JsonParser;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class SocialController implements Controller {
    @Override
    public BaseResponse process(HttpServletRequest req, HttpServletResponse resp) {
        if (req.getRequestURI().contains("redirect") && req.getMethod().equals("GET")){
            String code = req.getParameter("code");

            HttpClient client; // HttpClient 1회 호출
            client = HttpClient.newHttpClient();
            String data = "grant_type=authorization_code&client_id="+System.getenv("KAKAO_CLIENT_ID")+"&redirect_uri="+System.getenv("KAKAO_REDIRECT_URI")+"&client_secret="+System.getenv("KAKAO_CLIENT_SECRET")+"&code="+code;

            // HttpClient를 이용해 POST 방식으로 https://kauth.kakao.com/oauth/token에 요청 전송, 헤더 바디 문서 참조
            HttpRequest authReq = HttpRequest.newBuilder()
                    .uri(URI.create("https://kauth.kakao.com/oauth/token"))
                    .header("Content-Type","application/x-www-form-urlencoded;charset=utf-8")
                    .POST(HttpRequest.BodyPublishers.ofString(data))
                    .build();
            String accessToken;
            try {
                HttpResponse<String> res = client.send(authReq, HttpResponse.BodyHandlers.ofString());

                Map<String, String> tokenRes = JsonParser.from(res.body(),Map.class);

                accessToken = tokenRes.get("access_token");
                System.out.println(accessToken);
            } catch(Exception e){
                return null;
            }


            // 사용자 정보 조회 API 호출
            //      HttpCLient를 이용해 GET방식으로 https://kapi.kakao.com/v2/user/me에 요청 전송 (헤더는 문서 참조)
            HttpRequest userReq = HttpRequest.newBuilder()
                    .uri(URI.create("https://kapi.kakao.com/v2/user/me"))
                    .header("Content-Type","application/x-www-form-urlencoded;charset=utf-8")
                    .header("Authorization","Bearer "+accessToken)
                    .GET()
                    .build();

            String userName;
            String profileImage;
            try {
                HttpResponse<String> res = client.send(userReq, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));
                Map<String, Object> userInfoRes = JsonParser.from(res.body(), Map.class);
                Map<String, String > properties = (Map) userInfoRes.get("properties");
                userName = properties.get("nickname");
                profileImage = properties.get("profile_image");

            } catch(IOException e){
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            // 닉네임, 프로필 사진 주소 출력
            System.out.println("name: " + userName);
            System.out.println("profileUri: " + profileImage);

            // 회원가입 한 적 있나 없나 확인
            //  회원 가입을 했으면
            //      토큰 발급
            //  안했으면
            //      회원 가입 시키고 토큰 발급


            return null;
        }
        return null;
    }
}
