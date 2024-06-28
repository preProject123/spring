package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.Table;
import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException, NullPointerException {

      String ansiReset = "\u001B[0m";
      String ansiBackground = "\u001B[42m";

      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);


      User ivan = new User("Ivan", "Ivanov", "ivan5@mail.ru");
      User andrey = new User("Andrey", "Andreyov", "andreyov@mail.ru");
      User arseniy = new User("Arseniy", "Anoshko", "anoshko@mail.ru");
      User roman = new User("Roman", "Romanov", "roman@mail.ru");
      User stepan = new User("Stepan", "Stepanov", "stepan@mail.ru");

      Car bmw = new Car("BMW",234);
      Car toyota = new Car("Toyota",152);
      Car mazda = new Car("Mazda",36);
      Car mercedes = new Car("Mercedes",300);
      Car audi = new Car("Audi",752);

      userService.add(ivan.setCar(bmw).setUser(ivan));
      userService.add(andrey.setCar(mazda).setUser(andrey));
      userService.add(arseniy.setCar(mercedes).setUser(arseniy));
      userService.add(roman.setCar(toyota).setUser(roman));
      userService.add(stepan.setCar(audi).setUser(stepan));

      System.out.println(ansiBackground +   userService.getUserByCar("Mercedes", 300) + ansiReset);

      try {
         for (User user : userService.listUsers()){
            System.out.println(user+" "+ user.getCar());
         }
      } catch (NullPointerException e) {
         System.out.println("");;
      }

      context.close();
   }
}
