import javafx.application.Application;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.util.Pair;
import javafx.geometry.Insets;
import java.util.Optional;


public class NewLogin extends Application {
    @Override
    public void start(Stage primaryStage) {

        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Login");
        dialog.setHeaderText("Enter your username and password");



        ButtonType loginButtonType = new ButtonType("Login", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);


        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField username = new TextField();
        username.setPromptText("Username");
        PasswordField password = new PasswordField();
        password.setPromptText("Password");


        grid.add(new Label("Username:"), 0, 0);
        grid.add(username, 1, 0);
        grid.add(new Label("Password:"), 0, 1);
        grid.add(password, 1, 1);


        dialog.getDialogPane().setContent(grid);

        Optional<Pair<String, String>> input = dialog.showAndWait();
        System.out.println(input.get());


        if(String.valueOf(username.getText()).equals("dom123")){

            if(String.valueOf(password.getText()).equals("d123")){

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("You are now logged in!");
                alert.setContentText("Welcome: " + username.getText());
                alert.showAndWait();

                return;

            } else {
                int passwordattempts = 1;
                while (passwordattempts < 3) {
                    dialog.showAndWait();
                    passwordattempts++;
                }
            }
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Contact Admin");
            alert.showAndWait();

        } else {
            int usernameattempts = 1;
            while (usernameattempts < 3) {
                dialog.showAndWait();
                usernameattempts++;
            }
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Invalid Username");
            alert.showAndWait();
        }
    }


    public static void main (String [] args) {
        launch(args);
    }
}
