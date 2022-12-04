package com.bdq.application;

import com.bdq.WelcomeApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;

import java.util.Objects;
import java.util.concurrent.TimeoutException;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FieldsCadastroApplicationTest extends ApplicationTest {
    private final String fxid;
    private final String value;

    public FieldsCadastroApplicationTest(String fxid, String value) {
        this.fxid = fxid;
        this.value = value;
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent fxmlLoader = FXMLLoader.load(Objects.requireNonNull(WelcomeApplication.class.getResource("view/cadastro.fxml")));
        stage.setScene(new Scene(fxmlLoader));
        stage.show();
        stage.toFront();
    }

    @After
    public void tearDown() throws TimeoutException {
        FxToolkit.hideStage();
        release(new KeyCode[]{});
        release(new MouseButton[]{});
    }

    @Test
    public void testWriteOnField() {
        clickOn(fxid).write(value);
        assertEquals(((TextField) lookup(fxid).query()).getText(), value);
    }

    @Parameterized.Parameters
    public static Object[] fieldsToWrite() {
        return new Object[]{
                new Object[]{"#nome", "TestName"},
                new Object[]{"#login", "TestLogin"},
                new Object[]{"#senha", "TestPwd"},
        };
    }
}
