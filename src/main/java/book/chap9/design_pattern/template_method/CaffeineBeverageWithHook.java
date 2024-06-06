package book.chap9.design_pattern.template_method;

public class CaffeineBeverageWithHook {
    private final BeverageAction brewAction;
    private final BeverageAction addCondimentsAction;

    public CaffeineBeverageWithHook(BeverageAction brewAction, BeverageAction addCondimentsAction) {
        this.brewAction = brewAction;
        this.addCondimentsAction = addCondimentsAction;
    }

    public final void prepareRecipe() {
        boilWater();
        brewAction.execute();
        pourInCup();
        addCondimentsAction.execute();
    }

    private void pourInCup() {
        System.out.println("Pouring into cup");
    }

    private void boilWater() {
        System.out.println("Boiling water");
    }
}
