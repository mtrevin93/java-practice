public class StringOperations {
    public static void main(String[] args) {
        String myName = "Michael";
        System.out.println(myName);
        String firstLetterA = 'A' + myName.substring(1,7);
        String lastLetterZ = firstLetterA.substring(0,6) + 'Z';
        System.out.println(lastLetterZ);
        String greatWebsite = "www.stackoverflow.com";
        System.out.println(greatWebsite);
        String site1331 = greatWebsite.substring(4,17) + "1331";
        System.out.println(site1331);
    }
}