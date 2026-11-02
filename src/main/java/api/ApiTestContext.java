package api;

public class ApiTestContext {

    private static final ThreadLocal<Integer> createdApplicationId = new ThreadLocal<>();
    private static final ThreadLocal<Integer> createdStaffId = new ThreadLocal<>();

    public static void setStaffId(Integer id) {
        createdStaffId.set(id);
    }

    public static Integer getStaffId() {
        return createdStaffId.get();
    }

    public static void clearStaffId() {
        createdStaffId.remove();
    }

    public static void setApplicationId(int id) {
        createdApplicationId.set(id);
    }

    public static int getApplicationId() {
        return createdApplicationId.get();
    }

    public static void clearApplicationId() {
        createdApplicationId.remove();
    }
}
