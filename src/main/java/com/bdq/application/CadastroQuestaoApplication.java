package com.bdq.application;

import com.bdq.WelcomeApplication;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class CadastroQuestaoApplication extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) throws IOException {
    Parent root =
            FXMLLoader.load(
                    Objects.requireNonNull(WelcomeApplication.class.getResource("view/cadastro-questao.fxml")));
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }
}
