package com.bdq.application;

import com.bdq.WelcomeApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DialogPane;
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
public class BadCadastroApplicationTest extends ApplicationTest {
    private final String nameInput;
    private final String userInput;
    private final String senhaInput;

    public BadCadastroApplicationTest(String nameInput, String userInput, String senhaInput) {
        this.nameInput = nameInput;
        this.userInput = userInput;
        this.senhaInput = senhaInput;
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
    public void testBadCadastro() {
        clickOn("#nome").write(nameInput);
        clickOn("#login").write(userInput);
        clickOn("#senha").write(senhaInput);
        clickOn("#btEntrar");
        DialogPane dialogPane = lookup(".dialog-pane").query();
        assertEquals(dialogPane.getContentText(), "Há campos não preenchidos ou nome indisponivel!");
    }

    @Parameterized.Parameters
    public static Object[] badInputs() {
        return new Object[]{
                new Object[]{"Igor", "Igor", ""},
                new Object[]{"", "Igor", "1234"},
                new Object[]{"Igor", "", "1234"},
                new Object[]{"Igor", "Igor", "1234"},
        };
    }
}
