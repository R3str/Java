package com.company;

import com.company.Tools.Continent;

public class Country
{
    String name;
    String capital;
    Continent continent;
    int countPeople;
    int area;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = CheckTitle(name) ? name : "Ошибка";
    }

    public String getCapital()
    {
        return capital;
    }

    public void setCapital(String capital)
    {
        this.capital = CheckTitle(capital) ? capital : "Ошибка";
    }

    public Continent getContinent()
    {
        return continent;
    }

    public void setContinent(String continentNumber)
    {
        this.continent = CheckNumber(continentNumber, true) ? continent.values()[Integer.parseInt(continentNumber)] : continent.Ошибка;
    }

    public int getCountPeople()
    {
        return countPeople;
    }

    public void setCountPeople(String countPeople)
    {
        this.countPeople = CheckNumber(countPeople, false) ? Integer.parseInt(countPeople) : -999;
    }

    public int getArea()
    {
        return area;
    }

    public void setArea(String area)
    {
        this.area = CheckNumber(area, false) ? Integer.parseInt(area) : -999;
    }

    public Country()
    {
        this.name = "";
        this.capital = "";
        this.continent = Continent.Ошибка;
        this.countPeople = -999;
        this.area = -999;
    }

    public Country(String name, String capital, String continent, String countPeople, String area)
    {
        setName(name);
        setCapital(capital);
        setContinent(continent);
        setCountPeople(countPeople);
        setArea(area);
    }



    /*————————————————————Methods————————————————————*/

    public boolean CheckTitle(String name)
    {
        for (int i = 0; i < name.length(); i++)
        {
            if (!(Character.isAlphabetic(name.charAt(i))) && !(name.charAt(i) == ' ') && !(name.charAt(i) == '-'))
                return false;
        }

        return true;
    }

    public boolean CheckNumber(String number, boolean checkContinent)
    {
        for (int i = 0; i < number.length(); i++)
        {
            if(!Character.isDigit(number.charAt(i)))
                return false;
        }

        if(checkContinent)
        {
            int numberInt = Integer.parseInt(number);

            if(numberInt < 1 || numberInt > 7)
                return false;
        }

        return true;
    }

}
