import java.util.*; //import all java util

public class CandleShop {
    
    static Scanner sc = new Scanner(System.in); //scanner
    static Candle[] candles = new Candle[3]; //candles array 
    static int[] candleAmount = new int[3];
    static String name; //name
    static int type; //type
    static double cost; //cost
    static int burnTime; //burnTime
    static double totalCost = 0.0;
    static int totalBurnTime = 0;
    static double costPerMinute = 0.0;
    static double discountTotalCost= 0.0;
    static int points = 0;
    static int totalCandles = 0;
    
    public static void main(String[] args) {

        System.out.println("*******************************");
        System.out.println("Project 3");
        System.out.println("*******************************");
        // Add code here

        System.out.println("Welcome to the Candle shop!"); //introduce shop


        for(int i = 0 ; i < candles.length ; i++){ //for every candle (3), print prompts
            candles[i] = shopCreation(); //shop creation method called
        }

        System.out.print("\n" + "**************");
        System.out.print("\n" + "Customer Time!");
        System.out.println("\n" + "**************");
        System.out.println();

        getCandleAmount(); //gather the amount of each candle

        System.out.print("\n" + "****************************");
        System.out.print("\n" + "Coolest Reciept known to man");
        System.out.println("\n"+"****************************");
        System.out.println();

        for(int i = 0; i < candleAmount.length; i++){ //for every candle, print this message

            System.out.print(candleAmount[i] + " " + candles[i].getName() + " candles (Type " + candles[i].getType() + "): ");

            for(int j = 0; j < candleAmount[i]; j++){ //for each candle purchased, place a * per each

                System.out.print("*"); // * :)

            }
            System.out.println();
        }

        totals(); //calculate the total cost and burn time of all candles purchased

        discount(); //price with discount included

    }//end main



    public static Candle shopCreation(){ //shopCreation Method

        System.out.print("\n" + "Name your new Candle!");

        //Ask for name

        System.out.print("\n" + "Candle name: ");
        name = sc.nextLine();

        //Ask for type

        System.out.print("\n" + "Type (1, 2, 3):  ");
        type = sc.nextInt();

        //Ask for cost

        System.out.print("\n" + "Cost: ");
        cost = sc.nextDouble();

        //Ask for burnTime

        System.out.print("\n" + "Burn time (minutes)? ");
        burnTime = sc.nextInt();
        System.out.println();

        //Reset Scanner

        sc.nextLine();

        //return new values saved 

        return new Candle(name, type, cost, burnTime);

    }//end shopCreation method




    /*
        //
            //    Swap to customer view 
        //
    */

    public static void getCandleAmount(){ //Scanner for candle quantity

        System.out.print("How many of "+ candles[0].getName() + "? " ); //How many of Candle 1
        
        candleAmount[0] = sc.nextInt(); //first candle scanner
         
        System.out.print("How many of "+ candles[1].getName() + "? " ); //How many of Candle 2

        candleAmount[1] = sc.nextInt(); //second candle scanner
        
        System.out.print("How many of "+ candles[2].getName() + "? " ); //How many of Candle 3
        
        candleAmount[2] = sc.nextInt(); //third candle scanner

    }//end getCandleAmount




    public static void totals(){ //totals to cost and burn time

        for (int i = 0; i < candleAmount.length; i++) { //for every candle, multiply by cost and burn time

            totalCost += candles[i].getCost() * candleAmount[i]; //total cost of every candle
            totalBurnTime += candles[i].getTime() * candleAmount[i]; //total burn time of every candle
            totalCandles += candleAmount[i];
            
        }

        System.out.print("\n" + "Total cost: "); //print total cost
        System.out.printf("%.02f", totalCost);
        System.out.println("\n" + "Total burn time (minutes): " + totalBurnTime); //print total burn time

    }




    public static void discount(){ //including discounts

        if( totalCost >= 20.00 || totalCost < 35.00 ){ //between 20 and 35 $

            discountTotalCost = totalCost - (totalCost * 0.05);

        }
        if( totalCost >= 35.00 || totalCost < 55.00 ){ //between 35 and 55 $

            discountTotalCost = totalCost - (totalCost * 0.07);

        }
        if( totalCost >= 55.00 || totalCost < 100.00 ){ //between 55 and 100 $

            discountTotalCost = totalCost - (totalCost * 0.10);

        }
        if( totalCost >= 100.00 ){ //above 100 $

            discountTotalCost = totalCost - (totalCost * 0.20);
        }

        System.out.print("Price with discount included is: "); //discounted price
        System.out.printf("%.2f", discountTotalCost); //remove the decimals
        System.out.println();
        System.out.print("Cost per hour of total burn time: ");
        System.out.printf("%.02f", ((discountTotalCost / totalBurnTime)));
        System.out.print(" per minute");
        System.out.println();
        // total burn time / discount = cost per min of candle

        if(totalCandles >= 10){ //loyalty system!

            points = (int) Math.floor(totalCandles / 10); //every 10 candles purchesed is 1 loyalty point

        }


        System.out.println("Loyalty points: " + points); 
        //loyalty points



    } //end discount


}// end class
