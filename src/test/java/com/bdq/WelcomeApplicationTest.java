/*package com.bdq;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationTest;


public class WelcomeApplicationTest extends ApplicationTest {
    @Override
    public void start (Stage stage) throws Exception {
        Parent fxmlLoader = FXMLLoader.load(WelcomeApplication.class.getResource("view/welcome.fxml"));
        stage.setScene(new Scene(fxmlLoader));
        stage.show();
        stage.toFront();
    }

    @AfterEach
    public void tearDown () throws Exception {
        FxToolkit.hideStage();
        release(new KeyCode[]{});
        release(new MouseButton[]{});
    }

    @Test
    public void testWelcomeBtn () {
        clickOn("#btLogin");
        Pane loginPane = lookup("#loginPane").query();
        assertNotNull(loginPane);
    }

    @Test
    public void testCadastroBtn () {
        clickOn("#linkCadastro");
        Pane cadastroPane = lookup("#cadastroPane").query();
        assertNotNull(cadastroPane);
    }
}*/



