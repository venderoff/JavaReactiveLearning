package com.jrl.basics;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Configuration
public class PrintFluxMono {


    //Creat a  Data for Flux

    Flux<String> nameFlux(){

        return Flux.fromIterable(List.of("Usman", "ikram" , "Zara")) ;
    }

    // Cretae Data for Mono
    Mono<String> nameMono() {

        return Mono.just("Mary") ;

    }


    @Bean
    public String printDb(String[] args) {

        // instance created
        PrintFluxMono fluxMonoGeneratorService = new PrintFluxMono() ;

        //subscribe

        fluxMonoGeneratorService.nameFlux()
                .subscribe(
                   n -> {
                       System.out.println("Name is" + n);
                   }

                ) ;


        // Subscribbing and printing Mono
        System.out.println("working with Mono");
        fluxMonoGeneratorService.nameMono()
                .subscribe(
                   n -> {
                       System.out.println("Mono name is " + n);
                   }

                ) ;

        return "Success" ;
    }
}
