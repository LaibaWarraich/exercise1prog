package at.ac.fhcampuswien.fhmdb.models;

public enum Rating {
    ALL(0),
    RATING_1(1),
    RATING_2(2),
    RATING_3(3),
    RATING_4(4),
    RATING_5(5),
    RATING_6(6),
    RATING_7(7),
    RATING_8(8),
    RATING_9(9),
    RATING_10(10);
    private final int rating;

    Rating(int rating){
        this.rating = rating;
    }
    @Override
    public String toString() {
        if (this == ALL) {
            return "ALL";
        }
        else {
            return String.valueOf(rating);
        }
    }
}
