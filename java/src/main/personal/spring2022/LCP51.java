package personal.spring2022;

/**
 * LCP 51. 烹饪料理：https://leetcode-cn.com/problems/UEcfPD/
 */
public class LCP51 {

    public static int perfectMenu(int[] materials, int[][] cookbooks, int[][] attribute, int limit) {
        int[] leftMaterials = new int[materials.length];
        int ans = -1;
        for (int l = 0; l < cookbooks.length; l++) {
            System.arraycopy(materials, 0, leftMaterials, 0, materials.length);
            int x = 0, y = 0;
            for (int i = l; i < cookbooks.length; i++) {
                boolean make = true;
                for (int j = 0; j < cookbooks[i].length; j++) {
                    if (cookbooks[i][j] > leftMaterials[j]) {
                        make = false;
                        break;
                    }
                }
                if (make) {
                    for (int j = 0; j < cookbooks[i].length; j++) {
                        leftMaterials[j] -= cookbooks[i][j];
                    }
                    x += attribute[i][0];
                    y += attribute[i][1];
                }
            }
            if (y >= limit) {
                ans = Math.max(ans, x);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(perfectMenu(
            new int[] {3,2,4,1,2},
            new int[][]{
                {1,1,0,1,2},
                {2,1,4,0,0},
                {3,2,4,1,0}
            },
            new int[][]{
                {3,2},
                {2,4},
                {7,6}
            },
            5
        ));
    }

}
