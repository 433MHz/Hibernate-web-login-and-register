package com.packagename.myapp.spring.ViewClasses;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("login")
@HtmlImport("/frontend/styles/login-view-styles.html")
public class LoginView extends MainView {

    VerticalLayout VerticalLayoutLoginBlockMain = new VerticalLayout();
    VerticalLayout verticalLayoutLoginBlock = new VerticalLayout();

    HorizontalLayout horizontalLayoutLabelLoginInfo = new HorizontalLayout();
    Label labelLoginInfo = new Label("Logowanie");

    HorizontalLayout horizontalLayoutLabelAndTextFieldLogin = new HorizontalLayout();
    Label labelTextFieldLogin = new Label("Login: ");
    TextField textFieldLogin = new TextField();

    HorizontalLayout horizontalLayoutLabelAndPasswordFieldPassword = new HorizontalLayout();
    Label labelPasswordFieldPassword = new Label("Hasło: ");
    PasswordField passwordFieldPassword = new PasswordField();

    HorizontalLayout horizontalLayoutButtonLogin = new HorizontalLayout();
    Button buttonLogIn = new Button("Zaloguj");


    public LoginView(){

        buttonLogIn.addClassName("button-log-in-view");
        verticalLayoutLoginBlock.addClassName("verticalLayoutLoginBlock-view");
        labelLoginInfo.addClassName("labelLoginInfo-view");

        horizontalLayoutTopRightButtons.remove(buttonTopLogIn);

        horizontalLayoutLabelLoginInfo.add(labelLoginInfo);
        horizontalLayoutLabelAndTextFieldLogin.add(labelTextFieldLogin, textFieldLogin);
        horizontalLayoutLabelAndPasswordFieldPassword.add(labelPasswordFieldPassword, passwordFieldPassword);
        horizontalLayoutButtonLogin.add(buttonLogIn);

        verticalLayoutLoginBlock.add(horizontalLayoutLabelLoginInfo, horizontalLayoutLabelAndTextFieldLogin, horizontalLayoutLabelAndPasswordFieldPassword, horizontalLayoutButtonLogin);
        verticalLayoutLoginBlock.setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        VerticalLayoutLoginBlockMain.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        VerticalLayoutLoginBlockMain.add(verticalLayoutLoginBlock);
        add(VerticalLayoutLoginBlockMain);
    }
}
