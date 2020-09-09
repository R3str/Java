package com.company;
import java.util.Scanner;

public class Main {
    private static Country[] country = new Country[0];
    private static int num = 0;

    public static void main(String[] args)
    {
        CreateArray();
        ClearCmd();
        WriteCountry();
        ClearCmd();
        ShowCountry();
    }


    /*————————————————————Methods————————————————————*/

    public static class Country
    {
        String name;
        String capital;
        enum Continent
        {
            Ошибка,
            Северная_Амеика,
            Южная_Америка,
            Европа,
            Азия,
            Австралия,
            Антарктика
        }
        Continent yourContinent;
        int countPeople;
        int area;

        public void setName(String a)
        {
            for(int i = 0; i < a.length(); i++)
            {
                if (a.charAt(i) >= '0' && a.charAt(i) <= '9')
                {
                    name = "Ошибка";
                    break;
                }
            }

            if (name != "Ошибка")
                name = a;
        }

        public void setCapital(String a)
        {
            for(int i = 0; i < a.length(); i++)
            {
                if (a.charAt(i) >= '0' && a.charAt(i) <= '9')
                {
                    capital = "Ошибка";
                    break;
                }
            }

            if (capital != "Ошибка")
                capital = a;
        }

        public void setContinent(String a)
        {
            int choise = 0;

            for(int i = 0; i < a.length(); i++)
            {
                if (a.charAt(i) < '1' || a.charAt(i) > '7')
                {
                    yourContinent = Continent.Ошибка;
                    break;
                }
            }

            if(yourContinent != Continent.Ошибка)
            {
                choise = Integer.parseInt(a);

                switch (choise)
                {
                    case 1: yourContinent = Continent.Северная_Амеика; break;
                    case 2: yourContinent = Continent.Южная_Америка; break;
                    case 3: yourContinent = Continent.Европа; break;
                    case 4: yourContinent = Continent.Азия; break;
                    case 5: yourContinent = Continent.Австралия; break;
                    case 6: yourContinent = Continent.Антарктика; break;
                }
            }
        }

        public void setCountPeople(String a)
        {
            for(int i = 0; i < a.length(); i++)
            {
                if (a.charAt(i) < '0' || a.charAt(i) > '9')
                {
                    countPeople = 0;
                    break;
                }
            }

            if (countPeople != 0)
                countPeople = Integer.parseInt(a);
        }

        public void setArea(String a)
        {
            for(int i = 0; i < a.length(); i++)
            {
                if (a.charAt(i) < '0' || a.charAt(i) > '9')
                {
                    area = 0;
                    break;
                }
            }

            if(area != 0)
                area = Integer.parseInt(a);
        }

        Country()
        {
            this.name = "";
            this.capital = "";
            this.countPeople = 0;
            this.area = 0;
        }
    }

    public static void CreateArray()
    {
        Scanner scanner = new Scanner(System.in);
        boolean checkCorrect = true;

        System.out.print("Кол-во стран, которые вы хотите добавить: ");
        String numString = "";

        while(true)
        {
            numString = scanner.nextLine();

            for(int i=0; i < numString.length(); i++)
            {
                if(numString.charAt(i) < '0' || numString.charAt(i) > '9')
                {
                    checkCorrect = false;
                    System.out.println("Некорректное значение! Попробуйте еще раз");
                    break;
                }
            }

            if(checkCorrect)
                break;

            checkCorrect = true;
        }


        num = Integer.parseInt(numString);

        country = new Country[num];

        for(int i = 0; i < num; i++)
        {
            country[i] = new Country();
        }
    }

    public static void WriteCountry() {
        for (int i = 0; i < num; i++)
        {
            Scanner scanner = new Scanner(System.in);

            System.out.println("———Страна №" + (i+1) + "———");
            System.out.print("Введите название страны: ");
            String name = scanner.nextLine();

            System.out.print("Введите название столицы: ");
            String capital = scanner.nextLine();

            System.out.print("Введите название континента:\n");
            System.out.print(" 1. Северная Америка \n 2. Южная Америка \n 3. Европа \n 4. Азия \n 5. Австралия  \n 6. Антарктика \n Ваш выбор: ");
            String continent = scanner.nextLine();

            System.out.print("Введите количество населения: ");
            String countPeople = scanner.nextLine();

            System.out.print("Введите занимающую площадь: ");
            String area = scanner.nextLine();
            System.out.println("");

            country[i].setName(name);
            country[i].setCapital(capital);
            country[i].setContinent(continent);
            country[i].setCountPeople(countPeople);
            country[i].setArea(area);
        }
    }

    public static void ShowCountry()
    {
        for(int i = 0; i < num; i++)
        {
            System.out.println("———Страна №" + (i+1) + "———");
            System.out.println("Страна: " + country[i].name);
            System.out.println("Столица: " + country[i].capital);
            System.out.println("Континент: " + country[i].yourContinent);
            System.out.println("Население: " + country[i].countPeople);
            System.out.println("Площадь: " + country[i].area);
            System.out.println("");
        }
    }

    public static void ClearCmd()
    {
        for(int i = 0; i < 10; i++)
            System.out.println("");
    }

}
