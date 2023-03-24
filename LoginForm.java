import java.util.Scanner;

public class LoginForm {
    public String userName, lastName, firstName;
    public String gmail;
    private String password, rePassword;
    boolean loginSuccess;
    Scanner sc = new Scanner(System.in);

    public LoginForm(String userName, String gmail, String password) {
        this.userName = userName;
        this.gmail = gmail;
        this.password = password;
    }

    public LoginForm() {
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

    // Register Page
    public void registerPage() {
        System.out.print("""
                ----------------------------------------
                                Register
                ----------------------------------------
                """);
        System.out.print(" Fisrt Name: ");
        firstName = sc.nextLine();
        System.out.print("  Last Name: ");
        lastName = sc.nextLine();
        System.out.print("      Gmail: ");
        gmail = sc.nextLine();

        do {
            System.out.print("   Password: ");
            password = sc.nextLine();
            System.out.print("Re-Password: ");
            rePassword = sc.nextLine();

            // Compare Password
            if (rePassword.compareTo(password) < 0 || rePassword.compareTo(password) > 0) {
                System.out.println("Re-password is wrong!\nTry agian!");
            }
        } while (rePassword.compareTo(password) < 0 || rePassword.compareTo(password) > 0);
        System.out.print("""
                ----------------------------------------
                         Register Successfully!
                ----------------------------------------
                """);
    }

    // Reset Password
    public void resetPasswordPage() {
        String oldPassword;
        String ans = "N";
        System.out.print("""
                ----------------------------------------
                             Reset Password
                ----------------------------------------
                """);
        do {
            System.out.print("Old Password: ");
            oldPassword = sc.nextLine();
            // Compare Password
            if (oldPassword.compareTo(password) < 0 || oldPassword.compareTo(password) > 0) {
                System.out.println("Wrong Password!\nWanna try agian! (Y/N): ");
                ans = sc.nextLine();
            }
        } while (ans.compareTo("Y") == 0 || ans.compareTo("y") == 0);
        if (oldPassword.compareTo(password) == 0) {
            System.out.println("--------------- New Password ---------------");
            do {
                System.out.print("New Password: ");
                password = sc.nextLine();
                System.out.print(" Re-Password: ");
                rePassword = sc.nextLine();

                // Compare Password
                if (rePassword.compareTo(password) < 0 || rePassword.compareTo(password) > 0) {
                    System.out.println("Re-password is wrong!\nTry agian!");
                } else {
                    System.out.print("""
                            ----------------------------------------
                                        Rest Successfully!
                            ----------------------------------------
                            """);
                }
            } while (rePassword.compareTo(password) < 0 || rePassword.compareTo(password) > 0);
        }
    }

    // Login Page
    public void loginPage() {
        String ans = "N";
        System.out.print("""
                ----------------------------------------
                            Login Account
                ----------------------------------------
                """);
        System.out.print("   Gmail: ");
        gmail = sc.nextLine();
        do {
            System.out.print("Password: ");
            String password = sc.nextLine();
            // Compare Password
            if (password.compareTo(this.password) < 0 || password.compareTo(this.password) > 0) {
                System.out.println("Wrong Password!\nWanna try agian! (Y/N): ");
                ans = sc.nextLine();
            } else {
                System.out.print("""
                        ----------------------------------------
                                    Login Successfully !
                        ----------------------------------------
                        """);
                loginSuccess = true;
            }
        } while (ans.compareTo("Y") == 0 || ans.compareTo("y") == 0);
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
         * String userName, lastName, fisrtName;
         * String gmail;
         * String password;
         */
        Scanner sc = new Scanner(System.in);
        int option;
        LoginForm loginForm = new LoginForm();

        do {
            loginForm.landingPage();
            System.out.print("-> Your option: ");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    loginForm.registerPage();
                    break;
                case 2:
                    loginForm.loginPage();
                    if (loginForm.loginSuccess) {
                        do {
                            loginForm.profile();
                            System.out.print("-> Your option: ");
                            option = sc.nextInt();
                            switch (option) {
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
                        } while (option > 3 || option < 2);
                    }
                    break;
                default:
                    System.out.println("Option is not availble!!");
                    break;
            }
        } while (option != 3);

    }
}
