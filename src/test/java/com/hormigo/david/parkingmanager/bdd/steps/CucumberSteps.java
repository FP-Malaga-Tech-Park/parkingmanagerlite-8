package com.hormigo.david.parkingmanager.bdd.steps;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.hormigo.david.parkingmanager.bdd.CucumberConfiguration;
import com.hormigo.david.parkingmanager.user.service.UserService;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
public class CucumberSteps extends CucumberConfiguration {

    @MockBean
    private UserService userService;
    @Value("${local.server.port}")
    private  int port;
    private static ChromeDriver driver;
    @BeforeAll
    public static void prepareWebDriver() {

        System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        
    }

    //Pagina home

    @Given("un usuario esta en la pagina home")
    public void showHomePage(){
        driver.get("http://localhost:" + port + "/");
    }
    @Then("se muestra el titulo con un h1")
    public void showH1(){
        WebElement title = driver.findElement(By.id("home-title"));
        assertEquals("Bienvenidos a CPIFP Los Camaleones", title);
    }
    @Then("se muestra el boton Sorteos")
    public void showDrawButton(){
        WebElement drawButton = driver.findElement(By.id("to-draws-link"));
        assertNotNull(drawButton);
    }
    @Then("se muestra el boton Usuarios")
    public void showUserButton(){
        WebElement userButton = driver.findElement(By.id("to-users-link"));
        assertNotNull(userButton);
    }

    //Pagina User


    @Given("un usuario esta en la pagina users")
    public void userPage(){
        driver.get("http://localhost:" + port + "/users");
    }
    @Then("se muestra el titulo")
    public void showTitle(){
        WebElement userTitle=driver.findElement(By.id("users-title"));
        assertEquals("Usuarios", userTitle);
    }
    @Then("se muestra el boton de crear usuario")
    public void showCreateUserButton(){
        WebElement createUserButton=driver.findElement(By.id("users-button-create"));
        assertNotNull(createUserButton);
    }
    @Then("se muestra la tabla")
    public void showTable(){
        WebElement userTable=driver.findElement(By.id("user-table"));
        assertNotNull(userTable);
    }

    //CrateUser


    @Given("un usuario esta en la pagina de usuarios")
    public void openUserCreateForm()
    {
        driver.get("http://localhost:" + port + "/Users");
    }
    @When("el usuario hace click sobre el botón de crear usuario")
    public void openUserCreateForm2(){
        driver.findElement(By.id("users-button-create")).click();
        }
    @Then("se muestra un formulario")
    public void showForm(){
        WebElement userForm= driver.findElement(By.id("create-user-form"));
        assertNotNull(userForm);
    }
    @Then("se muestra el campo nombre")
    public void showName(){
        WebElement userName= driver.findElement(By.id("user-create-label-name"));
        assertNotNull(userName);
    }
    @Then("se muestra el campo apellido")
    public void showLastName(){
        WebElement userLastName= driver.findElement(By.id("user-create-label-lastname1"));
        assertNotNull(userLastName);
    }
    @Then("se muestra el campo apellido2")
    public void showLastName2(){
        WebElement userLastName2= driver.findElement(By.id("user-create-label-lastname2"));
        assertNotNull(userLastName2);
    }
    @Then("se muestra el campo correo")
    public void showEmail(){
        WebElement userEmail= driver.findElement(By.id("user-create-label-email"));
        assertNotNull(userEmail);
    }
    @Then("se muestra la seleccion de rol")
    public void showRol(){
        WebElement userRol= driver.findElement(By.id("select-rol"));
        assertNotNull(userRol);
    }

    //Página Sorteos


    @Given("un usuario esta en la pagina sorteos")
    public void drawPage(){
        driver.get("http://localhost:" + port + "/draws");
    }
    @Then("se muestra el titulo")
    public void showDrawTitle(){
        WebElement drawTitle=driver.findElement(By.id("draws-title"));
        assertEquals("Sorteos", drawTitle);
    }
    @Then("se muestra el boton de crear sorteo")
    public void showCreateDrawButton(){
        WebElement createDrawButton=driver.findElement(By.id("draws-button-create"));
        assertNotNull(createDrawButton);
    }
    @Then("se muestra la tabla")
    public void showDrawTable(){
        WebElement drawTable =driver.findElement(By.id("draw-list-table"));
        assertNotNull(drawTable);
    }

