//is it isA, hasA, usesA, producesA
public class ComparableTest {
    public static void main(String[] args) {
        Employee e1 = new Employee(101,"Jack",5000,33);
        Employee e2 = new Employee(102,"Robert",6000,35);
        Employee e3 = new Employee(103,"Julia",4000,30);
        Employee e4 = new Employee(100,"Preeti",9000,25);
        Employee e5 = new Employee(105,"Seema",8000,27);

        e3.talk(); //e3 is the invoker...

        Employee e33 = e3; //is e33 an object or just a reference???
        Employee e333 = e3;

        System.out.println("e1 hashcode  "+e1.hashCode());
        System.out.println("e2 hashcode  "+e2.hashCode());
        System.out.println("e3 hashcode  "+e3.hashCode());
        System.out.println("e4 hashcode  "+e4.hashCode());
        System.out.println("e33 hashcode "+e33.hashCode());
        System.out.println("e333hashcode "+e333.hashCode());

        e3.talk(e4); //e3 is the invoker, and e4 is passed inside it



        /*e1.compareMySelfWithOther(e2); //e2 is passed here, hence usesA
        e1.compareMySelfWithOther(e3);
        e1.compareMySelfWithOther(e4);
        e1.compareMySelfWithOther(e5);
    */
    }
}
//very important topic in interview point of view
class Employee {
    int employeeNumber; //lower the number,  employee is the senior most
                //higher the number, employee is the junior most
    String name;
    float salary;
    int age;
    //human tendency, very bad
    //color, trade, tradition, nationality, body, hair color
    //speech, parent, wife, mobile, boss, company ... thats grief
    //husband, kids, kids marks with neighbour's kids marks
    //and so on .....

    void talk() {
        System.out.println("talk is invoked...by whom??"+name+" "+age+" "+salary); //no need of any reference
    }
    void talk(Employee x) { //e4 is known as x now
        System.out.println(name+" is talking with "+x.name);
        System.out.println(this.hashCode()+ " with "+x.hashCode());
        //no need of any reference for name, ie e3
        // and x is the reference of e4
    }
    void compareMySelf(Employee x) // x is the reference
    { //comparing with own self, is the progress, that's happiness

        System.out.println(name+": compareMySelf is called...");
        System.out.println(name+": Thank you God for a good salary to me "+x.salary);
    }
    void compareMySelfWithOther(Employee x) {//e2 is passed here
        //comparing with others, is endless, that's grief, sorrow, anxiety

        System.out.println("----- Comapring --------------");

        System.out.println(name+": Comparing myself with other....");

        if(employeeNumber < x.employeeNumber) {
            System.out.println(name+" : Im junior to "+x.name);
        }
        else {
            System.out.println(name+" : Im senior to "+x.name);
        }

        if(age > x.age) {
            System.out.println(name+" : Im older than "+x.name);
        }
        else if(age < x.age){
            System.out.println(name+" : Im younger than "+x.name);
        }
        else {
            System.out.println(name+": we are of same age "+x.name);
        }

        if(salary < x.salary) { //salary of e1,  x.salary means salary of e2
            System.out.println(name+": Oh, my God?? my salary is lesser than "+x.name+"'s salary "+x.salary);
        }
        else if(salary > x.salary) {
            System.out.println(name+": WOw, oh my God!!! my salary is more than "+x.name+"'s salary "+x.salary);
        }
    }
    public Employee(int employeeNumber, String name, float salary, int age) {
        this.employeeNumber = employeeNumber;
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeNumber=" + employeeNumber +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
