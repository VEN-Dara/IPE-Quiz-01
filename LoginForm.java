import java.util.Scanner;

public class LoginForm {
    public String userName, lastName, firstName;
    public String gmail;
    private String password, rePassword;
    boolean loginSuccess;
    Scanner sc = new Scanner(System.in);

    public LoginForm(String userName, String gmail, String password ) {
        this.userName = userName;
        this.gmail = gmail;
        this.password = password;
    }
    public LoginForm( ) {
        this.password = "vendara";
    }

    public void landingPage() {
        System.out.println("""
                ----------------------------------------
                                Welcome
                ----------------------------------------
                1. Register Account
                2. Login Account
                        *If you already have an account. 
                3. Exit   
                """);
    }

    //Register Page
    public void registerPage() {
        
    }

    //Reset Password
    public void resetPasswordPage() {
        
           
    }

    //Login Page
    public void loginPage() {
        
    }

    public void profile() {
        System.out.print("""
            ----------------------------------------
                           Profile
            ----------------------------------------
            """);
        System.out.println("             " + lastName + "_" + firstName);
        System.out.println("- Gmail: " + gmail);
        System.out.println("1. Reset Password");
        System.out.println("2. Logout Account");
        System.out.println("3. Exit");
    }
    public static void main(String[] args) {
        /*
        String userName, lastName, fisrtName;
        String gmail;
        String password;  */
        Scanner sc = new Scanner(System.in);
        int option;
        LoginForm loginForm = new LoginForm();

        do {
            loginForm.landingPage();
            System.out.print("-> Your option: ");
            option = sc.nextInt();
            switch(option) {
                case 1:
                    loginForm.registerPage();
                    break;
                case 2:
                    loginForm.loginPage();
                    if(loginForm.loginSuccess) {
                        do {
                            loginForm.profile();
                            System.out.print("-> Your option: ");
                            option = sc.nextInt();
                            switch(option) {
                                case 1:
                                    loginForm.resetPasswordPage();
                                    break;
                                case 2:
                                    break;
                                case 3:
                                    System.out.println("Thanks For Using Our Program!");
                                    break;
                                default:
                                    System.out.println("Option is not availble!!");
                                    break;
                            }
                        }
                        while (option > 3 || option < 2);
                    }
                    break;
                default:
                    System.out.println("Option is not availble!!");
                    break;
            }
        }
        while(option != 3);
    



    }
}
