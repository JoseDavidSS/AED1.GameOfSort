package Sort;

public class Sort {
    private static Sort sort = null;

    public static Sort getInstance(){

        if (sort==null){
            sort = new Sort();
        }
        return sort;
    }

}
