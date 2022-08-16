package com.groovin.character;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SalsaDancer extends Character {


    public SalsaDancer(String name, int health) {
        super(name, health);
    }

    //Time dialogue before combat of SalsaDancer enemy character when engaging in combat with player
    @Override
    public void beginningDialogue() throws InterruptedException {
        System.out.println(".....");
        TimeUnit.MILLISECONDS.sleep(1500);
        System.out.println("Antonio: * dances *");
        TimeUnit.MILLISECONDS.sleep(1500);
        System.out.println("* some women in the crowd faint *");
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("Soulstepper: Woah, you remind me of a young me.");
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("Antonio: Yes my friend, Salsa is Sexy. Salsa is Love. Salsa is Love.");
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("Soulstepper: I can appreciate that. Maybe you can show me a move or two and I can show you mines? ");
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("Antonio: Oh? This sounds intriguing. Dance we shall.");
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("SoulStepper: Let's do it.");
        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.println("ALERT!!");
        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.println("ALERT!!");
        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.printf("%s challenges you to a dance off\n", this.getName());
        TimeUnit.MILLISECONDS.sleep(1500);
        System.out.println("Ready? Let's dance!");
    }

    //Time dialogue after combat of BreakDancer enemy character when engaging in combat with player
    @Override
    public void endingDialogue() throws InterruptedException {
        System.out.println(".....");
        TimeUnit.MILLISECONDS.sleep(1500);
        System.out.println("* women in the crowd swoon over Soulstepper and Antonio *");
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("Antonio: My friend, you dance with such passion. I can feel the fire in your heart!");
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("Soulstepper: Yes it was electric. We should definitely dance again some time");
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("Antonio: Please, consider me a friend for life.");
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("Soulstepper: Same to you Antonio.");
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.printf("You defeated %s with your soul and can now move on.\n", this.getName());
    }

//Random selection for Dance moves for combat of the CrunkDancer character
    @Override
    public void dance(Character soulStepper, Character enemy) {
        List<String> danceMoves = new ArrayList<>(5);
        danceMoves.add("Dile que no");
        danceMoves.add("Enchufla");
        danceMoves.add("Cubanito");
        danceMoves.add("70 en la salsa");
        danceMoves.add("Croqueta complicada");

        int number = randomInt(0, 4);


        if (number == 0) {
            System.out.printf("The %s hit you with a %s\n", getName(), danceMoves.get(0));
            soulStepper.decreaseHealth();
            System.out.printf("Soulsteppers current health is %s\n", soulStepper.getHealth());
        } else if (number == 1) {
            System.out.printf("The %s hit you with a %s", getName(), danceMoves.get(1));
            soulStepper.decreaseHealth();
            System.out.printf("Soulsteppers current health is %s\n", soulStepper.getHealth());
        } else if (number == 2) {
            System.out.printf("The %s hit you with a %s\n", getName(), danceMoves.get(2));
            soulStepper.decreaseHealth();
            System.out.printf("Soulsteppers current health is %s\n", soulStepper.getHealth());
        } else if (number == 3) {
            System.out.printf("The %s hit you with a %s\n", getName(), danceMoves.get(3));
            soulStepper.decreaseHealth();
            System.out.printf("Soulsteppers current health is %s\n", soulStepper.getHealth());
        } else {
            System.out.printf("The %s tried hit you with a move but missed!\n", getName());
        }
    }

    public int getHealth() {
        return Math.max(this.health, 0);
    }

    public String getName() {
        return name;
    }
}