package com.company;

import com.company.Tools.Continent;

import java.util.Scanner;

public class Main {
    private static Country[] country = new Country[8];

    public static void main(String[] args) {
        country[0] = new Country("Украина", "Карпаты", "4", "47000000", "603628");
        country[1] = new Country("Австрия", "Вена", "4", "8384000", "83879");
        country[2] = new Country("Великобритания", "Лондон", "4", "63700000", "242514");
        country[3] = new Country("Германия", "Берлин", "4", "81844000", "357114");
        country[4] = new Country("Дания", "Копенгаген", "4", "5600000", "43098");
        country[5] = new Country("Бангладеш", "Дакка", "5", "161000000", "147600");
        country[6] = new Country("Бруней", "Бандар-Сери-Бегаван", "5", "423000", "5770");
        country[7] = new Country("Израйль", "Иерусалим", "5", "5938000", "20800");

        System.out.println("Добро пожаловать в базу данных 'Государство'. Выберите действие:");
        System.out.print(
                        " 1. Добавление стран к уже существующей базе данных\n" +
                        " 2. Удаление всех стран, у которых население меньше указанного\n" +
                        " 3. Поиск по названию столицы\n" +
                        " 4. Поиск по занимаемой площади свыше указанной\n" +
                        " 5. Выдача сведений о государствах заданного континента с выбором способа сортировки\n\n" +
                        "Ваш выбор: "
        );

        Scanner scanner = new Scanner(System.in);
        String choiseString = scanner.nextLine();

        choiseString = CheckNumberWithCycle(choiseString, false);

        int choiseInt = Integer.parseInt(choiseString);
        while (choiseInt < 1 || choiseInt > 5)
        {
            System.out.println("Некорректное значение! Попробуйте еще раз");
            choiseInt = Integer.parseInt(choiseString);
        }


        switch (choiseInt)
        {
            case 1: AddCountry(); break;
            case 2: DeleteWithPopulationLess(); break;
            case 3: FindWithCapital(); break;
            case 4: FindWithAreaMore(); break;
            case 5: FindWithContinent(); break;
        }
    }



    /*————————————————————Methods————————————————————*/

    public static void AddCountry()
    {
        Scanner scanner = new Scanner(System.in);

        int numInt, startIndexCountry = country.length;

        System.out.print("Кол-во стран, которые вы хотите добавить: ");
        String numString;

        numString = scanner.nextLine();
        numString = CheckNumberWithCycle(numString, false);

        numInt = Integer.parseInt(numString);

        Country[] reservCountry;
        reservCountry = country;

        country = new Country[numInt+startIndexCountry];

        for (int i = 0; i < country.length-numInt; i++)
        {
            country[i] = reservCountry[i];
        }

        for (int i = startIndexCountry; i < country.length; i++ )
        {
            country[i] = new Country();
        }

        for (int i = startIndexCountry; i < country.length; i++)
        {

            System.out.println("———Страна №" + (i + 1) + "———");
            System.out.print("Введите название страны: ");
            String name = scanner.nextLine();

            System.out.print("Введите название столицы: ");
            String capital = scanner.nextLine();

            System.out.print("Введите название континента:\n");
            for (int j = 1; j < Continent.values().length; j++)
                System.out.println(" " + j + " " + Continent.values()[j]);

            System.out.print("Ваш выбор: ");
            String continent = scanner.nextLine();

            System.out.print("Введите количество населения: ");
            String countPeople = scanner.nextLine();

            System.out.print("Введите занимающую площадь: ");
            String area = scanner.nextLine();
            System.out.println("");

            country[i] = new Country(name, capital, continent, countPeople, area);
        }

        ShowCountry();
    }

    public static void ShowCountry() {
        for (int i = 0; i < country.length; i++)
        {
            System.out.println("———Страна №" + (i + 1) + "———");
            System.out.println("Страна: " + country[i].name);
            System.out.println("Столица: " + country[i].capital);
            System.out.println("Континент: " + country[i].continent);
            System.out.println("Население: " + country[i].countPeople);
            System.out.println("Площадь: " + country[i].area);
            System.out.println("");
        }
    }

    public static void  ShowCountry(Country[] sortingCounrty, int number)
    {
            System.out.println("———Страна №" + (number + 1) + "———");
            System.out.println("Страна: " + sortingCounrty[number].name);
            System.out.println("Столица: " + sortingCounrty[number].capital);
            System.out.println("Континент: " + sortingCounrty[number].continent);
            System.out.println("Население: " + sortingCounrty[number].countPeople);
            System.out.println("Площадь: " + sortingCounrty[number].area);
            System.out.println("");
    }

    public static void DeleteWithPopulationLess() {
        Scanner scanner = new Scanner(System.in);

        int numberDeleteInt, j = 0;
        int[] safePosition = new int[country.length];

        System.out.print("Удаление стран с численностью меньше заданной\nВаше число: ");
        String numberDeleteString = scanner.nextLine();
//Проврека на корректный ввод числа
        numberDeleteString = CheckNumberWithCycle(numberDeleteString, false);
//Перевод строки в число
        numberDeleteInt = Integer.parseInt(numberDeleteString);


//Запись кол-ва элементов, котрых нужно удалить и их кординатов
        for (int i = 0; i < country.length; i++) {
            if ((country[i].countPeople > numberDeleteInt)) {
                safePosition[j++] = i;
            }
        }

//Создание и запись резервного массива
        Country[] newC = new Country[j];

        for (int i = 0; i < newC.length; i++) {
            newC[i] = country[safePosition[i]];
        }

//Создание и запись основного массива
        country = new Country[newC.length];
        for (int i = 0; i < newC.length; i++) {
            country[i] = newC[i];
        }

        ShowCountry();
    }

