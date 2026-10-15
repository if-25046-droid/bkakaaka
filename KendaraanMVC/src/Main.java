import controller.KendaraanController;
import view.KendaraanView;

public class Main {
    public static void main(String[] args) {
        KendaraanView view = new KendaraanView();
        KendaraanController controller = new KendaraanController(view);
        controller.run();
    }
}
