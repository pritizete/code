import java.util.*;

public class pract1 {

    //Recursive
    static int recursion(int n){
        if(n<=1){
            return n;
        }
        return recursion(n-1)+ recursion(n-2);
    }

    //Non Recursive
    static int iterative(int n){
        int a=0, b=1, c=0;
        for(int i=2;i<=n;i++){
            c=a+b;
            a=b;
            b=c;
        }
        return (n==0)?a:b;
    }

    //Fibonacci Series
    static void series(int n){
        int a=0,b=1;

        for(int i=0;i<n;i++){
            System.out.print(a + " ");
            int c=a+b;
            a=b;
            b=c;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        while(true){
            System.out.println("1. Recursive Fibonacci");
            System.out.println("2. Iterative Fibonacci");
            System.out.println("3. Print Fibonacci Series");
            System.out.println("4. Exit");

            System.out.print("Enter option: ");

            int opt=sc.nextInt();

            if(opt==1){
                System.out.print("Enter n:");
                int n=sc.nextInt();
                System.out.println("Result: " +recursion(n));
            }

            else if(opt==2){
                System.out.print("Enter n:");
                int n=sc.nextInt();
                System.out.println("Result: " +iterative(n));
            }
            else if(opt==3){
                System.out.print("Enter n:");
                int n=sc.nextInt();
                series(n);
            }
            else if(opt==4){
                break;
            }
            else{
                System.out.println("Invalid option");
            }
        }
        sc.close();
    }
}
