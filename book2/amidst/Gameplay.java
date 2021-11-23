public class Gameplay {

    public static void main(String[] args) {

        BlueAstronaut Bob = new BlueAstronaut("Bob", 20, 6, 30);
        BlueAstronaut Heath = new BlueAstronaut("Heath", 30, 3, 21);
        BlueAstronaut Albert = new BlueAstronaut("Albert", 44, 2, 0);
        BlueAstronaut Angel = new BlueAstronaut("Angel", 0, 1, 0);

        RedAstronaut Liam = new RedAstronaut("Liam", 19, "experienced");
        RedAstronaut SuspiciousPerson = new RedAstronaut("Suspicious Person", 100, "expert");

        Liam.sabotage(Bob);
        System.out.println(Bob);

        Liam.freeze(SuspiciousPerson);
        Liam.freeze(Albert);
        System.out.println(Liam);
        System.out.println(Albert);

        Albert.emergencyMeeting();
        SuspiciousPerson.emergencyMeeting();

        Bob.emergencyMeeting();
        System.out.println(SuspiciousPerson);

        Heath.completeTask();
        System.out.println(Heath);
        Heath.completeTask();
        System.out.println(Heath);
        Heath.completeTask();

        Liam.freeze(Angel);
        System.out.println(Liam);
        System.out.println(Angel);

        Liam.sabotage(Bob);
        Liam.sabotage(Bob);
        System.out.println(Bob);
        Liam.freeze(Bob);
        System.out.println(Bob);

        Angel.emergencyMeeting();

    }

}