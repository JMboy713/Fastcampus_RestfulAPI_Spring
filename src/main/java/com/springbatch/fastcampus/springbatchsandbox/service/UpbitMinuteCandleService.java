package com.springbatch.fastcampus.springbatchsandbox.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springbatch.fastcampus.springbatchsandbox.http.UpbitFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpbitMinuteCandleService {
    private final UpbitFeignClient upbitFeignClient;



    public void callUpbit() {
//        ObjectMapper om = new ObjectMapper();
        String result = upbitFeignClient.getMinuteCandle(60, "KRW-BTC", 2);
        System.out.println(result);

    }
}