    //CreateDraw


    @Given("un usuario esta en la pagina de sorteos")
    public void openDrawCreateForm()
    {
        driver.get("http://localhost:" + port + "/Draws");
    }
    @When("el usuario hace click sobre el botón de crear sorteo")
    public void openDrawCreateForm2(){
        driver.findElement(By.id("draws-button-create")).click();
        }
    @Then("se muestra un formulario")
    public void showDrawForm(){
        WebElement drawForm= driver.findElement(By.id("create-draw-form"));
        assertNotNull(drawForm);
    }
    @Then("se muestra el campo descripcion")
    public void showDescription(){
        WebElement drawDescription= driver.findElement(By.id("draw-label-description"));
        assertNotNull(drawDescription);
    }
    @Then("se muestra el boton crear")
    public void showDrawButtonCreate(){
        WebElement drawButton= driver.findElement(By.id("draw-button-submit"));
        assertNotNull(drawButton);
    }

    //Navegación Home-Draws


    @Given("un usuario esta en la pagina inicial")
    public void openHometoDraw() {
        driver.get("http://localhost:" + port + "/");
    }
    @When("el usuario hace click sobre el botón de Sorteo")
    public void clickDrawButton(){
        driver.findElement(By.id("to-draws-link")).click();
    }
    @Then("se muestran todos los sorteos del sistema")
    public void navigateToDrawList(){
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("/draws"));
    }

    //Navegación draw-createDraw
    @Given("un usuario esta en la pagina sorteo")
    public void openDraw() {
        driver.get("http://localhost:" + port + "/draw");
    }
    @When("el usuario hace click sobre el botón crear sorteo")
    public void clickCreateDrawButton(){
        driver.findElement(By.id("draws-button-create")).click();
    }
    @Then("se muestra la pagina de creacion sorteo")
    public void navigateToCreateDraw(){
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("/newDraw"));
    }

    //Navegacion Home-Users

    @Given("un usuario esta en la pagina inicial")
    public void openHome() {
        driver.get("http://localhost:" + port + "/");
    }
    @When("el usuario hace click sobre el botón de Usuarios")
    public void clickUserButton(){
        driver.findElement(By.id("to-users-link")).click();
    }
    @Then("se muestran todos los usuarios del sistema")
    public void navigateToUsersList(){
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("/users"));
    }

    //Navegacion user-createUser
    @Given("un usuario esta en la pagina user")
    public void openUser() {
        driver.get("http://localhost:" + port + "/");
    }
    @When("el usuario hace click sobre el botón de crear nuevo usuario")
    public void clickCreateUserButton(){
        driver.findElement(By.id("users-button-create")).click();
    }
    @Then("se muestra la pagina de creacion de usuario")
    public void navigateToCreateUser(){
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("/newUser"));
    }

    //Navegacion user-draw

    @Given("un usuario esta en la pagina user")
    public void openUser2() {
        driver.get("http://localhost:" + port + "/users");
    }
    @When("el usuario hace click sobre el boton sorteos")
    public void clickDrawButtonFromUser(){
        driver.findElement(By.id("to-draws-link")).click();
    }
    @Then("se muestra la pagina de sorteos")
    public void navigateToDraw(){
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("/draws"));
    }

    //Navegacion draw-user

    @Given("un usuario esta en la pagina sorteos")
    public void openDraw2() {
        driver.get("http://localhost:" + port + "/draws");
    }
    @When("el usuario hace click sobre el boton usuarios")
    public void clickUserButtonFromDraw(){
        driver.findElement(By.id("to-users-link")).click();
    }
    @Then("se muestra la pagina usuarios")
    public void navigateToUser(){
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("/users"));
    }
    }
