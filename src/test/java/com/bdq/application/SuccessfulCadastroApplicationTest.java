package com.bdq.application;

import static org.junit.Assert.*;
import com.bdq.WelcomeApplication;
import com.bdq.config.db.DB;
import com.bdq.config.db.DbException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DialogPane;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import org.junit.After;
import org.junit.Test;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;

import java.sql.PreparedStatement;
import java.sql.SQLException;


import java.util.Objects;
import java.util.concurrent.TimeoutException;

public class SuccessfulCadastroApplicationTest extends ApplicationTest {

    @Override
    public void start (Stage stage) throws Exception {
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