package com.thothit;
/*

    Annotation : extended version of comments
                 its a new and modern way of describing meta-data

        Annotations are of TWO types
                    |
             ----------------
             |              |
        source level        class level (runtime environment)
        in .java file       .class file

   For which "target" the annotation is written?
   is it for all the levels?
   is it for a class?
   it is for a method?
   is it for a variable?
   is it for a field?
   it is for a constructor?



    Annotation   verses Comments
    Boy1                Boy2
    Cap(NY)             Cap
    Head                Head
    Body <-NZ           Body
    Legs <-Levis        Legs
    Shoes<-Nike         Shoes


                            detaisl.xml
                               Boy2's Cap is from NY
                               Boy2's T shirt - Nepal
                               Boy2's Jeans - Benetton
                               Boy2's Shoes - Sketchers

                               Boy3...
                               Boy4...

    @Path  @GET @POST  @ @  @ @ @ @@@@@@@@@@@@@ spring angular hibernate rest
*/

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/* below are the meta-deta details of Boy2
Created By : vishhal
    on date : 2-Aug-2021
    time : 7:30pm
    version : 1.0
*/
class SavingsAccount2 { //same as Boy2
    private int accountNumber;
    private String accountHolderName;
    private double accountBalance;
}

@DevelopedBy(developerName="vishhal",date="2-Aug-2021",time="7.30pm",version=1.0)
class SavingsAccount1 { //Boy 1

    private int accountNumber;
    private String accountHolderName;

    @SecuredBy(ask="otp,grid")
    private double accountBalance;

    @InvokedBy(client="BOA")
    public void deposit() {

    }
    public void deposit(double amt) {

    }
    public void withdraw() {

    }
    public void withdraw(double amt) {

    }
}

//class Class holds teh meta data of every object in java
public class AnnotationTest {
    public static void main(String[] args) {
        SavingsAccount1 savingsAccount1 = new SavingsAccount1();

        Class theClass = savingsAccount1.getClass();
        //we can see the world via the eyes,
        //but can we see our eyes via our eyes? we need a mirror!!!!!
        Annotation annotation[] = theClass.getAnnotations(); //REFLECTION API
        for (int i = 0; i < annotation.length; i++) {
            System.out.println("annotation is : "+annotation[i]);
            DevelopedBy developedBy = (DevelopedBy)  annotation[i];
            System.out.println("Developers name : "+developedBy.developerName());
            System.out.println("Developed  date : "+developedBy.date());
            System.out.println("Developed  time : "+developedBy.time());
            System.out.println("Developed  ver  : "+developedBy.version());

            double expectedVersion = 1.0;
            if(developedBy.version()==expectedVersion) {
                System.out.println("found the latest class file ..lets load it for banking...");
            }
            else {
                System.out.println("found the older version "+developedBy.version()+" it should be "+expectedVersion);
            }

            Method allMethods[] = theClass.getMethods();
            System.out.println("--showing all methods ---");
            for (int j = 0; j < allMethods.length; j++) {
                System.out.println("Method name : "+allMethods[j].getName()+" with "+allMethods[j].getParameterCount()+" parameters ");
                Annotation methodAnnotations[] = allMethods[j].getAnnotations();
                for (int k = 0; k < methodAnnotations.length; k++) {
                    System.out.println("Method annotation is : " + methodAnnotations[k]);
                }
            }
        }
    }
}


