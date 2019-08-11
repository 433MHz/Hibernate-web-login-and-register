package com.packagename.myapp.spring.ViewClasses;

import com.packagename.myapp.spring.HibernateFiles.HibernateConnect;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.router.Route;

@Route("rejestracja")
@HtmlImport("/frontend/styles/login-view-styles.html")
public class RegisterView extends LoginView {

    HorizontalLayout horizontalLayoutPasswordCheck = new HorizontalLayout();
    Label labelPasswordCheck = new Label("Hasło:");
    PasswordField passwordFieldCheckPassword = new PasswordField();

    public RegisterView(){
        labelLoginInfo.setText("Rejestracja");
        buttonLogIn.setText("Rejestracja");

        buttonLogIn.addClickListener(buttonClickEvent -> HibernateConnect.saveLoginAndPassword(textFieldLogin.getValue(), passwordFieldPassword.getValue(), passwordFieldCheckPassword.getValue()));

        horizontalLayoutPasswordCheck.add(labelPasswordCheck, passwordFieldCheckPassword);
        horizontalLayoutTopRightButtons.remove(buttonTopRegister);
        horizontalLayoutTopRightButtons.add(buttonTopLogIn);
        verticalLayoutLoginBlock.removeAll();
        verticalLayoutLoginBlock.add(horizontalLayoutLabelLoginInfo, horizontalLayoutLabelAndTextFieldLogin, horizontalLayoutLabelAndPasswordFieldPassword, horizontalLayoutPasswordCheck,  horizontalLayoutButtonLogin);
    }
}
