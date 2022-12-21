package com.example.chap03_thymeleaf.controller;

import com.example.chap03_thymeleaf.model.dto.ThymeTestDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/thyme")
public class ThymeTestController {

    @GetMapping("/")
    public String test1(){
        return "thyme/thymeleaf1";
    }

    @GetMapping("/test2")
    public String test2(Model model){  //https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html
        List<ThymeTestDTO> list = IntStream.rangeClosed(1,9).asLongStream().mapToObj(i -> {//asLongStream() 메소드는 IntStream의 int 요소를 long 요소로 타입 변환해서 LongStream을 생성 api참고
            ThymeTestDTO dto = ThymeTestDTO.builder()
                    .id(i)
                    .name("유재석" + i)
                    .phone("010-9999-123" + i)
                    .createDate(LocalDateTime.now())
                    .build();
            return dto;
        }).collect(Collectors.toList());//collect는 원소들의 스트림을 List나 Set, Map 같은 다른 종류의 결과로 변환하여 반환한다

        model.addAttribute("lists",list);

        return "thyme/thymeleaf1";
    }

    @GetMapping({"/thymeleaf1","/thymeleaf2"})/*   배열을 이용해서 하나이상의 url 처리가능  ,void이고 명칭 같으면 화면바로 연결됨,thymeleaf2할떄 보여주기  */
    public void test3(Model model) {
        List<ThymeTestDTO> list = IntStream.rangeClosed(1, 9).asLongStream().mapToObj(i -> {
            ThymeTestDTO dto = ThymeTestDTO.builder()
                    .id(i)
                    .name("유재석" + i)
                    .phone("010-9999-123" + i)
                    .createDate(LocalDateTime.now())
                    .build();
            return dto;
        }).collect(Collectors.toList());

        model.addAttribute("lists", list);

        model.addAttribute("authInfo", list.get(0)); // authInfo에 list의 0번째 값을 강제로 주입
    }

    @GetMapping({"/thymeleaf3","/thymeleaf5"})
    public void test4(){

    }
}
