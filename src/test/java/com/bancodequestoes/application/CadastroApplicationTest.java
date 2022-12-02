package com.bancodequestoes.application;

import com.bancodequestoes.WelcomeApplication;
import com.bancodequestoes.config.db.DB;
import com.bancodequestoes.config.db.DbException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DialogPane;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationTest;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.scene.control.TextField;

import java.util.Objects;
import java.util.concurrent.TimeoutException;

import static org.junit.jupiter.api.Assertions.*;


class CadastroApplicationTest extends ApplicationTest {

    @Override
    public void start (Stage stage) throws Exception {
        Parent fxmlLoader = FXMLLoader.load(Objects.requireNonNull(WelcomeApplication.class.getResource("view/cadastro.fxml")));
        stage.setScene(new Scene(fxmlLoader));
        stage.show();
        stage.toFront();
    }

    @AfterEach
    void tearDown() throws TimeoutException {
        FxToolkit.hideStage();
        release(new KeyCode[]{});
        release(new MouseButton[]{});
    }

    @ParameterizedTest
    @MethodSource("fieldsToWrite")
    public void testWriteOnField (String fxid, String value) {
        clickOn(fxid).write(value);
        assertEquals(((TextField) lookup(fxid).query()).getText(), value);
    }

    @ParameterizedTest
    @MethodSource("badInputs")
    public void testBadCadastro(String nameInput, String userInput, String senhaInput) {
        clickOn("#nome").write(nameInput);
        clickOn("#login").write(userInput);
        clickOn("#senha").write(senhaInput);
        clickOn("#btEntrar");
        DialogPane dialogPane = lookup(".dialog-pane").query();
        assertEquals(dialogPane.getContentText(), "Há campos não preenchidos ou nome indisponivel!");
    }

    @Test
    public void testSuccessfulCadastroAluno () throws Exception {
        new DBTestRunner().runTest(new DBTest() {
            public void prepareDB() {
                PreparedStatement st = null;
                try {
                    st = DB.getConnection().prepareStatement("DELETE FROM Aluno WHERE nomeUsr = ?");
                    st.setString(1, "TestLogin");
                    st.executeUpdate();
                } catch (SQLException e) {
                    throw new DbException(e.getMessage());
                } finally {
                    DB.closeStatement(st);
                }
            }
            public void test() {
                clickOn("#nome").write("TestName");
                clickOn("#login").write("TestLogin");
                clickOn("#senha").write("1234");
                clickOn("#btEntrar");
                DialogPane dialogPane = lookup(".dialog-pane").query();
                assertTrue(dialogPane.getContentText().contains("Você foi cadastrado com sucesso!"));
            }
        });
    }

    @Test
    public void testSuccessfulCadastroProfessor () throws Exception {
        new DBTestRunner().runTest(new DBTest() {
            public void prepareDB() {
                PreparedStatement st = null;
                try {
                    st = DB.getConnection().prepareStatement("DELETE FROM Professor WHERE nomeUsr = ?");
                    st.setString(1, "TestLogin");
                    st.executeUpdate();
                } catch (SQLException e) {
                    throw new DbException(e.getMessage());
                } finally {
                    DB.closeStatement(st);
                }
            }
            public void test() {
                clickOn("#nome").write("TestName");
                clickOn("#login").write("TestLogin");
                clickOn("#senha").write("1234");
                clickOn("#radioProfessor");
                clickOn("#btEntrar");
                DialogPane dialogPane = lookup(".dialog-pane").query();
                assertTrue(dialogPane.getContentText().contains("Você foi cadastrado com sucesso!"));
            }
        });
    }

    private static Object[] fieldsToWrite () {
        return new Object[]{
                new Object[] {"#nome", "TestName"},
                new Object[] {"#login", "TestLogin"},
                new Object[] {"#senha", "TestPwd"},
        };
    }

    private static Object[] badInputs () {
        return new Object[]{
                new Object[] {"Igor", "Igor", ""},
                new Object[] {"", "Igor", "1234"},
                new Object[] {"Igor", "", "1234"},
                new Object[] {"Igor", "Igor", "1234"},
        };
    }
}

interface DBTest {
    void prepareDB();
    void test();
}

class DBTestRunner {
    void runTest(DBTest test) throws Exception {
        test.prepareDB();
        try {
            test.test();
        } finally {
            test.prepareDB();
        }
    }
}





