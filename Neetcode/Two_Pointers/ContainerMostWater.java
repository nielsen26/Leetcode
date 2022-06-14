package Two_Pointers;

public class ContainerMostWater {
    public static int maxArea(int[] height) {
        int area = 0;
        int start = 0;
        int end = height.length - 1;
        while (start < end) {
            int lower = height[start] < height[end] ? height[start] : height[end];
            int new_area = (end - start) * lower;
            area = new_area > area ? new_area : area;

            if (height[start] < height[end])
                start++;
            else
                end--;
        }

        return area;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
    }
}