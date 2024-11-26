class   Solution {
    // Function to rotate an array by d elements in counter-clockwise direction.
    static void rotateArr(int arr[], int d, int n) {
        // add your code here
        d=d%n;
        int[] temp=new int[d];
        for(int i=0;i<d;i++)
        {
            temp[i] = arr[i];
        }
        for(int i =d; i<n;i++)
        {
            arr[i-d] = arr[i];
        }
        for(int i = n-d; i<n;i++)
        {
            arr[i] = temp[i-(n-d)];
        }

    }
}

//



class Solution {
    public void rotate(int arr[], int k) {
        int n=arr.length;
        k=k%n;
        if(k==0 || n==0) return;
        reverse(arr,n-k,n-1);
        reverse(arr,0,n-k-1);
        reverse(arr,0,n-1);
    }

    public void reverse(int arr[],int f,int l )
    {
        while(f<=l){
            int temp=arr[f];
            arr[f]=arr[l];
            arr[l]=temp;
            f++;l--;
        }
    }
};