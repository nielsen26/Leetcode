public class ContainerMostWater {
    public static int maxArea(int[] height) {
        int area = 0;

        for (int i = 0; i < height.length; i++) {
            int start = 0;
            int end = height.length - 1;
            boolean found = false;

            if (start != i || end != i) {
                while (i - start > end - i) {
                    if (height[i] > height[start])
                        start++;
                    else {
                        found = true;
                        int new_area = (i - start) * height[i];
                        area = new_area > area ? new_area : area;
                        break;
                    }
                }

                while (i - start < end - i) {
                    if (height[i] > height[end])
                        end--;
                    else {
                        found = true;
                        int new_area = (end - i) * height[i];
                        area = new_area > area ? new_area : area;
                        break;
                    }
                }

                if (!found) {
                    while (start != i) {
                        if (height[i] > height[start])
                            start++;
                        else {
                            int new_area = (i - start) * height[i];
                            area = new_area > area ? new_area : area;
                            break;
                        }
                        if (height[i] > height[end])
                            end--;
                        else {
                            int new_area = (end - i) * height[i];
                            area = new_area > area ? new_area : area;
                            break;
                        }
                    }
                }
            }
        }

        return area;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
    }
}