public class DinnerFullCourse {

    private Dish[] list = new Dish[5];// [0]-[4]の計5個

    public static void main(String[] args) {

        DinnerFullCourse fullcourse = new DinnerFullCourse();
        fullcourse.eatAll();
    }

    DinnerFullCourse() {
        list[0] = new Dish();
        list[0].setName("カレーライス");
        list[0].setValune(500);
        list[1] = new Dish();
        list[1].setName("ラーメン");
        list[1].setValune(1000);
        list[2] = new Dish();
        list[2].setName("オムライス");
        list[2].setValune(1200);
        list[3] = new Dish();
        list[3].setName("うどん");
        list[3].setValune(600);
        list[4] = new Dish();
        list[4].setName("すし");
        list[4].setValune(30000);
    }

    void eatAll() {
        String str = "";

        for (Dish element : list) {
            str += element.getName() + element.getValune() + "コ,";
        }

        System.out.println("今日のごはんは" + str + "です。");
    }

}
