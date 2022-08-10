package com.groovin.character;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BreakDancers extends Character {


    public BreakDancers(String name, int health) {
        super(name, health);
    }
    //Time dialogue before combat of BreakDancer enemy character when engaging in combat with player
    @Override
    public void beginningDialogue() throws InterruptedException {
        System.out.println(".....");
        TimeUnit.MILLISECONDS.sleep(1500);
        System.out.println("* break dancers dancing *");
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("Soulstepper: Those are some smooth moves there youngin.");
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("Tyler: Thanks gramps, these moves aren't for the we....... wait, you're Levon Soulstepper???");
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("Soulstepper: Ha ha, glad people still recognize me");
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("Tyler: Yooooo, I used to study all your moves when I was a kid, you use to kill that funky chicken!");
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("Tyler: I hate what happened between you and that guy LoVibe, all the real dancers in town still know you're still the Supreme Stepper!");
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("Soulstepper: Thanks kid, but I'm on a journey right now to go get my title back because I feel the same way.");
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("Tyler: Word? Well you got nothing but support and love from me and the rest of the break dancing community here.");
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("Tyler: But there is one thing that I would love to do before you go...");
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("SoulStepper: Yeah, what is it?");
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("Tyler: Let's have a dance off! It's been my dream to dance against you since I was a kid.");
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("SoulStepper: Sure kid, you're on but I must warn you that I'm not that same dude you saw all those years ago.");
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("Tyler: Don't worry, about me stepper I've been waiting on this my whole life!");
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
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("Tyler: *heavy panting* they don't call you the Supreme stepper for nothing.");
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("SoulStepper: Haha I might've went a little harder than I should.");
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("Tyler: Hahaha no worries man, this was awesome. Do me a favor though...");
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("Soulstepper: What's that?");
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("Tyler: Whoop LoVibe's ass.");
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("SoulStepper: You got it kid.");
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.printf("You defeated %s with your soul and can now move on.\n", this.getName());
    }

//Random selection for Dance moves for combat of the BreakDancer character
    @Override
    public void dance(Character soulStepper, Character enemy) throws InterruptedException {
        List<String> danceMoves = new ArrayList<>(5);
        danceMoves.add("Windmill");
        danceMoves.add("Flare");
        danceMoves.add("Back Spin");
        danceMoves.add("Head Spin");
        danceMoves.add("Jack Hammer");

        int number = randomInt(0, 4);


        if (number == 0) {
            System.out.printf("The %s hit you with a %s\n", getName(), danceMoves.get(0));
            soulStepper.decreaseHealth();
            System.out.printf("Soulsteppers current health is %s\n", soulStepper.getHealth());
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
