package it.pingflood.wintedbe;

import it.pingflood.wintedbe.data.entity.Color;
import it.pingflood.wintedbe.data.repo.ColorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

import static java.lang.System.*;

@SpringBootApplication
public class WintedBeApplication {
  
  public static void main(String[] args) {
    SpringApplication.run(WintedBeApplication.class, args);
  }
  
  
  @Bean
  public CommandLineRunner initDB(ColorRepository colorRepository) {
    return args -> {
      Color c1 = new Color();
      Color c2 = new Color();
      Color c3 = new Color();
    
      colorRepository.saveAll(List.of(c1,c2,c3));
      Iterable<Color> color = colorRepository.findAll();
      for (Color x : color) out.println(x);
    };
  }
  
  
  
}
