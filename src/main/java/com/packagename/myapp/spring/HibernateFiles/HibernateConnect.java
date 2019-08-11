package com.packagename.myapp.spring.HibernateFiles;


import com.vaadin.flow.component.notification.Notification;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class HibernateConnect {
    private static SessionFactory sessionFactory;

    public static void setUp(){
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        try {
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
        }
        catch (Exception e) {
            StandardServiceRegistryBuilder.destroy( registry );
        }
    }

    private static void setAll(String login, String password){
        UserLoginAndPassword userLoginAndPassword = new UserLoginAndPassword();

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        userLoginAndPassword.setLogin(login);
        userLoginAndPassword.setPassword(password);
        session.save(userLoginAndPassword);
        session.getTransaction().commit();
        session.close();
    }

    private static boolean checkIfLoginExist(String login){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            session.createQuery("from UserLoginAndPassword where UserLoginAndPassword.login = ?")
                    .addQueryHint(login)
                    .uniqueResult();
            session.close();
            return true;
        }
        catch (Exception e){
            System.out.println(e);
            session.close();
            return false;
        }


    }



    public static boolean saveLoginAndPassword(String login, String password, String passwordCheck){
        if(login.length() >= 6 && login.length() <= 24 && password.length() >= 6 && password.length() <= 24 && password.equals(passwordCheck)) {
            if(checkIfLoginExist(login)){
                Notification notification = new Notification("Login jest już zajęty", 5000, Notification.Position.TOP_CENTER);
                notification.open();
            }
            else{
                setAll(login, password);
                Notification notification = new Notification("Login nie jest zajęty", 5000, Notification.Position.TOP_CENTER);
                notification.open();
            }
        }
        else{
            Notification notification = new Notification("Sprawdź czy hasło i login mają od 6 do 24 znaków!", 5000, Notification.Position.TOP_CENTER);
            notification.open();
        }
        return true;
    }
}
