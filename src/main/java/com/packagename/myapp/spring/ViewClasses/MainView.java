package com.packagename.myapp.spring.ViewClasses;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route
@HtmlImport("/frontend/styles/menu-view-styles.html")
public class MainView extends VerticalLayout {


    HorizontalLayout horizontalLayoutTop = new HorizontalLayout();


    VerticalLayout verticalLayoutTopRightButtons = new VerticalLayout();
    HorizontalLayout horizontalLayoutTopRightButtons = new HorizontalLayout();

    Button buttonTopLogIn = new Button("Logowanie");
    Button buttonTopRegister = new Button("Rejestracja");


    VerticalLayout verticalLayoutTopLeftButtons = new VerticalLayout();
    HorizontalLayout horizontalLayoutTopLeftButtons = new HorizontalLayout();
    Image imageStar = new Image("/icons/Star.png", "Star");




    public MainView() {
        horizontalLayoutTop.addClassName("horizontalLayoutTop-form-layout");

        imageStar.setWidth("35px");
        imageStar.setHeight("35px");

        horizontalLayoutTopLeftButtons.add(imageStar);
        verticalLayoutTopLeftButtons.add(horizontalLayoutTopLeftButtons);
        verticalLayoutTopLeftButtons.setDefaultHorizontalComponentAlignment(Alignment.START);

        buttonTopLogIn.addClassName("button-top-right");
        buttonTopRegister.addClassName("button-top-right");
        horizontalLayoutTopRightButtons.add(buttonTopLogIn, buttonTopRegister);
        verticalLayoutTopRightButtons.add(horizontalLayoutTopRightButtons);
        verticalLayoutTopRightButtons.setDefaultHorizontalComponentAlignment(Alignment.END);

        buttonTopLogIn.addClickListener(buttonClickEvent -> {
           UI.getCurrent().navigate("login");
        });

        buttonTopRegister.addClickListener(buttonClickEvent -> {
           UI.getCurrent().navigate("rejestracja");
        });


        horizontalLayoutTop.add(verticalLayoutTopLeftButtons, verticalLayoutTopRightButtons);


        add(horizontalLayoutTop);
    }
}
