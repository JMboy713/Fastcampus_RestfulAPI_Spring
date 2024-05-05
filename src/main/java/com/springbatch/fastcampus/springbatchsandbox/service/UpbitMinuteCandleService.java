package com.springbatch.fastcampus.springbatchsandbox.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springbatch.fastcampus.springbatchsandbox.http.UpbitFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpbitMinuteCandleService {
    private final UpbitFeignClient upbitFeignClient;



    public void callUpbit(int unit,String market) {
//        ObjectMapper om = new ObjectMapper();
        String result = upbitFeignClient.getMinuteCandle(unit, market, 10);
        System.out.println(result);

    }
}
