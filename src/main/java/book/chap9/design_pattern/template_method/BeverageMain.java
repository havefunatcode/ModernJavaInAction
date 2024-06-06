package book.chap9.design_pattern.template_method;

public class BeverageMain {
    public static void main(String[] args) {
        CaffeineBeverageWithHook coffee = new CaffeineBeverageWithHook(
                () -> System.out.println("Dripping coffee"),
                () -> System.out.println("Adding milk")
        );

        coffee.prepareRecipe();

        System.out.println("================================================================================");

        CaffeineBeverageWithHook tea = new CaffeineBeverageWithHook(
                () -> System.out.println("Steeping the tea"),
                () -> System.out.println("Adding lemon")
        );

        tea.prepareRecipe();
    }
}
