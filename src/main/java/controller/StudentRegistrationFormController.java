package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class StudentRegistrationFormController {

    @FXML
    private DatePicker datePickerDob;

    @FXML
    private ToggleGroup genderGroup;

    @FXML
    private RadioButton radioBtnFemale;

    @FXML
    private RadioButton radioBtnMale;

    @FXML
    private PasswordField txtConfirmPassword;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtFullName;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtStudentId;

    @FXML
    void btnLoginOnAction(ActionEvent event) {

    }

    @FXML
    void btnRegisterOnAction(ActionEvent event) {

    }

}
