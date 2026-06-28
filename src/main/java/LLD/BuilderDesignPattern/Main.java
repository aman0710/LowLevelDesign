package LLD.BuilderDesignPattern;

public class Main {
    public static void main(String[] args) {
        EmailBuilder builder = new EmailBuilder();
        Email email = builder
                .setBody("Hello Aman")
                .setTo("abc@xyz.com")
                .setSubject("Weekly Connect")
                .setCc("amazing@anonymous.com")
                .build();

        System.out.println("Email Body: " + email.getBody());
        System.out.println("Email to: " + email.getTo());
        System.out.println("Email subject: " + email.getSubject());
    }
}
