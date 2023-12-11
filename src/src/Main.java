import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    private static boolean isAuthorized = false;
    private static final String CLIENT_ID = "a19ee7dbfda443b2a8150c9101bfd645";
    private static final String REDIRECT_URI = "http://localhost:8080";
    static boolean exit;

    public static void main(String[] args) {
        while (!exit) {
            chooseAction();
        }


    }

    private static void chooseAction() {
        while (true) {
            String choice = scanner.nextLine().trim();
            //String command = scanner.nextLine().trim();

            if (!isAuthorized && !choice.equals("auth") && !choice.equals("exit")) {
                System.out.println("Please, provide access for application.");
                continue;
            }

            switch (choice) {
                case "new":
                    if (isAuthorized) {
                        System.out.println("---NEW RELEASES---");
                        System.out.println("Mountains [Sia, Diplo, Labrinth]\n" +
                                "Runaway [Lil Peep]\n" +
                                "The Greatest Show [Panic! At The Disco]\n" +
                                "All Out Life [Slipknot]");
                    } else {
                        notification();
                    }
                    break;
                case "featured":
                    if (isAuthorized) {
                        System.out.println("---FEATURED---");
                        System.out.println("Mellow Morning\n" +
                                "Wake Up and Smell the Coffee\n" +
                                "Monday Motivation\n" +
                                "Songs to Sing in the Shower");
                    } else {
                        notification();
                    }
                    break;
                case "categories":
                    if (isAuthorized) {
                        System.out.println("---CATEGORIES---");
                        System.out.println("Top Lists\n" +
                                "Pop\n" +
                                "Mood\n" +
                                "Latin");
                    } else {
                        notification();
                    }
                    break;
                case "playlists Mood":
                    if (isAuthorized) {
                        System.out.println("---MOOD PLAYLISTS---");
                        System.out.println("Walk Like A Badass  \n" +
                                "Rage Beats  \n" +
                                "Arab Mood Booster  \n" +
                                "Sunday Stroll");
                    } else {
                        notification();
                    }
                    break;
                case "auth":
                    String authLink = generateAuthLink();
                    System.out.println(authLink);
                    isAuthorized = true;  // Simulating successful authorization
                    System.out.println("---SUCCESS---");
                    break;
                case "exit":
                    if (isAuthorized) {
                        System.out.println("---GOODBYE!---");
                        exit();
                        break;
                    }
                    else
                        notification();
                    exit();
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void exit() {
        exit = true;
        System.exit(0);

    }

    private static void notification() {
        System.out.println("Please, provide access for application.");
    }

    private static String generateAuthLink() {
        return "https://accounts.spotify.com/authorize?client_id=" + CLIENT_ID +
                "&redirect_uri=" + REDIRECT_URI + "&response_type=code";
    }
}