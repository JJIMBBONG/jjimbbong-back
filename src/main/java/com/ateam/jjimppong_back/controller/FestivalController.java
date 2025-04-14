package com.ateam.jjimppong_back.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.beans.factory.annotation.Value;

import reactor.core.publisher.Mono;


// 백엔드 작업 다 끝나면 연동 예정
@RestController
@RequestMapping("/api")
public class FestivalController {   
    
    @Value("${tourapi.service-key}")
    private String serviceKey;

    private final WebClient webClient = WebClient.create();

    @GetMapping("/festivals")
    public Mono<String> getFestivals(@RequestParam String areaCode, @RequestParam String sigunguCode) {
        String apiUrl = "https://apis.data.go.kr/B551011/KorService1/searchFestival1";

        String requestUrl = apiUrl + 
                "?serviceKey=" + serviceKey +
                "&numOfRows=5" +
                "&pageNo=1" +
                "&MobileOS=ETC" +
                "&MobileApp=MapApp" +
                "&eventStartDate=20250401" +
                "&areaCode=" + areaCode +
                "&sigunguCode=" + sigunguCode +
                "&_type=json";

        System.out.println("호출 API : " + requestUrl);
                
        return webClient.get()
            .uri(requestUrl)
            .retrieve()
            .bodyToMono(String.class)
            .doOnNext(body -> {
                if (body.startsWith("<")) {
                    System.out.println("API 응답이 HTML입니다. 키 또는 파라미터 오류 가능성!");
                } else {
                    System.out.println("JSON 응답 성공: " + body);
                }
                })
                .doOnError(error -> System.out.println("에러 발생: " + error.getMessage()));
    }   

}
