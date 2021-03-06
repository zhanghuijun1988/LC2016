public class Solution {
  //Need to do 1 pass way, self
    public void sortColors(int[] A) {
        if(A == null || A.length == 0) {
            return;
        }
        
        int i = 0, j = A.length - 1, k = 0;
        while(k <= j) {
            if(A[k] == 1) {
                k++;
            } else if(A[k] == 2) {
                swap(A, k, j);
                j--;
            } else {
                swap(A, k, i);
                i++;
                k++;
            }
        }
    }
  
  //self, 2 pass, move 0 to front, then sort 1 and 2
    public void sortColors(int[] A) {
        int len = A.length;
        if(len == 0)    return;
        
        int left = 0, right = len - 1;
        while(left < len && right >= 0 && left < right) {
            while(left < len && A[left] == 0) {
                left++;
            }
            while(right >= 0 && A[right] != 0) {
                right--;
            }
            if(left < right) {
                swap(A, left, right);
            }
        }
        
        left = 0;
        right = len - 1;
        while(left < len && A[left] == 0) {
            left++;
        }
        while(left < len && right >= 0 && left < right) {
            while(left < len && A[left] == 1) {
                left++;
            }
            while(right >= 0 && A[right] == 2) {
                right--;
            }
            if(left < right) {
                swap(A, left, right);
            }
        }
        
    }
    
    public void swap(int[] A, int i, int j){
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
    
    
}
