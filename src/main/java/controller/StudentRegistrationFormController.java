package controller;

import db.DBConnection;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import model.Student;
import org.apache.commons.validator.routines.EmailValidator;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class StudentRegistrationFormController implements Initializable {

    @FXML
    private Button btnRegister;

    @FXML
    private Label lblNameError;

    @FXML
    private Label lblEmailError;

    @FXML
    private Label lblPasswordError;

    @FXML
    private Label lblConfirmPasswordError;

    @FXML
    private Label lblDobError;

    @FXML
    private Label lblGenderError;

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

    private static final int EMAILMAXLENGTH = 64;

    @FXML
    void btnLoginOnAction(ActionEvent event) {

    }

    @FXML
    void btnRegisterOnAction(ActionEvent event) {
        validateFullName();
        validateEmailAddress();
        validatePassword();
        System.out.println("register clicked..");
    }

    private boolean validatePassword() {
        if(txtPassword.getText().trim().isEmpty()){
            lblPasswordError.setText("Password field cannot be empty!");
            lblPasswordError.setVisible(true);
            return false;
        }
        lblPasswordError.setVisible(false);
        return true;
    }

    private boolean validateEmailAddress() {
        if(EmailValidator.getInstance().isValid(txtEmail.getText().trim()) && txtEmail.getText().length() <= EMAILMAXLENGTH){
            lblEmailError.setVisible(false);
            return true;
        }
        lblEmailError.setText("Invalid Email Address!");
        lblEmailError.setVisible(true);
        return false;
    }

    private boolean validateFullName() {
        if(txtFullName.getText().trim().isEmpty()){
            lblNameError.setText("Name field cannot be empty!");
            lblNameError.setVisible(true);
            return false;
        }
        lblNameError.setVisible(false);
        return true;
    }

    private String generateStudentId() {
        List<Student> studentList = DBConnection.getDbConnection().getStudentList();
        return studentList.isEmpty() ? "S0001" : String.format("S%04d", Integer.parseInt(studentList.get(studentList.size() - 1).getStudentId().substring(1)) + 1);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtStudentId.setText(generateStudentId());
        btnRegister.disableProperty().bind(hasEmptyField());
    }

    private BooleanBinding hasEmptyField() {
        BooleanBinding isFieldEmpty = radioBtnMale.selectedProperty().or(radioBtnFemale.selectedProperty()).not().or(datePickerDob.getEditor().textProperty().isEmpty());
        for (TextField textField : Arrays.asList(txtStudentId, txtFullName, txtEmail, txtPassword, txtConfirmPassword)) {
            isFieldEmpty = isFieldEmpty.or(textField.textProperty().isEmpty());
        }
        return isFieldEmpty;
    }
}
