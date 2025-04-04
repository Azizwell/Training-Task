package org.example.company_service.config;

import org.example.company_service.entity.User;
import org.example.company_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.List;

//тут при запуске приложения добовит пользователя для наглядного примера
@Configuration
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {
  @Autowired
  UserRepository userRepository;


  @Override
  public void run(String... args) throws Exception {
    List<User> all = userRepository.findAll();
    if (all.isEmpty()) {
      userRepository.saveAll(List.of(
              new User("Leanne", "Graham", "1-770-736-8031 x56442", 1L),
              new User("Ervin", "Howell", "010-692-6593 x09125", 1L),
              new User("Clementine", "Bauch", "1-463-123-4447", 1L),
              new User("Patricia", "Lebsack", "493-170-9623 x156", 2L),
              new User("Chelsey", "Dietrich", "(254)954-1289", 2L)

      ));
    }


  }
}
