package at.ac.fhcampuswien.fhmdb.models;

public enum Years {
    ALL(1),
    YEAR_1957(1957),
    YEAR_1958(1958),
    YEAR_1959(1959),
    YEAR_1960(1960),
    YEAR_1961(1961),
    YEAR_1962(1962),
    YEAR_1963(1963),
    YEAR_1964(1964),
    YEAR_1965(1965),
    YEAR_1966(1966),
    YEAR_1967(1967),
    YEAR_1968(1968),
    YEAR_1969(1969),
    YEAR_1970(1970),
    YEAR_1971(1971),
    YEAR_1972(1972),
    YEAR_1973(1973),
    YEAR_1974(1974),
    YEAR_1975(1975),
    YEAR_1976(1976),
    YEAR_1977(1977),
    YEAR_1978(1978),
    YEAR_1979(1979),
    YEAR_1980(1980),
    YEAR_1981(1981),
    YEAR_1982(1982),
    YEAR_1983(1983),
    YEAR_1984(1984),
    YEAR_1985(1985),
    YEAR_1986(1986),
    YEAR_1987(1987),
    YEAR_1988(1988),
    YEAR_1989(1989),
    YEAR_1990(1990),
    YEAR_1991(1991),
    YEAR_1992(1992),
    YEAR_1993(1993),
    YEAR_1994(1994),
    YEAR_1995(1995),
    YEAR_1996(1996),
    YEAR_1997(1997),
    YEAR_1998(1998),
    YEAR_1999(1999),
    YEAR_2000(2000),
    YEAR_2001(2001),
    YEAR_2002(2002),
    YEAR_2003(2003),
    YEAR_2004(2004),
    YEAR_2005(2005),
    YEAR_2006(2006),
    YEAR_2007(2007),
    YEAR_2008(2008),
    YEAR_2009(2009),
    YEAR_2010(2010),
    YEAR_2011(2011),
    YEAR_2012(2012),
    YEAR_2013(2013),
    YEAR_2014(2014),
    YEAR_2015(2015),
    YEAR_2016(2016),
    YEAR_2017(2017),
    YEAR_2018(2018),
    YEAR_2019(2019),
    YEAR_2020(2020),
    YEAR_2021(2021),
    YEAR_2022(2022),
    YEAR_2023(2023),
    YEAR_2024(2024);

    private final int year;

    Years(int year){
        this.year = year;
    }
    @Override
    public String toString() {
        if (this == ALL) {
            return "ALL";
        }
        else {
            return String.valueOf(year);
        }
    }

    public int getYear() {
        return this.year;
    }
}
