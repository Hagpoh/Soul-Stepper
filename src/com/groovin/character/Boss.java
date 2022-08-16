package com.groovin.character;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

//Boss is a character on the game
public class Boss extends Character {


    public Boss(String name, int health) {
        super(name, health);
    }

    //different int when decreasing health by an attack from other characters
    @Override
    public void decreaseHealth() {
        this.health = health - randomInt(10, 25);
    }

    //Time dialogue before combat of Boss character when engaging in combat with player
    @Override
    public void beginningDialogue() throws InterruptedException {
        System.out.println(".....");
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("LoVibe: So you decided to show your face here again huh?");
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("Soulstepper: You know why I'm here... I came back to take what is mine!");
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("LoVibe: Go ahead and try Soul Stepper but your soul wasn't anywhere near mines last time.");
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("LoVibe: Perhaps you can to try to prove me wrong?");
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("Soulstepper: Well, let's not waste any time. Let me show you the real reason why they call me Soul Stepper..");
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("ALERT!!");
        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.println("ALERT!!");
        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.println("ALERT!!");
        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.println("ALERT!!");
        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.println("ALERT!!");
        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.printf("The Supreme Stepper %s challenges you to a dance off\n", this.getName());
        TimeUnit.MILLISECONDS.sleep(1500);
        System.out.println("Ready? Let's dance!");
    }
//    //Time dialogue after combat of Boss character when engaging in combat with player
    @Override
    public void endingDialogue() throws InterruptedException {
        System.out.println(".....");
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("LoVibe: NOOOOOOOOOOOOOOOOOO!");
        TimeUnit.MILLISECONDS.sleep(1500);
        System.out.println("LoVibe: I thought..... I was..... Supreme?!?!");
        TimeUnit.MILLISECONDS.sleep(1500);
        System.out.println("Soulstepper: HA! You thought wrong bitch, now give me my damn title back");
        TimeUnit.MILLISECONDS.sleep(1500);
        System.out.println("Soulstepper: Soul has been restored.");
        TimeUnit.MILLISECONDS.sleep(1500);
        TimeUnit.MILLISECONDS.sleep(1500);
        System.out.printf("You defeated %s with your soul and have regained your title as Supreme Stepper\n", this.getName());
        TimeUnit.MILLISECONDS.sleep(1500);
        System.out.println("CONGRATULATIONS");
        TimeUnit.MILLISECONDS.sleep(1500);
        System.out.println("YOU WIN!");
        TimeUnit.MILLISECONDS.sleep(1500);
        System.out.println("GAME OVER");
        System.exit(0);
    }
//Random selection for Dance moves for combat of the Boss character
    @Override
    public void dance(Character soulStepper, Character enemy) {
        List<String> danceMoves = new ArrayList<>(5);
        danceMoves.add("Dictator");
        danceMoves.add("Show-off");
        danceMoves.add("Cabbage Patch");
        danceMoves.add("Almighty Push");
        danceMoves.add("Washing Machine");

        int number = randomInt(0, 4);


        if (number == 0) {
            System.out.printf("The %s hit you with a %s\n", getName(), danceMoves.get(0));
            soulStepper.decreaseHealth();
            System.out.printf("Soulsteppers current health is %s", soulStepper.getHealth());
        } else if (number == 1) {
            System.out.printf("The %s hit you with a %s\n", getName(), danceMoves.get(1));
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