    public static void FindWithCapital()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Поиск по названию столицы\nВведите столицу: ");
        String capital = scanner.nextLine();
        capital = capital.substring(0, 1).toUpperCase() + capital.substring(1);


        for (int i = 0; i < country.length; i++)
        {
            if(country[i].capital.contains(capital))
            {
                System.out.println("Результат: ");
                ShowCountry(country,i);
            }
        }
    }

    public static void FindWithAreaMore()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Поиск по занимаемой площади свыше указанной\nВведите площадь: ");
        String numberString = scanner.nextLine();
        numberString = CheckNumberWithCycle(numberString, false);

        int numberInt = Integer.parseInt(numberString);

        for (int i = 0; i < country.length; i++)
        {
            if(country[i].area > numberInt)
                ShowCountry(country,i);
        }
    }

    public static void FindWithContinent()
    {
        Scanner scanner = new Scanner(System.in);

        int j = 0;

        System.out.print("Поиск по названию континента\nВведите континент:\n");
        for (int i = 1; i < Continent.values().length; i++)
            System.out.println(" " + i + ". " + Continent.values()[i]);

        String numberContinentString = scanner.nextLine();
        numberContinentString = CheckNumberWithCycle(numberContinentString, true);

        int numberContinentInt = Integer.parseInt(numberContinentString);

        System.out.print("Выберите способ сортировки: \n");
        System.out.println(" 1. По названию\n 2. По площади\n 3. По населению\n");
        System.out.println("Ваш выбор: ");

        String numberSortingString = scanner.nextLine();
        numberSortingString = CheckNumberWithCycle(numberSortingString, true);

        int numberSortingInt = Integer.parseInt(numberSortingString);

        for (int i = 0; i < country.length; i++)
        {
            if(country[i].continent == Continent.values()[numberContinentInt])
            {
                j++;
            }
        }

        Country[] sortingCountry = new Country[j];
        j = 0;

        for (int i = 0; i < country.length; i++)
        {
            if(country[i].continent == Continent.values()[numberContinentInt])
            {
                sortingCountry[j++] = country[i];
            }
        }

        switch (numberSortingInt)
        {
            case 1: SortingByName(sortingCountry); break;
            case 2: SortingByArea(sortingCountry); break;
            case 3: SortingByCountPeople(sortingCountry); break;
        }
    }

    public static void SortingByName(Country[] sortingCountry)
    {
        Country reservCountry = new Country();

        for (int i = 0; i < sortingCountry.length; i++)
        {
            if(i != (sortingCountry.length-1))
                if(sortingCountry[i].name.charAt(0) > sortingCountry[i+1].name.charAt(0))
                {
                    reservCountry = sortingCountry[i];
                    sortingCountry[i] = sortingCountry[i+1];
                    sortingCountry[i+1] = reservCountry;
                }
            ShowCountry(sortingCountry,i);
        }
    }

    public static void SortingByArea(Country[] sortingCountry)
    {
        SortingNumberArea(sortingCountry);

        for (int i = 0; i < sortingCountry.length; i++)
        {
            ShowCountry(sortingCountry, i);
        }
    }

    public static void SortingByCountPeople(Country[] sortingCountry)
    {
        SortingNumberCoutPeople(sortingCountry);

        for (int i = 0; i < sortingCountry.length; i++)
        {
            ShowCountry(sortingCountry, i);
        }
    }

    public static void SortingNumberArea(Country[] sortingCountry)
    {
        Country reservCountry = new Country();

        for (int i = 0; i < sortingCountry.length; i++)
        {
            if (i != (sortingCountry.length - 1)) {
                if (sortingCountry[i].area < sortingCountry[i + 1].area)
                {
                    reservCountry = sortingCountry[i];
                    sortingCountry[i] = sortingCountry[i + 1];
                    sortingCountry[i + 1] = reservCountry;


                    for (int j = --i; j >= 0; j--) {
                        if (sortingCountry[j].area < sortingCountry[j + 1].area)
                        {
                            reservCountry = sortingCountry[j];
                            sortingCountry[j] = sortingCountry[j + 1];
                            sortingCountry[j + 1] = reservCountry;
                        }
                    }
                }
            }
        }

    }

    public static void SortingNumberCoutPeople(Country[] sortingCountry)
    {
        Country reservCountry = new Country();

        for (int i = 0; i < sortingCountry.length; i++)
        {
            if (i != (sortingCountry.length - 1)) {
                if (sortingCountry[i].countPeople < sortingCountry[i + 1].countPeople)
                {
                    reservCountry = sortingCountry[i];
                    sortingCountry[i] = sortingCountry[i + 1];
                    sortingCountry[i + 1] = reservCountry;


                    for (int j = --i; j >= 0; j--) {
                        if (sortingCountry[j].countPeople < sortingCountry[j + 1].countPeople)
                        {
                            reservCountry = sortingCountry[j];
                            sortingCountry[j] = sortingCountry[j + 1];
                            sortingCountry[j + 1] = reservCountry;
                        }
                    }
                }
            }
        }

    }

    public static String CheckNumberWithCycle(String string, boolean mode)
    {
        Scanner scanner = new Scanner(System.in);

        while(!(country[0].CheckNumber(string, mode) || string.equals("Ошибка")))
        {
            System.out.println("Некорректное значение! Попробуйте еще раз");
            string = scanner.nextLine();
        }
        return string;
    }
}
