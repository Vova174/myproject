//package hiber.service;
//
//import hiber.config.HiberConfig;
//import hiber.model.User;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//import org.springframework.stereotype.Component;
//
//
//import javax.annotation.PostConstruct;
//
//@Component
//public class CreatUser {
//    private final UserService userService;
//
//    public CreatUser() {
//        AnnotationConfigApplicationContext context =
//                new AnnotationConfigApplicationContext(HiberConfig.class);
//        this.userService = context.getBean(UserService.class);
//    }
//
//    public CreatUser(UserService userService) {
//        this.userService = userService;
//    }
//
//    @PostConstruct
//    public void init(){
//        userService.save(new User("vova","pupkin"));
//        userService.save(new User("vova","pupkin"));
//        userService.save(new User("valera","puchkin"));
//        userService.save(new User("volodimir","polyshcyk"));
//        userService.save(new User("vikor","popov"));
//        userService.save(new User("vasya","petrenko"));
//        userService.save(new User("vadim","prutckyi"));
//    }
//
//}
