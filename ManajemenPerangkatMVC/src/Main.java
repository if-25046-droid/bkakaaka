import controller.PerangkatController;
import view.PerangkatView;
public class Main {
    public static void main(String[] args) {
        new PerangkatController(new PerangkatView()).jalankan();
    }
}
